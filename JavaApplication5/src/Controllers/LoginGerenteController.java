/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Controllers.helper.LoginGerenteHelper;
import Models.DAO.GerenteDAO;
import Models.Gerente;
import Views.Estoque;
import Views.LoginGerente;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author marcus lima
 */
public class LoginGerenteController {
    
    private LoginGerente view;
    private LoginGerenteHelper helper;

    public LoginGerenteController(LoginGerente view) {
        this.view = view;
        this.helper = new LoginGerenteHelper(this.view);
    }
    
    public void entrarNoSistema(){
        /** @author marcus lima
     * recebe um modelo de gerente e verifica se existe no banco, se existir, libera entrada no sistema e dá acesso a tela de menu
     */
        try {
            Gerente gerente = helper.obterModelo();
        GerenteDAO gerenteDAO = new GerenteDAO();
        ResultSet rsCaixaDao = gerenteDAO.loginGerente(gerente);
        
        if(rsCaixaDao.next()){
            Estoque telaEstoque = new Estoque();
            telaEstoque.setVisible(true);
            this.view.dispose();
        }else{
            JOptionPane.showMessageDialog(null,"Uuario ou senha inválido ");
        }
           
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"LoginController "+ erro);
        }
        
    }
    
    
}
