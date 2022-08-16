package modelDAO;

import model.Caixa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class CaixaDAO {
    Connection conn;
    
    
    public ResultSet loginCaixa(Caixa objCaixa) throws ClassNotFoundException{
        
        conn = new BancoDAO().conectaBD();
        
        try {
           String sql = "SELECT * FROM caixa WHERE emailCaixa = ? AND senhaCaixa = ? ";
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
