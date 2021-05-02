package com.spring.ifpb.controller;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
import com.spring.ifpb.model.Role;
import com.spring.ifpb.repository.EditoraRepository;
import com.spring.ifpb.repository.RoleRepository;
import com.spring.ifpb.service.AutorService;
import com.spring.ifpb.service.ClienteService;
import com.spring.ifpb.service.EditoraService;
import com.spring.ifpb.service.LivroService;

@Controller
@RequestMapping("/")
public class ClientePageController {

	@Autowired
	private AutorService autorService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private LivroService livroService;

	@Autowired
	private EditoraRepository editoraRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private ClienteService clienteService;

	@GetMapping
	public String paginaInicial() {
		return "index";
	}

	@GetMapping("/indice")
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
	
	@GetMapping("/dadosLivros")
	public String dadosLivros() {
		//autores
		autorService.create(new Autor("Zé Bola"));
		autorService.create(new Autor("Zé Cabra"));
		autorService.create(new Autor("Amaraí Silva"));
		autorService.create(new Autor("Quermoges Sousa"));
		autorService.create(new Autor("Amaro Brian"));
		autorService.create(new Autor("Geandalo Bola"));
		autorService.create(new Autor("Pedro Cirrose"));
		autorService.create(new Autor("Pôrô Dubar"));
		autorService.create(new Autor("Geraldo Fro Xao"));
		autorService.create(new Autor("Pedro Dubar"));
		
		//editora
		editoraRepository.save(new Editora("Papudinhos"));
		editoraRepository.save(new Editora("Paud'aguas"));
		editoraRepository.save(new Editora("LomBrass"));
		editoraRepository.save(new Editora("Res aCas"));
		editoraRepository.save(new Editora("Porr Isdevodka"));
		
		//livros
		List<Autor> aut = autorService.findAll();
		List<Editora> ed = editoraRepository.findAll();
		livroService.adicionarNovoLivro(new Livro("Alcoolicos Anonimo", 			"AUTO_AJUDA", new BigDecimal(34.90) ,10 , ed.get(0), aut.get(0)));
		livroService.adicionarNovoLivro(new Livro("Eu, tu e eu mesmo", 				"FOLCLORE", new BigDecimal(24.90) ,20 , ed.get(1), aut.get(1)));
		livroService.adicionarNovoLivro(new Livro("Se não é hoje é amanhã", 		"TECNICO_PROFISSIONAL", new BigDecimal(34.90) ,15 , ed.get(2), aut.get(2)));
		livroService.adicionarNovoLivro(new Livro("Se tu fô eu vô", 				"POESIA", new BigDecimal(54.90) ,05 , ed.get(3), aut.get(3)));
		livroService.adicionarNovoLivro(new Livro("Os Piratas", 					"FABULAS", new BigDecimal(14.90) ,22 , ed.get(4), aut.get(4)));
		livroService.adicionarNovoLivro(new Livro("Estourando O'Zovos", 			"GIBI", new BigDecimal(54.90) ,18 , ed.get(0), aut.get(5)));
		livroService.adicionarNovoLivro(new Livro("Qualquer coisa é a mesma coisa", "FICCAO", new BigDecimal(23.90) ,14 , ed.get(1), aut.get(6)));
		livroService.adicionarNovoLivro(new Livro("Nós e a Magaveia",	 			"DRAMA", new BigDecimal(99.90) ,12 , ed.get(2), aut.get(7)));
		livroService.adicionarNovoLivro(new Livro("Um toicim num faz mal a ninguem","CONTOS", new BigDecimal(99.90) ,11 , ed.get(3), aut.get(8)));
		livroService.adicionarNovoLivro(new Livro("Um dia eu vou me formar",		"CIENCIA", new BigDecimal(10.90) ,19 , ed.get(4), aut.get(9)));
		
		return "redirect:/indice";
	}
	
	
	@GetMapping("/dadosIniciais")
	public String dados() {
		
		Role adminRole = roleRepository.findByRole("ADMIN");
		Cliente c1 = new Cliente("123.456.789-98", "Evandson", "Oliveira", new Date(93,07,06), "oliveranza@gmail.com", passwordEncoder.encode("123"));
		c1.setRoles(Arrays.asList(adminRole));
		clienteService.create(c1);
		
		Role usersRole = roleRepository.findByRole("USERS");
		Cliente c2 = new Cliente("987.654.321-01", "Jose", "Caio", new Date(93,03,05), "josecaio@gmail.com", passwordEncoder.encode("123"));
		c2.setRoles(Arrays.asList(usersRole));
		clienteService.create(c2);
		
		return "redirect:/indice";
	}
	
	@GetMapping("/addRoles")
	public String roles() {
		roleRepository.save(new Role("ADMIN"));
		roleRepository.save(new Role("USERS"));
		return "redirect:/indice";
	}

	@RequestMapping("/listarLivros")
	public ModelAndView listarLivros() {
		ModelAndView modelAnsView = new ModelAndView("clientes/getLivros");
		Iterable<Livro> livros = livroService.findAll();
		modelAnsView.addObject("livros", livros);
		return modelAnsView;
	}

	@RequestMapping("/livrosMaisBaratos")
	public ModelAndView listarLivros2() {
		ModelAndView model = new ModelAndView("clientes/getLivros");
		Iterable<Livro> livros = livroService.findAllPage();
		model.addObject("livros", livros);
		return model;
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
		model.addAttribute("editoras", lista);
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
