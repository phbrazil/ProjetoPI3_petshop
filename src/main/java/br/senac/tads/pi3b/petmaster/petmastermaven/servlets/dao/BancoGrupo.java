/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.petmaster.petmastermaven.servlets.dao;

import br.senac.tads.pi3b.petmaster.petmastermaven.servlets.model.Grupo;
import java.awt.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BancoGrupo {

    private Connection conexao = null;

    Grupo grupo = new Grupo(null, null);

    private java.util.List<Grupo> listaGrupo = new ArrayList<Grupo>();

    public void gravarGrupo(Grupo grupo) {

        BancoConexao bancoconexao = new BancoConexao();

        try {

            Connection conexao = bancoconexao.getConnection();

            java.sql.Statement st = conexao.createStatement();
            st.executeUpdate("INSERT INTO grupos (nomegrupo, idloja) VALUES ('" + grupo.getNomeGrupo() + "','"
                    + grupo.getIdLoja() + "');");
            conexao.close();

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }

    }

 public void atualizarGrupo(Grupo grupo) {

        BancoConexao bancoconexao = new BancoConexao();

        try {

            Connection conexao = bancoconexao.getConnection();

            java.sql.Statement st = conexao.createStatement();
            st.executeUpdate("UPDATE grupos set nomegrupo = '" + grupo.getNomeGrupo() + "', idloja = '" + grupo.getIdLoja()
             + "' where nomegrupo like '%" + grupo.getNomeGrupo() + "%';");

            conexao.close();

            System.out.println("fiz o update");

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }

    }

    public Grupo PesquisarGrupo(String idgrupo) {

        String select = "";

        BancoConexao bancoconexao = new BancoConexao();

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = bancoconexao.getConnection();

            java.sql.Statement st = conexao.createStatement();
            select = "select * from grupos where idgrupo = '" + idgrupo + "'";
            ResultSet result = st.executeQuery(select);

            while (result.next()) {
                
                grupo.setNomeGrupo(result.getString("nomegrupo"));
                grupo.setIdLoja(result.getString("idloja"));
               
            }

            conexao.close();

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }
        System.out.println("to aqui nos produtinhos" + grupo.getNomeGrupo());

        return grupo;
    }

    public int ValidaCadastradoGrupo(String nomeGrupo) {

        String select = "";

        int qtdgrupocadastrado = 0;

        BancoConexao bancoconexao = new BancoConexao();

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = bancoconexao.getConnection();

            java.sql.Statement st = conexao.createStatement();
            select = "select count(*), idgrupo from grupos where nomeGrupo like '%" + nomeGrupo + "%'";
            ResultSet result = st.executeQuery(select);

            while (result.next()) {

                qtdgrupocadastrado = result.getInt("idgrupo");

            }

            conexao.close();

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }

        return qtdgrupocadastrado;
    }

    public boolean deletaGrupo(String nomegrupo) {

        boolean deletado = false;

        BancoConexao bancoconexao = new BancoConexao();

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = bancoconexao.getConnection();

            java.sql.Statement st = conexao.createStatement();
            st.executeUpdate("delete from grupos where nomegrupo like '%" + nomegrupo + "%'");

            conexao.close();
            deletado = true;

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }
        return deletado;

    }
    
   
}
