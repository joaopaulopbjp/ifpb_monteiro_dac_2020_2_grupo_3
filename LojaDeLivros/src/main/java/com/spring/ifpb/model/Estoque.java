package com.spring.ifpb.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ESTOQUE")
public class Estoque {

	@Id
	@Column(name="ID_ESTOQUE")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Embedded
	private Endereco endereco;
	
	@ManyToMany
	private List<Livro> livrosEmEstoque;


	
	

	public void addLivro(Livro l) {
		livrosEmEstoque.add(l);
	}
	
	public void excluirLivro(Livro l) {
		livrosEmEstoque.remove(l);
	}
	
	
	
	
	
	public Estoque() {
		livrosEmEstoque = new ArrayList<Livro>();
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Endereco getEndereco() {
		return endereco;
	}


	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}


	public List<Livro> getLivrosEmEstoque() {
		return livrosEmEstoque;
	}


	public void setLivrosEmEstoque(List<Livro> livrosEmEstoque) {
		this.livrosEmEstoque = livrosEmEstoque;
	}
	
}
