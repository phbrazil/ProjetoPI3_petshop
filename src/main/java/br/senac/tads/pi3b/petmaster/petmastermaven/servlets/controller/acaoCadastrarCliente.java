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
@WebServlet(name = "acaoCadastrarCliente", urlPatterns = {"/acaoCadastrarCliente"})

public class acaoCadastrarCliente extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acaocadastrarCliente = request.getParameter("acaocadastrarCliente");

        if (acaocadastrarCliente.equals("Cadastrar Cliente")) {

            request.getRequestDispatcher("cadastrarCliente.jsp").forward(request, response);

        } else if (acaocadastrarCliente.equals("Consultar Cliente")) {
            request.getRequestDispatcher("consultaCli.jsp").forward(request, response);

        }

    }

}
