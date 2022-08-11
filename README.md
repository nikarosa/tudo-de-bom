# Tudo de bom
Repositório para a implementação do desafio 01 do programa 'if black then code', uma parceria Gama Academy e IBM.

 O objetivo é o de implementar uma API em Java.
 O sistema deve permitir cadastro de novos clientes, incluindo dados pessoais, dados para contato e controle de estoque

## Requisitos mínimos:
1. Back-end:\
  a. Cadastro de clientes\
  b. LIstagem de clientes\
  c. Atualização de clientes\
  d. Deletar clientes\
  e. Histórico de transações entre contas\
  f. Controle de estoque\
  g. Medicamentos genéricos contêm 20% de desconto\

2. Gerais:\
  a. O código deve ser entregue em um repositório no Github\
  b. A API deve conter todos os métodos GET, PUT, POST, DELETE\
  c. Listar os endpoints no README.md\
  d. Testes automatizados, podem ser testes unitários ou testes de integração;
  
  A avaliação será feita a partir da **documentação da aplicação**.
  
  ## Da implementação do projeto:
  A inicialização foi feita a partir do [spring initializr](https://start.spring.io/).
  \
  Configurações utilizadas:
  
    Project: maven project
    Language: Java
    Spring Boot: 2.7.2
    Packaging: Jar
    Java: 17

  Dependencies:
  * Spring web
  * Spring Boot DevTools
  * Spring Data JPA
  * Lombok
  * H2 Database
  * MySQL Driver
  
  Comando para gerar a documentação utilizando o Maven: mvn -Dshow=private javadoc:javadoc
  
