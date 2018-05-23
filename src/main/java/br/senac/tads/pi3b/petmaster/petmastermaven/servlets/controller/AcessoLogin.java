/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.petmaster.petmastermaven.servlets.controller;

import br.senac.tads.pi3b.petmaster.petmastermaven.servlets.dao.BancoConexao;
import br.senac.tads.pi3b.petmaster.petmastermaven.servlets.model.LoginDados;
import br.senac.tads.pi3b.petmaster.petmastermaven.servlets.model.LoginDados;
import br.senac.tads.pi3b.petmaster.petmastermaven.servlets.model.LoginDados;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author paulo.bezerra
 */
public class AcessoLogin {

    private Connection conexao = null;

    private String username = null;
    private String nomeUser = null;
    private String password = null;

    public boolean ValidaAcesso(LoginDados logindados) {

        boolean usuarionabase = false;
        String select = "";

        //long validado = 0;
        BancoConexao bancoconexao = new BancoConexao();

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = bancoconexao.getConnection();

            java.sql.Statement st = conexao.createStatement();

            //select = "select count(*) validado from usuarios where username = '" + logindados.getUserName() + "' and password = '" + logindados.getPassword() + "'";
            select = "select nomeuser, username, password from usuarios where username = '" + logindados.getUserName() + "' and password = '" + logindados.getPassword() + "'";

            ResultSet result = st.executeQuery(select);

            while (result.next()) {
                username = result.getString("username");
                password = result.getString("password");
                nomeUser = result.getString("nomeuser");

            }
            if (username.equals(logindados.getUserName()) && password.equals(logindados.getPassword())) {

                usuarionabase = true;
                logindados.setNomeUser(nomeUser);

            } else {

                usuarionabase = false;

            }

            conexao.close();

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }

        return usuarionabase;

    }

}
