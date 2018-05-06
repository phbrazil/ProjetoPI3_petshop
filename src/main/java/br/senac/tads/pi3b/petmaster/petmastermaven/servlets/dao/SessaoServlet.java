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
import br.senac.tads.pi3b.petmaster.petmastermaven.servlets.model.Sessao;

/**
 *
 * @author Paulo.Bezerra
 */
@WebServlet(name = "sessao", urlPatterns = {"/sessao"})

public class SessaoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        boolean sessaovalida = false;

        HttpSession sessaoatual = null;

        Sessao sessao = new Sessao();

        sessaoatual = request.getSession();
        sessaovalida = sessao.Sessao(sessaoatual);

        if (sessaovalida == false) {
            response.sendRedirect("index.html");

        }

    }

}
