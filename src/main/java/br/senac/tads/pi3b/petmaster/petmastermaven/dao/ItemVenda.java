/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.petmaster.petmastermaven.dao;

import br.senac.tads.pi3b.petmaster.petmastermaven.model.Produtos;
import br.senac.tads.pi3b.petmaster.petmastermaven.model.Vendas;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Paulo.Bezerra
 */
public class ItemVenda {

    private Connection conexao = null;
    Conexao bancoconexao = new Conexao();

    public void InsertItemTemp(List<Produtos> carrinho, Vendas vendas) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = bancoconexao.getConnection();
            

            for (int i = 0; i < carrinho.size(); i++) {

                java.sql.Statement st = conexao.createStatement();
                st.executeUpdate("INSERT INTO itemvenda (idvenda, idprod,quantidadeitens, idloja) VALUES (" + vendas.getVendaID() + ",'" + carrinho.get(i).getCodigoprod()+ "'," 
                        + carrinho.get(i).getItensvenda()+ ","+vendas.getIdloja()+ ");");
            }
            conexao.close();
        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }
    }

}
