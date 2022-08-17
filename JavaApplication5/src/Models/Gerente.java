/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *Classe para objetos do tipo Gerente, onde serão contidos, valores e métodos para o mesmo.
 * @author marcus lima
 */
public class Gerente {
    
    private int idGerente;
    private String nomeGerente;
    private String telefoneGerente;
    private String emailGerente;
    private String senhaGerente;

    public Gerente() {
    }

    public int getIdGerente() {
        return idGerente;
    }

    public void setIdGerente(int idGerente) {
        this.idGerente = idGerente;
    }

    public String getNomeGerente() {
        return nomeGerente;
    }

    public void setNomeGerente(String nomeGerente) {
        this.nomeGerente = nomeGerente;
    }

    public String getTelefoneGerente() {
        return telefoneGerente;
    }

    public void setTelefoneGerente(String telefoneGerente) {
        this.telefoneGerente = telefoneGerente;
    }

    public String getEmailGerente() {
        return emailGerente;
    }

    public void setEmailGerente(String emailGerente) {
        this.emailGerente = emailGerente;
    }

    public String getSenhaGerente() {
        return senhaGerente;
    }

    public void setSenhaGerente(String senhaGerente) {
        this.senhaGerente = senhaGerente;
    }
    
    
}
