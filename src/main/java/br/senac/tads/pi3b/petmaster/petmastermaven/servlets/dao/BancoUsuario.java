/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.petmaster.petmastermaven.servlets.dao;

import br.senac.tads.pi3b.petmaster.petmastermaven.servlets.model.Usuario;
import java.awt.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BancoUsuario {

    private Connection conexao = null;

    Usuario usuario = new Usuario(null, null, null, null);

    private java.util.List<Usuario> listaUsuario = new ArrayList<Usuario>();

    public void gravarUsuario(Usuario usuario) {

        BancoConexao bancoconexao = new BancoConexao();

        try {

            Connection conexao = bancoconexao.getConnection();

            java.sql.Statement st = conexao.createStatement();
            st.executeUpdate("INSERT INTO usuarios (nomeuser, username, password, idgrupo) VALUES ('" + usuario.getNomeUsuario() + "','"
                    + usuario.getUsername() + "','" + usuario.getPassword() + "','" + usuario.getIdGrupo()+ "');");
            conexao.close();

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }

    }

  /*  public void atualizarLoja(Loja loja) {

        BancoConexao bancoconexao = new BancoConexao();

        try {

            Connection conexao = bancoconexao.getConnection();

            java.sql.Statement st = conexao.createStatement();
            st.executeUpdate("UPDATE loja set nomeloja = '" + loja.getNomeLoja() + "', logradouro = '" + loja.getLogradouro() + "',"
                    + "cidade = '" + loja.getCidade() + "',bairro ='" + loja.getBairro() + "UF = '" + loja.getUF() + "',cep='" + loja.getCep() + "',telefone='" + loja.getTelefone() + "' where nomeloja like '%" + loja.getNomeLoja() + "%'");

            conexao.close();

            System.out.println("fiz o update");

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }

    }*/

    public Usuario PesquisarUsuario(String username) {

        String select = "";

        BancoConexao bancoconexao = new BancoConexao();

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = bancoconexao.getConnection();

            java.sql.Statement st = conexao.createStatement();
            select = "select * from usuarios where username = '" + username + "'";
            ResultSet result = st.executeQuery(select);

            while (result.next()) {
                
                usuario.setNomeUsuario(result.getString("nomeuser"));
                usuario.setUsername(result.getString("username"));
                usuario.setPassword(result.getString("password"));
                usuario.setIdGrupo(result.getString("idgrupo"));
               
            }

            conexao.close();

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }

        return usuario;
    }

    public int ValidaCadastradoUsuario(String nomeUsuario) {

        String select = "";

        int qtdusuariocadastrado = 0;

        BancoConexao bancoconexao = new BancoConexao();

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = bancoconexao.getConnection();

            java.sql.Statement st = conexao.createStatement();
            select = "select count(*), codigouser from grupos where nomeGrupo like '%" + nomeUsuario + "%'";
            ResultSet result = st.executeQuery(select);

            while (result.next()) {

                qtdusuariocadastrado = result.getInt("codigouser");

            }

            conexao.close();

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }

        return qtdusuariocadastrado;
    }
/*
    public boolean deletaLoja(String nomeloja) {

        boolean deletado = false;

        BancoConexao bancoconexao = new BancoConexao();

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = bancoconexao.getConnection();

            java.sql.Statement st = conexao.createStatement();
            st.executeUpdate("delete from lojas where nomeLoja like '%" + nomeloja + "%'");

            conexao.close();
            deletado = true;

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }
        return deletado;

    }
    
    public ResultSet PesquisarClientesGeral() {

        String selectgeral = "";

        BancoConexao bancoconexao = new BancoConexao();

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = bancoconexao.getConnection();

            java.sql.Statement st = conexao.createStatement();
            selectgeral = "select * from clientes";
            ResultSet resultgeral = st.executeQuery(selectgeral);

            if(resultgeral!=null){
                System.out.println("ta aqui");
                return resultgeral;
            }

            conexao.close();

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }
        return null;
    }
     */
}
