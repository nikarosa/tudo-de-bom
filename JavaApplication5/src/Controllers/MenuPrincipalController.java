/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Views.Clientes;
import Views.LoginGerente;
import Views.MenuPrincipal;

/**
 *Classe para objetos do tipo MenuPrincipalController, onde serão contidos, valores e métodos para o mesmo.
 * @author marcus lima
 */
public class MenuPrincipalController {
     private final MenuPrincipal view;

    public MenuPrincipalController(MenuPrincipal view) {
        this.view = view;
    }
     
    /**
 *metodo que abre a tela de Estoque e fecha a de MenuPrincipal
 * @author marcus lima
 */
    public void navegarParaEstoque(){
        LoginGerente loginGerente = new LoginGerente();
        loginGerente.setVisible(true);
        this.view.dispose();
    }
    
    /**
 *metodo que abre a tela de CadastrarCliente e fecha a de MenuPrincipal
 * @author marcus lima
 */
    public void navegarParaCadastrarCliente(){
        Clientes clientes = new Clientes();
        clientes.setVisible(true);
        this.view.dispose();
    }
    
    /**
 *metodo que abre a tela de Vendas e fecha a de MenuPrincipal
 * @author marcus lima
 */
    public void navegarParaVendas(){
        
    }
    
}
