package com.spring.ifpb.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String titulo;

	private String categoria;

	private BigDecimal preco;

	@Column(name = "QTD_ESTOQUE")
	private Integer qtdEstoque;

	@ManyToOne(cascade = {CascadeType.REMOVE})
	private Editora editora;
	
	@ManyToOne(cascade = {CascadeType.REMOVE})
	private Autor autor;

	
	public Livro(String titulo, String categoria, BigDecimal preco, Integer qtdEstoque, Editora editora, Autor autor) {
		super();
		this.titulo = titulo;
		this.categoria = categoria;
		this.preco = preco;
		this.qtdEstoque = qtdEstoque;
		this.editora = editora;
		this.autor = autor;
	}

	public Livro() {

	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

//	@ManyToMany
//	private List<Autor> autores;

//	public void addAutor(Autor a) {
//		autores = new ArrayList<>();
//		autores.add(a);
//	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Integer getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(Integer qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
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

//	public List<Autor> getAutores() {
//		return autores;
//	}
//
//	public void setAutores(List<Autor> autores) {
//		this.autores = autores;
//	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

}
