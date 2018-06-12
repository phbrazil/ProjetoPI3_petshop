/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.petmaster.petmastermaven.servlets.controller;

import br.senac.tads.pi3b.petmaster.petmastermaven.dao.BancoUsuario;
import br.senac.tads.pi3b.petmaster.petmastermaven.dao.BancoUsuario;
import br.senac.tads.pi3b.petmaster.petmastermaven.model.Usuario;
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
@WebServlet(name = "AlterarUsuario", urlPatterns = {"/AlterarUsuario"})

public class AlterarUsuario extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        boolean deletado = false;
        BancoUsuario bancousuario = new BancoUsuario();

        String acaocliente = String.valueOf(request.getParameter("AcaoCliente"));

        if (acaocliente.equals("alterar")) {

            String nomeUsuario = request.getParameter("nomeusuario");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            //String idgrupo = request.getParameter("idgrupo");
            //String idfilial = request.getParameter("idfilial");

            Usuario usuarios = new Usuario(nomeUsuario, username, password, 0,0);
            bancousuario.atualizarUsuario(usuarios);

            request.setAttribute("mensagem", "Usuario Alterado");

            request.getRequestDispatcher("GerenciamentoUsuario.jsp").forward(request, response);

        } else if (acaocliente.equals("excluir")) {

            deletado = bancousuario.deletaUsuario(String.valueOf(request.getParameter("username")));

            if (deletado == true) {
                request.setAttribute("mensagem", "Usuario Deletado");

                request.getRequestDispatcher("GerenciamentoUsuario.jsp").forward(request, response);

            } else {
                request.getRequestDispatcher("GerenciamentoUsuario.jsp").forward(request, response);

                request.setAttribute("mensagem", "Falhou na hora de Deletar");

                System.out.println("falhou na hora de deletar");
            }

        }

    }

}
