package com.spring.ifpb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.ifpb.model.Editora;
import com.spring.ifpb.service.EditoraService;

@Controller
@RequestMapping("/editoras")
public class EditoraController {

	
	@Autowired
	private EditoraService editoraSevice;

	@GetMapping("/listar")
	public String listarEditoras(Model model) {
		List<Editora> lista = editoraSevice.findAll();
		model.addAttribute("editoras",lista);
		return "/admin/listagem/getEditora";
	}

	@GetMapping("/{id}")
	public Editora buscarEditora(@PathVariable(value = "id") long id) {
		return editoraSevice.findById(id);
	}

	@PostMapping("/novaEditora")
	public String salvarLivro(Editora e) {
		editoraSevice.save(e);
		return "redirect:/admin/listarEditoras";
	}

	@GetMapping("/excluir/{id}")
	public String deleteEditora(@PathVariable(value="id")long id) {
		editoraSevice.deleteById(id);
		return "redirect:/admin/listarEditoras";
	}

	@PutMapping
	public String atualizarEditora(Editora e) {
		editoraSevice.atualizarEditora(e);
		return "Editora Atualizado";
	}
	
}
