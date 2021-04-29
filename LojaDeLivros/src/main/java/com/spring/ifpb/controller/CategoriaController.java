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

import com.spring.ifpb.model.Categoria;
import com.spring.ifpb.repository.CategoriaRepository;

@Controller
@RequestMapping(value = "/categoria")
public class CategoriaController {

		@Autowired
		private CategoriaRepository categoriaRepository;

		@GetMapping("/listar")
		public String listarCategorias(Model model) {
			List<Categoria> lista = categoriaRepository.findAll();
			model.addAttribute("categorias", lista);
			return "listagem/getCategoria";
		}
		
		@GetMapping("/{id}")
		public Categoria buscarCategoria(@PathVariable(value = "id")Long id) {
			return categoriaRepository.findById(id);
		}

		@PostMapping("/novaCategoria")
		public String salvarCategoria(Categoria c) {
			categoriaRepository.save(c);
			return "redirect:/categoria/listar";
		}

		@DeleteMapping
		public String deleteCategoria(Categoria c) {
			categoriaRepository.delete(c);
			return "Categoria excluida com sucesso!";
		}

//		@DeleteMapping
//		public String deleteById(long id) {
//			categoriaRepository.deleteById(id);
//			return "Categoria excluida com sucesso!";
//		}
		
		@PutMapping
		public String atualizarCategoria(Categoria c) {
			categoriaRepository.save(c);
			return "Categoria Atualizada";
		}
		
}
