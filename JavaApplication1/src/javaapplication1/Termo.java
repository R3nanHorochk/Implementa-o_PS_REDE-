/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Renan
 */
public class Termo {
    private int id;
	private String nomeTermo;
	private List<ItemTermo> itens;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomeTermo() {
		return nomeTermo;
	}
	public void setNomeTermo(String nomeTermo) {
		this.nomeTermo = nomeTermo;
	}
	public List<ItemTermo> getItens() {
		return itens;
	}
	public void setItens(List<ItemTermo> itens) {
		this.itens = itens;
	}
	public Termo(String nomeTermo, List<ItemTermo> itens) {
		super();
		this.nomeTermo = nomeTermo;
		this.itens = itens;
	}
	
	
	
}
