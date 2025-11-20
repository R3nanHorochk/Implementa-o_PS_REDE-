/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author Renan
 */
public class PessoaFisica extends Entidade {
	private String cpf;
	private Identidade identidade;
	private Candidato Cand;
	public PessoaFisica(String nome, List<Localizacao> enderecos,email emai, String cpf, Identidade identidade) {
		super(nome, enderecos,emai);
		this.cpf = cpf;
		this.identidade = identidade;
	}
        public PessoaFisica() {
		super(null, null,null);
	}
        
        public PessoaFisica(String nome,List<String> end,String emailT,String cpf,String estadoCivil,
                            LocalDate dataNascimento,String nacionalidade, String profissao,Candidato C1,String s) {
            
            email e1 = new email(emailT);
            List<Localizacao> enderecosC = new ArrayList<>();
            for (String ender : end) {
            Localizacao l1 = new Localizacao(ender);
            enderecosC.add(l1);
            }
             super(nome,enderecosC,e1);
            this.cpf = cpf;
            Identidade i1 = new Identidade(estadoCivil, dataNascimento, nacionalidade, profissao,s);
            this.identidade = i1;
            this.Cand = C1;
	}
        
        public Candidato getCand() {
		return Cand;
	}

	public void setCand(Candidato cand) {
		Cand = cand;
	}
        
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Identidade getIdentidade() {
		return identidade;
	}

	public void setIdentidade(Identidade identidade) {
		this.identidade = identidade;
	}

	public PessoaFisica(String nome, List<Localizacao> enderecos) {
		super(nome, enderecos,null);
	}
        
        
	public void SalvaPF(){
                
             try (Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2"
                     , "root", "senha")) {


            String sqlEntidade = 
                "INSERT INTO PessoaFisica(cpf,idEntidade,idCand) VALUES (?,?,?)";

            PreparedStatement stmtEnt = conexao.prepareStatement(sqlEntidade, Statement.RETURN_GENERATED_KEYS);
            stmtEnt.setString(1, this.cpf);
            stmtEnt.setInt(2, this.getId());
            stmtEnt.setInt(3, Cand.getId());
            stmtEnt.executeUpdate();

            


            } catch (SQLException e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
            }
            
            }
        
        
        
        public void SalvaIdentidade(){
             
            java.sql.Date dataSQL = java.sql.Date.valueOf(identidade.getDataNascimento());   
             try (Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2"
                     , "root", "senha")) {


            String sqlEntidade = 
                "INSERT INTO Identidade(cpf,estadoCivil,data_nascimento,nacionalidade,profissao,sexo) "
                    + "VALUES (?,?,?,?,?,?)";

            PreparedStatement stmtEnt = conexao.prepareStatement(sqlEntidade, Statement.RETURN_GENERATED_KEYS);
            stmtEnt.setString(1, this.cpf);
            stmtEnt.setString(2, identidade.getEstadoCivil());
            stmtEnt.setDate(3, dataSQL );
            stmtEnt.setString(4, identidade.getNacionalidade());
            stmtEnt.setString(5, identidade.getProfissao());
            stmtEnt.setString(6, identidade.getSexo());
            stmtEnt.executeUpdate();

            


            } catch (SQLException e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
            }
            
            }
	
	
}
