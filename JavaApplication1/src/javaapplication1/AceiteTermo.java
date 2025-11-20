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
public class AceiteTermo {
    private int id;
	private List<AceiteTermoItem> itens;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public List<AceiteTermoItem> getItens() {
		return itens;
	}
	public void setItens(List<AceiteTermoItem> itens) {
		this.itens = itens;
	}
	public AceiteTermo(List<AceiteTermoItem> itens) {
		super();
		this.itens = itens;
	}
        public void SalvaAceiteOB(int idAfi){
             int idAceite = 0;
             try (Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2"
                     , "root", "senha")) {


            String sqlEntidade = 
                "INSERT INTO AceiteTermo(idAfiliacao,idTermo) VALUES (?,?)";

            PreparedStatement stmtEnt = conexao.prepareStatement(sqlEntidade, Statement.RETURN_GENERATED_KEYS);
            stmtEnt.setInt(1, idAfi);
            stmtEnt.setInt(2, 1);
            stmtEnt.executeUpdate();

            ResultSet rsEnt = stmtEnt.getGeneratedKeys();

            if (rsEnt.next()) {
                idAceite = rsEnt.getInt(1);
                this.setId(idAceite);
            }


            } catch (SQLException e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
            }
            
            }
        
        public void SalvaAceiteOP(int idAfi){
             int idAceite = 0;   
             try (Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2"
                     , "root", "senha")) {


            String sqlEntidade = 
                "INSERT INTO AceiteTermo(idAfiliacao,idTermo) VALUES (?,?)";

            PreparedStatement stmtEnt = conexao.prepareStatement(sqlEntidade, Statement.RETURN_GENERATED_KEYS);
            stmtEnt.setInt(1, idAfi);
            stmtEnt.setInt(2, 2);
            stmtEnt.executeUpdate();
            
            ResultSet rsEnt = stmtEnt.getGeneratedKeys();
            
            if (rsEnt.next()) {
                idAceite = rsEnt.getInt(1);
                this.setId(idAceite);
            }


            } catch (SQLException e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
            }
            
            }
        
        public void salvarItensAceite(){
         int idATI = 0;
         try (Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2"
                     , "root", "senha")) {

             for (AceiteTermoItem ati : itens) {
            
            
            String sqlEntidade = 
                "INSERT INTO ItemAceite(idAceite,idItemTermo,descricao) VALUES (?,?,?)";

            PreparedStatement stmtEnt = conexao.prepareStatement(sqlEntidade, Statement.RETURN_GENERATED_KEYS);
            stmtEnt.setInt(1, this.id);
            stmtEnt.setInt(2, ati.getItem().getId());
            stmtEnt.setString(3, ati.getItem().getDescricao());
            stmtEnt.executeUpdate();

            // pega a chave gerada (idEntidade)
            ResultSet rsEnt = stmtEnt.getGeneratedKeys();

            if (rsEnt.next()) {
                idATI = rsEnt.getInt(1);
                ati.setId(idATI);
            }
            
            }

            } catch (SQLException e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
            }
     }
	
}
