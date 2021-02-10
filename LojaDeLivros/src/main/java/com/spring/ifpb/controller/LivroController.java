package com.spring.ifpb.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.ifpb.model.Livro;
import com.spring.ifpb.repository.LivroRepository;

@Controller
@RequestMapping(value = "/Livros")
public class LivroController {

	@Autowired
	private LivroRepository livroRepository;

	@GetMapping
	public List<Livro> listarLivros() {
		return livroRepository.findAll();
	}

	@GetMapping("/{id}")
	public Livro buscarLivro(@PathVariable(value = "id") Long id) {
		return livroRepository.findById(id);
	}
	
	@GetMapping("/{titulo}")
	public Livro buscarPeloTitulo(@PathVariable(value="id") String titulo){
		return livroRepository.findByTitulo(titulo);
	}

	/*
	 * metodo de buscar os livros pelo preço que seja menor que o valor passado
	 * o metodo também recebe o numero da pagina que o usuario quer que seja exiibida
	 * retorna a lista de forma ascendente.
	 */
	
	public Page<Livro> buscarPeloPrecoMenorQue(BigDecimal preco, int numPagina){
		Pageable paginacao = PageRequest.of(numPagina, 3, Sort.by(Sort.Direction.ASC, "preco"));
		return livroRepository.findByPrecoLessThan(preco, paginacao);
	}
	
	@PostMapping
	public String salvarLivro(Livro l) {
		if (livroExiste(l))
			return "Esse já foi cadastrado antes";
		else {
			livroRepository.save(l);
			return "Novo livro Salvo com sucesso!";
		}
	}
	
	public boolean livroExiste(Livro l) {					// metodo de validação para saber se o livro ja está no BD ou nao
		try {
			Livro l1 = buscarLivro(l.getId());
			if (l1 == null)
				return false;
			else
				return true;
		} catch (Exception e) {
			return false;
		}
	}

	@DeleteMapping
	public String deleteLivro(Livro l) {
		if (livroExiste(l)) {
			livroRepository.delete(l);
			return "Livro excluido com sucesso!";
		} else {
			return "Não existe um livro cadastrado com esse id";
		}
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