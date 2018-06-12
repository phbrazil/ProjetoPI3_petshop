/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.petmaster.petmastermaven.dao;

import br.senac.tads.pi3b.petmaster.petmastermaven.model.Usuario;
import java.awt.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BancoUsuario {

    private Connection conexao = null;

    Usuario usuario = new Usuario(null, null, null, 0, 0);

    private java.util.List<Usuario> listaUsuario = new ArrayList<Usuario>();

    public void gravarUsuario(Usuario usuario) {

        Conexao bancoconexao = new Conexao();

        try {

            Connection conexao = bancoconexao.getConnection();

            java.sql.Statement st = conexao.createStatement();
            st.executeUpdate("INSERT INTO usuarios (nomeuser, username, password, idgrupo, idloja) VALUES ('" + usuario.getNomeUsuario() + "','"
                    + usuario.getUsername() + "','" + usuario.getPassword() + "'," + usuario.getIdgrupo() + "," + usuario.getIdfilial() + ");");
            conexao.close();

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }

    }

    public void atualizarUsuario(Usuario usuario) {

        Conexao bancoconexao = new Conexao();

        try {

            Connection conexao = bancoconexao.getConnection();

            java.sql.Statement st = conexao.createStatement();
            st.executeUpdate("UPDATE usuarios set nomeuser = '" + usuario.getNomeUsuario() + "',"
                    + "password = '" + usuario.getPassword() +"' where username = '" + usuario.getUsername().trim() + "'");

            conexao.close();

            System.out.println("fiz o update" + usuario.getNomeUsuario());

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }

    }

    public Usuario PesquisarUsuario(String username) {

        String select = "";

        Conexao bancoconexao = new Conexao();

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = bancoconexao.getConnection();

            java.sql.Statement st = conexao.createStatement();
            select = "select * from usuarios where username = '" + username.trim() + "'";
            ResultSet result = st.executeQuery(select);

            while (result.next()) {

                usuario.setNomeUsuario(result.getString("nomeuser"));
                usuario.setUsername(result.getString("username"));
                usuario.setPassword(result.getString("password"));
                usuario.setIdgrupo(result.getInt("idgrupo"));
                usuario.setIdfilial(result.getInt("idfilial"));

            }

            conexao.close();

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }

        return usuario;
    }

    public int idFilial(String filialnome) {

        String select = "";
        int idfilial = 0;

        Conexao bancoconexao = new Conexao();

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = bancoconexao.getConnection();

            java.sql.Statement st = conexao.createStatement();
            select = "select idloja from lojas where nomeloja = '" + filialnome.trim() + "'";
            ResultSet result = st.executeQuery(select);

            while (result.next()) {

                idfilial = result.getInt("idloja");

            }

            conexao.close();

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }

        return idfilial;
    }

    public int idGrupo(String nomegrupo) {

        String select = "";
        int idgrupo = 0;

        Conexao bancoconexao = new Conexao();

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = bancoconexao.getConnection();

            java.sql.Statement st = conexao.createStatement();
            select = "select idgrupo from grupos where nomegrupo = '" + nomegrupo.trim() + "'";
            ResultSet result = st.executeQuery(select);

            while (result.next()) {

                idgrupo = result.getInt("idgrupo");

            }

            conexao.close();

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }

        return idgrupo;
    }

    public int ValidaCadastradoUsuario(String username) {

        String select = "";

        int qtdusuariocadastrado = 0;

        Conexao bancoconexao = new Conexao();

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = bancoconexao.getConnection();

            java.sql.Statement st = conexao.createStatement();
            select = "select count(*) as quantidade from usuarios where username = '" + username + "'";
            ResultSet result = st.executeQuery(select);

            while (result.next()) {

                qtdusuariocadastrado = result.getInt("quantidade");

            }

            conexao.close();

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }

        return qtdusuariocadastrado;
    }

    public boolean deletaUsuario(String username) {

        boolean deletado = false;

        Conexao bancoconexao = new Conexao();

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = bancoconexao.getConnection();

            java.sql.Statement st = conexao.createStatement();
            st.executeUpdate("delete from usuarios where username = '" + username.trim() + "'");

            conexao.close();
            deletado = true;

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }
        return deletado;

    }

}
