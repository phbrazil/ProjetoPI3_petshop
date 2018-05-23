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
@WebServlet(name = "AcaoConsulta", urlPatterns = {"/AcaoConsulta"})

public class AcaoConsulta extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acaoconsulta = request.getParameter("AcaoConsulta");

        if (acaoconsulta.equals("Consultar Produto")) {

            request.getRequestDispatcher("ConsultaProd.jsp").forward(request, response);

        } else if (acaoconsulta.equals("Consultar Pet")) {

            request.getRequestDispatcher("ConsultaPet.jsp").forward(request, response);

        } else if (acaoconsulta.equals("Listar Estoque Produtos")) {

            request.getRequestDispatcher("EstoqueProd.jsp").forward(request, response);

        } else if (acaoconsulta.equals("Listar Estoque Pets")) {

            request.getRequestDispatcher("EstoquePet.jsp").forward(request, response);

        }

    }

}
