/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.petmaster.petmastermaven.servlets.dao;

import br.senac.tads.pi3b.petmaster.petmastermaven.servlets.model.Grupo;
import br.senac.tads.pi3b.petmaster.petmastermaven.servlets.model.Loja;
import java.awt.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BancoGrupo {

    private Connection conexao = null;

    Grupo grupo = new Grupo(null, null);

    private java.util.List<Loja> listaLoja = new ArrayList<Loja>();

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

    }

    public Loja PesquisarLoja(String idloja) {

        String select = "";

        BancoConexao bancoconexao = new BancoConexao();

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = bancoconexao.getConnection();

            java.sql.Statement st = conexao.createStatement();
            select = "select * from lojas where idloja = '" + idloja + "'";
            ResultSet result = st.executeQuery(select);

            while (result.next()) {
                
                loja.setNomeLoja(result.getString("nomeloja"));
                System.out.println("Result nome " + result.getString("nomeloja"));
                loja.setLogradouro(result.getString("logradouro"));
                loja.setBairro(result.getString("bairro"));
                loja.setCidade(result.getString("cidade"));
                loja.setUF(result.getString("uf"));
                loja.setCep(result.getString("cep"));
                loja.setTelefone(result.getString("telefone"));      

            }

            conexao.close();

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }
        System.out.println("to aqui nos produtinhos" + loja.getNomeLoja());

        return loja;
    }
*/
    public int ValidaCadastradoLoja(String nomeLoja) {

        String select = "";

        int qtdlojacadastrado = 0;

        BancoConexao bancoconexao = new BancoConexao();

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = bancoconexao.getConnection();

            java.sql.Statement st = conexao.createStatement();
            select = "select count(*), idloja from lojas where nomeloja like '%" + nomeLoja + "%'";
            ResultSet result = st.executeQuery(select);

            while (result.next()) {

                qtdlojacadastrado = result.getInt("idloja");

            }

            conexao.close();

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }

        return qtdlojacadastrado;
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
