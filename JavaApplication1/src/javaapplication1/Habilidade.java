/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

/**
 *
 * @author Renan
 */
public class Habilidade {
    private int id;
	private String Habilidade;

	

	public Habilidade(String habilidade) {
		super();
		Habilidade = habilidade;
	}

	public String getHabilidade() {
		return Habilidade;
	}

	public void setHabilidade(String habilidade) {
		Habilidade = habilidade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
