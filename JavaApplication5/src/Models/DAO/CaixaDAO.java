/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DAO;

import Models.Caixa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *Classe para objetos do tipo CaixaDAO, onde serão contidos, valores e métodos para o mesmo.
 * @author marcus lima
 */
public class CaixaDAO {
    Connection conn;
    
    /** @author marcu
     * Metodo que vai no banco de dados e verifica se o email e senha do caixa estão cadastrados
     * @param objCaixa
     * @return rs
     */
    
    public ResultSet loginCaixa(Caixa objCaixa){
        
        conn = BancoDAO.conectar();
        
        try {
           String sql = "SELECT * FROM vendedor WHERE email_vendedor = ? AND senha_vendedor = ? ";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, objCaixa.getEmailCaixa());
            pstm.setString(2, objCaixa.getSenhaCaixa());
            
            ResultSet rs = pstm.executeQuery();
            return rs;
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "CaixaDAO " + erro);
            return null;
        }
    }
}
