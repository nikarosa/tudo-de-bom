/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controllerhelper.EstoqueHelper;
import modelDAO.ProdutoDAO;
import model.Produto;
import view.Estoque;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author marcu
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
    
    public void cadastrar() throws ClassNotFoundException {
        Produto produtoModelo = helper.obterModelo();
        
        new ProdutoDAO().cadastrarProduto(produtoModelo);
        
        helper.limparTela();
         
    }
        
    public void atualizar() throws ClassNotFoundException{
        Produto produtoModelo = helper.obterModelo();
    
        new ProdutoDAO().atualizarProduto(produtoModelo);
        
        helper.limparTela();
    }
    
    public void deletar() throws ClassNotFoundException{
        Produto produtoModelo = helper.obterModelo();
    
        new ProdutoDAO().deletarProduto(produtoModelo);
        
        helper.limparTela();
    } 
    
    public void buscar() throws ClassNotFoundException{
        helper.resetTable();
        
        Produto produto = helper.obterModelo2();
        
        new ProdutoDAO().buscarProdutoIdNome(produto);
        
        try {
            ProdutoDAO objProduto = new ProdutoDAO();

            DefaultTableModel model;
            model = (DefaultTableModel) view.getjTabbedPane1Guias().getModel();
            model.setNumRows(0);

            ArrayList<Produto> listarProduto = objProduto.listarProduto();

            listarProduto.stream().forEach((listaProduto) -> {
                model.addRow(new Object[]{listaProduto.getId(), listaProduto.getNomeProduto(), listaProduto.getMarcaProduto(), listaProduto.getValorProduto(), listaProduto.getQuantidadeProduto(), listaProduto.getFlag_medicamento(), listaProduto.getFlag_generico()});
            });

        } catch (Exception erro) {
                JOptionPane.showMessageDialog(null, "CrudProduto - buscarTabela" + erro.getMessage());
        }   
    }
    
    public void preencharTabela(){
     try {
        ProdutoDAO objProduto = new ProdutoDAO();

        DefaultTableModel model;
        model = (DefaultTableModel) view.getjTabbedPane1Guias().getModel();
        model.setNumRows(0);

        ArrayList<Produto> listarProduto = objProduto.listarProduto();

        listarProduto.stream().forEach((listaProduto) -> {
            model.addRow(new Object[]{listaProduto.getId(), listaProduto.getNomeProduto(), listaProduto.getMarcaProduto(), listaProduto.getValorProduto(), listaProduto.getQuantidadeProduto(), listaProduto.getFlag_medicamento(), listaProduto.getFlag_generico()});
        });

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "CrudProduto - preencherTabela" + erro.getMessage());
        }  
    }
    
}
