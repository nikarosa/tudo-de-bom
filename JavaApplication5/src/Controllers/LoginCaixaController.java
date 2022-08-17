/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Controllers.helper.LoginCaixaHelper;
import Models.Caixa;
import Models.DAO.CaixaDAO;
import Views.LoginCaixa;
import Views.MenuPrincipal;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *Classe para objetos do tipo LoginCaixaController, onde serão contidos, valores e métodos para o mesmo.
 * @author marcus lima
 */
public class LoginCaixaController {
    
    private final LoginCaixa view;
    private final LoginCaixaHelper helper;

    public LoginCaixaController(LoginCaixa view) {
        this.view = view;
        this.helper = new LoginCaixaHelper(view);
    }
    
    public void entrarNoSistema(){
        /** @author marcus lima
     * recebe um modelo de caixa e verifica se existe no banco, se existir, libera entrada no sistema e dá acesso a tela de menu
     */
        try {
            Caixa caixa = helper.obterModelo();
        CaixaDAO caixaDAO = new CaixaDAO();
        ResultSet rsCaixaDao = caixaDAO.loginCaixa(caixa);
        
        if(rsCaixaDao.next()){
            MenuPrincipal telaMenu = new MenuPrincipal();
            telaMenu.setVisible(true);
            this.view.dispose();
        }else{
            JOptionPane.showMessageDialog(null,"Uuario ou senha inválido ");
        }
           
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"LoginController "+ erro);
        }
        
    }
    
}
