/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.petmaster.petmastermaven.servlets.dao;

import br.senac.tads.pi3b.petmaster.petmastermaven.servlets.model.Pets;
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
@WebServlet(name = "cadastrarPet", urlPatterns = {"/cadastrarPet"})

public class cadastrarPet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nomepet = request.getParameter("nomepet");
        String codigobarraspet = request.getParameter("codigopet");
        String descricaopet = request.getParameter("descricaopet");
        String categoriapet = request.getParameter("categoriapet");
        double valorpet = Double.parseDouble(request.getParameter("valorpet"));
        int qtdestoquepet = Integer.valueOf(request.getParameter("qtdestoquepet"));
        Pets pets = new Pets(null, 0, null, null, 0, null);

        bancoPet bancopet = new bancoPet();

        int qtdpetcadastrado = bancopet.validacadastradopet(codigobarraspet);

        if (qtdpetcadastrado == 0) {
            pets = new Pets(nomepet, valorpet, codigobarraspet, descricaopet, qtdestoquepet, categoriapet);

            
            bancopet.gravarpet(pets);
            request.getRequestDispatcher("cadastradoSuccess.jsp").forward(request, response);

        } else {

            request.setAttribute("codigobarras", codigobarraspet);
            

            request.getRequestDispatcher("jaCadastrado.jsp").forward(request, response);

        }

    }

}
