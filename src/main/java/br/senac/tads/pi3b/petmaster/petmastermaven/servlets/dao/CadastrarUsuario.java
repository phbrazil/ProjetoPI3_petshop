/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.petmaster.petmastermaven.servlets.dao;

import br.senac.tads.pi3b.petmaster.petmastermaven.servlets.model.Usuario;
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
@WebServlet(name = "CadastrarUsuario", urlPatterns = {"/CadastrarUsuario"})

public class CadastrarUsuario extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nomeUsuario = request.getParameter("nomeusuario");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String idgrupo = request.getParameter("idgrupo");


        BancoUsuario bancousuario = new BancoUsuario();

        int qtdusuariocadastrado = bancousuario.ValidaCadastradoUsuario(nomeUsuario);

        if (qtdusuariocadastrado == 0) {

            Usuario usuario = new Usuario(nomeUsuario, username, password, idgrupo);
            
            bancousuario.gravarUsuario(usuario);
            request.setAttribute("nomeUsuario", nomeUsuario);
            request.setAttribute("mensagem", "Usuario cadastrado com sucesso!");

            request.getRequestDispatcher("CadastrarUsuario.jsp").forward(request, response);

        } else {

            request.setAttribute("nomeUsuario", nomeUsuario);
            request.setAttribute("mensagem", "falha");

            request.getRequestDispatcher("CadastrarUsuario.jsp").forward(request, response);

        }

    }

}
