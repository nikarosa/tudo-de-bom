package com.tudodebom.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tudodebom.model.Cliente;
import com.tudodebom.service.ClienteService;

@RestController
@RequestMapping("cliente")
public class ClienteController {
	private final ClienteService clienteService;
	
	public ClienteController(ClienteService clienteService) {
		super();
		this.clienteService = clienteService;
	}
	
	@GetMapping()
	public ResponseEntity<List<Cliente>> getClientes() {
		List<Cliente> listaClientes = clienteService.listarTodos();
		
		return new ResponseEntity<>(listaClientes, HttpStatus.OK);
	}
	
}
