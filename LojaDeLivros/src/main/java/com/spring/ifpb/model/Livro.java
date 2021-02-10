package com.spring.ifpb.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "TB_Livro")
@OnDelete(action = OnDeleteAction.CASCADE)
public class Livro {

	@Id
	@Column(name = "ID_LIVRO")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String titulo;

	private BigDecimal preco;
	
	private Integer qtd;

	@ManyToOne
	private Editora editora;

	@ManyToOne
	private Categoria categoria;

	@ManyToMany
	private List<Autor> autores;
	
//	@ManyToOne
//	private Prateleira prateleira;

	
	
	
	
	public void addAutor(Autor a) {
		autores = new ArrayList<>();
		autores.add(a);
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Integer getQtd() {
		return qtd;
	}

	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

//	public Prateleira getPrateleira() {
//		return prateleira;
//	}
//
//	public void setPrateleira(Prateleira prateleira) {
//		this.prateleira = prateleira;
//	}
//	
}
