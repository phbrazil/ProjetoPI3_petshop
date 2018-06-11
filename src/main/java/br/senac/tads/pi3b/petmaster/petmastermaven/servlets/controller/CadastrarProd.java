/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.petmaster.petmastermaven.servlets.controller;

import br.senac.tads.pi3b.petmaster.petmastermaven.dao.BancoSessao;
import br.senac.tads.pi3b.petmaster.petmastermaven.dao.ProdutosDAO;
import br.senac.tads.pi3b.petmaster.petmastermaven.model.Produtos;
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
@WebServlet(name = "CadastrarProd", urlPatterns = {"/CadastrarProd"})

public class CadastrarProd extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sessao = request.getSession();

        BancoSessao bancosessao = new BancoSessao();
        String sessaoid = sessao.getId();

        String nomeprod = request.getParameter("nomeprod");
        String codigobarrasprod = request.getParameter("codigoprod");
        String descricaoprod = request.getParameter("descricaoprod");
        String categoriaprod = request.getParameter("categoriaprod");
        double valorprod = Double.parseDouble(request.getParameter("valorprod"));
        int qtdestoque = Integer.valueOf(request.getParameter("qtdestoque"));
        int idloja = bancosessao.idLoja(sessaoid);

        Produtos produtos = new Produtos(null, 0, null, null, 0, null, 0);

        ProdutosDAO bancoprod = new ProdutosDAO();

        boolean repetido = bancoprod.validacadastradoprod(codigobarrasprod);

        if (repetido == false) {
            produtos = new Produtos(nomeprod, valorprod, codigobarrasprod, descricaoprod, qtdestoque, categoriaprod, idloja);

            bancoprod.gravarproduto(produtos);
            request.getRequestDispatcher("CadastradoSuccess.jsp").forward(request, response);

        } else {

            request.setAttribute("codigobarras", codigobarrasprod);

            request.getRequestDispatcher("jaCadastrado.jsp").forward(request, response);

        }

    }

}
