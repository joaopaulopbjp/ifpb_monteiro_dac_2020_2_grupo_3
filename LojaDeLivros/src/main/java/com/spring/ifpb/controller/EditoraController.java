package com.spring.ifpb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

	@GetMapping("/listar")
	public String listarEditoras(Model model) {
		List<Editora> lista = editoraRepository.findAll();
		model.addAttribute("editoras",lista);
		return "listagem/getEditora";
	}

	@GetMapping("/{id}")
	public Editora buscarEditora(@PathVariable(value = "id") long id) {
		return editoraRepository.findById(id);
	}

	@PostMapping("/novaEditora")
	public String salvarLivro(Editora e) {
		editoraRepository.save(e);
		return "redirect:/editoras/listar";
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
