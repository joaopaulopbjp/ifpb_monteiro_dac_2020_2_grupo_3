package com.spring.ifpb.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_PEDIDO")
public class Pedido {

	@Id
	@Column(name="ID_PEDIDO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "TB_PEDIDO_PRODUTO")
	private List<Produto> produtos;
	
	private BigDecimal valorTotal;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dtPedido;
	
	
	

	public void addProduto(Produto p) {
		produtos.add(p);
		calcularValorDoPedido();
	}
	
	public void excluirProduto(Produto p) {
		produtos.remove(p);
		calcularValorDoPedido();
	}
	
	public void calcularValorDoPedido() {
		produtos.forEach(prod -> valorTotal= prod.getValorToral().add(valorTotal));
	}
	
	
	
	
	
	
	public Pedido() {
		this.produtos = new ArrayList<Produto>();
		this.dtPedido = new Date();
		this.valorTotal= new BigDecimal(0);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Produto> getItens() {
		return produtos;
	}

	public void setItens(List<Produto> itens) {
		this.produtos = itens;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
	
}
