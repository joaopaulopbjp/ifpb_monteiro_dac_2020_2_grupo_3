package com.spring.ifpb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.spring.ifpb.model.Editora;
import com.spring.ifpb.repository.EditoraRepository;

@Service
public class EditoraService {
	@Autowired
	private EditoraRepository repositoryEditora;

	public Editora buscarEditoraPeloId(@PathVariable(value="id")long id) {
		return repositoryEditora.findById(id);
	}
	
	public List<Editora> findAll(){
		return repositoryEditora.findAll();
	}
}
