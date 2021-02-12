package com.spring.ifpb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.ifpb.model.Pedido;
import com.spring.ifpb.repository.PedidoRepository;

@Controller
@RequestMapping(value="/Pedidos")
public class PedidoController {

	@Autowired
	private PedidoRepository pedidoRepository;

	@GetMapping
	List<Pedido> listarPedidos() {
		return pedidoRepository.findAll();
	}

	@GetMapping("/{id}")
	Pedido buscarPeloId(@PathVariable(value="id")Long id) {
		return pedidoRepository.findById(id);
	}

	@PostMapping
	public String salvarPedido(Pedido p) {
		pedidoRepository.save(p);
		return "Peiddo registrado com sucesso!";
	}

	@DeleteMapping
	public String deletePedido(Pedido p) {
		pedidoRepository.delete(p);
		return "Pedido excluido com sucesso!";
	}
	
	@PutMapping
	public String atualizarLivro(Pedido p) {
		pedidoRepository.save(p);
		return "Pedido Atualizado";
	}
	
}
