/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.petmaster.petmastermaven.servlets.model;

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

    private  java.util.List<Pets> listaPets = new ArrayList<Pets>();

    public java.util.List<Pets> getListaPets() {
        return listaPets;
    }

    
    


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

    public void inserirPets(Pets pets) {
        listaPets.add(pets);

    }

   

    public int PetsTamanho() {

        return listaPets.size();
    }

    public int obterPetsLista(String nome) {
        if (nome != null && !listaPets.isEmpty()) {
            for (int i = 0; i < listaPets.size(); i++) {
                if (listaPets.get(i) != null && listaPets.get(i).getNome().toUpperCase().contains(nome.toUpperCase())) {
                    return i;

                }
            }
        }
        return -1;
    }
    
    

    public Pets obterPetsListaGeral(int indice) {
        if (!listaPets.isEmpty()) {
            for (int i = 0; i < listaPets.size(); i++) {
                if (listaPets.get(i) != null) {
                    System.out.println(listaPets.get(indice).getNome());
                    return listaPets.get(indice);

                }
            }
        }
        return null;
    }
}
