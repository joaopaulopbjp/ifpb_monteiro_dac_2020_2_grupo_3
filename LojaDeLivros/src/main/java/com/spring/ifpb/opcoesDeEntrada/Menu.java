package com.spring.ifpb.opcoesDeEntrada;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.ifpb.controller.AutorController;
import com.spring.ifpb.controller.EditoraController;
import com.spring.ifpb.controller.LivroController;
import com.spring.ifpb.model.Autor;
import com.spring.ifpb.model.Editora;
import com.spring.ifpb.model.Livro;

public class Menu {
	
	/*
	 * Author @Jose Caio
	 * Opcoes para um menu de entrada
	 */

	// @Autowired
	private AutorController controladorDoAutor;

	// @Autowired
	private LivroController controladorDoLivro;

	// @Autowired
	private EditoraController controladorDeEditora;

	private Autor novoAutor;

	private Livro novoLivro;

	private Editora novaEditora;

	private Scanner input;
	
	private int opcaoDesejada;
	
	public Menu(AutorController controladorDoAutor, LivroController controladorDoLivro,
			EditoraController controladorDeEditora, int opcaoDeEntrada) {
		this.controladorDoAutor = controladorDoAutor;
		this.controladorDeEditora = controladorDeEditora;
		this.controladorDoLivro = controladorDoLivro;
		this.input = new Scanner(System.in);
		this.novoAutor = new Autor();
		this.novoLivro = new Livro();
		this.novaEditora = new Editora();
		this.opcaoDesejada = opcaoDeEntrada;
		this.regrasDoMenu(this.opcaoDesejada);

	}
	
	public void regrasDoMenu(int opcao) {
		if(opcao == 1)
			this.cadastrarAutor();
		else if (opcao == 2)
			this.cadasttrarLivro();
	}

	public String cadastrarAutor() {
		System.out.println("Digite o nome do autor :");
		String nome = input.nextLine();
		System.out.println("Digite o email do autor :");
		String email = input.nextLine();
		novoAutor.setNome(nome);
		novoAutor.setEmail(email);
		return controladorDoAutor.salvarAutor(novoAutor);
	}

	public void cadasttrarLivro() {
		System.out.println("Qual o titulo do Livro ?");
		novoLivro.setTitulo(input.nextLine());
		System.out.println("Qual a quantidade de exemplares disponivel ?");
		novoLivro.setQtdEstoque(Integer.parseInt(input.nextLine()));
		System.out.println("Qual o valor do Livro ?");
		novoLivro.setPreco(input.nextBigDecimal());
		System.out.println("Email do Autor do livro?");
		String email = input.nextLine();
		while (controladorDoAutor.econtrarAutorPeloEmail(email).equals(null)) {
			System.out.println("Autor não encontrado, digite um email válido");
			email = input.nextLine();
		}

		System.out.println("Digite o Id da editora que produziu o livro");
		long idEditora = Long.parseLong(input.nextLine());
		while (controladorDeEditora.buscarEditora(idEditora).equals(null)) {
			System.out.println("Digite um Id valido da editora que produziu o livro");
			idEditora = Long.parseLong(input.nextLine());
		}
		/*
		 * Abaixo a perssitencia dos dados solicitados 
		 */
		
		novaEditora = controladorDeEditora.buscarEditora(idEditora);
		novoLivro.addAutor(novoAutor);
		novoLivro.setEditora(novaEditora);
		controladorDoLivro.salvarLivro(novoLivro);
	}

}
