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
	
	@GetMapping("/{titulo}")
	public Livro buscarPeloTitulo(@PathVariable(value="id") String titulo){
		return livroRepository.findByTitulo(titulo);
	}
	@GetMapping("/excluir/{id}")
	public String excluirLivro(@PathVariable(value="id") Long id, Model model) {
		livroService.deletarLivroId(id);
		model.addAttribute("livros",livroService.findAll());
		return "redirect:/admin/listarLivros";
	}

	/*
	 * metodo de buscar os livros pelo preço que seja menor que o valor passado
	 * o metodo também recebe o numero da pagina que o usuario quer que seja exiibida
	 * retorna a lista de forma ascendente.
	 */
	@RequestMapping("/getLivrosMaisBaratos")
	public ModelAndView buscarPeloPrecoMenorQue(){
		ModelAndView model = new ModelAndView("admin/listagem/getLivros");
		Iterable<Livro> livros= livroService.findAllPage();
		model.addObject("livros", livros);
		return model;
	}

}