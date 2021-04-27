package com.spring.ifpb.repository;

import java.math.BigDecimal;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.ifpb.model.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{

	Livro findByTitulo(String titulo);
	Page<Livro> findByPrecoLessThan(BigDecimal preco, Pageable paginacao);
	
}
