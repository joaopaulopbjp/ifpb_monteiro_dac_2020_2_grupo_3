package com.spring.ifpb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.ifpb.model.Cliente;

@Repository
public interface UsuarioRepository extends JpaRepository<Cliente, Long>{

	Cliente findByCpf(Long cpf);
	Cliente findByEmail(String email);
	
	

}
