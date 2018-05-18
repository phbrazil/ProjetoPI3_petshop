/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.petmaster.petmastermaven.servlets.dao;

import br.senac.tads.pi3b.petmaster.petmastermaven.servlets.model.Cliente;
import br.senac.tads.pi3b.petmaster.petmastermaven.servlets.model.Produtos;
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
@WebServlet(name = "cadastrarCliente", urlPatterns = {"/cadastrarCliente"})

public class cadastrarCliente extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nomeCliente = request.getParameter("nomecliente");
        String logradouro = request.getParameter("logradouro");
        String RGCliente = request.getParameter("rgcliente");
        String CPFCliente = request.getParameter("cpfcliente");
        String email = request.getParameter("email");
        String pais = request.getParameter("pais");
        String cidade = request.getParameter("cidade");
        String bairro = request.getParameter("bairro");
        String uf = request.getParameter("uf");
        String estado = request.getParameter("estado");
        String cep = request.getParameter("cep").replace("-", "").replace(".", "");
        String telefone = request.getParameter("telefone");
        String celular = request.getParameter("celular");
        String sexo = request.getParameter("sexo");
        String estadocivil = request.getParameter("estadocivil");
        String nascimento = request.getParameter("nascimento");

        bancoCli bancocli = new bancoCli();

        int qtdclicadastrado = bancocli.ValidaCadastradoCliente(CPFCliente);

        if (qtdclicadastrado == 0) {

            Cliente cliente = new Cliente(CPFCliente, nascimento, nomeCliente, logradouro, bairro, cidade, cep, estado, uf, email, sexo, telefone, celular, pais, RGCliente, estadocivil);
            
            bancocli.gravarCliente(cliente);
            request.setAttribute("cpfcliente", CPFCliente);
            request.setAttribute("resultado", "Cliente Cadastrado");

            request.getRequestDispatcher("cadastrarCliente.jsp").forward(request, response);

        } else {

            request.setAttribute("cpfcliente", CPFCliente);
            request.setAttribute("resultado", "CPF já está Cadastrado");

            request.getRequestDispatcher("cadastrarCliente.jsp").forward(request, response);

        }

    }

}
