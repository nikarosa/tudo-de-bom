package com.tudodebom.cliente.model.dao;

import com.tudodebom.cliente.connection.ConnectionFactory;
import com.tudodebom.cliente.model.bean.Dados;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author nigor
 */
public class ClienteDAO {
    public void inserirDados(Dados dado){
        Connection conexao = ConnectionFactory.conectar();
        PreparedStatement state = null;
        
        try {
            state = conexao.prepareStatement("insert into Clientes (nome_cliente, cpf_cliente, email_cliente, telefone_cliente) values (?, ?, ?, ?)");
            state.setString(1, dado.getNome());
            state.setString(2, dado.getCPF());
            state.setString(3, dado.getEmail());
            state.setString(4, dado.getTelefone());
            
            state.executeUpdate();
            JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro "+ex.getMessage());
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(conexao, state);
            
        }
    }
    
    public List<Dados> voltarDados(){
        Connection conexao = ConnectionFactory.conectar();
        PreparedStatement state = null;
        ResultSet res = null;
        
        List<Dados> listaCliente = new ArrayList<>();
        
        try {
            state = conexao.prepareStatement("select * from Clientes");
            res = state.executeQuery();
            
                while(res.next()){
                    Dados dado = new Dados();
                    
                    dado.setId(res.getInt("id_clientes"));
                    dado.setNome(res.getString("nome_cliente"));
                    dado.setCPF(res.getString("cpf_cliente"));
                    dado.setEmail(res.getString("email_cliente"));
                    dado.setTelefone(res.getString("telefone_cliente"));
                    
                    listaCliente.add(dado);
                }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(conexao, state, res);
        }
        
        return listaCliente;
    }
    
    public void alterarDados(Dados dado){
        Connection conexao = ConnectionFactory.conectar();
        PreparedStatement state = null;
        
        try {
            state = conexao.prepareStatement("update Clientes set nome_cliente = ?, cpf_cliente = ?, email_cliente = ?, telefone_cliente = ? where id_clientes = ?;");
            state.setString(1, dado.getNome());
            state.setString(2, dado.getCPF());
            state.setString(3, dado.getEmail());
            state.setString(4, dado.getTelefone());
            state.setInt(5, dado.getId());
            
            state.executeUpdate();
            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro "+ex.getMessage());
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(conexao, state);
            
        }
    }
    public void excluirDados(Dados dado){
        Connection conexao = ConnectionFactory.conectar();
        PreparedStatement state = null;
        
        try {
            state = conexao.prepareStatement("delete from Clientes where id_clientes = ?;");
            state.setInt(1, dado.getId());
            
            state.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro de cliente excluído com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro "+ex.getMessage());
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(conexao, state);
            
        }
    }
    
    public List<Dados> buscaDados(String nome){
        Connection conexao = ConnectionFactory.conectar();
        PreparedStatement state = null;
        ResultSet res = null;
        
        List<Dados> listaCliente = new ArrayList<>();
        
        try {
            state = conexao.prepareStatement("select * from Clientes where nome_cliente like ?");
            state.setString(1, "%"+nome+"%");
            res = state.executeQuery();
            
                while(res.next()){
                    Dados dado = new Dados();
                    
                    dado.setId(res.getInt("id_clientes"));
                    dado.setNome(res.getString("nome_cliente"));
                    dado.setCPF(res.getString("cpf_cliente"));
                    dado.setEmail(res.getString("email_cliente"));
                    dado.setTelefone(res.getString("telefone_cliente"));
                    
                    listaCliente.add(dado);
                }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(conexao, state, res);
        }
        
        return listaCliente;
    }
}
