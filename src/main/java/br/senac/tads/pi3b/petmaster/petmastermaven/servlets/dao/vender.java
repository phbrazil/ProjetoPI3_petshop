/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.petmaster.petmastermaven.servlets.dao;

import br.senac.tads.pi3b.petmaster.petmastermaven.servlets.model.Produtos;
import br.senac.tads.pi3b.petmaster.petmastermaven.servlets.model.Sessao;
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
        
        boolean sessaovalida = false;

        String cpfcliente = request.getParameter("cpfcliente");
        String nomecliente = request.getParameter("nomecliente");

        HttpSession sessaoatual = null;

        Sessao sessao = new Sessao();
        sessaoatual = request.getSession();
        sessaovalida = sessao.Sessao(sessaoatual);

        if (!cpfcliente.equals("")) {

            sessaoatual.setAttribute("nomecliente", nomecliente);
            sessaoatual.setAttribute("cpfcliente", cpfcliente);

            request.getRequestDispatcher("vender.jsp").forward(request, response);

        } else {

            sessaoatual.setAttribute("nomecliente", "Pesquise o CPF");

            request.getRequestDispatcher("pesquisarcpf.jsp").forward(request, response);

        }

        //sessaoatual.invalidate();
    }

}
