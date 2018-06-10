/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.petmaster.petmastermaven.servlets.controller;

import br.senac.tads.pi3b.petmaster.petmastermaven.dao.Clientes;
import br.senac.tads.pi3b.petmaster.petmastermaven.model.Cliente;
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
@WebServlet(name = "ConsultaCli", urlPatterns = {"/ConsultaCli"})
public class ConsultaCli extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        String cpfcliente = request.getParameter("cpfcliente");


        Clientes bancocpf = new Clientes();

        Cliente cliente = new Cliente(null, null, null, null, null, null, null, null, null, null, null, 
                null, null, null, null, null);

        cliente = bancocpf.PesquisarCliente(cpfcliente);
        

        if (cliente.getNomeCliente()!= null) {
            
            
            request.setAttribute("resultado", cliente);
            

            request.getRequestDispatcher("ConsultaClienteResult.jsp").forward(request, response);

        } else {

            request.setAttribute("resultado", "Cliente não encontado");

            request.getRequestDispatcher("ConsultaCli.jsp").forward(request, response);

        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
