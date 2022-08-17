/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.LoginGerente;
import view.MenuPrincipal;

/**
 *
 * @author marcu
 */
public class MenuPrincipalController {
     private final MenuPrincipal view;

    public MenuPrincipalController(MenuPrincipal view) {
        this.view = view;
    }
     
    
    public void navegarParaEstoque(){
        LoginGerente loginGerente = new LoginGerente();
        loginGerente.setVisible(true);
        this.view.dispose();
    }
    
}
