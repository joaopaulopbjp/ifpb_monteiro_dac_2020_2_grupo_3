package com.spring.ifpb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.ifpb.model.Estoque;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Integer>{
	
	Estoque findById(Long id);
}
