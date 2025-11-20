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
public class certidao {
    private int id;
	private String legalName;
        private String registroEmpresa;
        private LocalDate anexadoCertidao;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLegalName() {
		return legalName;
	}
	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}
	public certidao(String legalName) {
		super();
		this.legalName = legalName;
	}

    public String getRegistroEmpresa() {
        return registroEmpresa;
    }

    public LocalDate getAnexadoCertidao() {
        return anexadoCertidao;
    }

    public void setRegistroEmpresa(String registroEmpresa) {
        this.registroEmpresa = registroEmpresa;
    }

    public void setAnexadoCertidao(LocalDate anexadoCertidao) {
        this.anexadoCertidao = anexadoCertidao;
    }

    public certidao(String legalName, String registroEmpresa, LocalDate anexadoCertidao) {
        this.legalName = legalName;
        this.registroEmpresa = registroEmpresa;
        this.anexadoCertidao = anexadoCertidao;
    }
    
	
}
