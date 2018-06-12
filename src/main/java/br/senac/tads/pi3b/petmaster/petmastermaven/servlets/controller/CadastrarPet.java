/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.petmaster.petmastermaven.servlets.controller;

import br.senac.tads.pi3b.petmaster.petmastermaven.dao.BancoSessao;
import br.senac.tads.pi3b.petmaster.petmastermaven.dao.PetDAO;
import br.senac.tads.pi3b.petmaster.petmastermaven.model.Pets;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Paulo.Bezerra
 */
@WebServlet(name = "CadastrarPet", urlPatterns = {"/CadastrarPet"})

public class CadastrarPet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sessao = request.getSession();

        BancoSessao bancosessao = new BancoSessao();
        String sessaoid = sessao.getId();
        String nomepet = request.getParameter("nomepet");
        String codigobarraspet = request.getParameter("codigopet");
        String descricaopet = request.getParameter("descricaopet");
        String categoriapet = request.getParameter("categoriapet");
        double valorpet = Double.parseDouble(request.getParameter("valorpet"));
        int qtdestoquepet = Integer.valueOf(request.getParameter("qtdestoquepet"));
        int idloja = bancosessao.idLoja(sessaoid);

        Pets pets = new Pets(null, 0, null, null, 0, null,0);

        PetDAO bancopet = new PetDAO();

        int qtdpetcadastrado = bancopet.validacadastradopet(codigobarraspet);
        
        System.out.println("to aqui ainda");

        if (qtdpetcadastrado == 0) {
            
            System.out.println("entrei aqui");
            
            pets = new Pets(nomepet, valorpet, codigobarraspet, descricaopet, qtdestoquepet, categoriapet, idloja);

            bancopet.gravarpet(pets);
            request.getRequestDispatcher("CadastradoSuccess.jsp").forward(request, response);

        } else {

            request.setAttribute("codigobarras", codigobarraspet);

            request.getRequestDispatcher("jaCadastrado.jsp").forward(request, response);

        }

    }

}
