package com.spring.ifpb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.ifpb.model.Pedido;
import com.spring.ifpb.repository.PedidoRepository;
@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	public List<Pedido> findAll() {
		return pedidoRepository.findAll();
	}
	
	public Pedido findById(Long id) {
		return pedidoRepository.findById(id);
	}
	
	public void save (Pedido pedido) {
		pedidoRepository.save(pedido);
	}
	

}
