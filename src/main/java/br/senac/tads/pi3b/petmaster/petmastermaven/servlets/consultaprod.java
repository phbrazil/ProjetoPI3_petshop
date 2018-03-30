/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.petmaster.petmastermaven.servlets;

import java.awt.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author paulo.bezerra
 */
@WebServlet(name = "consultaprod", urlPatterns = {"/consultaprod"})
public class consultaprod extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Produtos produtos = new Produtos(8, "Casinha de Cachorro", "29/03/2018", 800.00);

        String consultaprod = request.getParameter("consultaprod");

        if (consultaprod.contains("casinha")) {

            request.setAttribute("resultado", produtos);

            request.getRequestDispatcher("consultaprodresult.jsp").forward(request, response);

        } else {

            produtos.setNome("Não encontrado");
            produtos.setdtCadastro(null);
            produtos.setValor(0);

            request.setAttribute("resultado", produtos);

            request.getRequestDispatcher("consultaprodresult.jsp").forward(request, response);

        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
