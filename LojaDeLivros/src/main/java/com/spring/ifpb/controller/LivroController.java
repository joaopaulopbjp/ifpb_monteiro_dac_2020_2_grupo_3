package com.spring.ifpb.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.ifpb.model.Livro;
import com.spring.ifpb.service.LivroService;

@RequestMapping("/livro")
@Controller
public class LivroController {
	
	@Autowired
	private LivroService livroService;
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/createLivro")
	public String createLivro(@ModelAttribute  Livro novoLivro,Model model) {
		livroService.adicionarNovoLivro(novoLivro);
		return "redirect:/admin/listarLivros";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/editarLivro")
	public String atualizarLivro(@ModelAttribute  Livro novoLivro,Model model) {
		livroService.adicionarNovoLivro(novoLivro);
		model.addAttribute("livros",livroService.findAll());
		return "redirect:/admin/listarLivros";
	}
	
	@GetMapping("/buscar/{id}")
	public Livro buscarPeloId(@PathVariable(value="id") long id){
		return livroService.findById(id);
	}
	@GetMapping("/excluir/{id}")
	public String excluirLivro(@PathVariable(value="id") Long id, Model model) {
		livroService.deletarLivroId(id);
		model.addAttribute("livros",livroService.findAll());
		return "redirect:/admin/listarLivros";
	}



}