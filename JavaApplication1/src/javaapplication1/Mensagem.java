/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author Renan
 */
public class Mensagem extends valida{
    private int id;
	private String Conteudo;
        
	private LocalDate data;

    public Mensagem(String Conteudo, LocalDate data, boolean status) {
        super(status);
        this.Conteudo = Conteudo;
        this.data = data;
    }

    

    public int getId() {
        return id;
    }

    public String getConteudo() {
        return Conteudo;
    }

    

    public LocalDate getData() {
        return data;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setConteudo(String Conteudo) {
        this.Conteudo = Conteudo;
    }

    

    public void setData(LocalDate data) {
        this.data = data;
    }
    public void ExibeMensagem(String mensagem){
                JOptionPane.showMessageDialog(
        null,
        mensagem,
        "Sucesso",
        JOptionPane.INFORMATION_MESSAGE
);
    }    
        
}
