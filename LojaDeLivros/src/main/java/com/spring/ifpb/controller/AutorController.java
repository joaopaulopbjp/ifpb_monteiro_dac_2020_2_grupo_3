package com.spring.ifpb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.ifpb.model.Autor;
import com.spring.ifpb.repository.AutorRepository;

@Controller
@RequestMapping(value = "/Autor")
public class AutorController {

	@Autowired
	private AutorRepository autorRepository;

	@GetMapping
	public List<Autor> listarAutores() {
		return autorRepository.findAll();
	}

	@GetMapping("/{id}")
	public Autor buscarPeloId(@PathVariable(value = "id") Long id) {
		return autorRepository.findById(id);
	}

	@GetMapping("/{nome}")
	public Autor buscarPeloNome(@PathVariable(value = "nome") String nome) {
		return autorRepository.findByNome(nome);
	}

	public String salvarAutor(Autor a) {
		if (validarAutor(a)) {
			autorRepository.save(a);
			return "Autor Salvo!";
		} else
			return "Já existe um Autor com esse mesmo nome ou id";
	}

	public boolean validarAutor(Autor a) {
		Autor a1 = buscarPeloId(a.getId());
		if (a1 == null)
			return true;
		else {
			a1 = buscarPeloNome(a.getNome());
			if (a1 == null) {
				return true;
			} else
				return false;
		}
	}

	@DeleteMapping
	public String deleteAutor(Autor a) {
		autorRepository.delete(a);
		return "Autor excluido com sucesso!";
	}

//	@DeleteMapping
//	public String deleteById(long id) {
//		autorRepository.deleteById(id);
//		return "Autor excluido com sucesso!";
//	}

	@PutMapping
	public String atualizarAutor(Autor a) {
		autorRepository.save(a);
		return "Autor Atualizado";
	}

}
