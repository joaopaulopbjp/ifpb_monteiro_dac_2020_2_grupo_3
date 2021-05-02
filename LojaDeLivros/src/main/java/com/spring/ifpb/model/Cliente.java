package com.spring.ifpb.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	@Column(name = "USERNAME")
	private String username;
	
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
	
	@Column(name = "ROLE_CLIENTE")
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(joinColumns = @JoinColumn(name="usuario_id"),
				inverseJoinColumns = @JoinColumn(name="role_id"))
	private Collection<Role> roles;

	
	public Cliente() {

	}

	public Cliente(String cpf, String nome, String sobreNome, Date dtNacimento, String email,
			String senha) {
		super();
		this.username = email;
		this.cpf = cpf;
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.dtNacimento = dtNacimento;
		this.email = email;
		this.senha = senha;
	}
	
	public Cliente(String cpf, String nome, String sobreNome, Date dtNacimento, String email,
			String senha, Collection<Role> roles) {
		super();
		this.username = email;
		this.cpf = cpf;
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.dtNacimento = dtNacimento;
		this.email = email;
		this.senha = senha;
		this.roles = roles;
	}





	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
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
