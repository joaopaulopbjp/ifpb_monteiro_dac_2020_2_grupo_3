package com.spring.ifpb.model;

import java.math.BigDecimal;

import javax.persistence.Embeddable;


@Embeddable
public class Produto {
	
	private Long cod;
	
	private String descricao;
	
	private double qtd;
	
	private BigDecimal valorUnitario;
	
	private BigDecimal valorTotal;

	
	

	
	public Produto() {
	}


	public Produto(Livro livro,  double qtd) {
		this.cod = livro.getId();
		this.descricao = livro.getTitulo();
		this.qtd = qtd;
		this.valorUnitario = livro.getPreco();
		this.valorTotal =livro.getPreco().multiply(BigDecimal.valueOf(qtd));
	}


	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getQtd() {
		return qtd;
	}

	public void setQtd(double qtd) {
		this.qtd = qtd;
	}
	
//	public Long getId() {
//		return id;
//	}
//
//
//	public void setId(Long id) {
//		this.id = id;
//	}


	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}


	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}


	public BigDecimal getValorToral() {
		return valorTotal;
	}

	public void setValorToral(BigDecimal valorToral) {
		this.valorTotal = valorToral;
	}
	
}
