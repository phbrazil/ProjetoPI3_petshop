/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.petmaster.petmastermaven.servlets.controller;

import br.senac.tads.pi3b.petmaster.petmastermaven.model.Produtos;
import java.util.ArrayList;

/**
 *
 * @author killuminatti08
 */
public class AtualizarListaCarrinho {

    private static java.util.List<Produtos> listaCarrinho = new ArrayList<Produtos>();

    
    public void inserirProduto(Produtos produtos) {
        listaCarrinho.add(produtos);

    }

    public void RemoverProduto(int indice) {
        listaCarrinho.remove(indice);

    }

    public static Produtos atualizarListaCarrinho() {
        if (!listaCarrinho.isEmpty()) {
            for (int i = 0; i < listaCarrinho.size(); i++) {
                if (listaCarrinho.get(i) != null) {
                    return listaCarrinho.get(i);

                }
            }
        }
        return null;
    }
    
     public static Produtos pesquisarProduto(int indice) {
        if (!listaCarrinho.isEmpty()) {
            for (int i = 0; i < listaCarrinho.size(); i++) {
                if (listaCarrinho.get(indice) != null) {
                    return listaCarrinho.get(indice);

                }
            }
        }
        return null;
    }

    public int TamanhoListaCarrinho() {
        return listaCarrinho.size();
    }

}
