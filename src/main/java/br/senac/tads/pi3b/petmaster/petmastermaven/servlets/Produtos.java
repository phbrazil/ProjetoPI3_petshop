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
public class Produtos {

    private long id;

    private double valor;

    private String nome;

    private Date dtCadastro;

    private String descricao;


    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getdtCadastro() {
        return dtCadastro;
    }

    public void setdtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;

    }

    public String getDescricao() {
        return descricao;
    }



    

    public Produtos(String nome, String dtCadastro, double valor) {
        DateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        this.nome = nome;
        this.valor = valor;
        try {
            this.dtCadastro = formatador.parse(dtCadastro);
        } catch (ParseException e) {

        }
    }

}
