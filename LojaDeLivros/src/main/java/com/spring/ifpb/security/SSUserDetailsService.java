package com.spring.ifpb.security;


import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.ifpb.model.Cliente;
import com.spring.ifpb.model.Role;
import com.spring.ifpb.repository.UsuarioRepository;

@Service
@Transactional
public class SSUserDetailsService implements UserDetailsService {
	
	private UsuarioRepository userRepository;
	
	
	public SSUserDetailsService(UsuarioRepository userRepository) {
		this.userRepository = userRepository;
	}


	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			Cliente usuario = userRepository.findByUsername(username);
			if(usuario==null)
				return null;
			return new org.springframework.security.core.userdetails.User(usuario.getUsername(),usuario.getSenha(), getAuthories(usuario));
		} catch (Exception e) {
			throw new UsernameNotFoundException("Usuario nao encontrado!");
		}
	}
	
	private Set<GrantedAuthority> getAuthories(Cliente usuario){
		Set<GrantedAuthority> authorities = new HashSet<>();
		for (Role role: usuario.getRoles()) {
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getRole());
			authorities.add(grantedAuthority);
			
		}
		return authorities;
	}
	
}
