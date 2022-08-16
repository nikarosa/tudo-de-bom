package modelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Pedido;
import model.Produto;

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
    
       public ArrayList<Pedido> listarPedidosIdCliente() {
        return listaPedido;
    }
    
    public ArrayList<Pedido> listarPedidosIdProduto() {
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
                Produto obProduto = new Produto();
                
                obProduto.setId(rs.getInt("id_produtos"));
                obProduto.setNomeProduto(rs.getString("nome_produto"));
                obProduto.setMarcaProduto(rs.getString("marca_produto"));
                obProduto.setValorProduto(rs.getDouble("valor_produto"));
                obProduto.setQuantidadeProduto(rs.getInt("qtd_produto"));
                obProduto.setFlag_medicamento(rs.getBoolean("tipo_produto"));
                obProduto.setFlag_generico(rs.getBoolean("gen_produto"));
                
                listaPedido.add(obProduto);
            }
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ProdutoDAO buscarProdutoIdNome" + erro);
        }
        return listaProduto;
    }
    
    public void deletarPedido(Pedido pedido) throws ClassNotFoundException{
        connection = new BancoDAO().conectaBD();
        
        String sql = "DELETE FROM pedidos WHERE id_pedido= ?;";
        
        try {
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1, objProduto.getId());
            pstm.execute();
            pstm.close();
        } catch (SQLException erro) {
        JOptionPane.showMessageDialog(null,"PedidoDAO - deletarPedido"+ erro);
        }
    }
    
 
}
