package com.spring.ifpb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.ifpb.model.Editora;
import com.spring.ifpb.repository.EditoraRepository;

@Controller
@RequestMapping("/editoras")
public class EditoraController {

	@Autowired
	private EditoraRepository editoraRepository;

	@GetMapping
	public List<Editora> listarEditoras() {
		List<Editora> lista = editoraRepository.findAll();
		return editoraRepository.findAll();
	}

	@GetMapping("/{id}")
	public Editora buscarEditora(@PathVariable(value = "id") long id) {
		return editoraRepository.findById(id);
	}

	@PostMapping
	public String salvarLivro(Editora e) {
		editoraRepository.save(e);
		return "Editora Salva!";
	}

	@DeleteMapping
	public String deleteEditora(Editora e) {
		editoraRepository.delete(e);
		return "Editora excluida com sucesso!";
	}

//	@DeleteMapping
//	public String deleteById(long id) {
//		editoraRepository.deleteById(id);
//		return "Editora excluida com sucesso!";
//	}
	
	@PutMapping
	public String atualizarEditora(Editora e) {
		editoraRepository.save(e);
		return "Editora Atualizado";
	}
	
}
