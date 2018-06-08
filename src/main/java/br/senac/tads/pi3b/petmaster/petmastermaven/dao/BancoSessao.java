/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.petmaster.petmastermaven.dao;

import br.senac.tads.pi3b.petmaster.petmastermaven.model.Sessao;
import br.senac.tads.pi3b.petmaster.petmastermaven.model.Vendas;
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

        Conexao bancoconexao = new Conexao();

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = bancoconexao.getConnection();

            java.sql.Statement st = conexao.createStatement();

            st.executeUpdate("INSERT INTO sessao (idsessao, vendedor, idloja) VALUES ('" + sessao.getIdsessao() + "','" + sessao.getVendedor() + "',"+sessao.getIdloja()+");");

            conexao.close();

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }
    }

    public String Vendedor(String idsessao) {

        Conexao bancoconexao = new Conexao();

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
    public int idLoja(String idsessao) {

        Conexao bancoconexao = new Conexao();

        int idloja = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = bancoconexao.getConnection();

            java.sql.Statement st = conexao.createStatement();

            String select = "SELECT idloja from sessao where idsessao = '" + idsessao + "'";

            ResultSet result = st.executeQuery(select);

            while (result.next()) {

                idloja = result.getInt("idloja");

            }

            conexao.close();

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }
        return idloja;

    }

}
