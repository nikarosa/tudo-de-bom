/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Controllers.helper.EstoqueHelper;
import Models.DAO.ProdutoDAO;
import Models.Produto;
import Views.Estoque;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Classe que realiza o gerenciamento do Estoque e que detem os seus principais metodos
 * @author marcus lima
 */
public class EstoqueController {
    private final EstoqueHelper helper;
    private final Estoque view;

    /**
     *
     * @param view
     */
    public EstoqueController(Estoque view) {
        this.view = view;
        this.helper = new EstoqueHelper(view);
    }
    /**
     * Metodo que realiza o cadastro de produto a partir de um modelo obtido com o EstoqueHelper
     * @throws ClassNotFoundException 
     * @author marcus lima
     */
    public void cadastrar() throws ClassNotFoundException {
        Produto produtoModelo = helper.obterModelo();
         new ProdutoDAO().cadastrarProduto(produtoModelo);
         helper.limparTela();
         
      }
    /**
     * Metodo que realiza a atualização de produto a partir de um modelo obtido com o EstoqueHelper, deve ser usado sempre que for aumentar a quantidade de um produto no estoque
     * @throws ClassNotFoundException 
     * @author marcus lima
     */
        public void atualizar() throws ClassNotFoundException{
        Produto produtoModelo = helper.obterModelo();
         new ProdutoDAO().atualizarProduto(produtoModelo);
         helper.limparTela();
    }
    /**
     * Metodo que realiza o delete de produto a partir de um modelo obtido com o EstoqueHelper
     * @author marcus lima
     */    
    public void deletar(){
        Produto produtoModelo = helper.obterModelo();
         new ProdutoDAO().deletarProduto(produtoModelo);
         helper.limparTela();
    } 
    /**
     * Metodo que realiza a busca de um produto, a partir de um modelo obtido com o EstoqueHelper, e preenchia uma tabela com as informações do msm
     * @author marcus lima
     */ 
    public void buscar(){
        helper.resetTable();
        Produto produto = helper.obterModelo2();
        new ProdutoDAO().buscarProdutoIdNome(produto);
     try {
                ProdutoDAO objProduto = new ProdutoDAO();

                DefaultTableModel model;
                model = (DefaultTableModel) view.getjTable1Produto().getModel();
                model.setNumRows(0);

                ArrayList<Produto> listarProduto = objProduto.listarProduto();

                listarProduto.stream().forEach((listaProduto) -> {
                    model.addRow(new Object[]{listaProduto.getId(), listaProduto.getNomeProduto(),listaProduto.getMarcaProduto(),listaProduto.getQuantidadeProduto() ,listaProduto.getQuantidadeAtualProduto(),listaProduto.getQuantidadeVendidaProduto() , listaProduto.getValorProduto(), listaProduto.getValorDescontoProduto(), listaProduto.getValorAtualProduto()});
                });

            } catch (Exception erro) {
                JOptionPane.showMessageDialog(null, "CrudProduto - buscarTabela" + erro.getMessage());
            }   
    }
    /**
     * Metodo que realiza a atualização de produto a partir de um modelo obtido com o EstoqueHelper, deve ser usado apenas no começo do mes para resetar os produtos
     * @author marcus lima
     * @throws java.lang.ClassNotFoundException
     */ 
    public void atualizarProduto() throws ClassNotFoundException{
        Produto produtoModelo = helper.obterModelo3();
         new ProdutoDAO().atualizarProduto(produtoModelo);
         helper.limparTela();
    }
    
}
