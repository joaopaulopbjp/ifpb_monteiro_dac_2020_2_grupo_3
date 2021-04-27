package com.spring.ifpb.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	public List<Livro> findAllPege(){
		return repositoryLivro.findAll(Sort.by(Sort.Direction.ASC, "preco"));
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
	 
//	 public Page<Livro> buscaPaginadoMenorValor(BigDecimal preco, int numDaPag){
//			Pageable paginacao = PageRequest.of(numDaPag, 3, Sort.by(Sort.Direction.ASC, "preco"));
//			return repositoryLivro.findByPrecoLessThan(preco, paginacao);
//		}
}
