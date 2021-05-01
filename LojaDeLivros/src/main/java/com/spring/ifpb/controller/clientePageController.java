package com.spring.ifpb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.ifpb.model.Autor;
import com.spring.ifpb.model.Cliente;
import com.spring.ifpb.model.Editora;
import com.spring.ifpb.model.Livro;
import com.spring.ifpb.repository.EditoraRepository;
import com.spring.ifpb.service.AutorService;
import com.spring.ifpb.service.ClienteService;
import com.spring.ifpb.service.EditoraService;
import com.spring.ifpb.service.LivroService;

@Controller
@RequestMapping("/")
public class clientePageController {

	@Autowired
	private AutorService autorService;
	
	@Autowired
	private LivroService livroService;
	
	@Autowired
	private EditoraService editoraService;
	
	@Autowired
	private EditoraRepository editoraRepository;
	
	@Autowired
	private ClienteService clienteService;
	

	@GetMapping
	public String paginaInicial() {
		return "index";
	}
	
	@GetMapping("index")
	public String paginaIndex() {
		return "index";
	}
	
	@GetMapping("/sobre")
	public String paginaSobre() {
		return "clientes/sobre";
	}
	
	@GetMapping("/login")
	public String paginaLogin() {
		return "login";
	}

	@RequestMapping("/listarLivros")
	public ModelAndView listarLivros() {
		ModelAndView modelAnsView = new ModelAndView("clientes/getLivros");
		Iterable<Livro> livros= livroService.findAll();
		modelAnsView.addObject("livros", livros);
		return modelAnsView;
	}

	
	@GetMapping("/listarAutores")
	public String listarAutores(Model model) {
		List<Autor> autores = autorService.findAll();
		model.addAttribute("autores", autores);
		return "admin/listagem/getAutores";
	}

	@GetMapping("/listarEditoras")
	public String listarEditoras(Model model) {
		List<Editora> lista = editoraRepository.findAll();
		model.addAttribute("editoras",lista);
		return "/listagem/getEditora";
	}
	
	@GetMapping("/cadastrarCliente")
	public String paginaNovoCliente() {
		return "clientes/NovoCliente";
	}
	
	@PostMapping("/createCliente")
	public String create(Cliente cliente) { 
		clienteService.create(cliente);
		return "redirect:/login";
	}
	
	
}
