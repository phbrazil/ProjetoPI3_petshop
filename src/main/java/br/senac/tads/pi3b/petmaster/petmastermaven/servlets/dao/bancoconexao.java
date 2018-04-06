/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.petmaster.petmastermaven.servlets.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author paulo.hbezerra
 */
public class bancoconexao {

    private String url = "jdbc:mysql://localhost:3306/PetMaster";
    private String driver = "com.mysql.jdbc.Driver";
    private String userName = "root";
    private String password = "admin";
    private Connection conexao = null;

    public  Connection getConnection() throws SQLException {

        try {
            Class.forName(driver);
            if (conexao == null) {
                conexao = DriverManager.getConnection(url, userName, password);
            }
            System.out.print("Conectou porraaaaaaa");
        } catch (Exception e) {
            System.out.print("Erro: " + e.getMessage());
        }
        return conexao;
    }

}
