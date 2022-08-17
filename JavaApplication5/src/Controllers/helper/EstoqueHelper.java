/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.helper;

import Models.Produto;
import Views.Estoque;
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
    
    /**
     * metodo que constroi u modelo a partir das informações vindas dos campos da jframe e aplica as regras de negocio a um modelo de Produto que será usado poteriormente
     * @return modeloProduto
     * @author marcus lima
     */
    public Produto obterModelo(){
        Produto modeloProduto = new Produto();
    int id = Integer.parseInt(view.getjTextField2CodigoProduto1().getText());
    String nome = view.getjTextField1NomeProduto1().getText();
    double valor = Double.parseDouble(view.getjFormattedTextField1ValorProduto1().getText());
    String marca = view.getjTextField3MarcaProduto1().getText();
    int quantidade = Integer.parseInt(view.getjTextField4QuantidadeProduto1().getText());
    quantidade = quantidade + modeloProduto.getQuantidadeAtualProduto();
    boolean medicamento = false;
    double desconto = 0;
    double atual = valor;
    if(view.getjCheckBox1Medicamento1().isSelected()){
        medicamento = true;
    }
    boolean generico = false;
    if(view.getjCheckBox2Generico1().isSelected()){
        generico = true;
    }
    if((generico == true) & (medicamento == true)){
         desconto = (valor * 20 / 100);
         atual = valor - desconto;
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
    /**
     * metodo que constroi u modelo a partir das informações vindas dos campos da jframe e aplica as regras de negocio a um modelo de Produto que será usado poteriormente
     * @return modeloProduto
     * @author marcus lima
     */
    public Produto obterModelo2(){
        Produto modeloProduto = new Produto();
        String nome = view.getjTextField2NomProduto().getText();
        int id = Integer.parseInt(view.getjTextField2CodProduto().getText());
        modeloProduto.setId(id);
        modeloProduto.setNomeProduto(nome);
        return modeloProduto;
    }
    /**
     * metodo que constroi u modelo a partir das informações vindas dos campos da jframe e aplica as regras de negocio a um modelo de Produto que será usado poteriormente
     * @return modeloProduto
     * @author marcus lima
     */
    public Produto obterModelo3(){
        Produto modeloProduto = new Produto();
    int id = Integer.parseInt(view.getjTextField2CodigoProduto().getText());
    String nome = view.getjTextField1NomeProduto().getText();
    double valor = Double.parseDouble(view.getjFormattedTextField1ValorProduto().getText());
    String marca = view.getjTextField3MarcaProduto().getText();
    int quantidade = Integer.parseInt(view.getjTextField4QuantidadeProduto().getText());
    boolean medicamento = false;
    double desconto = 0;
    double atual = valor;
    if(view.getjCheckBox1Medicamento().isSelected()){
        medicamento = true;
    }
    boolean generico = false;
    if(view.getjCheckBox2Generico().isSelected()){
        generico = true;
    }
    if((generico == true) & (medicamento == true)){
         desconto = (valor * 20 / 100);
         atual = valor - desconto;
    }
    modeloProduto.setId(id);
    modeloProduto.setFlag_generico(generico);
    modeloProduto.setFlag_medicamento(medicamento);
    modeloProduto.setMarcaProduto(marca);
    modeloProduto.setQuantidadeProduto(quantidade);
    modeloProduto.setValorProduto(valor);
    modeloProduto.setValorDescontoProduto(desconto);
    modeloProduto.setValorAtualProduto(atual);
    modeloProduto.setNomeProduto(nome);
    return modeloProduto;
    }
    /**
     * metodo que limpa os campos da tela da classe de estoque
     * @author marcus lima
     */
    public void limparTela(){
        view.getjFormattedTextField1ValorProduto().setText(" ");
        view.getjTextField1NomeProduto().setText(" ");
        view.getjTextField2CodProduto().setText(" ");
        view.getjTextField3MarcaProduto().setText(" ");
        view.getjTextField4QuantidadeProduto().setText(" ");
        view.getjCheckBox1Medicamento1().setText(" ");
        view.getjCheckBox2Generico1().setText(" ");
        view.getjFormattedTextField1ValorProduto1().setText(" ");
        view.getjTextField1NomeProduto1().setText(" ");
        view.getjTextField2CodigoProduto1().setText(" ");
        view.getjTextField2CodProduto().setText(" ");
        view.getjTextField2NomProduto().setText(" ");
        view.getjTextField3MarcaProduto1().setText(" ");
        view.getjTextField4QuantidadeProduto1().setText(" ");
    }
    
    /**
     * metodo que limpa os campos da tabela da classe de estoque
     * @author marcus lima
     */
    public void resetTable(){
        DefaultTableModel model;
                model = (DefaultTableModel) this.view.getjTable1Produto().getModel();
                model.setNumRows(0);
        
    }
    
  
}
