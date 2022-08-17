/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author marcu
 */
public class ProdutoDAO {
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<Produto> listaProduto = new ArrayList<Produto>();


    public void cadastrarProduto(Produto objProduto) throws ClassNotFoundException {

        System.out.println("ALGUMA COISA!");
        String sql = "INSERT INTO produtos VALUES (?,?,?,?,?,?);";

        conn = new BancoDAO().conectaBD();

        try {

            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, objProduto.getId());
            pstm.setString(2, objProduto.getNomeProduto());
            pstm.setInt(3, objProduto.getQuantidadeProduto());
            pstm.setDouble(4, objProduto.getValorProduto());
            pstm.setBoolean(5, objProduto.getFlag_medicamento());
            pstm.setBoolean(6, objProduto.getFlag_generico());
            pstm.execute();
            pstm.close();

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "ProdutoDAO - cadastrarProduto" + erro);
        }
    }
    
     public void atualizarProduto(Produto objProduto) throws ClassNotFoundException {

        String sql = "UPDATE produtos SET  nome_produto = ?, marca_produto =?, qtd_produto = ?, valor_produto = ?, tipo_produto = ?, gen_produto = ? Where id_produtos = ? ;";

        conn = new BancoDAO().conectaBD();

        try {

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objProduto.getNomeProduto());
            pstm.setString(2, objProduto.getMarcaProduto());
            pstm.setInt(3, objProduto.getQuantidadeProduto());
            pstm.setDouble(4, objProduto.getValorProduto());
            pstm.setBoolean(5, objProduto.getFlag_medicamento());
            pstm.setBoolean(6, objProduto.getFlag_generico());
            pstm.setInt(7, objProduto.getId());
            pstm.execute();
            pstm.close();

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "ProdutoDAO - atualizarProduto" + erro);
        }

    }
    
    public ArrayList<Produto> listarProduto() throws ClassNotFoundException {
        String sql = "SELECT * FROM produtos;";
        conn = new BancoDAO().conectaBD();

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
    
    public void deletarProduto(Produto objProduto) throws ClassNotFoundException{
        conn = new BancoDAO().conectaBD();
        
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
    
    
    public ArrayList<Produto> buscarProdutoIdNome(Produto objProduto) throws ClassNotFoundException {
        String sql = "SELECT * FROM produtos WHERE id_produtos like %?% or nome_produto like %?%;";
        conn = new BancoDAO().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, objProduto.getId());
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
}
