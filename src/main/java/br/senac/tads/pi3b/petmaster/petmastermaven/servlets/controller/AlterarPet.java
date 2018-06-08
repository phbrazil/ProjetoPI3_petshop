/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.petmaster.petmastermaven.servlets.controller;

import br.senac.tads.pi3b.petmaster.petmastermaven.dao.Pet;
import br.senac.tads.pi3b.petmaster.petmastermaven.dao.Pet;
import br.senac.tads.pi3b.petmaster.petmastermaven.model.Pets;
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
@WebServlet(name = "AlterarPet", urlPatterns = {"/AlterarPet"})

public class AlterarPet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        boolean deletado = false;
        Pet bancopet = new Pet();

        String alterar = String.valueOf(request.getParameter("alterar"));
        String excluir = String.valueOf(request.getParameter("excluir"));

        if (alterar.equals("alterar")) {

            String nomepet = request.getParameter("nomepet");
            String codigobarraspet = request.getParameter("codigopet");
            String descricaopet = request.getParameter("descricaopet");
            String categoriapet = request.getParameter("categoriapet");
            double valorpet = Double.parseDouble(request.getParameter("valorpet"));
            int qtdestoquepet = Integer.valueOf(request.getParameter("qtdestoquepet"));
            Pets pets = new Pets(null, 0, null, null, 0, null);

            pets = new Pets(nomepet, valorpet, codigobarraspet, descricaopet, qtdestoquepet, categoriapet);

            bancopet.atualizarpet(pets);

            request.getRequestDispatcher("CadastradoSuccess.jsp").forward(request, response);

        } else if (excluir.equals("excluir")) {

            deletado = bancopet.deletapet(String.valueOf(request.getParameter("codigopet")));

            if (deletado == true) {
                request.getRequestDispatcher("Deletado.jsp").forward(request, response);

            }else{
                
                System.out.println("falhou na hora de deletar");
            }

        }

    }

}
