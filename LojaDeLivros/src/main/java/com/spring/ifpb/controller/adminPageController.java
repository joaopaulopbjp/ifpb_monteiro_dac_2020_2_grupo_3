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
@RequestMapping("/admin")
public class adminPageController {

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
	public String home2() {
		return "admin/pagInicial";
	}
	
	
	@GetMapping("/sobre")
	public String paginaSobre() {
		return "admin/adminSobre";
	}


	
	@RequestMapping("/listarLivros")
	public ModelAndView listarLivros() {
		ModelAndView modelAnsView = new ModelAndView("admin/listagem/getLivros");
		Iterable<Livro> livros= livroService.findAll();
		modelAnsView.addObject("livros", livros);
		return modelAnsView;
	}
	
	@GetMapping("/cadastrarLivro")
	public String novoLivro(Livro novoLivro,Model model) {
		model.addAttribute(new Livro());
		model.addAttribute("editoras", editoraService.findAll());
		model.addAttribute("autores", autorService.findAll());
		return "admin/cadastro/NewLivro";
	}

	@GetMapping("/editarLivro/{id}")
	public String editarLivro(@PathVariable(value="id") Long id,Livro livro,Model model) {
		
		Livro livro1 = livroService.findById(id).get();
		model.addAttribute("livro",livro1);
		livro = livro1;
		model.addAttribute("autores",autorService.findAll());
		model.addAttribute("editoras",editoraService.findAll());
		return "admin/cadastro/EditarLivro";
	}
	
	@GetMapping("/listarAutores")
	public String listarAutores(Model model) {
		List<Autor> autores = autorService.findAll();
		model.addAttribute("autores", autores);
		return "admin/listagem/getAutores";
	}
	
	@GetMapping("/cadastrarAutor")
	public String pagCadastro() {
		return "admin/cadastro/NewAutor";
	}

	@GetMapping("/listarEditoras")
	public String listarEditoras(Model model) {
		List<Editora> lista = editoraRepository.findAll();
		model.addAttribute("editoras",lista);
		return "admin/listagem/getEditora";
	}
	
	@GetMapping("/cadastrarEditora")
	public String paginaNovaCategoria() {
		return "admin/cadastro/NewEditora";
	}


	@GetMapping("/listarClientes")
	public String listarClientes(Model model) {
		List<Cliente> autores = clienteService.findAll();
		model.addAttribute("clientes", autores);
		return "admin/listagem/getClientes";
	}
	
	@GetMapping("/cadastrarCliente")
	public String paginaNovoCliente() {
		return "admin/cadastro/NewCliente";
	}
	
	
	
}
