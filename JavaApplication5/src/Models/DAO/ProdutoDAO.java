/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DAO;

import Models.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *Classe para objetos do tipo ProdutoDAO, onde serão contidos, valores e métodos para o mesmo.
 * @param PreparedStatement pstm
 * @param Connection conn 
 * @param ResultSet rs
 * @param ArrayList<Produto> listaProduto
 * @author marcus lima
 */
public class ProdutoDAO {
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<Produto> listaProduto = new ArrayList<>();

/**
 * Metodo que cadastra um objeto de produto na tabela produtos
 * @param objProduto
 * @throws ClassNotFoundException 
 * author marcus lima
 */
public void cadastrarProduto(Produto objProduto) throws ClassNotFoundException {

        String sql = "INSERT INTO produtos VALUES (?,?,?,?,?,?,?,?,?,?);";

        conn = BancoDAO.conectar();

        try {

            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, objProduto.getId());
            pstm.setString(2, objProduto.getNomeProduto());
            pstm.setInt(3, objProduto.getQuantidadeProduto());
            pstm.setDouble(4, objProduto.getValorProduto());
            pstm.setBoolean(5, objProduto.getFlag_medicamento());
            pstm.setBoolean(6, objProduto.getFlag_generico());
            pstm.setInt(7, objProduto.getQuantidadeVendidaProduto());
            pstm.setInt(8, objProduto.getQuantidadeAtualProduto());
            pstm.setDouble(9, objProduto.getValorDescontoProduto());
            pstm.setDouble(10, objProduto.getValorAtualProduto());
            pstm.execute();
            pstm.close();

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "ProdutoDAO - cadastrarProduto" + erro);
        }
    }
    /**
     * Metodo que atualiza um objeto de Produto da tabela produtos
     * @param objProduto
     * @throws ClassNotFoundException 
     * author marcus lima
     */
     public void atualizarProduto(Produto objProduto) throws ClassNotFoundException {

        String sql = "UPDATE produtos SET  nome_produto = ?, qtd_produto = ?, valor_produto = ?, tipo_produto = ?, gen_produto = ?, qt_vendida = ?, qtd_atual = ?, valor_desconto = ?, valor_atual = ? Where id_produtos = ? ;";

        conn = BancoDAO.conectar();

        try {

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objProduto.getNomeProduto());
            pstm.setInt(2, objProduto.getQuantidadeProduto());
            pstm.setDouble(3, objProduto.getValorProduto());
            pstm.setBoolean(4, objProduto.getFlag_medicamento());
            pstm.setBoolean(5, objProduto.getFlag_generico());
            pstm.setInt(6, objProduto.getQuantidadeVendidaProduto());
            pstm.setInt(7, objProduto.getQuantidadeAtualProduto());
            pstm.setDouble(8, objProduto.getValorDescontoProduto());
            pstm.setDouble(9, objProduto.getValorAtualProduto());
            pstm.setInt(10, objProduto.getId());
            pstm.execute();
            pstm.close();

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "ProdutoDAO - atualizarProduto" + erro);
        }

    }
    /**
     * Metodo que seleciona todos os objetos da tabela produtos e os armazena em um array 
     * @return listaProduto
     * author marcus lima
     */
    public ArrayList<Produto> listarProduto() {
        String sql = "SELECT * FROM produtos;";
        conn = BancoDAO.conectar();

        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while(rs.next()){
                Produto objProduto = new Produto();
                objProduto.setId(rs.getInt("id_produtos"));
                objProduto.setNomeProduto(rs.getString("nome_produto"));
                objProduto.setMarcaProduto(rs.getString("marca_produto"));
                objProduto.setValorProduto(rs.getDouble("valor_produto"));
                objProduto.setQuantidadeProduto(rs.getInt("qtd_produto"));
                objProduto.setFlag_medicamento(rs.getBoolean("tipo_produto"));
                objProduto.setFlag_generico(rs.getBoolean("gen_produto"));
                listaProduto.add(objProduto);
            }
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ProdutoDAO - listarProduto" + erro);
        }
        return listaProduto;
    }
    /**
     * Metodo que deleta um objeto de Produto da tabela produtos
     * @param objProduto 
     * author marcus lima
     */
    public void deletarProduto(Produto objProduto){
        conn = BancoDAO.conectar();
        
        String sql = "DELETE FROM produtos WHERE id_produtos= ?;";
        
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, objProduto.getId());
            pstm.execute();
            pstm.close();
        } catch (SQLException erro) {
        JOptionPane.showMessageDialog(null,"ProdutoDAO - deletarProduto"+ erro);
        }
    }
    
    /**
     * Metodo que busca no banco e seleciona todos os produtos que tem nome ou id iguais aos do objeto produto passado como parametro
     * @param objProduto
     * @return listaProdutos
     * @author marcus lima
     */
    public ArrayList<Produto> buscarProdutoIdNome(Produto objProduto) {
        String sql = "SELECT * FROM produtos WHERE id_produtos like %?% or nome_produto like %?%;";
        conn = BancoDAO.conectar();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, objProduto.getId());
            pstm.setString(2, objProduto.getNomeProduto());
            rs = pstm.executeQuery();
            
            while(rs.next()){
                Produto obProduto = new Produto();
                obProduto.setId(rs.getInt("id_produtos"));
                obProduto.setNomeProduto(rs.getString("nome_produto"));
                obProduto.setMarcaProduto(rs.getString("marca_produto"));
                obProduto.setValorProduto(rs.getDouble("valor_produto"));
                obProduto.setQuantidadeProduto(rs.getInt("qtd_produto"));
                obProduto.setFlag_medicamento(rs.getBoolean("tipo_produto"));
                obProduto.setFlag_generico(rs.getBoolean("gen_produto"));
                listaProduto.add(obProduto);
            }
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ProdutoDAO buscarProdutoIdNome" + erro);
        }
        return listaProduto;
    }
    
    /**
     * Metodo que realiza a compra de um produto alterando a varias quantidade vendida e quantidade atual
     * @param objProduto
     * @throws ClassNotFoundException 
     */
    public void compraProduto(Produto objProduto) throws ClassNotFoundException {

        String sql = "UPDATE produtos SET qt_vendida = ?, qtd_atual = ? Where id_produtos = ? ;";

        conn = BancoDAO.conectar();

        try {

            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, objProduto.getQuantidadeVendidaProduto());
            pstm.setInt(2, objProduto.getQuantidadeAtualProduto());
            pstm.setInt(10, objProduto.getId());
            pstm.execute();
            pstm.close();

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "ProdutoDAO - atualizarProduto" + erro);
        }

    }
    
}
