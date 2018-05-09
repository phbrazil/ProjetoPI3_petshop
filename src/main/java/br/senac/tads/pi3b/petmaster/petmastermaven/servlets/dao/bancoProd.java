/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.petmaster.petmastermaven.servlets.dao;

import br.senac.tads.pi3b.petmaster.petmastermaven.servlets.model.Produtos;
import java.awt.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author killuminatti08
 */
public class bancoProd {

    private Connection conexao = null;

    Produtos produtos = new Produtos(null, 0, null, null, 0, null);

    private java.util.List<Produtos> listaProd = new ArrayList<Produtos>();

    public void gravarproduto(Produtos produtos) {

        bancoConexao bancoconexao = new bancoConexao();

        try {

            Connection conexao = bancoconexao.getConnection();

            java.sql.Statement st = conexao.createStatement();
            st.executeUpdate("INSERT INTO produtos (codigobarrasprod, nomeprod,valor,"
                    + "datacadastroprod, descricaoprod,categoriaprod, quantidadeprod)"
                    + " VALUES ('" + produtos.getCodigoprod() + "','" + produtos.getNomeprod()
                    + "'," + produtos.getValorprod() + ",now(),'"
                    + produtos.getDescricaoprod() + "','" + produtos.getCategoriaprod() + "'," + produtos.getQtdestoque() + ");");

            conexao.close();

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }

    }

    public void atualizarprod(Produtos produtos) {

        bancoConexao bancoconexao = new bancoConexao();

        try {

            Connection conexao = bancoconexao.getConnection();

            java.sql.Statement st = conexao.createStatement();
            st.executeUpdate("UPDATE PRODUTOS set codigobarrasprod = '" + produtos.getCodigoprod() + "', nomeprod = '" + produtos.getNomeprod() + "',"
                    + "valor = " + produtos.getValorprod() + ",descricaoprod = '" + produtos.getDescricaoprod() + "',categoriaprod = '" + produtos.getCategoriaprod() + "',"
                    + "quantidadeprod = " + produtos.getQtdestoque() + " where codigobarrasprod = '" + produtos.getCodigoprod() + "'");

            conexao.close();

            System.out.println("fiz o update");

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }

    }

    public Produtos PesquisarProduto(String buscaprod) {

        String select = "";

        bancoConexao bancoconexao = new bancoConexao();

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = bancoconexao.getConnection();

            java.sql.Statement st = conexao.createStatement();
            select = "select * from produtos where nomeprod like '%" + buscaprod + "%' or codigobarrasprod = '" + buscaprod + "'";
            ResultSet result = st.executeQuery(select);

            while (result.next()) {

                produtos.setCodigoprod(result.getString("codigobarrasprod"));
                produtos.setNomeprod(result.getString("nomeprod"));
                produtos.setValorprod(result.getDouble("valor"));
                produtos.setDtCadastro(result.getDate("datacadastroprod"));
                produtos.setDescricaoprod(result.getString("descricaoprod"));
                produtos.setCategoriaprod(result.getString("categoriaprod"));
                produtos.setQtdestoque(result.getInt("quantidadeprod"));
                produtos.setListaProd(produtos);

                System.out.println(produtos.getListaProd().get(0).getNomeprod() + "huahhadusahuda");

            }

            conexao.close();

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }

        return produtos;
    }

    public int validacadastradoprod(String buscaprod) {

        String select = "";

        int qtdprodcadastrado = 0;

        bancoConexao bancoconexao = new bancoConexao();

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = bancoconexao.getConnection();

            java.sql.Statement st = conexao.createStatement();
            select = "select count(*) quantidade from produtos where codigobarrasprod = '" + buscaprod + "'";
            ResultSet result = st.executeQuery(select);

            while (result.next()) {

                qtdprodcadastrado = result.getInt("quantidade");

            }

            conexao.close();

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }

        return qtdprodcadastrado;
    }

    public boolean deletaprod(String codigobarrasprod) {

        boolean deletado = false;

        bancoConexao bancoconexao = new bancoConexao();

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = bancoconexao.getConnection();

            java.sql.Statement st = conexao.createStatement();
            st.executeUpdate("delete from produtos where codigobarrasprod = '" + codigobarrasprod + "'");

            conexao.close();
            deletado = true;

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }
        return deletado;

    }

    public List PesquisarProdutoGeral(List lista) {

        String select = "";

        bancoConexao bancoconexao = new bancoConexao();

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = bancoconexao.getConnection();

            java.sql.Statement st = conexao.createStatement();
            select = "select * from produtos";
            System.out.println("fiz o select");
            ResultSet result = st.executeQuery(select);

            while (result.next()) {

                produtos.setCodigoprod(result.getString("codigobarrasprod"));
                produtos.setNomeprod(result.getString("nomeprod"));
                produtos.setValorprod(result.getDouble("valor"));
                produtos.setDtCadastro(result.getDate("datacadastroprod"));
                produtos.setDescricaoprod(result.getString("descricaoprod"));
                produtos.setCategoriaprod(result.getString("categoriaprod"));
                produtos.setQtdestoque(result.getInt("quantidadeprod"));
                produtos.setListaProd(produtos);

                System.out.println(produtos.getListaProd().get(0).getNomeprod() + "huahhadusahuda" + produtos.getListaProd().size());

            }

            conexao.close();

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }
        return lista;
    }

}
