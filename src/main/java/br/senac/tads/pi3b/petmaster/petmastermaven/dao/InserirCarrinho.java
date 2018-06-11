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
public class InserirCarrinho {

    private Connection conexao = null;

    Produtos produtos = new Produtos(null, 0, null, null, 0, null,0);

    private java.util.List<Produtos> listaProd = new ArrayList<Produtos>();

    public void GravarCarrinho(Produtos produtos, String idsessao, String vendedor) {

        Conexao bancoconexao = new Conexao();

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



    

    public boolean DeletaProdCarrinho(String sessaoid,String codigobarrasprod ) {

        boolean deletado = false;

        Conexao bancoconexao = new Conexao();

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
    
        public boolean LimpaCarrinho(String sessaoid) {

        boolean deletado = false;

        Conexao bancoconexao = new Conexao();

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = bancoconexao.getConnection();

            java.sql.Statement st = conexao.createStatement();
            st.executeUpdate("delete from carrinho where idsessao = '" + sessaoid + "';");

            conexao.close();
            deletado = true;

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }
        return deletado;

    }

    public ResultSet ListarCarrinho(String idsessao) {

        String selectgeral = "";

        Conexao bancoconexao = new Conexao();

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
