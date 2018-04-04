/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.petmaster.petmastermaven.servlets.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author paulo.bezerra
 */
public class Produtos {

    private long codigoprod;

    private double valorprod;

    private String nomeprod;

    private Date dtCadastro;

    private String descricaoprod;
    
    int qtdestoque;

    



    

    public Produtos(int qtdestoque, String nome, String dtCadastro, double valor) {
        DateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        this.nomeprod = nome;
        this.valorprod = valor;
        this.qtdestoque = qtdestoque;
        try {
            this.dtCadastro = formatador.parse(dtCadastro);
        } catch (ParseException e) {

        }
    }

    public long getCodigoprod() {
        return codigoprod;
    }

    public void setCodigoprod(long codigoprod) {
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

}
