/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author marcu
 */
public class Produto {
    
    private int id;
    private String nomeProduto;
    private String marcaProduto; 
    private double valorProduto;
    private int quantidadeProduto;
    private boolean flag_medicamento;
    private boolean flag_generico;

    public Produto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getMarcaProduto() {
        return marcaProduto;
    }

    public void setMarcaProduto(String marcaProduto) {
        this.marcaProduto = marcaProduto;
    }

    public double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }

    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public boolean getFlag_medicamento() {
        return flag_medicamento = false;
    }

    public void setFlag_medicamento(boolean flag_medicamento) {
        this.flag_medicamento = flag_medicamento;
    }

    public boolean getFlag_generico() {
        return flag_generico = false;
    }

    public void setFlag_generico(boolean flag_generico) {
        this.flag_generico = flag_generico;
    }
    
    
}
