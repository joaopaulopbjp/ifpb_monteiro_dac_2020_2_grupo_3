package com.spring.ifpb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.ifpb.model.Cliente;
import com.spring.ifpb.repository.UsuarioRepository;
@Service
public class ClienteService {
	@Autowired
	private UsuarioRepository usuarioRepository;

	public Cliente create(Cliente cliente) {
		return usuarioRepository.save(cliente);
	}

	public Cliente findByEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}
	
	public List<Cliente> findAll(){
		return usuarioRepository.findAll();
	}
}
