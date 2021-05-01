package com.spring.ifpb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.ifpb.model.Autor;
import com.spring.ifpb.service.AutorService;

@RequestMapping("/autor")
@Controller()
public class AutorController {
	@Autowired
	private AutorService autorService;



	@GetMapping("/{id}")
	public String buscarPeloID(@PathVariable(value = "id")Long id, Model model) {
		model.addAttribute("autor", autorService.findById(id));
		return "buscarPeloID";
	}

	@GetMapping("/ola")
	public String run(Model model) {
		model.addAttribute("listaCompleta", "Ola Mundo");
		return "OlaMundo";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/createAutor")
	public String create(Autor a) {
		autorService.create(a);
		return "redirect:/listarAutores";
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

	@GetMapping("/excluir/{id}")
	public String delete(@PathVariable(value="id") Long id) {
		autorService.delete(id);
		return "redirect:/admin/listarAutores";
	}

	@PutMapping
	public Autor atualizarAutor(long id) {
		autorService.update(id);
		Autor a = autorService.findById(id);
		return a;
	}

}
