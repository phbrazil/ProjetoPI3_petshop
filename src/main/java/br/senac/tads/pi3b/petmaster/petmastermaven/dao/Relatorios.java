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
public class Relatorios {

    private Connection conexao = null;

    Produtos produtos = new Produtos(null, 0, null, null, 0, null,0);

    private java.util.List<Produtos> listaProd = new ArrayList<Produtos>();



    public ResultSet Vendas(String inicio, String fim, int idloja) {

        String selectgeral = "";

        Conexao bancoconexao = new Conexao();

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = bancoconexao.getConnection();

            java.sql.Statement st = conexao.createStatement();
            selectgeral = "select * from vendas where datavenda between '"+inicio+"' and '"+fim+"' and idloja = "+idloja+";";
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
