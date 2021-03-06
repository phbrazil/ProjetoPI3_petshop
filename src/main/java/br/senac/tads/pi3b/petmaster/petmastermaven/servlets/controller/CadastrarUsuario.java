/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.petmaster.petmastermaven.servlets.controller;

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
@WebServlet(name = "CadastrarUsuario", urlPatterns = {"/CadastrarUsuario"})

public class CadastrarUsuario extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        

        String nomeUsuario = request.getParameter("nomeusuario");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String idgruponome = request.getParameter("idgrupo");
        String idfilialnome = request.getParameter("idfilial");
        
        System.out.println("grupo"+idgruponome);
        System.out.println("filial"+idfilialnome);

        BancoUsuario bancousuario = new BancoUsuario();
        
        int idfilial = bancousuario.idFilial(idfilialnome);
        int idgrupo = bancousuario.idGrupo(idgruponome);

        int qtdusuariocadastrado = bancousuario.ValidaCadastradoUsuario(username.trim());

        if (qtdusuariocadastrado == 0) {
            
            System.out.println("entrei aqui");

            Usuario usuario = new Usuario(nomeUsuario, username, password, idgrupo,idfilial);
            
            bancousuario.gravarUsuario(usuario);
            
            request.setAttribute("mensagem", "Usuario cadastrado com sucesso!");

            request.getRequestDispatcher("GerenciamentoUsuario.jsp").forward(request, response);

        } else {

            request.setAttribute("nomeUsuario", nomeUsuario);
            request.setAttribute("mensagem", "Usuário já se encontra cadastrado");

            request.getRequestDispatcher("GerenciamentoUsuario.jsp").forward(request, response);

        }

    }

}
