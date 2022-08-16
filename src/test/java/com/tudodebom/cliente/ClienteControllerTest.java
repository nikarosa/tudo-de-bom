package com.tudodebom.cliente;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.tudodebom.controller.ClienteController;
import com.tudodebom.model.Cliente;
import com.tudodebom.repository.ClienteRepository;
import com.tudodebom.service.ClienteService;

import junit.framework.TestCase;

@WebMvcTest(ClienteController.class)
public class ClienteControllerTest extends TestCase{

	@Autowired
    MockMvc mockMvc;
	
	@MockBean
	ClienteRepository clienteRepository;
	@MockBean
	ClienteService clienteService;
	
	Cliente a = new Cliente("Spring", "123.456.789-00", "spring@tudodebom.com", "+55(00)11111-1111");
    Cliente b = new Cliente("Spring Doidao", "098.765.432-00", "springDoidao@tudodebom.com", "+55(00)12222-2222");
    Cliente c = new Cliente("Alexandre", "123.456.789-00", "alexandre@tudodebom.com", "+55(00)13333-3333");
    
	@Test
	public void  testGetClientes() throws Exception {
		//dado
		List<Cliente> testantoListaCliente = new ArrayList<>(Arrays.asList(a, b, c));
        
        Mockito.when(clienteService.listarTodos()).thenReturn(testantoListaCliente);
        // quando
        
        mockMvc.perform(MockMvcRequestBuilders
                .get("/v1/api/cliente")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[1].nome", is("Spring Doidao")));
	}
}
