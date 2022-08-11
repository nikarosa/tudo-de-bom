package com.tudodebom.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
* Cliente é uma classe modelo com os dados necessários para
* as operações de CRUD.
* 
* @author Alexandre Ferreira
* 
*/
@Entity
public class Cliente {
	
	/**
	 * id do cliente:
	 * dado de controle para o banco de dados.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	/**
	 * Nome do cliente:
	 * dado pessoal do cliente.
	 */
	private String nome;
	
	/**
	 * CPF do cliente:
	 * dado pessoal do cliente.
	 */
	private String cpf;
	
	/**
	 * Email do cliente:
	 * dado de contato do cliente.
	 */
	private String email;
	
	/**
	 * Telefone do cliente:
	 * dado de contato do cliente.
	 */
	private String telefone;
	

	/**
	 * Construtor padrão da classe Cliente.
	 */
	public Cliente() {
		super();
	}
		
	/**
	 * Construtor com todos o parâmentros,
	 * menos o ID porque é um dado que será gerado automaticamente pelo bando de dados.
	 */
	public Cliente(String nome, String cpf, String email, String telefone) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", cpf=" 
				+ cpf + ", email=" + email + ", telefone=" + telefone + "]";
	}
		
}
