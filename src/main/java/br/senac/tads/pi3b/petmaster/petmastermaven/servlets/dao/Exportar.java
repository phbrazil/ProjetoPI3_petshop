/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.petmaster.petmastermaven.servlets.dao;

import br.senac.tads.pi3b.petmaster.petmastermaven.servlets.model.Cliente;
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

            BancoCli bancocli = new BancoCli();

            ResultSet exportarcli = bancocli.PesquisarClientesGeral();

            if (exportarcli != null) {
                request.setAttribute("exportarcliente", exportarcli);
                request.getRequestDispatcher("ExportClientes.jsp").forward(request, response);

            }

        } else if (exportartipo.equals("ExportarProdutos")) {

            BancoProd bancoprod = new BancoProd();

            ResultSet exportarprod = bancoprod.PesquisarProdutosGeral();

            if (exportarprod != null) {
                request.setAttribute("exportarprodutos", exportarprod);
                request.getRequestDispatcher("ExportProdutos.jsp").forward(request, response);
            }

        } else if (exportartipo.equals("ExportarPets")) {

            BancoPet bancopet = new BancoPet();

            ResultSet exportarpet = bancopet.PesquisarPetGeral();

            if (exportarpet != null) {
                request.setAttribute("exportarpets", exportarpet);
                request.getRequestDispatcher("ExportPets.jsp").forward(request, response);
            }
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
