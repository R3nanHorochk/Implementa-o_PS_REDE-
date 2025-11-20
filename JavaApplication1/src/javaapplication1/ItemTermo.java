/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

/**
 *
 * @author Renan
 */
    public class ItemTermo {
        private int id;
            private String descricao;
            public int getId() {
                    return id;
            }
            public void setId(int id) {
                    this.id = id;
            }
            public String getDescricao() {
                    return descricao;
            }
            public void setDescricao(String descricao) {
                    this.descricao = descricao;
            }
            public ItemTermo(String descricao) {
                    super();
                    this.descricao = descricao;
            }

    public ItemTermo(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }
            
            

    }
