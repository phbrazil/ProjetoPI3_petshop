/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.petmaster.petmastermaven.servlets.dao;

import br.senac.tads.pi3b.petmaster.petmastermaven.servlets.model.Produtos;
import br.senac.tads.pi3b.petmaster.petmastermaven.servlets.model.Vendas;
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
@WebServlet(name = "SessaoServlet", urlPatterns = {"/SessaoServlet"})

public class SessaoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sessao = request.getSession();

        String vendedor = (String) request.getAttribute("vendedor");

        sessao.setAttribute("vendedor", vendedor);
        
        
        Vendas vendas = new Vendas();
        
        vendas.setVendedor(vendedor);
        

        request.getRequestDispatcher("Home.jsp").forward(request, response);

    }

}
