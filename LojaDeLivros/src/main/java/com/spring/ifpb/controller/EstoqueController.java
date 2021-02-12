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

import com.spring.ifpb.model.Estoque;
import com.spring.ifpb.repository.EstoqueRepository;

@Controller
@RequestMapping(value = "Estoques")
public class EstoqueController {

	@Autowired
	private EstoqueRepository estoqueRepository;

	@GetMapping
	public List<Estoque> listarEstoques() {
		return estoqueRepository.findAll();
	}

	@GetMapping("/{id}")
	public Estoque buscarPeloId(@PathVariable(value = "id") Long id) {
		return estoqueRepository.findById(id);
	}

	@PostMapping
	public String salvarEstoque(Estoque e) {
		if (estoqueExiste(e.getId())) {
			return "Estoque já Existe";
		}else {
			estoqueRepository.save(e);
			return "Estoque Salvo";
		}
	}

	public boolean estoqueExiste(Long id) {
		try {
			Estoque e1 = buscarPeloId(id);
			if (e1 == null)
				return false;
			else
				return true;
		} catch (Exception e) {
			return false;
		}
	}

	@DeleteMapping
	public String deleteEstoque(Estoque e) {
		estoqueRepository.delete(e);
		return "Estoque excluido com sucesso!";
	}

	@PutMapping
	public String atualizarEstoque(Estoque e) {
		estoqueRepository.save(e);
		return "Estoque Atualizado";
	}

}
