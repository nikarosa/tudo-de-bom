/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerhelper;

import model.Produto;
import view.Estoque;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author marcu
 */
public class EstoqueHelper {

    private final Estoque view;
    
    public EstoqueHelper(Estoque view) {
       this.view = view;
    }
    
    public Produto obterModelo(){
        
        Produto modeloProduto = new Produto();
        
        int id = Integer.parseInt(view.getjTextField2CodigoProduto().getText());
        String nome = view.getjTextField1NomeProduto().getText();
        double valor = Double.parseDouble(view.getTxtValor().getText());
        String marca = view.getjTextField3MarcaProduto().getText();
        int quantidade = Integer.parseInt(view.getjTextField4QuantidadeProduto().getText());
        boolean medicamento = false;
        boolean generico = false;
        
        if(view.getjCheckBox1Medicamento().isSelected()){
            medicamento = true;
        }
        
        if(view.getjCheckBox2Generico().isSelected()){
            generico = true;
        }
    
        modeloProduto.setId(id);
        modeloProduto.setFlag_generico(generico);
        modeloProduto.setFlag_medicamento(medicamento);
        modeloProduto.setMarcaProduto(marca);
        modeloProduto.setQuantidadeProduto(quantidade);
        modeloProduto.setValorProduto(valor);
        modeloProduto.setNomeProduto(nome);
        
        return modeloProduto;
    }
    
    public Produto obterModelo2(){
        Produto modeloProduto = new Produto();
        
        String nome = view.getjTextField2NomProduto().getText();
        int id = Integer.parseInt(view.getjTextField2CodProduto().getText());
        
        modeloProduto.setId(id);
        modeloProduto.setNomeProduto(nome);
        
        return modeloProduto;
    }
    
    public void limparTela(){
        view.getTxtValor().setText(" ");
        view.getjTextField1NomeProduto().setText(" ");
        view.getjTextField2CodProduto().setText(" ");
        view.getjTextField3MarcaProduto().setText(" ");
        view.getjTextField4QuantidadeProduto().setText(" ");
    }
    
    public void resetTable(){
        DefaultTableModel model;
       
        model = (DefaultTableModel) this.view.getjTabbedPane1Guias().getModel();
        model.setNumRows(0);
    }
}
