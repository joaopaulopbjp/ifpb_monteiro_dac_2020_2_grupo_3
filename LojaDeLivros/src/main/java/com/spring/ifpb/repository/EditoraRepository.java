package com.spring.ifpb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.ifpb.model.Editora;

@Repository
public interface EditoraRepository extends JpaRepository<Editora, Integer>{

	Editora findById(Long id);
	
}
