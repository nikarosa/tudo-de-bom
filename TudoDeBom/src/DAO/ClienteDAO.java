package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Cliente;



public class ClienteDAO {
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    ArrayList<Cliente> listaCliente = new ArrayList<>();
    
    public void inserirCliente(Cliente cliente) throws SQLException{    
        String sql = "INSERT INTO clientes VALUES (?, ?, ?, ?);";
        
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getCPF());
            preparedStatement.setString(3, cliente.getEmail());
            preparedStatement.setString(4, cliente.getTelefone());
            
            preparedStatement.executeUpdate();            
            preparedStatement.close();
            
            JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro "+ex.getMessage());
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public ArrayList<Cliente> listarClientes() throws SQLException, ClassNotFoundException{
        String sql = "select * from clientes;";
        
        connection = new BancoDAO().conectaBD();
        
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                Cliente cliente = new Cliente();

                cliente.setId(resultSet.getInt("id_clientes"));
                cliente.setNome(resultSet.getString("nome_cliente"));
                cliente.setCPF(resultSet.getString("cpf_cliente"));
                cliente.setEmail(resultSet.getString("email_cliente"));
                cliente.setTelefone(resultSet.getString("telefone_cliente"));

                listaCliente.add(cliente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            connection.close();
        }
        
        return listaCliente;
    }
    
    public void alterarCliente(Cliente cliente) throws ClassNotFoundException, SQLException{
        String sql = "update clientes set nome_cliente = ?, cpf_cliente = ?, email_cliente = ?, telefone_cliente = ? where id_clientes = ?;";
        
        connection = new BancoDAO().conectaBD();
        
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getCPF());
            preparedStatement.setString(3, cliente.getEmail());
            preparedStatement.setString(4, cliente.getTelefone());
            preparedStatement.setInt(5, cliente.getId());
            
            preparedStatement.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro "+ex.getMessage());
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            connection.close();
        }
    }
    
    public void excluirCliente(Cliente cliente) throws SQLException, ClassNotFoundException{
        String sql = "update clientes set nome_cliente = ?, cpf_cliente = ?, email_cliente = ?, telefone_cliente = ? where id_clientes = ?;";
        
        connection = new BancoDAO().conectaBD();
        
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, cliente.getId());
            preparedStatement.execute();
            
            JOptionPane.showMessageDialog(null, "Registro de cliente excluído com sucesso!");
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro "+ex.getMessage());
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            connection.close();
        }
    }
    
    public ArrayList<Cliente> listarClientePorNome(String nome) throws SQLException, ClassNotFoundException{
        String sql = "select * from Clientes where nome_cliente like ?";
        
        connection = new BancoDAO().conectaBD();
        
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%"+nome+"%");
            resultSet = preparedStatement.executeQuery();
            
                while(resultSet.next()){
                    Cliente cliente = new Cliente();
                    
                    cliente.setId(resultSet.getInt("id_clientes"));
                    cliente.setNome(resultSet.getString("nome_cliente"));
                    cliente.setCPF(resultSet.getString("cpf_cliente"));
                    cliente.setEmail(resultSet.getString("email_cliente"));
                    cliente.setTelefone(resultSet.getString("telefone_cliente"));
                    
                    listaCliente.add(cliente);
                }
        }
        catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            connection.close();
        }
        
        return listaCliente;
    }

}
