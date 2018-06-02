/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.petmaster.petmastermaven.servlets.dao;

import br.senac.tads.pi3b.petmaster.petmastermaven.servlets.controller.AtualizarListaCarrinho;
import br.senac.tads.pi3b.petmaster.petmastermaven.servlets.model.Vendas;
import java.sql.Connection;

/**
 *
 * @author Paulo.Bezerra
 */
public class BancoItemVenda {

    private Connection conexao = null;
    BancoConexao bancoconexao = new BancoConexao();

    public void InsertItemTemp(AtualizarListaCarrinho carrinho, Vendas vendas) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = bancoconexao.getConnection();

            for (int i = 0; i < carrinho.TamanhoListaCarrinho(); i++) {

                java.sql.Statement st = conexao.createStatement();
                st.executeUpdate("INSERT INTO itemvenda (idvenda, idproduto,quantidadeitens) VALUES (" + vendas.getVendaID() + "," + carrinho.pesquisarProduto(i).getCodigoprod()+ "," + carrinho.pesquisarProduto(i).getQtdestoque()+ ");");

            }
            conexao.close();
        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }
    }

}
