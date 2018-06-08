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
public class BancoCarrinho {

    private Connection conexao = null;

    Produtos produtos = new Produtos(null, 0, null, null, 0, null);

    private java.util.List<Produtos> listaProd = new ArrayList<Produtos>();

    public void GravarCarrinho(Produtos produtos, String idsessao, String vendedor) {

        BancoConexao bancoconexao = new BancoConexao();

        try {

            Connection conexao = bancoconexao.getConnection();

            java.sql.Statement st = conexao.createStatement();
            st.executeUpdate("INSERT INTO carrinho (idsessao, nomeprod,codigobarrasprod,"
                    + "vendedor, valorprod, quantidadeitens) VALUES ('" + idsessao + "','" + produtos.getNomeprod()
                    + "','" + produtos.getCodigoprod() + "','" + vendedor + "'," + produtos.getValorprod() + "," + produtos.getItensvenda() + ");");

            conexao.close();


        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }

    }

    public void AtualizarCarrinho(Produtos produtos, String idsessao) {

        BancoConexao bancoconexao = new BancoConexao();

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

        BancoConexao bancoconexao = new BancoConexao();

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

    public boolean DeletaProdCarrinho(String sessaoid,String codigobarrasprod ) {

        boolean deletado = false;

        BancoConexao bancoconexao = new BancoConexao();

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = bancoconexao.getConnection();

            java.sql.Statement st = conexao.createStatement();
            st.executeUpdate("delete from carrinho where idsessao = '" + sessaoid + "' and codigobarrasprod = '"+codigobarrasprod+"';");

            conexao.close();
            deletado = true;

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }
        return deletado;

    }

    public ResultSet ListarCarrinho(String idsessao) {

        String selectgeral = "";

        BancoConexao bancoconexao = new BancoConexao();

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = bancoconexao.getConnection();

            java.sql.Statement st = conexao.createStatement();
            selectgeral = "select * from carrinho where idsessao = '" + idsessao + "'";
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
