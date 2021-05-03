package com.spring.ifpb.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.spring.ifpb.model.Livro;
import com.spring.ifpb.repository.LivroRepository;

@Service
public class LivroService {
	@Autowired
	private LivroRepository repositoryLivro;
	
	
	public List<Livro> findAll(){
		return repositoryLivro.findAll();
	}
	
	//bucar paginada por preço
	public Page<Livro> findAllByPrecoless(int numPag){
		Pageable page = PageRequest.of(numPag, 5,(Sort.by(Sort.Direction.ASC, "preco")));
		return repositoryLivro.findAll(page);
	}
	
	//buca paginada normal
	public Page<Livro> findAllPageable(int numPag){
		Pageable page = PageRequest.of(numPag, 5);
		return repositoryLivro.findAll(page);
	}
	
	public Livro livroExiste(String titulo) {
		return repositoryLivro.findByTitulo(titulo);
	}
	
	public Livro buscarPeloTitulo(@PathVariable(value="id") String titulo){
		return repositoryLivro.findByTitulo(titulo);
	}
	
	public Livro adicionarNovoLivro(Livro novoLivro) {
		return repositoryLivro.save(novoLivro);
	}
	 public void deletarLivro(Livro livro) {
		 repositoryLivro.delete(livro);
	 }
	 
	 public void deletarLivroId(Long id) {
		 repositoryLivro.deleteById(id);
	 }
	 
	 public Livro findById(Long id) {
		 return repositoryLivro.findById(id).get();
	 }
	 
	 public Livro findByTitulo(String titulo) {
		 return repositoryLivro.findByTitulo(titulo);
	 }
	 
	 public Livro updateLivro(Livro novoLivro) {
			return repositoryLivro.save(novoLivro);
		}
}
