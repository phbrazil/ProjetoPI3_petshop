/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.petmaster.petmastermaven.model;

/**
 *
 * @author killuminatti08
 */
public class Sessao {
    
    private String idsessao = null;
    private String vendedor = null;
    private int idloja = 0;

    public int getIdloja() {
        return idloja;
    }

    public void setIdloja(int idloja) {
        this.idloja = idloja;
    }

    public String getIdsessao() {
        return idsessao;
    }

    public void setIdsessao(String idsessao) {
        this.idsessao = idsessao;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }
    
    
}
