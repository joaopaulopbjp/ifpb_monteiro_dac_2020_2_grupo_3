package com.spring.ifpb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.spring.ifpb.resources.CategoriaLivro;

@Entity
@Table(name="TB_CATEGORIA")
public class Categoria {
	
	//ATRIBUTOS
	
	@Id
	@Column(name="ID_CATEGORIA")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	@Column(name="DESCRICAO_CATEGORIA", unique = true)
	private CategoriaLivro nome;


	
	
	//METODOS
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public CategoriaLivro getNome() {
		return nome;
	}
	
	public void setNome(CategoriaLivro nome) {
		this.nome = nome;
	}

	

	
}
