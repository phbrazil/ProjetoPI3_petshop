/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.petmaster.petmastermaven.servlets.dao;

import br.senac.tads.pi3b.petmaster.petmastermaven.servlets.model.Cliente;
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
@WebServlet(name = "alterarCli", urlPatterns = {"/alterarCli"})

public class alterarCli extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        boolean deletado = false;
        bancoCli bancocli = new bancoCli();

        String acaocliente = String.valueOf(request.getParameter("acaocliente"));

        if (acaocliente.equals("alterar")) {

            String nomeprod = request.getParameter("nomeprod");
            String codigobarrasprod = request.getParameter("codigoprod");
            String descricaoprod = request.getParameter("descricaoprod");
            String categoriaprod = request.getParameter("categoriaprod");
            double valorprod = Double.parseDouble(request.getParameter("valorprod"));
            int qtdestoque = Integer.valueOf(request.getParameter("qtdestoque"));
            Cliente clientes = new Cliente(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

            //clientes = new Cliente(nomeprod, valorprod, codigobarrasprod, descricaoprod, qtdestoque, categoriaprod);

            bancocli.atualizarCli(clientes);

            request.setAttribute("mensagem", "Cliente Alterado");

            request.getRequestDispatcher("consultaCli.jsp").forward(request, response);

        } else if (acaocliente.equals("excluir")) {

            deletado = bancocli.deletaCliente(String.valueOf(request.getParameter("cpfcliente")));

            if (deletado == true) {
                request.setAttribute("mensagem", "Cliente Deletado");

                request.getRequestDispatcher("consultaCli.jsp").forward(request, response);

            } else {

                System.out.println("falhou na hora de deletar");
            }

        }

    }

}
