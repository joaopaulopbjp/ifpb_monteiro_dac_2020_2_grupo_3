package com.spring.ifpb;

import java.math.BigDecimal;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.util.NumberUtils;

import com.spring.ifpb.model.Livro;
import com.spring.ifpb.opcoesDeEntrada.Menu;
import com.spring.ifpb.service.LivroService;

@SpringBootApplication
public class LojaDeLivrosApplication implements CommandLineRunner {
	@Autowired
	private LivroService servicoDeLivro;

	@Autowired
	private Menu menu;
	private Page<Livro> livros;

	private Scanner input;

	public static void main(String[] args) {
		SpringApplication.run(LojaDeLivrosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/*
		 * criando e salvando instancias de autor, editora e categoria, para salvar no
		 * bd e para poder atribuir a um livro para poder salva-lo no BD
		 */
		input = new Scanner(System.in);
		int opcao = -1;
		while (true) {
			System.out.println(
					"Digite 1:Para cadastrar um autor, 2:Para encontrar um autor pelo seu email, 3: Buscar livro pelo Título, 4: Cadastrar novo livro"
							+ " 5: Remover um livro, 6: Listar os livros mais baratos, 0: Para encerrar a Aplicação");
			opcao = Integer.parseInt(input.nextLine());
			if (opcao == 1)
				menu.cadastrarAutor();
			else if (opcao == 2)
				menu.buscarAutorPeloEmail();
			else if (opcao == 3)
				menu.buscarLivroPeloTitulo();
			else if (opcao == 4)
				menu.cadastrarLivro();
			else if (opcao == 5)
				menu.deletarLivro();
			else if (opcao == 6) {
				System.out.println("Qual o valor dos livros que deseja listar ?");
				String valor = input.nextLine();
				NumberUtils.parseNumber(valor, BigDecimal.class);
				System.out.println("Qual numero da pagina?");
				int num = Integer.parseInt(input.nextLine());
				if (num > 0 && valor != null) {
					livros = servicoDeLivro.buscaPaginadoMenorValor(NumberUtils.parseNumber(valor, BigDecimal.class),
							num);
					System.out.println("Foi encontrado " + livros.getNumber() + " com valor aproximado ao " + valor
							+ " que foi solicitado");
				} else
					System.out.println("Valores Invalidos");
			}else if(opcao == 0) {
				System.out.println("Encerrando a Aplicação ");
				break;
			}
		}
	}

}
