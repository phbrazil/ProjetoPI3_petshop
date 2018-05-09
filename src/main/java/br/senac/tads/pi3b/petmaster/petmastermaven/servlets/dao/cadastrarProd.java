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

/**
 *
 * @author Paulo.Bezerra
 */
@WebServlet(name = "cadastrarProd", urlPatterns = {"/cadastrarProd"})

public class cadastrarProd extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nomeprod = request.getParameter("nomeprod");
        String codigobarrasprod = request.getParameter("codigoprod");
        String descricaoprod = request.getParameter("descricaoprod");
        String categoriaprod = request.getParameter("categoriaprod");
        double valorprod = Double.parseDouble(request.getParameter("valorprod"));
        int qtdestoque = Integer.valueOf(request.getParameter("qtdestoque"));
        Produtos produtos = new Produtos(null, 0, null, null, 0, null);

        bancoProd bancoprod = new bancoProd();

        int qtdprodcadastrado = bancoprod.validacadastradoprod(codigobarrasprod);

        if (qtdprodcadastrado == 0) {
            produtos = new Produtos(nomeprod, valorprod, codigobarrasprod, descricaoprod, qtdestoque, categoriaprod);

            
            bancoprod.gravarproduto(produtos);
            request.getRequestDispatcher("cadastradoSuccess.jsp").forward(request, response);

        } else {

            request.setAttribute("codigobarras", codigobarrasprod);
            

            request.getRequestDispatcher("jaCadastrado.jsp").forward(request, response);

        }

    }

}
