/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

/**
 *
 * @author Renan
 */
public class Interesse {
    private int id;
	private String Interesse;
	public Interesse(String interesse) {
		super();
		Interesse = interesse;
	}
	public String getInteresse() {
		return Interesse;
	}
	public void setInteresse(String interesse) {
		Interesse = interesse;
	}

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
        
	
}
