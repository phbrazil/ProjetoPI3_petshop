/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.petmaster.petmastermaven.servlets.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author paulo.bezerra
 */
public class Loja {

    private int lojaid;
    private String nomeLoja;
    private String logradouro;
    private String cidade;
    private String bairro;
    private String UF;
    private String pais;
    private String cep;
    private String telefone;


    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    
    
    public int getlojaid() {
        return lojaid;
    }

    public void setClienteid(int lojaid) {
        this.lojaid = lojaid;
    }

    public String getNomeLoja() {
        return nomeLoja;
    }

    public void setNomeLoja(String nomeLoja) {
        this.nomeLoja = nomeLoja;
    }


    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    private java.util.List<Loja> listaLoja = new ArrayList<Loja>();

    public List<Loja> getListaLoja() {
        return listaLoja;
    }

    public void setListaLoja(Loja lojas) {
        listaLoja.add(lojas);
    }

    
    public Loja(String nomeLoja, String logradouro, 
            String cidade, String bairro, String UF, String cep, String telefone) {
        this.nomeLoja = nomeLoja;
        this.logradouro = logradouro;
        this.cep = cep;
        this.bairro = bairro;
        this.cidade = cidade;
        this.UF = UF;
        this.telefone = telefone;

    }
   
    public Loja obterLojaLista(String id) {
        if (!listaLoja.isEmpty()) {
            for (int i = 0; i < listaLoja.size(); i++) {
                if (listaLoja.get(i) != null) {
                    return listaLoja.get(i);

                }
            }
        }
        return null;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }


    public void setListaLoja(List<Loja> listaLoja) {
        this.listaLoja = listaLoja;
    }
    
}
