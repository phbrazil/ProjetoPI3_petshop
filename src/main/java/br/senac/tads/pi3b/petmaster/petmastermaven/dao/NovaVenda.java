/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.petmaster.petmastermaven.dao;

import br.senac.tads.pi3b.petmaster.petmastermaven.model.Vendas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Paulo.Bezerra
 */
public class NovaVenda {

    /**
     *
     * @author paulo.hbezerra
     */
    private Connection conexao = null;

    public void InsertNovaVenda(Vendas vendas) {

        Conexao bancoconexao = new Conexao();

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conexao = bancoconexao.getConnection();

            java.sql.Statement st = conexao.createStatement();
            
            System.out.println("entrei aqui"+vendas.getIdloja());
            

            st.executeUpdate("INSERT INTO vendas (cpfcliente, totalvalor,datavenda,quantidadeitens, vendastatus, vendedor, idloja) VALUES ('" + vendas.getCPFCliente() + "'," + vendas.getTotalValor() + ",NOW()," + vendas.getQuantidadeItensVenda() + ",true,'" 
                    + vendas.getVendedor() +"',"+vendas.getIdloja()+ ");");
            String idvenda = "SELECT LAST_INSERT_ID() as idvenda";

            ResultSet result = st.executeQuery(idvenda);

            while (result.next()) {

                int resultadovendaid = result.getInt("idvenda");
                vendas.setVendaID(resultadovendaid);
    

            }

            conexao.close();

        } catch (Exception e) {

            System.out.println("erro" + e.getMessage());

        }
    }

}
