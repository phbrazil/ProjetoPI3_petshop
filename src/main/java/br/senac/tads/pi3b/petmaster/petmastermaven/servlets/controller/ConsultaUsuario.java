/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.petmaster.petmastermaven.servlets.controller;

import br.senac.tads.pi3b.petmaster.petmastermaven.dao.BancoUsuario;
import br.senac.tads.pi3b.petmaster.petmastermaven.model.Usuario;
import java.awt.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author paulo.bezerra
 */
@WebServlet(name = "ConsultaUsuario", urlPatterns = {"/ConsultaUsuario"})
public class ConsultaUsuario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        String consultaUsuario = request.getParameter("ConsultaUsuario");
                

        BancoUsuario selectusuario = new BancoUsuario();

        Usuario usuarios = new Usuario(null, null, null, 0,0);
     
        if (consultaUsuario.trim() != null) {

            usuarios = selectusuario.PesquisarUsuario(consultaUsuario);
            
            
        }

        if (usuarios.getNomeUsuario() != null) {

            request.setAttribute("resultado", usuarios);

            request.getRequestDispatcher("ConsultaUsuarioResult.jsp").forward(request, response);

        } else {

            request.setAttribute("resultado", "Usuario não encontado");

            request.getRequestDispatcher("ConsultaUsuarioResult.jsp").forward(request, response);

        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
