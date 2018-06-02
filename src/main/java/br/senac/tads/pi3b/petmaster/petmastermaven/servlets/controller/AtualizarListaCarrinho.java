package br.senac.tads.pi3b.petmaster.petmastermaven.servlets.controller;

import br.senac.tads.pi3b.petmaster.petmastermaven.servlets.model.Produtos;
import java.awt.List;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author paulo.hbezerra
 */
public class AtualizarListaCarrinho {

    private static java.util.List<Produtos> listaCarrinho = new ArrayList<Produtos>();

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
