/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DAO;

import Models.Gerente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *Classe para objetos do tipo GerenteDAO, onde serão contidos, valores e métodos para o mesmo.
 * @author marcus lima
 */
public class GerenteDAO {
    Connection conn;
    
    /** @author marcus lima
     * Metodo que vai no banco de ddos e verifica se o email e senha do gerente estão cadastrados
     * @param objGerente
     * @return rs
     */
    public ResultSet loginGerente(Gerente objGerente){
        
        conn = BancoDAO.conectar();
        
        try {
           String sql = "SELECT * FROM gerente WHERE email_gerente = ? AND senha_gerente = ? ";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, objGerente.getEmailGerente());
            pstm.setString(2, objGerente.getSenhaGerente());
            
            ResultSet rs = pstm.executeQuery();
            return rs;
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "GerenteDAO " + erro);
            return null;
        }
    }
}
