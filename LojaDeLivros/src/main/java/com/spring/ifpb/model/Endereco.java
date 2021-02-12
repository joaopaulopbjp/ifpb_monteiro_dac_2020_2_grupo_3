package com.spring.ifpb.model;

import javax.persistence.Embeddable;

@Embeddable
public class Endereco {

	private String Estado;
	
	private String cidade;
	
	private String CEP;
	
	private String logradoro;
	
	private String numero;

	
	
	
	
	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String cEP) {
		CEP = cEP;
	}

	public String getLogradoro() {
		return logradoro;
	}

	public void setLogradoro(String logradoro) {
		this.logradoro = logradoro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
}
