package Models.DAO;

import Models.Vendas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class VendasDAO {
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    ArrayList<Vendas> listaVendas = new ArrayList<>();
    
    
    public void cadastrarVendas(ArrayList<Vendas> pedidos) throws ClassNotFoundException {

        String sql = "INSERT INTO pedido VALUES (?,?,?,?,?,?);";

        connection = BancoDAO.conectar();

        try {
            for(Vendas pedido: pedidos) {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, pedido.getIdVendedor());
                preparedStatement.setInt(2, pedido.getIdCliente());
                preparedStatement.setInt(3, pedido.getIdProduto());
                preparedStatement.setInt(4, pedido.getQtdProduto());
                preparedStatement.setDouble(5, pedido.getValorProduto());
                preparedStatement.setDouble(6, pedido.getValorTotal());
                preparedStatement.execute();
            }
            
            preparedStatement.close();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "VendasDAO - cadastrarVendas" + erro);
        }
    }
    
    public ArrayList<Vendas> listarVendass() throws ClassNotFoundException {
        String sql = "SELECT * FROM pedidos;";
        
        connection = new BancoDAO().conectaBD();

        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                Vendas pedido = new Vendas();
                
                pedido.setIdVendas(resultSet.getInt("id_pedido"));
                pedido.setIdVendedor(resultSet.getInt("id_vendedor"));
                pedido.setIdCliente(resultSet.getInt("id_cliente"));
                pedido.setIdProduto(resultSet.getInt("id_produto"));
                pedido.setQtdProduto(resultSet.getInt("pedido_qtd_produto"));
                pedido.setValorProduto(resultSet.getDouble("pedido_vl_produto"));
                pedido.setValorTotal(resultSet.getDouble("pedido_valor_total"));
                
                listaVendas.add(pedido);
            }
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "VendasDAO - listarVendas" + erro);
        }
        
        return listaVendas;
    }
    
    public ArrayList<Vendas> listarVendassIdCliente(int idCliente) throws ClassNotFoundException {
        String sql = "SELECT * FROM produtos WHERE id_produto = ?;";
        connection = new BancoDAO().conectaBD();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idCliente);
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                Vendas pedido = new Vendas();
                
                pedido.setIdVendas(resultSet.getInt("id_pedido"));
                pedido.setIdVendedor(resultSet.getInt("id_vendedor"));
                pedido.setIdCliente(resultSet.getInt("id_cliente"));
                pedido.setIdProduto(resultSet.getInt("id_produto"));
                pedido.setQtdProduto(resultSet.getInt("pedido_qtd_produto"));
                pedido.setValorProduto(resultSet.getDouble("pedido_vl_produto"));
                pedido.setValorTotal(resultSet.getDouble("pedido_valor_total"));
                
                listaVendas.add(pedido);
            }
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Vendas listar pedidos por produto" + erro);
        }   
           
        return listaVendas;
    }
    
    public ArrayList<Vendas> listarVendassIdProduto(int idProduto) throws ClassNotFoundException {
        String sql = "SELECT * FROM produtos WHERE id_produto = ?;";
        connection = new BancoDAO().conectaBD();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idProduto);
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                Vendas pedido = new Vendas();
                
                pedido.setIdVendas(resultSet.getInt("id_pedido"));
                pedido.setIdVendedor(resultSet.getInt("id_vendedor"));
                pedido.setIdCliente(resultSet.getInt("id_cliente"));
                pedido.setIdProduto(resultSet.getInt("id_produto"));
                pedido.setQtdProduto(resultSet.getInt("pedido_qtd_produto"));
                pedido.setValorProduto(resultSet.getDouble("pedido_vl_produto"));
                pedido.setValorTotal(resultSet.getDouble("pedido_valor_total"));
                
                listaVendas.add(pedido);
            }
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Vendas listar pedidos por produto" + erro);
        }
        
        return listaVendas;
    }            
    
    public ArrayList<Vendas> listarVendassIdVendedor(int idVendedor) throws ClassNotFoundException {
        String sql = "SELECT * FROM produtos WHERE id_vendedor = ?;";
        connection = new BancoDAO().conectaBD();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idVendedor);
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                Vendas pedido = new Vendas();
                
                pedido.setIdVendas(resultSet.getInt("id_pedido"));
                pedido.setIdVendedor(resultSet.getInt("id_vendedor"));
                pedido.setIdCliente(resultSet.getInt("id_cliente"));
                pedido.setIdProduto(resultSet.getInt("id_produto"));
                pedido.setQtdProduto(resultSet.getInt("pedido_qtd_produto"));
                pedido.setValorProduto(resultSet.getDouble("pedido_vl_produto"));
                pedido.setValorTotal(resultSet.getDouble("pedido_valor_total"));
                
                listaVendas.add(pedido);
            }
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Vendas listar pedidos por vendedor" + erro);
        }
        
        return listaVendas;
    }
    
    public void deletarVendas(int idVendas) throws ClassNotFoundException{
        connection = new BancoDAO().conectaBD();
        
        String sql = "DELETE FROM pedidos WHERE id_pedido= ?;";
        
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idVendas);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"VendasDAO - deletarVendas"+ erro);
        }
    }
 
}