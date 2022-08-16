package com.tudodebom.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tudodebom.model.Cliente;
import com.tudodebom.repository.ClienteRepository;
import com.tudodebom.service.ClienteService;

/**
 * Classe responsável por receber as requisições 
 * encaminhar o pedido a banco de dados e 
 * retornar a resposta obtida.
 */
@RestController
@RequestMapping("/v1/api/cliente")
public class ClienteController {
	private final ClienteService clienteService;
	private final ClienteRepository clienteRepository;
	
	public ClienteController(ClienteService clienteService, ClienteRepository clienteRepository) {
		super();
		this.clienteService = clienteService;
		this.clienteRepository = clienteRepository;
	}
	
	/**
	 * Método getClientes()
	 * retorna uma lista com todos os clientes cadastrados no banco de dados
	 * e o status 200 de sucesso da requisição 
	 */
	@GetMapping()
	public ResponseEntity<List<Cliente>> getClientes() {
		List<Cliente> listaClientes = clienteService.listarTodos();
		
		return new ResponseEntity<>(listaClientes, HttpStatus.OK);
	}
	
	@GetMapping("/{clienteId}")
	public ResponseEntity<Optional<Cliente>> listarCliente(@PathVariable Long clienteId ) {
		Optional<Cliente> cliente = clienteService.listarPorID(clienteId);
		
		if(!clienteRepository.existsById(clienteId)) {
			return ResponseEntity.notFound().build(); 
		}
		
		return new ResponseEntity<>(cliente, HttpStatus.OK);
	}
	
	@DeleteMapping("/{clienteId}")
	public ResponseEntity<Void> remover(@PathVariable Long clienteId ) {
		if(!clienteService.existeId(clienteId)) {
			return ResponseEntity.notFound().build(); 
		}
		
		try {
			clienteService.excluir(clienteId);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return ResponseEntity.noContent().build();
	}
	
}
