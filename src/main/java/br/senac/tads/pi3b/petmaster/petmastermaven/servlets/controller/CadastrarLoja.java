/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.petmaster.petmastermaven.servlets.controller;

import br.senac.tads.pi3b.petmaster.petmastermaven.dao.Lojas;
import br.senac.tads.pi3b.petmaster.petmastermaven.model.Loja;
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
@WebServlet(name = "CadastrarLoja", urlPatterns = {"/CadastrarLoja"})

public class CadastrarLoja extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idloja = request.getParameter("idloja");
        String nomeLoja = request.getParameter("nomeloja");
        String logradouro = request.getParameter("logradouro");
        String cidade = request.getParameter("cidade");
        String bairro = request.getParameter("bairro");
        String uf = request.getParameter("uf");
        String cep = request.getParameter("cep").replace("-", "").replace(".", "");
        String telefone = request.getParameter("telefone");

        Lojas bancoLoja = new Lojas();

        int qtdclicadastrado = bancoLoja.ValidaCadastradoLoja(nomeLoja);

        if (qtdclicadastrado == 0) {
            
            Loja loja = new Loja(nomeLoja, logradouro, cidade, bairro, uf, cep, telefone);
                               //nomeloja, logradouro, cidade, bairro, uf, cep, telefone
            bancoLoja.gravarLoja(loja);
            request.setAttribute("nomeloja", nomeLoja);
            request.setAttribute("mensagem", "Loja cadastrada com sucesso!");

            request.getRequestDispatcher("CadastrarLoja.jsp").forward(request, response);

        } else {

            request.setAttribute("nomeloja", nomeLoja);
            request.setAttribute("mensagem", "falha");

            request.getRequestDispatcher("CadastrarLoja.jsp").forward(request, response);

        }

    }

}
