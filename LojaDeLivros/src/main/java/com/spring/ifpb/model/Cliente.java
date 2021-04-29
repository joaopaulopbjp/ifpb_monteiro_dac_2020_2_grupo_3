package com.spring.ifpb.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.sun.istack.NotNull;

@Entity
@Table(name = "TB_CLIENTE")
public class Cliente {

	@Id
	@Column(name = "ID_CLIENTE")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	@Column(name = "CPF_CLIENTE")
	private String cpf;

	@NotNull
	@Column(name = "NOME_CLIENTE")
	private String nome;

	@NotNull
	@Column(name = "SOBRENOME_CLIENTE")
	private String sobreNome;

	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_NASC_CLIENTE")
	private Date dtNacimento;

	@NotNull
	@Column(name = "EMAIL_CLIENTE")
	private String email;

	@NotNull
	@Column(name = "SENHA_CLIENTE")
	private String senha;

	public String getCPF() {
		return cpf;
	}

	public void setCPF(String cpf) {
		cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDtNacimento() {
		return dtNacimento;
	}

	public void setDtNacimento(Date dtNacimento) {
		this.dtNacimento = dtNacimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

}
