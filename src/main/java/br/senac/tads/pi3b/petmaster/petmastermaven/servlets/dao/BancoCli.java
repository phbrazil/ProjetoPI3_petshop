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
public class BancoCli {

    private Connection conexao = null;

    Cliente cliente = new Cliente(null,null,null, null, null, null, null, null, null, null, null, null, null, null, null, null);

    private java.util.List<Cliente> listaCli = new ArrayList<Cliente>();

    public void gravarCliente(Cliente cliente) {

        BancoConexao bancoconexao = new BancoConexao();

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

        BancoConexao bancoconexao = new BancoConexao();

        try {

            Connection conexao = bancoconexao.getConnection();

            java.sql.Statement st = conexao.createStatement();
            st.executeUpdate("UPDATE clientes set nome = '" + cliente.getNomeCliente()+ "', logradouro = '" + cliente.getLogradouro()+ "',"
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

    public Cliente PesquisarCliente(String CPF) {

        String select = "";

        BancoConexao bancoconexao = new BancoConexao();

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = bancoconexao.getConnection();

            java.sql.Statement st = conexao.createStatement();
            select = "select * from clientes where cpfcliente  = '" + CPF + "'";
            ResultSet result = st.executeQuery(select);

            while (result.next()) {

                cliente.setCpfCliente(result.getString("cpfcliente"));
                cliente.setRG(result.getString("rg"));
                cliente.setNomeCliente(result.getString("nome"));
                cliente.setLogradouro(result.getString("logradouro"));
                cliente.setBairro(result.getString("bairro"));
                cliente.setCidade(result.getString("cidade"));
                cliente.setEstado(result.getString("estado"));
                cliente.setUF(result.getString("uf"));
                cliente.setPais(result.getString("pais"));
                cliente.setCep(result.getString("cep"));
                cliente.setTelefone(result.getString("telefone"));
                cliente.setCelular(result.getString("celular"));
                cliente.setEmail(result.getString("email"));
                cliente.setSexo(result.getString("sexo"));
                cliente.setEstado(result.getString("estado"));
                cliente.setEstadoCivil(result.getString("estadocivil"));
                cliente.setNascimento(result.getString("nascimento"));
                cliente.setListaCliente(cliente);

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

        BancoConexao bancoconexao = new BancoConexao();

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

        BancoConexao bancoconexao = new BancoConexao();

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

}
