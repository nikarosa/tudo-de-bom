package controller;

import model.Pedido;

public class PedidoController {

    private final Pedido view;

    public PedidoController(Pedido view) {
        this.view = view;
    }
    
    public void cadastrar() throws ClassNotFoundException {
        Pedido pedido = new Pedido();
        
//        new PedidoDAO().cadastrarPedido(pedido);
        
//        helper.limparTela();
         
    }
           
    public void deletar() throws ClassNotFoundException{
//        Produto produtoModelo = helper.obterModelo();
//    
//        new ProdutoDAO().deletarProduto(produtoModelo);
//        
//        helper.limparTela();
    } 
    
    public void buscar() throws ClassNotFoundException{
//        helper.resetTable();
//        
//        Produto produto = helper.obterModelo2();
//        
//        new ProdutoDAO().buscarProdutoIdNome(produto);
//        
//        try {
//            ProdutoDAO objProduto = new ProdutoDAO();
//
//            DefaultTableModel model;
//            model = (DefaultTableModel) view.getjTabbedPane1Guias().getModel();
//            model.setNumRows(0);
//
//            ArrayList<Produto> listarProduto = objProduto.listarProduto();
//
//            listarProduto.stream().forEach((listaProduto) -> {
//                model.addRow(new Object[]{listaProduto.getId(), listaProduto.getNomeProduto(), listaProduto.getMarcaProduto(), listaProduto.getValorProduto(), listaProduto.getQuantidadeProduto(), listaProduto.getFlag_medicamento(), listaProduto.getFlag_generico()});
//            });
//
//        } catch (ClassNotFoundException erro) {
//                JOptionPane.showMessageDialog(null, "CrudProduto - buscarTabela" + erro.getMessage());
//        }   
    }
    
//    public void carregarComboBoxProdutos(JComboBox produtos) throws ClassNotFoundException{
//
//        ArrayList<Produto> listaProdutos = new ProdutoDAO().listarProduto();
//
//        PedidoUtil.carregarNomeProdutos(produtos, listaProdutos);
//    }
}
