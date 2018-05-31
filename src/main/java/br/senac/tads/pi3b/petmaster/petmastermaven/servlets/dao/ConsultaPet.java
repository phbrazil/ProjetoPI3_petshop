/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.petmaster.petmastermaven.servlets.dao;

import br.senac.tads.pi3b.petmaster.petmastermaven.servlets.model.Pets;
import br.senac.tads.pi3b.petmaster.petmastermaven.servlets.model.Produtos;
import java.awt.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author paulo.bezerra
 */
@WebServlet(name = "ConsultaPet", urlPatterns = {"/ConsultaPet"})
public class ConsultaPet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String consultaPet = request.getParameter("ConsultaPet");

        BancoPet selectpet = new BancoPet();

        Pets pets = new Pets(null, 0, null, null, 0, null);
        
        if (consultaPet.trim() != null) {
            pets = selectpet.PesquisarPet(consultaPet);

        }

        if (pets.getNomepet() != null) {

            request.setAttribute("resultado", pets);

            request.getRequestDispatcher("ConsultaPetResult.jsp").forward(request, response);

        } else {

            request.setAttribute("resultado", "Pet não encontrado");

            request.getRequestDispatcher("ConsultaPet.jsp").forward(request, response);

        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
