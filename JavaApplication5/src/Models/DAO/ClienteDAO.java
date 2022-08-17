package Models.DAO;


import Models.Cliente;
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
    public void inserirDados(Cliente dado){
        Connection conexao = BancoDAO.conectar();
        PreparedStatement state = null;
        
        try {
            state = conexao.prepareStatement("insert into clientes (nome_cliente, cpf_cliente, email_cliente, telefone_cliente) values (?, ?, ?, ?)");
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
            BancoDAO.closeConnection(conexao, state);
            
        }
    }
    
    public List<Cliente> voltarDados(){
        Connection conexao = BancoDAO.conectar();
        PreparedStatement state = null;
        ResultSet res = null;
        
        List<Cliente> listaCliente = new ArrayList<>();
        
        try {
            state = conexao.prepareStatement("select * from clientes");
            res = state.executeQuery();
            
                while(res.next()){
                    Cliente dado = new Cliente();
                    
                    dado.setId(res.getInt("id_cliente"));
                    dado.setNome(res.getString("nome_cliente"));
                    dado.setCPF(res.getString("cpf_cliente"));
                    dado.setEmail(res.getString("email_cliente"));
                    dado.setTelefone(res.getString("telefone_cliente"));
                    
                    listaCliente.add(dado);
                }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            BancoDAO.closeConnection(conexao, state, res);
        }
        
        return listaCliente;
    }
    
    public void alterarDados(Cliente dado){
        Connection conexao = BancoDAO.conectar();
        PreparedStatement state = null;
        
        try {
            state = conexao.prepareStatement("update clientes set nome_cliente = ?, cpf_cliente = ?, email_cliente = ?, telefone_cliente = ? where id_cliente = ?;");
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
            BancoDAO.closeConnection(conexao, state);
            
        }
    }
    public void excluirDados(Cliente dado){
        Connection conexao = BancoDAO.conectar();
        PreparedStatement state = null;
        
        try {
            state = conexao.prepareStatement("delete from clientes where id_cliente = ?;");
            state.setInt(1, dado.getId());
            
            state.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro de cliente excluído com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro "+ex.getMessage());
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            BancoDAO.closeConnection(conexao, state);
            
        }
    }
    
    public List<Cliente> buscaDados(String nome){
        Connection conexao = BancoDAO.conectar();
        PreparedStatement state = null;
        ResultSet res = null;
        
        List<Cliente> listaCliente = new ArrayList<>();
        
        try {
            state = conexao.prepareStatement("select * from clientes where nome_cliente like ?");
            state.setString(1, "%"+nome+"%");
            res = state.executeQuery();
            
                while(res.next()){
                    Cliente dado = new Cliente();
                    
                    dado.setId(res.getInt("id_cliente"));
                    dado.setNome(res.getString("nome_cliente"));
                    dado.setCPF(res.getString("cpf_cliente"));
                    dado.setEmail(res.getString("email_cliente"));
                    dado.setTelefone(res.getString("telefone_cliente"));
                    
                    listaCliente.add(dado);
                }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            BancoDAO.closeConnection(conexao, state, res);
        }
        
        return listaCliente;
    }
}
