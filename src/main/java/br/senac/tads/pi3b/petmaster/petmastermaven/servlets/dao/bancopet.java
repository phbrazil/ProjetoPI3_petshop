/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.petmaster.petmastermaven.servlets.dao;

import br.senac.tads.pi3b.petmaster.petmastermaven.servlets.model.Pets;
import br.senac.tads.pi3b.petmaster.petmastermaven.servlets.model.Produtos;
import java.awt.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author killuminatti08
 */
public class bancopet {

    private Connection conexao = null;

    Pets pets = new Pets(null, 0, null, null, 0, null);

    private java.util.List<Pets> listaPet = new ArrayList<Pets>();

    public void gravarpet(Pets pets) {

        bancoconexao bancoconexao = new bancoconexao();

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

        bancoconexao bancoconexao = new bancoconexao();

        try {

            Connection conexao = bancoconexao.getConnection();

            java.sql.Statement st = conexao.createStatement();
            st.executeUpdate("UPDATE PETS set codigobarraspet = '" + pets.getCodigopet() + "', nomepet = '" + pets.getNomepet() + "',"
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

        bancoconexao bancoconexao = new bancoconexao();

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = bancoconexao.getConnection();

            java.sql.Statement st = conexao.createStatement();
            select = "select * from pets where nomepet like '%" + buscapet + "%' or codigobarraspet = '" + buscapet + "'";
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

        bancoconexao bancoconexao = new bancoconexao();

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

        bancoconexao bancoconexao = new bancoconexao();

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

    public List PesquisarPetGeral(List lista) {

        String select = "";

        bancoconexao bancoconexao = new bancoconexao();

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = bancoconexao.getConnection();

            java.sql.Statement st = conexao.createStatement();
            select = "select * from pets";
            System.out.println("fiz o select pets");
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
        return lista;
    }

}
