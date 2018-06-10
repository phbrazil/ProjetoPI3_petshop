/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.petmaster.petmastermaven.servlets.controller;

import br.senac.tads.pi3b.petmaster.petmastermaven.dao.Lojas;
import br.senac.tads.pi3b.petmaster.petmastermaven.model.Pets;
import br.senac.tads.pi3b.petmaster.petmastermaven.model.Loja;
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
@WebServlet(name = "ConsultaLoja", urlPatterns = {"/ConsultaLoja"})
public class ConsultaLoja extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        String consultaLoja = request.getParameter("ConsultaLoja");
                

        Lojas selectloja = new Lojas();

        Loja lojas = new Loja(null, null, null, null, null, null, null);
     
        if (consultaLoja.trim() != null) {

            lojas = selectloja.PesquisarLoja(consultaLoja);
            
            
        }

        if (lojas.getNomeLoja() != null) {

            request.setAttribute("resultado", lojas);

            request.getRequestDispatcher("ConsultaLojaResult.jsp").forward(request, response);

        } else {

            request.setAttribute("resultado", "Loja não encontada");

            request.getRequestDispatcher("ConsultaLoja.jsp").forward(request, response);

        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
