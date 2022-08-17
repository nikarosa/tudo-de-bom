/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author marcu
 */
public class Caixa {
    
    private int idCaixa;
    private String nomeCaixa;
    private String telefoneCaixa;
    private String emailCaixa;
    private String senhaCaixa;
    private Gerente idGerente;

    public Gerente getIdGerente() {
        return idGerente;
    }

    public void setIdGerente(Gerente idGerente) {
        this.idGerente = idGerente;
    }

    public Caixa() {
    }

    public String getNomeCaixa() {
        return nomeCaixa;
    }

    public void setNomeCaixa(String nomeCaixa) {
        this.nomeCaixa = nomeCaixa;
    }

    public String getTelefoneCaixa() {
        return telefoneCaixa;
    }

    public void setTelefoneCaixa(String telefoneCaixa) {
        this.telefoneCaixa = telefoneCaixa;
    }

    public String getEmailCaixa() {
        return emailCaixa;
    }

    public void setEmailCaixa(String emailCaixa) {
        this.emailCaixa = emailCaixa;
    }

    public String getSenhaCaixa() {
        return senhaCaixa;
    }

    public void setSenhaCaixa(String senhaCaixa) {
        this.senhaCaixa = senhaCaixa;
    }

    public int getIdCaixa() {
        return idCaixa;
    }

    public void setIdCaixa(int idCaixa) {
        this.idCaixa = idCaixa;
    }
    
    
    
}
