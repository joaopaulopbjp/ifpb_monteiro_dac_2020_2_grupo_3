package com.spring.ifpb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.ifpb.model.Livro;
import com.spring.ifpb.repository.LivroRepository;
import com.spring.ifpb.service.AutorService;
import com.spring.ifpb.service.EditoraService;
import com.spring.ifpb.service.LivroService;

@RequestMapping("/livro")
@Controller
public class LivroController {

	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private LivroService livroService;
	
	@Autowired
	private EditoraService editoraService;
	
	@Autowired
	private AutorService autorService;

//	@RequestMapping("/ListarLivros")
//	public ModelAndView listarLivros() {
//		ModelAndView modelAnsView = new ModelAndView("listagem/getLivros");
//		Iterable<Livro> livros= livroService.findAll();
//		modelAnsView.addObject("livros", livros);
//		return modelAnsView;
//	}
	
//	@GetMapping("/createLivro")
//	public String novoLivro(Livro novoLivro,Model model) {
//		model.addAttribute(new Livro());
//		model.addAttribute("editoras", editoraService.findAll());
//		model.addAttribute("autores", autorService.findAll());
//		return "cadastro/NewLivro";
//	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/createLivro")
	public String createLivro(@ModelAttribute  Livro novoLivro,Model model) {
		livroService.adicionarNovoLivro(novoLivro);
		System.out.println(novoLivro.getId());
		return "redirect:/livro/ListarLivros";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/editarLivro")
	public String atualizarLivro(@ModelAttribute  Livro novoLivro,Model model) {
		
		livroService.adicionarNovoLivro(novoLivro);
		System.out.println(novoLivro.getId());
		model.addAttribute("livros",livroService.findAll());
		return "redirect:/livro/ListarLivros";
	}
	
	@GetMapping("/editar/{id}")
	public String editarLivro(@PathVariable(value="id") Long id,Livro livro,Model model) {
		
		Livro livro1 = livroService.findById(id).get();
		model.addAttribute("livro",livro1);
		livro = livro1;
		System.out.println("ID: "+livro.getId());
		model.addAttribute("autores",autorService.findAll());
		model.addAttribute("editoras",editoraService.findAll());
		return "cadastro/EditarLivro";
	}
	
	@GetMapping("/{titulo}")
	public Livro buscarPeloTitulo(@PathVariable(value="id") String titulo){
		return livroRepository.findByTitulo(titulo);
	}
	@GetMapping("/excluir/{id}")
	public String excluirLivro(@PathVariable(value="id") Long id, Model model) {
		livroService.deletarLivroId(id);
		model.addAttribute("livros",livroService.findAll());
		return "redirect:/livro/ListarLivros";
	}

	/*
	 * metodo de buscar os livros pelo preço que seja menor que o valor passado
	 * o metodo também recebe o numero da pagina que o usuario quer que seja exiibida
	 * retorna a lista de forma ascendente.
	 */
	@RequestMapping("/getLivrosMaisBaratos")
	public ModelAndView buscarPeloPrecoMenorQue(){
		ModelAndView model = new ModelAndView("listagem/getLivros");
		Iterable<Livro> livros= livroService.findAllPege();
		model.addObject("livros", livros);
		return model;
	}
	
	


	@PutMapping
	public String atualizarLivro(Livro l) {
		livroRepository.save(l);
		return "livro Atualizado";
	}

}