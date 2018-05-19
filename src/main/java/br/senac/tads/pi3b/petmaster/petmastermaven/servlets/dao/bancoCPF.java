/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.petmaster.petmastermaven.servlets.dao;

import br.senac.tads.pi3b.petmaster.petmastermaven.servlets.model.Cliente;
import java.awt.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author paulo.bezerra
 */
public class bancoCPF {

    private Connection conexao = null;

    Cliente cliente = new Cliente(null, null,null, null, null, null, null, null, null, null, null, null, null, null, null, null);

    private java.util.List<Cliente> listacliente = new ArrayList<Cliente>();

    public Cliente PesquisarCPF(String CPF) {

        String select = "";

        bancoConexao bancoconexao = new bancoConexao();

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

}
