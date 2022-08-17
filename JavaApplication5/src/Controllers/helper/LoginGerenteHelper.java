/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.helper;

import Models.Gerente;
import Views.LoginGerente;

/**
 *Classe para objetos do tipo LoginGerenteHelper, onde serão contidos, valores e métodos para o mesmo.
 * @author marcus lima
 */
public class LoginGerenteHelper {
    
    private final LoginGerente view;

    public LoginGerenteHelper(LoginGerente view) {
        this.view = view;
    }
    
    public Gerente obterModelo(){
        Gerente gerenteModelo = new Gerente();
        String email = this.view.getjTextField1EmailGerente().getText();
        String senha = this.view.getjTextField2SenhaGerente().getText();
        gerenteModelo.setEmailGerente(email);
        gerenteModelo.setSenhaGerente(senha);
        return gerenteModelo;
    }
    
    
}
