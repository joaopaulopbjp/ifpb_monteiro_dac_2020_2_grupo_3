package com.spring.ifpb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PaginasController {

	@GetMapping("/home")
	public String home() {
		return "pagInicial";
	}
	
	@GetMapping
	public String paginaInicial() {
		return "pagInicial";
	}
	
	@GetMapping("/sobre")
	public String paginaSobre() {
		return "sobre";
	}
}
