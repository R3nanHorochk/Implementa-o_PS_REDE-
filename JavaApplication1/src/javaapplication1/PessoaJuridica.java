/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Renan
 */
public class PessoaJuridica extends Entidade {
	private String cnpj;
	private PessoaFisica representante;
	private certidao certidao;
	public PessoaJuridica(String nome, List<String> enderecosComercial,String Email, 
                String cnpj, PessoaFisica representante,String legalName,String registroEmpresa,
                LocalDate anexadoCertidao) {
                email e1 = new email(Email);
                List<Localizacao> enderecosC = new ArrayList<>();
                for (String ender : enderecosComercial) {
                Localizacao l1 = new Localizacao(ender);
                enderecosC.add(l1);
                }
		super(nome, enderecosC,e1);
		this.cnpj = cnpj;
		this.representante = representante;
                certidao c1 = new certidao(legalName,registroEmpresa,anexadoCertidao);
		this.certidao = c1;
                
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public PessoaFisica getRepresentante() {
		return representante;
	}
	public void setRepresentante(PessoaFisica representante) {
		this.representante = representante;
	}
	public certidao getCertidao() {
		return certidao;
	}
	public void setCertidao(certidao certidao) {
		this.certidao = certidao;
	}
	public void SalvaPJ(String CPF){
                
             try (Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2"
                     , "root", "senha")) {


            String sqlEntidade = 
                "INSERT INTO PessoaJuridica(cnpj,cpf_representante,idEntidade) VALUES (?,?,?)";

            PreparedStatement stmtEnt = conexao.prepareStatement(sqlEntidade, Statement.RETURN_GENERATED_KEYS);
            stmtEnt.setString(1, this.cnpj);
            stmtEnt.setString(2, CPF);
            stmtEnt.setInt(3, this.getId());
            stmtEnt.executeUpdate();

            


            } catch (SQLException e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
            }
            
            }
        
        
        
        public void SalvaCertidao(){
             
            java.sql.Date dataSQL = java.sql.Date.valueOf(certidao.getAnexadoCertidao());   
             try (Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2"
                     , "root", "senha")) {


            String sqlEntidade = 
                "INSERT INTO Certidao(cnpj,legalNome,registroEmpresa,anexadoCertidao) "
                    + "VALUES (?,?,?,?)";

            PreparedStatement stmtEnt = conexao.prepareStatement(sqlEntidade, Statement.RETURN_GENERATED_KEYS);
            stmtEnt.setString(1, this.cnpj);
            stmtEnt.setString(2, certidao.getLegalName());
            stmtEnt.setString(3, certidao.getRegistroEmpresa());
            stmtEnt.setDate(4, dataSQL);
            stmtEnt.executeUpdate();

            


            } catch (SQLException e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
            System.out.println(cnpj);
            }
            
            }
	
}
