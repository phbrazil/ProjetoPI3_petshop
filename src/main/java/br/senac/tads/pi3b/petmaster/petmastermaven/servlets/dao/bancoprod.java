/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.petmaster.petmastermaven.servlets.dao;

import br.senac.tads.pi3b.petmaster.petmastermaven.servlets.model.Produtos;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author killuminatti08
 */
public class bancoprod {

    public void gravarproduto(Produtos produtos) {

        bancoconexao bancoconexao = new bancoconexao();

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

        bancoconexao bancoconexao = new bancoconexao();

        try {

            Connection conexao = bancoconexao.getConnection();

            java.sql.Statement st = conexao.createStatement();
            st.executeUpdate("UPDATE PRODUTOS set codigobarrasprod = '"+produtos.getCodigoprod()+"', nomeprod = '"+produtos.getNomeprod()+"',"
                    +"valor = "+produtos.getValorprod()+",descricaoprod = '"+produtos.getDescricaoprod()+"','"+produtos.getCategoriaprod()+"',"
                    +"quantidadeprod = "+produtos.getQtdestoque()+" where codigobarrasprod = '"+produtos.getCodigoprod());
            
            

            conexao.close();

            System.out.println("fiz o update");

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }

    }

    private Connection conexao = null;

    Produtos produtos = new Produtos(null, 0, null, null, 0, null);

    public Produtos PesquisarProduto(String buscaprod) {

        String select = "";

        bancoconexao bancoconexao = new bancoconexao();

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

        bancoconexao bancoconexao = new bancoconexao();

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

}
