/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.petmaster.petmastermaven.servlets.dao;

import br.senac.tads.pi3b.petmaster.petmastermaven.servlets.model.Produtos;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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
@WebServlet(name = "vender", urlPatterns = {"/vender"})

public class vender extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String cpf = request.getParameter("cpfcliente");

        HttpSession sessao = null;

        if (cpf != null) {
            System.out.println("cpf é " + cpf);

            sessao = request.getSession();

            sessao.setAttribute("primeironome", "achou caraio");
            sessao.setAttribute("cpfcliente", cpf);

            request.getRequestDispatcher("vender.jsp").forward(request, response);

        } else if (cpf.equals("")) {
            System.out.println("diferente");
            sessao.setAttribute("primeironome", "Pesquise o CPF");

            request.getRequestDispatcher("vender.jsp").forward(request, response);

        }
        
        sessao.invalidate();

    }

}
