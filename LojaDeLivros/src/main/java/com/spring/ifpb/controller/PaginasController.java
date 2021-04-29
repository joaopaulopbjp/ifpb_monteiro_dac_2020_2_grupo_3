package com.spring.ifpb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
public class PaginasController {

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

	
	@RequestMapping("/listarLivros")
	public ModelAndView listarLivros() {
		ModelAndView modelAnsView = new ModelAndView("listagem/getLivros");
		Iterable<Livro> livros= livroService.findAll();
		modelAnsView.addObject("livros", livros);
		return modelAnsView;
	}
	
	@GetMapping("/cadastrarLivro")
	public String novoLivro(Livro novoLivro,Model model) {
		model.addAttribute(new Livro());
		model.addAttribute("editoras", editoraService.findAll());
		model.addAttribute("autores", autorService.findAll());
		return "cadastro/NewLivro";
	}

	@GetMapping("/listarAutores")
	public String listarAutores(Model model) {
		List<Autor> autores = autorService.findAll();
		model.addAttribute("autores", autores);
		return "listagem/getAutores";
	}
	
	@GetMapping("/cadastrarAutor")
	public String pagCadastro() {
		return "cadastro/NewAutor";
	}

	@GetMapping("/listarEditoras")
	public String listarEditoras(Model model) {
		List<Editora> lista = editoraRepository.findAll();
		model.addAttribute("editoras",lista);
		return "listagem/getEditora";
	}
	
	@GetMapping("/cadastrarEditora")
	public String paginaNovaCategoria() {
		return "/cadastro/NewEditora";
	}


	@GetMapping("/listarClientes")
	public String listarClientes(Model model) {
		List<Cliente> autores = clienteService.findAll();
		model.addAttribute("clientes", autores);
		return "listagem/getClientes";
	}
	
	@GetMapping("/cadastrarCliente")
	public String paginaNovoCliente() {
		return "cadastro/NewCliente";
	}
	
	
	
}
