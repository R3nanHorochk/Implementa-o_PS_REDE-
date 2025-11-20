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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Renan
 */
public class Entidade {
    private int id;
	protected String nome;
	protected email email;
	protected List<Localizacao> enderecos;
    public void adicionarEndereco(String local) {
        Localizacao e1 = new Localizacao(local);
        enderecos.add(e1);
    }
    public void removerEndereco(int index) {
        enderecos.remove(index);
    }
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Localizacao> getEnderecos() {
		return enderecos;
	}
	public void setEnderecos(List<Localizacao> enderecos) {
		this.enderecos = enderecos;
	}
	public Entidade(String nome, List<Localizacao> enderecos,email emai) {
		super();
		this.nome = nome;
		this.enderecos = enderecos;
                this.email = emai;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public email getEmail() {
		return email;
	}
	public void setEmail(email email) {
		this.email = email;
	}
        public int SalvaEntidade(){
             int idEntidade = 0;
             try (Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2"
                     , "root", "senha")) {


            String sqlEntidade = 
                "INSERT INTO entidade (nome) VALUES (?)";

            PreparedStatement stmtEnt = conexao.prepareStatement(sqlEntidade, Statement.RETURN_GENERATED_KEYS);
            stmtEnt.setString(1, this.nome);
            stmtEnt.executeUpdate();

            // pega a chave gerada (idEntidade)
            ResultSet rsEnt = stmtEnt.getGeneratedKeys();

            if (rsEnt.next()) {
                idEntidade = rsEnt.getInt(1);
                this.setId(idEntidade);
            }


            } catch (SQLException e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
            }
            return idEntidade;
            }

     public void salvarEnderecos(){
         int idLocal = 0;
         try (Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2"
                     , "root", "senha")) {

             for (Localizacao loc : enderecos) {
            
            
            String sqlEntidade = 
                "INSERT INTO Endereco (idEntidade,local) VALUES (?,?)";

            PreparedStatement stmtEnt = conexao.prepareStatement(sqlEntidade, Statement.RETURN_GENERATED_KEYS);
            stmtEnt.setInt(1, this.id);
            stmtEnt.setString(2, loc.getLocal());
            stmtEnt.executeUpdate();

            // pega a chave gerada (idEntidade)
            ResultSet rsEnt = stmtEnt.getGeneratedKeys();

            if (rsEnt.next()) {
                idLocal = rsEnt.getInt(1);
                loc.setId(idLocal);
            }
            
            }

            } catch (SQLException e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
            }
     }
     
     public int SalvaEmail(){
             int idEmail = 0;
             
             try (Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2"
                     , "root", "senha")) {


            String sqlEntidade = 
                "INSERT INTO email (EnderecoEmail,idEntidade) VALUES (?,?)";

            PreparedStatement stmtEnt = conexao.prepareStatement(sqlEntidade, Statement.RETURN_GENERATED_KEYS);
            stmtEnt.setString(1, email.getEmail());
            stmtEnt.setInt(2, this.id);
            stmtEnt.executeUpdate();

            ResultSet rsEnt = stmtEnt.getGeneratedKeys();

            if (rsEnt.next()) {
                idEmail = rsEnt.getInt(1);
                this.email.setId(idEmail);
            }


            } catch (SQLException e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
            }
            return idEmail;
            }
}
