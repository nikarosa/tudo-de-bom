package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Pedido;

public class PedidoDAO {
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    ArrayList<Pedido> listaPedido = new ArrayList<>();
    
    
    public void cadastrarPedido(ArrayList<Pedido> pedidos) throws ClassNotFoundException {

        String sql = "INSERT INTO pedido VALUES (?,?,?,?,?,?);";

        connection = new BancoDAO().conectaBD();

        try {
            for(Pedido pedido: pedidos) {
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
            JOptionPane.showMessageDialog(null, "PedidoDAO - cadastrarPedido" + erro);
        }
    }
    
    public ArrayList<Pedido> listarPedidos() throws ClassNotFoundException {
        String sql = "SELECT * FROM pedidos;";
        
        connection = new BancoDAO().conectaBD();

        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                Pedido pedido = new Pedido();
                
                pedido.setIdPedido(resultSet.getInt("id_pedido"));
                pedido.setIdVendedor(resultSet.getInt("id_vendedor"));
                pedido.setIdCliente(resultSet.getInt("id_cliente"));
                pedido.setIdProduto(resultSet.getInt("id_produto"));
                pedido.setQtdProduto(resultSet.getInt("pedido_qtd_produto"));
                pedido.setValorProduto(resultSet.getDouble("pedido_vl_produto"));
                pedido.setValorTotal(resultSet.getDouble("pedido_valor_total"));
                
                listaPedido.add(pedido);
            }
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "PedidoDAO - listarPedido" + erro);
        }
        
        return listaPedido;
    }
    
    public ArrayList<Pedido> listarPedidosIdCliente(int idCliente) throws ClassNotFoundException {
        String sql = "SELECT * FROM produtos WHERE id_produto = ?;";
        connection = new BancoDAO().conectaBD();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idCliente);
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                Pedido pedido = new Pedido();
                
                pedido.setIdPedido(resultSet.getInt("id_pedido"));
                pedido.setIdVendedor(resultSet.getInt("id_vendedor"));
                pedido.setIdCliente(resultSet.getInt("id_cliente"));
                pedido.setIdProduto(resultSet.getInt("id_produto"));
                pedido.setQtdProduto(resultSet.getInt("pedido_qtd_produto"));
                pedido.setValorProduto(resultSet.getDouble("pedido_vl_produto"));
                pedido.setValorTotal(resultSet.getDouble("pedido_valor_total"));
                
                listaPedido.add(pedido);
            }
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Pedido listar pedidos por produto" + erro);
        }   
           
        return listaPedido;
    }
    
    public ArrayList<Pedido> listarPedidosIdProduto(int idProduto) throws ClassNotFoundException {
        String sql = "SELECT * FROM produtos WHERE id_produto = ?;";
        connection = new BancoDAO().conectaBD();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idProduto);
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                Pedido pedido = new Pedido();
                
                pedido.setIdPedido(resultSet.getInt("id_pedido"));
                pedido.setIdVendedor(resultSet.getInt("id_vendedor"));
                pedido.setIdCliente(resultSet.getInt("id_cliente"));
                pedido.setIdProduto(resultSet.getInt("id_produto"));
                pedido.setQtdProduto(resultSet.getInt("pedido_qtd_produto"));
                pedido.setValorProduto(resultSet.getDouble("pedido_vl_produto"));
                pedido.setValorTotal(resultSet.getDouble("pedido_valor_total"));
                
                listaPedido.add(pedido);
            }
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Pedido listar pedidos por produto" + erro);
        }
        
        return listaPedido;
    }            
    
    public ArrayList<Pedido> listarPedidosIdVendedor(int idVendedor) throws ClassNotFoundException {
        String sql = "SELECT * FROM produtos WHERE id_vendedor = ?;";
        connection = new BancoDAO().conectaBD();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idVendedor);
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                Pedido pedido = new Pedido();
                
                pedido.setIdPedido(resultSet.getInt("id_pedido"));
                pedido.setIdVendedor(resultSet.getInt("id_vendedor"));
                pedido.setIdCliente(resultSet.getInt("id_cliente"));
                pedido.setIdProduto(resultSet.getInt("id_produto"));
                pedido.setQtdProduto(resultSet.getInt("pedido_qtd_produto"));
                pedido.setValorProduto(resultSet.getDouble("pedido_vl_produto"));
                pedido.setValorTotal(resultSet.getDouble("pedido_valor_total"));
                
                listaPedido.add(pedido);
            }
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Pedido listar pedidos por vendedor" + erro);
        }
        
        return listaPedido;
    }
    
    public void deletarPedido(int idPedido) throws ClassNotFoundException{
        connection = new BancoDAO().conectaBD();
        
        String sql = "DELETE FROM pedidos WHERE id_pedido= ?;";
        
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idPedido);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"PedidoDAO - deletarPedido"+ erro);
        }
    }
 
}
