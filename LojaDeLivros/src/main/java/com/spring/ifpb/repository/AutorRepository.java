package com.spring.ifpb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.ifpb.model.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long>{
	
	Autor findById(long id);
	Autor findByEmail(String email);
	Autor findByNome(String nome);

}
