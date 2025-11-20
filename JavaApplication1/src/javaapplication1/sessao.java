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
import java.util.List;

/**
 *
 * @author Renan
 */
public class sessao {
    private int id;
	private Candidato candidato;
	private Afiliacao afiliacao;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Candidato getCandidato() {
		return candidato;
	}
	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}
	public Afiliacao getAfiliacao() {
		return afiliacao;
	}
	public void setAfiliacao(Afiliacao afiliacao) {
		this.afiliacao = afiliacao;
	}
	public sessao() {
		super();
	}
        
        public PessoaFisica CriarPessoaF(){
        PessoaFisica p1 = new PessoaFisica();
        p1.setCand(candidato);
        return p1;
        }
        
        public PessoaFisica CriarPessoaF(String nome,List<String> end,String emailT,String cpf,String estadoCivil,
                            LocalDate dataNascimento,String nacionalidade, String profissao,String s){
        PessoaFisica p1 = new PessoaFisica(nome,end,emailT,cpf,estadoCivil,
                dataNascimento,nacionalidade,profissao,candidato,s);
        return p1;
        }
        
        public PessoaJuridica CriarPessoaJ(String nome,List<String> end,String emailT,String cnpj,
                            PessoaFisica representante,String legalName, 
                            String registroEmpresa,LocalDate anexadoCertidao){
        PessoaJuridica p1 = new PessoaJuridica(nome,end,emailT,cnpj,representante,
                legalName,registroEmpresa,anexadoCertidao);
        return p1;
        }
        public Afiliacao CriarAfiliacao(){
        Afiliacao afilia = new Afiliacao("PENDENTE",this.candidato);
        this.afiliacao = afilia;
        SalvaAfiliacao();
        return afilia;
        }
        
        public Candidato CriarCandidato(){
        Candidato cand = new Candidato();
        this.candidato = cand;
        SalvaCandidato();
        return cand;
        }
        
        public void SalvaAfiliacao(){
             int idResult = 0;   
             try (Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2"
                     , "root", "senha")) {


            String sqlEntidade = 
                "INSERT INTO Afiliacao(STATUS,idCand) VALUES (?,?)";

            PreparedStatement stmtEnt = conexao.prepareStatement(sqlEntidade, Statement.RETURN_GENERATED_KEYS);
            stmtEnt.setString(1, "PENDENTE");
            stmtEnt.setInt(2, this.candidato.getId());
            stmtEnt.executeUpdate();

              ResultSet rsEnt = stmtEnt.getGeneratedKeys();

            if (rsEnt.next()) {
                idResult = rsEnt.getInt(1);
                this.afiliacao.setId(idResult);
            }


            } catch (SQLException e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
            }
            
            }
        
         public void SalvaCandidato(){
             int idResult = 0;   
             try (Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2"
                     , "root", "senha")) {


            String sqlEntidade = 
                "INSERT INTO Candidato(STATUS) VALUES (?)";

            PreparedStatement stmtEnt = conexao.prepareStatement(sqlEntidade, Statement.RETURN_GENERATED_KEYS);
            stmtEnt.setString(1, "PENDENTE");
            stmtEnt.executeUpdate();

              ResultSet rsEnt = stmtEnt.getGeneratedKeys();

            if (rsEnt.next()) {
                idResult = rsEnt.getInt(1);
                this.candidato.setId(idResult);
            }


            } catch (SQLException e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
            }
            
            }
         
         public void MudarStatus(String status){
             
             try (Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2"
                     , "root", "senha")) {

        String sql = "UPDATE Candidato SET STATUS = ? WHERE idCand = ?";

        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, status); // novo status
        stmt.setInt(2, this.candidato.getId()); // id do candidato existente

        int rows = stmt.executeUpdate();

        if (rows > 0) {
            System.out.println("Status atualizado com sucesso!");
            this.candidato.setStatus(status); // atualiza no objeto também
        } else {
            System.out.println("Nenhum candidato encontrado para atualizar.");
        }
        
         String sqlAfil = "UPDATE Afiliacao SET STATUS = ? WHERE idAfiliacao = ?";
        PreparedStatement stmtAfil = conexao.prepareStatement(sqlAfil);
        stmtAfil.setString(1, status);
        stmtAfil.setInt(2, this.afiliacao.getId());

        int rowsAfil = stmtAfil.executeUpdate();

        if (rowsAfil > 0) {
            System.out.println("Status da afiliação atualizado!");
            this.afiliacao.setStatus(status);
        } else {
            System.out.println("Nenhuma afiliação encontrada para atualizar.");
        }

            } catch (SQLException e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
            }
             
            
            }
	
    
}
