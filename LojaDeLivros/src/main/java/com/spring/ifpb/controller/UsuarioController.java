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

import com.spring.ifpb.model.Usuario;
import com.spring.ifpb.repository.UsuarioRepository;

@Controller
@RequestMapping(value = "/Users")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping
	public List<Usuario> listarUsuarios() {
		return usuarioRepository.findAll();
	}

	@GetMapping("/{CPF}")
	public Usuario buscarUsuario(@PathVariable(value = "CPF") Long cpf) {
		return usuarioRepository.findByCPF(cpf);
	}

	@GetMapping("/{email}")
	public Usuario buscarPeloEmail(@PathVariable(value = "email") String email) {
		return usuarioRepository.findByEmail(email);
	}

	@PostMapping
	public String salvarUsuario(Usuario u) {
		Usuario u1 = buscarUsuario(u.getCPF());
		if (u1 == null) {
			usuarioRepository.save(u);
			return "usuario salvo";
		} else
			return "Esses Usuario já existe";
	}

//	public boolean validarUsuario(Usuario u) {
//		try {
//			Usuario u1 = buscarUsuario(u.getCPF());
//			return false;
//		} catch (Exception e) {
//			Usuario u1 = buscarPeloEmail(u.getEmail());
//			if (u1 == null) {
//				return true;
//			} else
//				return false;
//		}
//	}

	@DeleteMapping
	public String deleteUsuario(Usuario u) {
		usuarioRepository.delete(u);
		return "Usuario excluido com sucesso!";
	}

	@PutMapping
	public String atualizarUsuario(Usuario u) {
		usuarioRepository.save(u);
		return "Usuario Atualizado com sucesso!";
	}

}
