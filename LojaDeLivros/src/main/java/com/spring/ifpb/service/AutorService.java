package com.spring.ifpb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.spring.ifpb.model.Autor;
import com.spring.ifpb.repository.AutorRepository;

@Service
public class AutorService {

	@Autowired
	private AutorRepository repositoryAutor;
	
	public Autor adicionarNovoAutor(Autor autor) {
		return repositoryAutor.save(autor);
	}

	
	public Autor buscarAutorPeloEmail(String email) {
		return repositoryAutor.findByEmail(email);
	}
	
	
	public Autor buscarAutorPeloId(@PathVariable(value="id")long id) {
		return repositoryAutor.findById(id);
	}

}
