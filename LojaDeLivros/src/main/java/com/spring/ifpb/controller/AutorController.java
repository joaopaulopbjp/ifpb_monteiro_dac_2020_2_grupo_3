package com.spring.ifpb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.ifpb.model.Autor;
import com.spring.ifpb.service.AutorService;

@RequestMapping("/autor")
@Controller()
public class AutorController {
	@Autowired
	private AutorService autorService;

	@GetMapping("/inicio")
	public String paginaInicial() {
		return "pagInicial";
	}
	
	@GetMapping("/getAutores")
	public String listarAutores(Model model) {
		List<Autor> autores = autorService.findAll();
		model.addAttribute("autores", autores);
		return "getAutores";
	}
	
	@GetMapping("/buscarPeloEmail")
	public String econtrarAutorPeloEmail(String email, Model model) {
		
		model.addAttribute("buscarPeloEmail", autorService.findByEmail(email));
		return "buscarPeloEmail";
	}
	
	@GetMapping("/ola")
	public String run(Model model) {
		model.addAttribute("listaCompleta","Ola Mundo");
		return "OlaMundo";
	}

//	@GetMapping("/{id}")
//	public Autor buscarPeloId(@PathVariable(value = "id") long id) {
//		return autorService.findById(id);
//	}
//
//	@GetMapping("/{nome}")
//	public Autor buscarPeloNome(@PathVariable(value = "nome") String nome) {
//		return autorService.findByNome(nome);
//	}


	@DeleteMapping
	public ResponseEntity<?> delete(@PathVariable("email") String email) {
		autorService.delete(email);
		return ResponseEntity.ok().build();
	}	


	@PutMapping
	public Autor atualizarAutor(String email) {
		autorService.update(email);
		Autor a = autorService.findByEmail(email);
		return a;
	}

}
