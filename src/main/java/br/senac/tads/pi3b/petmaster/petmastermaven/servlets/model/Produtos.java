/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.petmaster.petmastermaven.servlets.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author paulo.bezerra
 */
public class Produtos {

    private String codigoprod;

    private double valorprod;

    private String nomeprod;

    private Date dtCadastro;

    private String descricaoprod;

    private int qtdestoque;

    private String categoriaprod;

    private java.util.List<Produtos> listaProd = new ArrayList<Produtos>();

    public Produtos(String codigoprod, double valorprod, String nomeprod, String descricaoprod, int qtdestoque, String categoriaprod) {
        this.codigoprod = codigoprod;
        this.valorprod = valorprod;
        this.nomeprod = nomeprod;
        this.descricaoprod = descricaoprod;
        this.qtdestoque = qtdestoque;
        this.categoriaprod = categoriaprod;

    }

    public String getCodigoprod() {
        return codigoprod;
    }

    public String getCategoriaprod() {
        return categoriaprod;
    }

    public void setCategoriaprod(String categoriaprod) {
        this.categoriaprod = categoriaprod;
    }

    public void setCodigoprod(String codigoprod) {
        this.codigoprod = codigoprod;
    }

    public double getValorprod() {
        return valorprod;
    }

    public void setValorprod(double valorprod) {
        this.valorprod = valorprod;
    }

    public String getNomeprod() {
        return nomeprod;
    }

    public void setNomeprod(String nomeprod) {
        this.nomeprod = nomeprod;
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    public String getDescricaoprod() {
        return descricaoprod;
    }

    public void setDescricaoprod(String descricaoprod) {
        this.descricaoprod = descricaoprod;
    }

    public int getQtdestoque() {
        return qtdestoque;
    }

    public void setQtdestoque(int qtdestoque) {
        this.qtdestoque = qtdestoque;
    }

    public Produtos obterPetsLista(String nome) {
        if (!listaProd.isEmpty()) {
            for (int i = 0; i < listaProd.size(); i++) {
                if (listaProd.get(i) != null && listaProd.get(i).nomeprod.toUpperCase().contains(nome.toUpperCase())) {
                    return listaProd.get(i);

                }
            }
        }
        return null;
    }

}
