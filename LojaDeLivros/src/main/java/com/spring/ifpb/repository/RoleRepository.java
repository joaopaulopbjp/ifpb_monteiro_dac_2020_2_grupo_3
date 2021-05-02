package com.spring.ifpb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.ifpb.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	
	Role findByRole(String role);
	
	

}
