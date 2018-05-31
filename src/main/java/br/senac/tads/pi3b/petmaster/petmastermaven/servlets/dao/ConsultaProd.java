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
@WebServlet(name = "ConsultaProd", urlPatterns = {"/ConsultaProd"})
public class ConsultaProd extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        String consultaProd = request.getParameter("ConsultaProd");
                

        BancoProd selectprod = new BancoProd();

        Produtos produtos = new Produtos(null, 0, null, null, 0, null);

        
        if (consultaProd.trim() != null) {
            
            produtos = selectprod.PesquisarProduto(consultaProd);
            
            System.out.println("to aqui");

        }

        if (produtos.getNomeprod() != null) {

            request.setAttribute("resultado", produtos);

            request.getRequestDispatcher("ConsultaProdResult.jsp").forward(request, response);

        } else {

            request.setAttribute("resultado", "Produto não encontado");

            request.getRequestDispatcher("ConsultaProd.jsp").forward(request, response);

        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
