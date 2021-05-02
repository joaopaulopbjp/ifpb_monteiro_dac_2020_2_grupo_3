package com.spring.ifpb.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.spring.ifpb.repository.UsuarioRepository;

@Configuration
@EnableWebSecurity
public class SecuriryConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private SSUserDetailsService userDetailsService;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetailsService userDetailsServiceBean() throws Exception{
		return new SSUserDetailsService(usuarioRepository);
	}
	
	@Bean
	public static BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/assets/**");	//permite que a pagina carregue os css
		web.ignoring().antMatchers("/imagens/**");	//permite que a pagina carregue as imagens
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
//			.antMatchers("/addRoles").permitAll()
//			.antMatchers("/dadosIniciais").permitAll()
//			.antMatchers("/livrosMaisBaratos").permitAll()
			.antMatchers("/*").permitAll()
			.antMatchers("/resources**").permitAll()
			.antMatchers("/","jdbc:mysql://localhost/**").permitAll()
			.antMatchers("/resources/**").permitAll()
			.antMatchers("/css/**").permitAll()
			.antMatchers("/admin/*").access("hasAnyAuthority('ADMIN')")
			.antMatchers("/admin/*/*").access("hasAnyAuthority('ADMIN')")
//			.antMatchers("/index").access("hasAnyAuthority('USERS')")
			.anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll()
			.and()
			.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/login").permitAll()
			.and()
			.httpBasic();
		
		http.csrf().disable();	//permite usar os metodos de criar e atualizar dos controllers, porem o usuario comum tbm pode fazer
								//se souber a sintexe da url (tem que corrigir)
		http.headers().frameOptions().disable();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsServiceBean()).passwordEncoder(passwordEncoder());
		
		
//		auth.inMemoryAuthentication()
//			.withUser("root").password(passwordEncoder().encode("123")).authorities("ADMIN")
//			.and()
//			.withUser("oliveranza").password(passwordEncoder().encode("123")).authorities("USERS");
	}
}
