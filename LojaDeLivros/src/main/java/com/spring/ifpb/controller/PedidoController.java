package com.spring.ifpb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.ifpb.model.Pedido;
import com.spring.ifpb.service.PedidoService;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;

	@GetMapping
	List<Pedido> listarPedidos() {
		return pedidoService.findAll();
	}

	@GetMapping("/{id}")
	Pedido buscarPeloId(@PathVariable(value = "id") Long id) {
		return pedidoService.findById(id);
	}

	@PostMapping
	public String salvarPedido(Pedido p) {
		pedidoService.save(p);
		return "Peiddo registrado com sucesso!";
	}

	@PutMapping
	public String atualizarLivro(Pedido p) {
		pedidoService.save(p);
		return "Pedido Atualizado";
	}

}
