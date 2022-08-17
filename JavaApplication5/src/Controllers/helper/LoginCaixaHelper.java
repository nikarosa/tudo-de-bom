/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.helper;

import Models.Caixa;
import Views.LoginCaixa;

/**
 *
 * @author marcu
 */
public class LoginCaixaHelper {
    
    private final LoginCaixa view;
    
    public LoginCaixaHelper(LoginCaixa view) {
        this.view = view;
    }
    
    
    public Caixa obterModelo(){
        String nome = view.getjTextField1EmailCaixa().getText();
        String senha = view.getjPasswordField1SenhaCaixa().getSelectedText();
        Caixa modelo = new Caixa();
        modelo.setEmailCaixa(nome);
        modelo.setSenhaCaixa(senha);
        return modelo;
    }
}
