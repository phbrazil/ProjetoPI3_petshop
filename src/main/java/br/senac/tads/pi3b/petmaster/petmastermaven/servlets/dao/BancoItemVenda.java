/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.petmaster.petmastermaven.servlets.dao;

import br.senac.tads.pi3b.petmaster.petmastermaven.servlets.controller.AtualizarListaCarrinho;
import br.senac.tads.pi3b.petmaster.petmastermaven.servlets.model.Produtos;
import br.senac.tads.pi3b.petmaster.petmastermaven.servlets.model.Vendas;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Paulo.Bezerra
 */
public class BancoItemVenda {

    private Connection conexao = null;
    BancoConexao bancoconexao = new BancoConexao();

    public void InsertItemTemp(List<Produtos> carrinho, Vendas vendas) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = bancoconexao.getConnection();
            
            System.out.println("tamanho do carrinho = "+carrinho.size());

            for (int i = 0; i < carrinho.size(); i++) {

                java.sql.Statement st = conexao.createStatement();
                st.executeUpdate("INSERT INTO itemvenda (idvenda, idprod,quantidadeitens) VALUES (" + vendas.getVendaID() + ",'" + carrinho.get(i).getCodigoprod()+ "'," + carrinho.get(i).getItensvenda()+ ");");
                System.out.println("i aqui"+i);
            }
            conexao.close();
        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }
    }

}
