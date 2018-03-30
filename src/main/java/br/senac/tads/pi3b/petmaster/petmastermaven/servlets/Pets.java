/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.petmaster.petmastermaven.servlets;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author paulo.bezerra
 */
public class Pets {

    private long id;

    private double valor;

    private String nome;

    private String categoria;

    private String raca;

    private Date dtCadastro;

    private String descricao;
    
    int qtdestoque;

    public int getQtdestoque() {
        return qtdestoque;
    }

    public void setQtdestoque(int qtdestoque) {
        this.qtdestoque = qtdestoque;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Pets(int qtdestoque, String nome, String dtCadastro, double valor) {
        DateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        this.nome = nome;
        this.valor = valor;
        this.qtdestoque = qtdestoque;
        try {
            this.dtCadastro = formatador.parse(dtCadastro);
        } catch (ParseException e) {

        }
    }
}
