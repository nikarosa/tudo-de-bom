package com.tudodebom.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.tudodebom.model.Cliente;
import com.tudodebom.repository.ClienteRepository;

@Service
public class ClienteService {
	public final ClienteRepository clienteRepository;

	/**
	 * Contrutor da Classe ClienteService
	 */
	public ClienteService(ClienteRepository clienteRepository) {
		super();
		this.clienteRepository = clienteRepository;
	}
	
	/**
	 * Método listarTodos()
	 * retorna uma lista com todos os elementos da tabela cliente
	 */
	public List<Cliente> listarTodos() {
		List<Cliente> clientes= new ArrayList<>();
		
		clientes = clienteRepository.findAll();
		
		return clientes;
	}
	
	public Optional<Cliente> listarPorID(Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		
		return cliente;
	}
	
	public boolean existeId(Long id) {
		return clienteRepository.existsById(id);
	}
	
	@Transactional
	public void excluir(Long pedidoId) {
		clienteRepository.deleteById(pedidoId);
	}
	
}
