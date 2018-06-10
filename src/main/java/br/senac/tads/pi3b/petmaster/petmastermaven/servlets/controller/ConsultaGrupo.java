/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.petmaster.petmastermaven.servlets.controller;

import br.senac.tads.pi3b.petmaster.petmastermaven.dao.Grupos;
import br.senac.tads.pi3b.petmaster.petmastermaven.model.Pets;
import br.senac.tads.pi3b.petmaster.petmastermaven.model.Grupo;
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
@WebServlet(name = "ConsultaGrupo", urlPatterns = {"/ConsultaGrupo"})
public class ConsultaGrupo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        String consultaGrupo = request.getParameter("ConsultaGrupo");
                

        Grupos selectGrupo = new Grupos();

        Grupo grupos = new Grupo(null, null);
     
        if (consultaGrupo.trim() != null) {

            grupos = selectGrupo.PesquisarGrupo(consultaGrupo);
            
            
        }

        if (grupos.getNomeGrupo() != null) {

            request.setAttribute("resultado", grupos);

            request.getRequestDispatcher("ConsultaGrupoResult.jsp").forward(request, response);

        } else {

            request.setAttribute("resultado", "Grupo não encontado");

            request.getRequestDispatcher("ConsultaGrupo.jsp").forward(request, response);

        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
