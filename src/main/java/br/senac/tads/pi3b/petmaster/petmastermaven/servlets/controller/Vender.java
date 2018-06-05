/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.petmaster.petmastermaven.servlets.controller;

import br.senac.tads.pi3b.petmaster.petmastermaven.servlets.model.Produtos;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Paulo.Bezerra
 */
@WebServlet(name = "Vender", urlPatterns = {"/Vender"})

public class Vender extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String cpfcliente = request.getParameter("cpfcliente");
        String nomecliente = request.getParameter("nomecliente");
        String vendedor = request.getParameter("vendedor");
        


        HttpSession sessaoatual = request.getSession();

        if (!cpfcliente.equals("")) {

            sessaoatual.setAttribute("nomecliente", nomecliente);
            sessaoatual.setAttribute("cpfcliente", cpfcliente);
            sessaoatual.setAttribute("vendedor", vendedor);

            request.getRequestDispatcher("Vender.jsp").forward(request, response);

        } else {

            sessaoatual.setAttribute("nomecliente", "Pesquise o CPF");

            request.getRequestDispatcher("PesquisarCPF.jsp").forward(request, response);

        }

        //sessaoatual.invalidate();
    }

}
