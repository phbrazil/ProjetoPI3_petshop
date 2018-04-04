/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.petmaster.petmastermaven.servlets;

import br.senac.tads.pi3b.petmaster.petmastermaven.servlets.model.Pets;
import java.awt.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author paulo.bezerra
 */
@WebServlet(name = "relatorios", urlPatterns = {"/relatorios"})
public class relatorios extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        java.util.List<Pets> listapets = new ArrayList<Pets>();
        Pets pets = new Pets(2, "Vira-lata", "29/03/2018", 1.00);
        listapets.add(pets);
        Pets pets1 = new Pets(23, "Cachorro loko", "29/03/2018", 10.00);
        listapets.add(pets1);
        Pets pets2 = new Pets(35, "Bulldog", "29/03/2018", 150.00);
        listapets.add(pets2);
        Pets pets3 = new Pets(3, "Chiuaua", "29/03/2018", 1500.00);
        listapets.add(pets);
        
        int tamanho = listapets.size();
        request.setAttribute("tamanho", tamanho);

        for (int i = 0; i < listapets.size(); i++) {
            request.setAttribute("resultado", listapets);

        }
        request.getRequestDispatcher("relatoriosresult.jsp").forward(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
