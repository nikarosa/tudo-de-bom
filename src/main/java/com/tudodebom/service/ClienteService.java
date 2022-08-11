package com.tudodebom.service;

import java.util.ArrayList;
import java.util.List;

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
	 * lista todos os elementos da tabela cliente
	 * 
	 */
	public List<Cliente> listarTodos() {
		List<Cliente> clientes= new ArrayList<>();
		
		clientes = clienteRepository.findAll();
		return clientes;
	}
	
}
