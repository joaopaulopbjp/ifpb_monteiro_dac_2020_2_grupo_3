//package com.spring.ifpb.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.spring.ifpb.model.Prateleira;
//import com.spring.ifpb.repository.PrateleiraRepository;
//
//@Controller
//@RequestMapping(value="/Prateleira")
//public class PrateleiraController {
//
//	
//	@Autowired
//	private PrateleiraRepository prateleiraRepository;
//	
//	@GetMapping
//	public List<Prateleira> listarPrateleiras() {
//		return prateleiraRepository.findAll();
//	}
//	
//	@GetMapping("/{id}")
//	public Prateleira buscarPrateleira(@PathVariable(value = "id")Long id) {
//		return prateleiraRepository.findById(id);
//	}
//
//	@PostMapping
//	public String salvarPrateleira(Prateleira p) {
//		prateleiraRepository.save(p);
//		return "Prateleira Salva!";
//	}
//	
//	@DeleteMapping
//	public String deletePrateleira(Prateleira p) {
//		prateleiraRepository.delete(p);
//		return "Prateleira excluida com sucesso!";
//	}
//
////	@DeleteMapping
////	public String deleteById(Long id) {
////		prateleiraRepository.deleteById(id);
////		return "Prateleira excluida com sucesso!";
////	}
//	
//	@PutMapping
//	public String atualizarPrateleira(Prateleira p) {
//		prateleiraRepository.save(p);
//		return "Prateleira Atualizado";
//	}
//	
//}
