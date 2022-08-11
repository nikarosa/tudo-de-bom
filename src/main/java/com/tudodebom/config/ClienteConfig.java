package com.tudodebom.config;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tudodebom.model.Cliente;
import com.tudodebom.repository.ClienteRepository;

@Configuration
public class ClienteConfig {

	@Bean
    CommandLineRunner initDatabase(ClienteRepository clienteRepository) {
		return args -> {
	            Cliente a = new Cliente("Spring", "123.456.789-00", "spring@tudodebom.com", "+55(00)11111-1111");
	            Cliente b = new Cliente("Spring Doidao", "098.765.432-00", "springDoidao@tudodebom.com", "+55(00)12222-2222");
	            Cliente c = new Cliente("Alexandre", "123.456.789-00", "alexandre@tudodebom.com", "+55(00)13333-3333");
	            

	            clienteRepository.saveAll(
	                List.of(a, b, c)
	            );
	        };
	    
	}
}
