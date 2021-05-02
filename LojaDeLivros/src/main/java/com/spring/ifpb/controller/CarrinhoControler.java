package com.spring.ifpb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.ifpb.model.Livro;
import com.spring.ifpb.service.LivroService;

@Controller()
@RequestMapping("/carrinhoDeCompras")
public class CarrinhoControler {
	
	@Autowired
	private LivroService livroService;
	
	
	private List<Livro> carrinho;
	
	public CarrinhoControler() {
		carrinho = new ArrayList<Livro>();
	}

	@GetMapping("/carrinho")
	public String chamarCarrinho(Model model) {
		model.addAttribute("livros", this.getCarrinho());
		
		return "carrinho/carrinho";
	}
	
	@GetMapping("/addAoCarrinho/{id}")
	public String adicionarAoCarrinho(@PathVariable(value="id") Long id) {
		carrinho.add((livroService.findById(id)));
		
		return "redirect:/listarLivros";
	}
	
	@GetMapping("/removerDoCarrinho/{id}")
	public String removerDoCarrinho(@PathVariable(value="id") Long id,Model model) {
		for (int i = 0; i < this.getCarrinho().size(); i++) {
			if(carrinho.get(i).getId() == id)
				getCarrinho().remove(i);
		}
		model.addAttribute("livros", this.getCarrinho());
		return "carrinho/carrinho";
	}
	
	@GetMapping("/finalizarPedido/{id}")
	public String finalizar(@PathVariable(value="id") Long id) {
		Livro livro = livroService.findById(id);
		livro.setQtdEstoque(livro.getQtdEstoque()-1);
		livroService.updateLivro(livro);
		
		return "redirect:/listarLivros";
	}

	public List<Livro> getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(List<Livro> carrinho) {
		this.carrinho = carrinho;
	}
	
	
	

}
