/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.petmaster.petmastermaven.servlets.dao;

import br.senac.tads.pi3b.petmaster.petmastermaven.servlets.model.Pets;
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
@WebServlet(name = "consultapet", urlPatterns = {"/consultapet"})
public class consultapet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
        
        
        
        
        

        /*Pets pets = new Pets(2, "Vira-lata", "29/03/2018", 1.00);
        Pets pets1 = new Pets(23, "Cachorro loko", "29/03/2018", 10.00);
        Pets pets2 = new Pets(35, "Bulldog", "29/03/2018", 150.00);

        pets.inserirPets(pets);

        pets.inserirPets(pets1);

        pets.inserirPets(pets2);

        String consultapet = request.getParameter("consultapet");

        Pets resultado = pets.obterPetsLista(consultapet);

       if (resultado.getNomepet().toUpperCase().contains(consultapet.toUpperCase())) {

           request.setAttribute("resultado", resultado);
            

            request.getRequestDispatcher("consultapetresult.jsp").forward(request, response);

        } else {
            
           pets.setNomepet("Não encontrado");


            request.setAttribute("resultado", resultado);

            request.getRequestDispatcher("consultapetresult.jsp").forward(request, response);

        }

         */
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
