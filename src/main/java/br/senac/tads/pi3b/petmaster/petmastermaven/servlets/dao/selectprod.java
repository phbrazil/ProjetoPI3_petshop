/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.petmaster.petmastermaven.servlets.dao;

import br.senac.tads.pi3b.petmaster.petmastermaven.servlets.model.Produtos;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author killuminatti08
 */
public class selectprod {

    private Connection conexao = null;

    Produtos produtos = new Produtos(null, 0, null, null, 0, null);

    public Produtos PesquisarProduto(String buscaprod) {

        String select = "";

        bancoconexao bancoconexao = new bancoconexao();

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = bancoconexao.getConnection();

            java.sql.Statement st = conexao.createStatement();
            select = "select * from produtos where nomeprod like '%" + buscaprod+"%' or codigobarrasprod = "+buscaprod;
            ResultSet result = st.executeQuery(select);

            while (result.next()) {

                produtos.setCodigoprod(result.getString("codigobarrasprod"));
                produtos.setNomeprod(result.getString("nomeprod"));
                produtos.setValorprod(result.getDouble("valor"));
                produtos.setDtCadastro(result.getDate("datacadastroprod"));
                produtos.setDescricaoprod(result.getString("descricaoprod"));
                produtos.setCategoriaprod(result.getString("categoriaprod"));
                produtos.setQtdestoque(result.getInt("quantidadeprod"));

            }

            conexao.close();

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }
        if (produtos.getNomeprod()== null) {
            //JOptionPane.showMessageDialog(null, "Produto não encontrado");
        }

        return produtos;
    }

}
