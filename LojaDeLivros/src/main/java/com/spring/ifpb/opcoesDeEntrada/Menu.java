package com.spring.ifpb.opcoesDeEntrada;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.ifpb.controller.AutorController;
import com.spring.ifpb.controller.EditoraController;
import com.spring.ifpb.controller.LivroController;
import com.spring.ifpb.model.Autor;
import com.spring.ifpb.model.Editora;
import com.spring.ifpb.model.Livro;
import com.spring.ifpb.service.AutorService;
import com.spring.ifpb.service.EditoraService;
import com.spring.ifpb.service.LivroService;

@Service
public class Menu {

	/*
	 * Author @Jose Caio Opcoes para um menu de entrada
	 */
	@Autowired
	private LivroService servicoDeLivro;

	@Autowired
	private AutorService servicoDeAutor;
	
	@Autowired
	private EditoraService servicoDeEditora;

	@Autowired
	private AutorController controladorDoAutor;

	@Autowired
	private LivroController controladorDoLivro;

	@Autowired
	private EditoraController controladorDeEditora;

	private Autor novoAutor;

	private Livro novoLivro;

	private Editora novaEditora;

	private Scanner input;

	private int opcaoDesejada;

	public Menu() {
		this.input = new Scanner(System.in);
		this.novoAutor = new Autor();
		this.novoLivro = new Livro();
		this.novaEditora = new Editora();
		// this.opcaoDesejada = opcaoDeEntrada;
		// this.regrasDoMenu(this.opcaoDesejada);

	}

//	public Menu(LivroController controladorDoLivro,long deleteLivroPeloId, int opcao) {
//		this.controladorDoLivro = controladorDoLivro;
//		if (opcao == 3)
//			this.deletarLivro(deleteLivroPeloId);
//		else if (opcao == 4)
//			this.atualizarLivro(deleteLivroPeloId);
//	}

//	public void regrasDoMenu(int opcao) {
//		if (opcao == 1)
//			this.cadastrarAutor();
//		else if (opcao == 2)
//			this.cadasttrarLivro();
//	}
	
	public Autor cadastrarAutor() {
		System.out.println("Digite o nome do autor :");
		String nome = input.nextLine();
		System.out.println("Digite o email do autor :");
		String email = input.nextLine();
		if (!nome.equals("") && !email.equals("")) {
			novoAutor.setNome(nome);
			novoAutor.setEmail(email);
		}
		if (novoAutor != null)
			return servicoDeAutor.create(novoAutor);
		return null;
	}

	public Autor buscarAutorPeloEmail() throws Exception {
		String email = "";
		System.out.println("Digite o email do autor desejado:");
		email = input.nextLine();
		novoAutor = servicoDeAutor.findByEmail(email);
		if (novoAutor == null) {
			System.out.println("Nenhum autor foi encontrado com esse endereço de email");
			return null;
		}
		System.out.println(
				"Autor(a) " + novoAutor.getNome() + " cadastrado(a) com o endereço de email " + novoAutor.getEmail());
		return novoAutor;
	}

	public Livro buscarLivroPeloTitulo() {
		String title = "";
		System.out.println("Digite o título do livro que você está a procura:");
		title = input.nextLine();
		novoLivro = servicoDeLivro.buscarPeloTitulo(title);
		if (title.equals("") || novoLivro == null) {
			System.out.println("Livro não encontrado");
			return null;
		}
		System.out.println(
				"O livro " + novoLivro.getTitulo() + " foi encontrado, seu valor é " + novoLivro.getPreco() + "R$");
		return novoLivro;
	}

	public void cadastrarLivro() {
		System.out.println("Qual o titulo do Livro ?");
		novoLivro.setTitulo(input.nextLine());
		System.out.println("Qual a quantidade de exemplares disponivel ?");
		novoLivro.setQtdEstoque(Integer.parseInt(input.nextLine()));
		System.out.println("Qual o valor do Livro ?");
		novoLivro.setPreco(input.nextBigDecimal());
		String email = "";
		while (servicoDeAutor.findByEmail(email) == null) {
			System.out.println("Digite um email válido para encontrar o Autor(a)");
			email = input.nextLine();
		}

		long idEditora = -1;
		while (servicoDeEditora.buscarEditoraPeloId(idEditora) == null) {
			System.out.println("Digite um Id valido da editora que produziu o livro");
			idEditora = Long.parseLong(input.nextLine());
		}
		/*
		 * Abaixo a perssitencia dos dados solicitados
		 */

		novaEditora = servicoDeEditora.buscarEditoraPeloId(idEditora);
		novoLivro.addAutor(novoAutor);
		novoLivro.setEditora(novaEditora);
		servicoDeLivro.adicionarNovoLivro(novoLivro);
	}

	public boolean deletarLivro() {
		String titulo = "";
		System.out.println("Digite o titulo do livro que você quer remover do banco de dados");
		titulo = input.nextLine();
		Livro delete = servicoDeLivro.buscarPeloTitulo(titulo);
		if (delete != null) {
			servicoDeLivro.deletarLivro(delete);
			System.out.println("Livro deletado com sucesso");
			return true;
		}
		System.out.println("Livro não encontrado");
		return false;

	}

	public boolean atualizarLivro(long idDoLivroParaSerAtualizado) {
		Livro update = controladorDoLivro.buscarLivro(idDoLivroParaSerAtualizado);
		if (update.equals(null) == false) {
			controladorDoLivro.atualizarLivro(update);
			System.out.println("Livro atualizado");
			return true;
		}
		System.out.println("Livro não encontrado");
		return false;
	}

}
