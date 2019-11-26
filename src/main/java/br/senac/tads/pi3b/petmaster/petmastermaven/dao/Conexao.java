/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.petmaster.petmastermaven.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author paulo.hbezerra
 */
public class Conexao {

    private String url = "jdbc:mysql://localhost:3306/petmaster?useTimezone=true&serverTimezone=UTC";

    //private String driver = "com.mysql.jdbc.Driver";
    private String driver = "com.mysql.cj.jdbc.Driver";

    private Connection conexao = null;

    private String userName = "senac";
    private String password = "senac";

    public Connection getConnection() throws SQLException {

        try {
            Class.forName(driver);
            if (conexao == null) {

                conexao = DriverManager.getConnection(url, userName, password);

            }
        } catch (Exception e) {
            System.out.print("Erro na conexao: " + e.getMessage());
        }
        return conexao;
    }
}
