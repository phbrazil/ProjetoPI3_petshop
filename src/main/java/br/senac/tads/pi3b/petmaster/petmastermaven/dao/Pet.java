/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.petmaster.petmastermaven.dao;

import br.senac.tads.pi3b.petmaster.petmastermaven.model.Pets;
import br.senac.tads.pi3b.petmaster.petmastermaven.model.Produtos;
import java.awt.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author killuminatti08
 */
public class Pet {

    private Connection conexao = null;

    Pets pets = new Pets(null, 0, null, null, 0, null);

    private java.util.List<Pets> listaPet = new ArrayList<Pets>();

    public void gravarpet(Pets pets) {

        Conexao bancoconexao = new Conexao();

        try {

            Connection conexao = bancoconexao.getConnection();

            java.sql.Statement st = conexao.createStatement();
            st.executeUpdate("INSERT INTO pets (codigobarraspet, nomepet,valorpet,"
                    + "datacadastropet, descricaopet,categoriapet, quantidadepet)"
                    + " VALUES ('" + pets.getCodigopet()+ "','" + pets.getNomepet()
                    + "'," + pets.getValorpet()+ ",now(),'"
                    + pets.getDescricaopet() + "','" + pets.getCategoriapet() + "'," + pets.getQtdestoquepet() + ");");

            conexao.close();

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }

    }

    public void atualizarpet(Pets pets) {

        Conexao bancoconexao = new Conexao();

        try {

            Connection conexao = bancoconexao.getConnection();

            java.sql.Statement st = conexao.createStatement();
            st.executeUpdate("UPDATE pets set codigobarraspet = '" + pets.getCodigopet() + "', nomepet = '" + pets.getNomepet() + "',"
                    + "valorpet = " + pets.getValorpet() + ",descricaopet = '" + pets.getDescricaopet() + "',categoriapet = '" + pets.getCategoriapet() + "',"
                    + "quantidadepet = " + pets.getQtdestoquepet()+ " where codigobarraspet = '" + pets.getCodigopet() + "'");

            conexao.close();

            System.out.println("fiz o update pet");

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }

    }

    public Pets PesquisarPet(String buscapet) {

        String select = "";

        Conexao bancoconexao = new Conexao();

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = bancoconexao.getConnection();

            java.sql.Statement st = conexao.createStatement();
            select = "select * from pets where codigobarraspet = '" + buscapet.trim() + "'";
            ResultSet result = st.executeQuery(select);

            while (result.next()) {

                pets.setCodigopet(result.getString("codigobarraspet"));
                pets.setNomepet(result.getString("nomepet"));
                pets.setValorpet(result.getDouble("valorpet"));
                pets.setDtCadastropet(result.getDate("datacadastropet"));
                pets.setDescricaopet(result.getString("descricaopet"));
                pets.setCategoriapet(result.getString("categoriapet"));
                pets.setQtdestoquepet(result.getInt("quantidadepet"));
                pets.setListaPet(pets);


            }

            conexao.close();

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }

        return pets;
    }

    public int validacadastradopet(String buscapet) {

        String select = "";

        int qtdpetcadastrado = 0;

        Conexao bancoconexao = new Conexao();

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = bancoconexao.getConnection();

            java.sql.Statement st = conexao.createStatement();
            select = "select count(*) quantidade from pets where codigobarraspet = '" + buscapet + "'";
            ResultSet result = st.executeQuery(select);

            while (result.next()) {

                qtdpetcadastrado = result.getInt("quantidade");

            }

            conexao.close();

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }

        return qtdpetcadastrado;
    }

    public boolean deletapet(String codigobarraspet) {

        boolean deletado = false;

        Conexao bancoconexao = new Conexao();

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = bancoconexao.getConnection();

            java.sql.Statement st = conexao.createStatement();
            st.executeUpdate("delete from pets where codigobarraspet = '" + codigobarraspet + "'");

            conexao.close();
            deletado = true;

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }
        return deletado;

    }

    public ResultSet PesquisarPetGeral() {

        String selectgeral = "";

        Conexao bancoconexao = new Conexao();

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = bancoconexao.getConnection();

            java.sql.Statement st = conexao.createStatement();
            selectgeral = "select * from pets";
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
