package br.senac.tads.pi3b.petmaster.petmastermaven.servlets.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Paulo.Bezerra
 */
@WebServlet(name = "AcaoCadastrar", urlPatterns = {"/AcaoCadastrar"})

public class AcaoCadastrar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acaocadastrar = request.getParameter("AcaoCadastrar");

        if (acaocadastrar.equals("Cadastrar Produto")) {

            request.getRequestDispatcher("CadastrarProd.jsp").forward(request, response);

        } else if (acaocadastrar.equals("Cadastrar Pet")) {
            request.getRequestDispatcher("CadastrarPet.jsp").forward(request, response);

        }

    }

}
