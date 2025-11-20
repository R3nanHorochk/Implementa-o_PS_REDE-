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
public class Perfil {
    private int id;
	private String Perfil;
	private List<Habilidade> habilidades;
	private List<Interesse> interesses;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPerfil() {
		return Perfil;
	}
	public void setPerfil(String perfil) {
		Perfil = perfil;
	}
	public List<Habilidade> getHabilidades() {
		return habilidades;
	}
	public void setHabilidades(List<Habilidade> habilidades) {
		this.habilidades = habilidades;
	}
	public List<Interesse> getInteresses() {
		return interesses;
	}
	public void setInteresses(List<Interesse> interesses) {
		this.interesses = interesses;
	}
	public Perfil(String perfil, List<String> habilidades, List<String> interesses) {
		super();
		Perfil = perfil;
                List<Habilidade> habil = new ArrayList<>();
                for (String habiTxt : habilidades) {
                Habilidade H1 = new Habilidade(habiTxt);
                habil.add(H1);
                }
                List<Interesse> Inter = new ArrayList<>();
                for (String InteTxt : interesses) {
                Interesse I1 = new Interesse(InteTxt);
                Inter.add(I1);
                }
                this.habilidades = habil;
		this.interesses = Inter;
	}
        
        public void salvarPerfil(int idCand){
         int idLocal = 0;
         try (Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2"
                     , "root", "senha")) {

            
            
            
            String sqlEntidade = 
                "INSERT INTO Perfil (descricao,idCand) VALUES (?,?)";

            PreparedStatement stmtEnt = conexao.prepareStatement(sqlEntidade, Statement.RETURN_GENERATED_KEYS);
            stmtEnt.setString(1, this.Perfil);
            stmtEnt.setInt(2, idCand);
            stmtEnt.executeUpdate();

            // pega a chave gerada (idEntidade)
            ResultSet rsEnt = stmtEnt.getGeneratedKeys();

            if (rsEnt.next()) {
                idLocal = rsEnt.getInt(1);
                this.setId(idLocal);
            }
            
            

            } catch (SQLException e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
            }
        }
        
        public void salvarHabilidades(){
         int idLocal = 0;
         try (Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2"
                     , "root", "senha")) {

             for (Habilidade Hab : habilidades) {
            
            
            String sqlEntidade = 
                "INSERT INTO habilidade (idPerfil,descricao) VALUES (?,?)";

            PreparedStatement stmtEnt = conexao.prepareStatement(sqlEntidade, Statement.RETURN_GENERATED_KEYS);
            stmtEnt.setInt(1, this.id);
            stmtEnt.setString(2, Hab.getHabilidade());
            stmtEnt.executeUpdate();

            // pega a chave gerada (idEntidade)
            ResultSet rsEnt = stmtEnt.getGeneratedKeys();

            if (rsEnt.next()) {
                idLocal = rsEnt.getInt(1);
                Hab.setId(idLocal);
            }
            
            }

            } catch (SQLException e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
            }
     }
        
        public void salvarInteresses(){
         int idLocal = 0;
         try (Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2"
                     , "root", "senha")) {

             for (Interesse Inter : interesses) {
            
            
            String sqlEntidade = 
                "INSERT INTO Interesse (idPerfil,descricao) VALUES (?,?)";

            PreparedStatement stmtEnt = conexao.prepareStatement(sqlEntidade, Statement.RETURN_GENERATED_KEYS);
            stmtEnt.setInt(1, this.id);
            stmtEnt.setString(2, Inter.getInteresse());
            stmtEnt.executeUpdate();

            // pega a chave gerada (idEntidade)
            ResultSet rsEnt = stmtEnt.getGeneratedKeys();

            if (rsEnt.next()) {
                idLocal = rsEnt.getInt(1);
                Inter.setId(idLocal);
            }
            
            }

            } catch (SQLException e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
            }
     }
	
}
