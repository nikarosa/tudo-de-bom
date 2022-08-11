package com.tudodebom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tudodebom.model.Cliente;

/**
 * Classe responsável por manipular a tabela Cliente no banco de dados
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
