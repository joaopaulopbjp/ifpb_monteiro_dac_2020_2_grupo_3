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
//import com.spring.ifpb.model.CDD;
//import com.spring.ifpb.repository.CDDRepository;
//
//@Controller
//@RequestMapping(value="/CDD")
//public class CDDController {
//	
//	@Autowired
//	private CDDRepository cddRepository;
//	
//	@GetMapping
//	public List<CDD> listarCDDs() {
//		return cddRepository.findAll();
//	}
//	
//	@GetMapping("/{id}")
//	public CDD buscarCDD(@PathVariable(value = "id")Long id) {
//		return cddRepository.findById(id);
//	}
//
//	@PostMapping
//	public String salvarCDD(CDD cdd) {
//		cddRepository.save(cdd);
//		return "Centro de Distribuição Salvo!";
//	}
//	
//	@DeleteMapping
//	public String deleteCDD(CDD cdd) {
//		cddRepository.delete(cdd);
//		return "Centro de Distribuição excluido com sucesso!";
//	}
//
////	@DeleteMapping
////	public String deleteById(Long id) {
////		cddRepository.deleteById(id);
////		return "CDD excluido com sucesso!";
////	}
//	
//	@PutMapping
//	public String atualizarCDD(CDD cdd) {
//		cddRepository.save(cdd);
//		return "Centro de Distribuição Atualizado";
//	}
//	
//	
//}
