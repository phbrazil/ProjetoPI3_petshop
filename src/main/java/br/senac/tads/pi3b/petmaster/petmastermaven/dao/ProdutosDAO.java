/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.petmaster.petmastermaven.dao;

import br.senac.tads.pi3b.petmaster.petmastermaven.model.Produtos;
import java.awt.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author killuminatti08
 */
public class ProdutosDAO {

    private Connection conexao = null;

    Produtos produtos = new Produtos(null, 0, null, null, 0, null);

    private java.util.List<Produtos> listaProd = new ArrayList<Produtos>();

    public void gravarproduto(Produtos produtos) {

        Conexao bancoconexao = new Conexao();

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

        Conexao bancoconexao = new Conexao();

        try {

            Connection conexao = bancoconexao.getConnection();

            java.sql.Statement st = conexao.createStatement();
            st.executeUpdate("UPDATE PRODUTOS set codigobarrasprod = '" + produtos.getCodigoprod() + "', nomeprod = '" + produtos.getNomeprod() + "',"
                    + "valor = " + produtos.getValorprod() + ",descricaoprod = '" + produtos.getDescricaoprod() + "',categoriaprod = '" + produtos.getCategoriaprod() + "',"
                    + "quantidadeprod = " + produtos.getQtdestoque() + " where codigobarrasprod = '" + produtos.getCodigoprod() + "'");

            conexao.close();

            System.out.println("aqui no update" + produtos.getCodigoprod());
            System.out.println("fiz o update");

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }

    }

    public Produtos PesquisarProduto(String codigobarrasprod) {

        String select = "";

        Conexao bancoconexao = new Conexao();

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = bancoconexao.getConnection();

            java.sql.Statement st = conexao.createStatement();
            select = "select * from produtos where codigobarrasprod = '" + codigobarrasprod.trim() + "'";
            ResultSet result = st.executeQuery(select);

            while (result.next()) {

                produtos.setCodigoprod(result.getString("codigobarrasprod"));
                produtos.setNomeprod(result.getString("nomeprod"));
                produtos.setValorprod(result.getDouble("valor"));
                produtos.setDtCadastro(result.getDate("datacadastroprod"));
                produtos.setDescricaoprod(result.getString("descricaoprod"));
                produtos.setCategoriaprod(result.getString("categoriaprod"));
                produtos.setQtdestoque(result.getInt("quantidadeprod"));
                //produtos.setListaProd(produtos);

            }

            conexao.close();

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }

        return produtos;
    }

    public boolean validacadastradoprod(String buscaprod) {

        boolean repetido = false;

        String selectprod = "";
        String selectpet = "";

        int qtdprodcadastrado = 0;
        int qtdpetcadastrado = 0;

        Conexao bancoconexao = new Conexao();

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = bancoconexao.getConnection();

            java.sql.Statement stprod = conexao.createStatement();

            selectprod = "select count(*) quantidadeprod from produtos where codigobarrasprod = '" + buscaprod + "'";
            ResultSet resultprod = stprod.executeQuery(selectprod);
            
            while (resultprod.next()) {

                qtdprodcadastrado = resultprod.getInt("quantidadeprod");
                System.out.println(qtdpetcadastrado);

            }
            
            java.sql.Statement stpet = conexao.createStatement();

            selectpet = "select count(*) quantidadepet from pets where codigobarraspet = '" + buscaprod + "'";
            ResultSet resultpet = stpet.executeQuery(selectpet);

            while (resultpet.next()) {

                qtdpetcadastrado = resultpet.getInt("quantidadepet");
                System.out.println(qtdpetcadastrado);

            }

            conexao.close();

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }
        if (qtdpetcadastrado > 0 || qtdprodcadastrado > 0) {
            repetido = true;
        }

        return repetido;
    }

    public boolean deletaprod(String codigobarrasprod) {

        boolean deletado = false;

        Conexao bancoconexao = new Conexao();

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

    public ResultSet PesquisarProdutosGeral() {

        String selectgeral = "";

        Conexao bancoconexao = new Conexao();

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = bancoconexao.getConnection();

            java.sql.Statement st = conexao.createStatement();
            selectgeral = "select * from produtos";
            ResultSet resultgeral = st.executeQuery(selectgeral);

            if (resultgeral != null) {
                return resultgeral;
            }

            conexao.close();

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }
        return null;
    }

}
