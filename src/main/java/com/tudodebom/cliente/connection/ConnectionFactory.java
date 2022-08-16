package com.tudodebom.cliente.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nigor
 */
public class ConnectionFactory {
    private static String DRIVER = "com.mysql.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/tdb";
    private static String USER = "root";
    private static String PASS = "mysql";
    
    public static Connection conectar(){
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro: ", ex);
        }
    }
    
    public static void closeConnection(Connection conexao){
       
       try{
           if (conexao != null){
               conexao.close();
           }
       } catch(SQLException ex){
           Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    public static void closeConnection(Connection conexao, PreparedStatement state){
        
       closeConnection(conexao);
       
       try{
           if (state != null){
               state.close();
           }
       } catch(SQLException ex){
           Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
       }
           
    }
    public static void closeConnection(Connection conexao, PreparedStatement state, ResultSet res){
        
       closeConnection(conexao, state);
       
       try{
           if (res != null){
               res.close();
           }
       } catch(SQLException ex){
           Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
       }
           
    }
}
