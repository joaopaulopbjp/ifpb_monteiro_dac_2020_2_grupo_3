package com.spring.ifpb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

	@RequestMapping("/ListarLivros")
	public ModelAndView listarLivros() {
		ModelAndView model = new ModelAndView("listagem/getLivros");
		Iterable<Livro> livros= livroService.findAll();
		model.addObject("livros", livros);
		return model;
		
	}
	
	@GetMapping("/createLivro")
	public String novoLivro(Livro novoLivro,Model model) {
		model.addAttribute(new Livro());
		model.addAttribute("editoras", editoraService.findAll());
		model.addAttribute("autores", autorService.findAll());
		return "cadastro/NewLivro";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/createLivro")
	public String createLivro(Livro novoLivro,Model model) {
		livroService.adicionarNovoLivro(novoLivro);
		return "cadastro/NewAutor";
	}

	
	@GetMapping("/{titulo}")
	public Livro buscarPeloTitulo(@PathVariable(value="id") String titulo){
		return livroRepository.findByTitulo(titulo);
	}
	@GetMapping("/excluir/{id}")
	public String excluirLivro(@PathVariable(value="id") Long id) {
		livroService.deletarLivroId(id);
		return "listagem/getLivros";
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
	
	


//	@DeleteMapping
//	public String deleteById(long id) {
//		livroRepository.deleteById(id);
//		return "Livro excluido com sucesso!";
//	}

	@PutMapping
	public String atualizarLivro(Livro l) {
		livroRepository.save(l);
		return "livro Atualizado";
	}

}