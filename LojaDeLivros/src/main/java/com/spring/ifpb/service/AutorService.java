package com.spring.ifpb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.spring.ifpb.model.Autor;
import com.spring.ifpb.repository.AutorRepository;


@Service
public class AutorService {

	@Autowired
	private AutorRepository repositoryAutor;

	public Autor create(Autor autor) {
		return repositoryAutor.save(autor);
	}

	public Autor findByEmail(String email) {
		return repositoryAutor.findByEmail(email);
	}

	public Autor findByEmail(@PathVariable(value = "id") long id) {
		return repositoryAutor.findById(id);
	}

	public Autor update(String email) {
		Autor entity = repositoryAutor.findByEmail(email);

		return repositoryAutor.save(entity);
	}

	public List<Autor> findAll() {

		return repositoryAutor.findAll();
	}
	
	public void delete(String email) {
		Autor entity = repositoryAutor.findByEmail(email);
		repositoryAutor.delete(entity);
	}
}
