//package com.spring.ifpb.model;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.ManyToMany;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//@Entity
//@Table(name="TB_PRATELEIRA")
//public class Prateleira {
//
//	public Prateleira() {
//		livros = new ArrayList<Livro>();
//	}
//
//	@Id
//	@Column(name="ID_PRATELEIRA")
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Long id;
//	
//	private String localizacao;
//	
//	@ManyToOne
//	private CDD cdd;
//
//	@ManyToMany
//	private List<Livro> livros;
//	
//	
//	
//	
//
//	public void addLivro(Livro lv) {
//		getLivros().add(lv);
//	}
//	
//	
//	
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getLocalizacao() {
//		return localizacao;
//	}
//
//	public void setLocalizacao(String localizacao) {
//		this.localizacao = localizacao;
//	}
//
//	public CDD getCdd() {
//		return cdd;
//	}
//
//	public void setCdd(CDD cdd) {
//		this.cdd = cdd;
//	}
//
//	public List<Livro> getLivros() {
//		return livros;
//	}
//
//	public void setLivros(List<Livro> livros) {
//		this.livros = livros;
//	}
//	
//}
