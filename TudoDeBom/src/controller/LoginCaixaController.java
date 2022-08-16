/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controllerhelper.LoginCaixaHelper;
import model.Caixa;
import modelDAO.CaixaDAO;
import view.LoginCaixa;
import view.MenuPrincipal;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author marcu
 */
public class LoginCaixaController {
    
    private final LoginCaixa view;
    private final LoginCaixaHelper helper;

    public LoginCaixaController(LoginCaixa view) {
        this.view = view;
        this.helper = new LoginCaixaHelper(view);
    }
    
    public void entrarNoSistema() throws ClassNotFoundException{
        //pegar usuario da view
        //pesquisar usuario do banco
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
