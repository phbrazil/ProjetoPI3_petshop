/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.petmaster.petmastermaven.servlets.dao;

import br.senac.tads.pi3b.petmaster.petmastermaven.servlets.model.Sessao;
import br.senac.tads.pi3b.petmaster.petmastermaven.servlets.model.Vendas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Paulo.Bezerra
 */
public class BancoSessao {

    /**
     *
     * @author paulo.hbezerra
     */
    private Connection conexao = null;

    public void InsertSessao(Sessao sessao) {

        BancoConexao bancoconexao = new BancoConexao();

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = bancoconexao.getConnection();

            java.sql.Statement st = conexao.createStatement();

            st.executeUpdate("INSERT INTO sessao (idsessao, vendedor) VALUES ('" + sessao.getIdsessao() + "','" + sessao.getVendedor() + "');");

            conexao.close();

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }
    }

    public String selectSessao(String idsessao) {

        BancoConexao bancoconexao = new BancoConexao();

        String vendedor = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = bancoconexao.getConnection();

            java.sql.Statement st = conexao.createStatement();

            String select = "SELECT vendedor from sessao where idsessao = '" + idsessao + "'";

            ResultSet result = st.executeQuery(select);

            while (result.next()) {

                vendedor = result.getString("vendedor");

            }

            conexao.close();

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }
        return vendedor;

    }

}
