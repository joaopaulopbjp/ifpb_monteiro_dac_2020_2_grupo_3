package com.spring.ifpb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_EDITORA")

public class Editora {

	@Id
	@Column(name = "ID_EDITORA")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name= "NOME_EDITORA", unique = true)
	private String nome;

	
	public Editora() {

	}

	public Editora(String nome) {
		this.nome = nome;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
