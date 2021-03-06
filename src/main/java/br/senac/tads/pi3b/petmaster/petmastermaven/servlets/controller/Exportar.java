/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.petmaster.petmastermaven.servlets.controller;

import br.senac.tads.pi3b.petmaster.petmastermaven.dao.Clientes;
import br.senac.tads.pi3b.petmaster.petmastermaven.dao.PetDAO;
import br.senac.tads.pi3b.petmaster.petmastermaven.dao.ProdutosDAO;
import br.senac.tads.pi3b.petmaster.petmastermaven.model.Cliente;
import java.awt.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
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
@WebServlet(name = "Exportar", urlPatterns = {"/Exportar"})
public class Exportar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String exportartipo = request.getParameter("exportar");

        if (exportartipo.equals("ExportarCliente")) {

            Clientes bancocli = new Clientes();

            ResultSet exportarcli = bancocli.PesquisarClientesGeral();

                
                request.setAttribute("exportarcliente", exportarcli);
                request.getRequestDispatcher("Exportar/ExportClientes.jsp").forward(request, response);

            

        } else if (exportartipo.equals("ExportarProdutos")) {
            
            System.out.println("entrei aqui");

            ProdutosDAO bancoprod = new ProdutosDAO();

            ResultSet exportarprod = bancoprod.PesquisarProdutosGeral();

            if (exportarprod != null) {
                
                request.setAttribute("exportarprodutos", exportarprod);
                request.getRequestDispatcher("Exportar/ExportProdutos.jsp").forward(request, response);
            }

        } else if (exportartipo.equals("ExportarPets")) {

            PetDAO bancopet = new PetDAO();

            ResultSet exportarpet = bancopet.PesquisarPetGeral();

            if (exportarpet != null) {
                
                request.setAttribute("exportarpets", exportarpet);
                request.getRequestDispatcher("Exportar/ExportPets.jsp").forward(request, response);
            }
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
