/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.petmaster.petmastermaven.servlets.controller;

import antlr.collections.impl.LList;
import br.senac.tads.pi3b.petmaster.petmastermaven.dao.BancoUsuario;
import br.senac.tads.pi3b.petmaster.petmastermaven.dao.Lojas;
import br.senac.tads.pi3b.petmaster.petmastermaven.model.Loja;
import br.senac.tads.pi3b.petmaster.petmastermaven.model.Usuario;
import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Paulo.Bezerra
 */
@WebServlet(name = "ListaFiliais", urlPatterns = {"/ListaFiliais"})

public class ListaFiliais extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Lojas lojasselect = new Lojas();

        ResultSet listafiliais = lojasselect.NomeLoja();

        request.setAttribute("listafiliais", listafiliais);

        request.getRequestDispatcher("CadastrarUsuario.jsp").forward(request, response);

    }

}
