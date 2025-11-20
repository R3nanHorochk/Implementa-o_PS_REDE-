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
public class Identidade {
    private int id;
	private String estadoCivil;
        private LocalDate dataNascimento;
        private String nacionalidade;
        private String profissao;
        private String sexo;
	public Identidade(String estadoCivil) {
		super();
		this.estadoCivil = estadoCivil;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public Identidade() {
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Identidade(String estadoCivil, LocalDate dataNascimento, String nacionalidade, 
            String profissao,String sexo ) {
        this.estadoCivil = estadoCivil;
        this.dataNascimento = dataNascimento;
        this.nacionalidade = nacionalidade;
        this.profissao = profissao;
        this.sexo = sexo;
    }
        
        
}
