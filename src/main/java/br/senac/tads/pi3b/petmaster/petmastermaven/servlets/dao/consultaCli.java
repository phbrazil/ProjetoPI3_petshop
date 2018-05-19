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
@WebServlet(name = "consultaCli", urlPatterns = {"/consultaCli"})
public class consultaCli extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        String cpfcliente = request.getParameter("cpfcliente");


        bancoCli bancocli = new bancoCli();
        bancoCPF bancocpf = new bancoCPF();

        Cliente cliente = new Cliente(null, null, null, null, null, null, null, null, null, null, null, 
                null, null, null, null, null);

        cliente = bancocpf.PesquisarCPF(cpfcliente);
        

        if (cliente.getNomeCliente()!= null) {
            
            System.out.println("achei");
            
            request.setAttribute("resultado", cliente);
            

            request.getRequestDispatcher("consultaClienteResult.jsp").forward(request, response);

        } else {
            System.out.println("nao achei");

            request.setAttribute("resultado", "Cliente não encontado");

            request.getRequestDispatcher("consultaCli.jsp").forward(request, response);

        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
