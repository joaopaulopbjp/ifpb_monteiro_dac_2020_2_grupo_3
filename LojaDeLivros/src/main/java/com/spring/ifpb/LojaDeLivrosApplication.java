package com.spring.ifpb;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.spring.ifpb.controller.AutorController;
import com.spring.ifpb.controller.CategoriaController;
import com.spring.ifpb.controller.EditoraController;
import com.spring.ifpb.controller.LivroController;
import com.spring.ifpb.controller.UsuarioController;
import com.spring.ifpb.model.Autor;
import com.spring.ifpb.model.Categoria;
import com.spring.ifpb.model.Editora;
import com.spring.ifpb.model.Livro;
import com.spring.ifpb.model.Usuario;
import com.spring.ifpb.repository.LivroRepository;
import com.spring.ifpb.resources.CategoriaLivro;

@SpringBootApplication
public class LojaDeLivrosApplication implements CommandLineRunner {

	private AutorController ac;
	private EditoraController ec;
	private CategoriaController cc;
//	private CDDController cddc;
//	private PrateleiraController pc;
	private UsuarioController uc;
	private LivroController lc;

	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public LojaDeLivrosApplication(LivroController lc, AutorController ac, EditoraController ec, CategoriaController cc,
			/* CDDController cddc, PrateleiraController pc, */ UsuarioController uc) {
		this.ac = ac;
		this.ec = ec;
		this.cc = cc;
//		this.cddc = cddc;
//		this.pc = pc;
		this.uc = uc;
		this.lc = lc;
	}

	public static void main(String[] args) {
		SpringApplication.run(LojaDeLivrosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/*
		 * criando e salvando instancias de autor, editora e categoria, para salvar no
		 * bd e para poder atribuir a um livro para poder salva-lo no BD
		 */

		Autor a = new Autor();
		a.setId(1l);
		a.setNome("Roger Pressman");
		System.out.println(ANSI_CYAN + ac.salvarAutor(a) + ANSI_RESET);

		Editora ed = new Editora();
		ed.setNome("Atica");
		System.out.println(ANSI_CYAN + ec.salvarLivro(ed) + ANSI_RESET);

		Categoria ct = new Categoria();
		ct.setDescricao(CategoriaLivro.BIOGRAFIA);
		System.out.println(ANSI_CYAN + cc.salvarCategoria(ct) + ANSI_RESET);

		/*
		 * criando 4 instancias de livro para salvar no BD
		 */

		Livro l1 = new Livro();
		l1.setPreco(new BigDecimal(40.00));
		l1.setTitulo("livro de teste 1");
		l1.addAutor(a);
		l1.setEditora(ed);
		l1.setCategoria(ct);
		System.out.println(ANSI_CYAN + lc.salvarLivro(l1) + ANSI_RESET);

		Livro l2 = new Livro();
		l2.setPreco(new BigDecimal(50.00));
		l2.setTitulo("livro de teste 2");
		l2.addAutor(a);
		l2.setEditora(ed);
		l2.setCategoria(ct);
		System.out.println(ANSI_CYAN + lc.salvarLivro(l2) + ANSI_RESET);

		Livro l3 = new Livro();
		l3.setPreco(new BigDecimal(45.00));
		l3.setTitulo("livro de teste 3");
		l3.addAutor(a);
		l3.setEditora(ed);
		l3.setCategoria(ct);
		System.out.println(ANSI_CYAN + lc.salvarLivro(l3) + ANSI_RESET);

		Livro l4 = new Livro();
		l4.setPreco(new BigDecimal(50.00));
		l4.setTitulo("livro de teste 4");
		l4.addAutor(a);
		l4.setEditora(ed);
		l4.setCategoria(ct);
		System.out.println(ANSI_CYAN + lc.salvarLivro(l4) + ANSI_RESET);

		/*
		 * cadastrar usuario
		 */
		Usuario u = new Usuario();
		u.setCPF(10048986496l);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dt = sdf.parse("06/07/1993");
		u.setDtNacimento(dt);
		u.setEmail("oliveranza@gmail.com");
		u.setNome("Oliver Ranza");
		u.setSenha("Senha120*");
		System.out.println(ANSI_CYAN + uc.salvarUsuario(u) + ANSI_RESET);

		/*
		 * CDD E PRATELEIRA RETIRADO DO PROJETO
		 * 
		 * 
		 * * * Cadastro do centro de distribuição (cdd) *
		 * 
		 * CDD cdd = new CDD(); cdd.setEstado("PB"); cdd.setCidade("Monteiro");
		 * System.out.println(ANSI_CYAN + cddc.salvarCDD(cdd)+ANSI_RESET);
		 * 
		 * * * cadastrando prateleira e associando um livro a ela *
		 * 
		 * Prateleira pt = new Prateleira(); pt.setLocalizacao("A33"); pt.setCdd(cdd);
		 * pt.addLivro(l1); System.out.println(ANSI_CYAN + pc.salvarPrateleira(pt)+
		 * ANSI_RESET);
		 * 
		 * 
		 * * associando o livro l1 a sua devida prateleira; * e associando a prateleria
		 * ao seu centro de distribuição * l1.setPrateleira(pt);
		 * System.out.println(ANSI_CYAN + lc.atualizarLivro(l1)+ANSI_RESET);
		 * //atulizando os dados do livro l1 cdd.addPrateleira(pt);
		 * System.out.println(ANSI_CYAN + cddc.atualizarCDD(cdd)+ANSI_RESET);
		 * //atualizando os dados do centro de distribuição cdd
		 */

		int numDaPag = 0; // variável para definir o numero da pagina que será exibida
		int precoDaFiltrage = 55;

		/*
		 * exibindo resultado de forma paginada e organizada por preço
		 */

		Page<Livro> livros = lc.buscarPeloPrecoMenorQue(new BigDecimal(precoDaFiltrage), numDaPag);
		System.out.println(ANSI_RED + "_____________________________________________________________" + ANSI_RESET);
		System.out.println(ANSI_GREEN + livros);
		System.out.println("Pagina atual: " + livros.getNumber());
		System.out.println("total de elementos: " + livros.getTotalElements());
		livros.forEach(livro -> System.out
				.println("id: " + livro.getId() + " - " + livro.getTitulo() + " - preço: " + livro.getPreco()));
		System.out.println(ANSI_RED + "-------------------------------------------------------------" + ANSI_RESET);

		Livro livro1 = new Livro(); // criando livro para teste de atualização e exclusão
		livro1.setId(5l);
		System.out.println(ANSI_CYAN + lc.deleteLivro(livro1) + ANSI_RESET); // excluir livro

		livro1 = lc.buscarLivro(4l); // metodo de buscar livro no BD
		livro1.setPreco(new BigDecimal(60));
		System.out.println(ANSI_CYAN + lc.atualizarLivro(livro1) + ANSI_RESET); // alterar preco do livro

		/*
		 * exibindo os livro apos exclusão e atualização
		 */
		livros = lc.buscarPeloPrecoMenorQue(new BigDecimal(55), numDaPag);
		System.out.println(ANSI_RED + "_____________________________________________________________" + ANSI_RESET);
		System.out.println(ANSI_GREEN + livros);
		System.out.println("Pagina atual: " + livros.getNumber());
		System.out.println("total de elementos: " + livros.getTotalElements());
		livros.forEach(livro -> System.out
				.println("id: " + livro.getId() + " - " + livro.getTitulo() + " - preço: " + livro.getPreco()));
		System.out.println(ANSI_RED + "-------------------------------------------------------------" + ANSI_RESET);

	}

}
