package com.spring.ifpb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.ifpb.model.Cliente;
import com.spring.ifpb.service.ClienteService;
@RequestMapping("/cliente")
@Controller()
public class ClienteController {

	@Autowired
	private ClienteService clienteService;


	@PostMapping("/createCliente")
	public String create(Cliente cliente) { 
		clienteService.create(cliente);
		return "redirect:/listarClientes";
	}
}
