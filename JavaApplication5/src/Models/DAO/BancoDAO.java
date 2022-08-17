package Models.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author nigor
 */
public class BancoDAO {
    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/tdb";
    private static String USER = "root";
    private static String PASS = "mysql";
    
    /**
     *
     * @return
     */
    public static Connection conectar(){
        Connection conn = null;
        try { 
           conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tdb", "root", "root");
//            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tdb?serverTimezone=UTC&allowPublicKeyRetrieval=TRUE&useSSL=TRUE", "root", "mysql");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"BancoDAO"+ erro.getMessage());
        }
       
        return conn;
    }
    
    public static void closeConnection(Connection conexao){
       
       try{
           if (conexao != null){
               conexao.close();
           }
       } catch(SQLException ex){
           Logger.getLogger(BancoDAO.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    public static void closeConnection(Connection conexao, PreparedStatement state){
        
       closeConnection(conexao);
       
       try{
           if (state != null){
               state.close();
           }
       } catch(SQLException ex){
           Logger.getLogger(BancoDAO.class.getName()).log(Level.SEVERE, null, ex);
       }
           
    }
    public static void closeConnection(Connection conexao, PreparedStatement state, ResultSet res){
        
       closeConnection(conexao, state);
       
       try{
           if (res != null){
               res.close();
           }
       } catch(SQLException ex){
           Logger.getLogger(BancoDAO.class.getName()).log(Level.SEVERE, null, ex);
       }
           
    }

    Connection conectaBD() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

