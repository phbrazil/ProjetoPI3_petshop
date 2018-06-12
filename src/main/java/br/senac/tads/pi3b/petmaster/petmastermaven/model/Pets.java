/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.petmaster.petmastermaven.model;

import java.awt.List;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author paulo.bezerra
 */
public class Pets {

    private String codigobarraspet;

    private double valorpet;

    private String nomepet;

    private String categoriapet;

    private String racapet;

    private Date dtCadastropet;

    private String descricaopet;

    private int qtdestoquepet;

    private int idloja;

    public int getIdloja() {
        return idloja;
    }

    public void setIdloja(int idloja) {
        this.idloja = idloja;
    }

    public Pets(String nomepet, double valorpet, String codigobarraspet, String descricaopet, int qtdestoquepet, String categoriapet, int idloja) {
        this.codigobarraspet = codigobarraspet;
        this.nomepet = nomepet;
        this.valorpet = valorpet;
        this.descricaopet = descricaopet;
        this.qtdestoquepet = qtdestoquepet;
        this.categoriapet = categoriapet;
        this.idloja = idloja;

    }

    public String getCodigopet() {
        return codigobarraspet;
    }

    public void setCodigopet(String codigobarraspet) {
        this.codigobarraspet = codigobarraspet;
    }

    public double getValorpet() {
        return valorpet;
    }

    public void setValorpet(double valorpet) {
        this.valorpet = valorpet;
    }

    public String getNomepet() {
        return nomepet;
    }

    public void setNomepet(String nomepet) {
        this.nomepet = nomepet;
    }

    public String getCategoriapet() {
        return categoriapet;
    }

    public void setCategoriapet(String categoriapet) {
        this.categoriapet = categoriapet;
    }

    public String getRacapet() {
        return racapet;
    }

    public void setRacapet(String racapet) {
        this.racapet = racapet;
    }

    public Date getDtCadastropet() {
        return dtCadastropet;
    }

    public void setDtCadastropet(Date dtCadastropet) {
        this.dtCadastropet = dtCadastropet;
    }

    public String getDescricaopet() {
        return descricaopet;
    }

    public void setDescricaopet(String descricaopet) {
        this.descricaopet = descricaopet;
    }

    public int getQtdestoquepet() {
        return qtdestoquepet;
    }

    public void setQtdestoquepet(int qtdestoquepet) {
        this.qtdestoquepet = qtdestoquepet;
    }

}
