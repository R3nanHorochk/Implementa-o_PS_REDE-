/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

import java.time.LocalDate;

/**
 *
 * @author Renan
 */
public class AceiteTermoItem {
    private int id;
	private ItemTermo item;
	private LocalDate data;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ItemTermo getItem() {
		return item;
	}
	public void setItem(ItemTermo item) {
		this.item = item;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public AceiteTermoItem(ItemTermo item, LocalDate data) {
		super();
		this.item = item;
		this.data = data;
	}
        
        
}
