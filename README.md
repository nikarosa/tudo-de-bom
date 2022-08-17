# Tudo de bom
Essa aplicação foi criada no NetBeans<br>
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
  
  A avaliação será feita a partir da **documentação da aplicação**.\
  EndPoints 
  1. src/DAO/ProdutoDAO/cadastrarProduto
  2. src/DAO/ProdutoDAO/atualizarProduto
  3. src/DAO/ProdutoDAO/listarProduto
  4. src/DAO/ProdutoDAO/deletarProduto
  5. src/DAO/ProdutoDAO/buscarProdutoIdNome
  1. src/DAO/PedidoDAO/cadastrarPedido
  2. src/DAO/PedidoDAO/listarPedidos
  3. src/DAO/PedidoDAO/listarPedidosIdCliente
  4. src/DAO/PedidoDAO/listarPedidosIdProduto
  5. src/DAO/PedidoDAO/listarPedidosIdVendedor
  6. src/DAO/PedidoDAO/deletarPedido
  1. src/DAO/PedidoDAO/ inserirCliente
  2. src/DAO/PedidoDAO/listarClientes
  3. src/DAO/PedidoDAO/alterarCliente
  4. src/DAO/PedidoDAO/excluirCliente
  5. src/DAO/PedidoDAO/listarClientePorNome
