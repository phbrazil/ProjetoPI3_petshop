/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.petmaster.petmastermaven.servlets.dao;

import br.senac.tads.pi3b.petmaster.petmastermaven.servlets.model.Cliente;
import br.senac.tads.pi3b.petmaster.petmastermaven.servlets.model.Produtos;
import java.awt.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author killuminatti08
 */
public class bancoCli {

    private Connection conexao = null;

    Cliente cliente = new Cliente(null,null,null, null, null, null, null, null, null, null, null, null, null, null, null, null);

    private java.util.List<Cliente> listaCli = new ArrayList<Cliente>();

    public void gravarCliente(Cliente cliente) {

        bancoConexao bancoconexao = new bancoConexao();

        try {

            Connection conexao = bancoconexao.getConnection();

            java.sql.Statement st = conexao.createStatement();
            st.executeUpdate("INSERT INTO clientes (nome, logradouro,rg,"
                    + "cpfcliente, pais,cidade, bairro, estado, uf, cep, telefone,celular,email,sexo,"
                    + "estadocivil, nascimento,datacadastro, statuscliente) VALUES ('" + cliente.getNomeCliente()+ "','" 
                    + cliente.getLogradouro()+"','"+cliente.getRG()+"','"+cliente.getCpfCliente()+"','"
                    + cliente.getPais()+"','"+cliente.getCidade()+"','"+cliente.getBairro()+"','"
                    +cliente.getEstado()+"','"+cliente.getUF()+"','"+cliente.getCep()+"','"
                    +cliente.getTelefone()+"','"+cliente.getCelular()+"','"+cliente.getEmail()+"','"
                    +cliente.getSexo()+"','"+cliente.getEstadoCivil()+"','"+cliente.getNascimento()+"',"
                    +"now(), true);");        
            conexao.close();

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }

    }

    public void atualizarCli(Cliente cliente) {

        bancoConexao bancoconexao = new bancoConexao();

        try {

            Connection conexao = bancoconexao.getConnection();

            java.sql.Statement st = conexao.createStatement();
            st.executeUpdate("UPDATE clientes set nome = '" + cliente.getNomeCliente()+ "', logradouto = '" + cliente.getLogradouro()+ "',"
                    + "rg = '" + cliente.getRG()+ "',CPFCliente = '" + cliente.getCpfCliente()+ "',pais = '" + cliente.getPais()+ "',"
                    + "cidade = '" + cliente.getCidade()+ "',bairro ='"+cliente.getBairro()+"',estado = '"+cliente.getEstado()+"',"
                    +"UF = '"+cliente.getUF()+"',cep='"+cliente.getCep()+"',telefone='"+cliente.getTelefone()+"',celular='"+cliente.getCelular()+"',"
                    +"email='"+cliente.getEmail()+"',sexo='"+cliente.getSexo()+"',estadocivil='"+cliente.getEstadoCivil()+"',nascimento='"+cliente.getNascimento()+"' where cpfcliente = '" + cliente.getCpfCliente()+ "'");

            conexao.close();

            System.out.println("fiz o update");

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }

    }

    public Cliente PesquisarCliente(String cpfcliente) {

        String select = "";

        bancoConexao bancoconexao = new bancoConexao();

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = bancoconexao.getConnection();

            java.sql.Statement st = conexao.createStatement();
            select = "select * from clientes where cpfcliente = '" + cpfcliente.trim() + "'";
            ResultSet result = st.executeQuery(select);

            while (result.next()) {

                cliente.setCpfCliente(result.getString("cpfcliente"));
                //produtos.setNomeprod(result.getString("nomeprod"));
                //produtos.setValorprod(result.getDouble("valor"));
                //produtos.setDtCadastro(result.getDate("datacadastroprod"));
                //produtos.setDescricaoprod(result.getString("descricaoprod"));
                //produtos.setCategoriaprod(result.getString("categoriaprod"));
                //produtos.setQtdestoque(result.getInt("quantidadeprod"));
                //produtos.setListaProd(produtos);


            }

            conexao.close();

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }

        return cliente;
    }

    public int ValidaCadastradoCliente(String cpfcliente) {

        String select = "";

        int qtdclicadastrado = 0;

        bancoConexao bancoconexao = new bancoConexao();

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = bancoconexao.getConnection();

            java.sql.Statement st = conexao.createStatement();
            select = "select count(*) quantidade from clientes where cpfcliente = '" + cpfcliente + "'";
            ResultSet result = st.executeQuery(select);

            while (result.next()) {

                qtdclicadastrado = result.getInt("quantidade");

            }

            conexao.close();

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }

        return qtdclicadastrado;
    }

    public boolean deletaCliente(String cpfcliente) {

        boolean deletado = false;

        bancoConexao bancoconexao = new bancoConexao();

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = bancoconexao.getConnection();

            java.sql.Statement st = conexao.createStatement();
            st.executeUpdate("delete from clientes where cpfcliente = '" + cpfcliente + "'");

            conexao.close();
            deletado = true;

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }
        return deletado;

    }

    public List PesquisarClientesGeral(List lista) {

        String select = "";

        bancoConexao bancoconexao = new bancoConexao();

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = bancoconexao.getConnection();

            java.sql.Statement st = conexao.createStatement();
            select = "select * from clientes";
            System.out.println("fiz o select");
            ResultSet result = st.executeQuery(select);

            while (result.next()) {

                //produtos.setCodigoprod(result.getString("codigobarrasprod"));
                //produtos.setNomeprod(result.getString("nomeprod"));
                //produtos.setValorprod(result.getDouble("valor"));
                //produtos.setDtCadastro(result.getDate("datacadastroprod"));
                //produtos.setDescricaoprod(result.getString("descricaoprod"));
                //produtos.setCategoriaprod(result.getString("categoriaprod"));
                //produtos.setQtdestoque(result.getInt("quantidadeprod"));
                //produtos.setListaProd(produtos);


            }

            conexao.close();

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }
        return lista;
    }

}
