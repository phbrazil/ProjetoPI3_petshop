/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.petmaster.petmastermaven.servlets.dao;

import br.senac.tads.pi3b.petmaster.petmastermaven.servlets.model.Cliente;
import br.senac.tads.pi3b.petmaster.petmastermaven.servlets.model.Loja;
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
@WebServlet(name = "AlterarLoja", urlPatterns = {"/AlterarLoja"})

public class AlterarLoja extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        boolean deletado = false;
        BancoLoja bancoLoja = new BancoLoja();

        String acaocliente = String.valueOf(request.getParameter("AcaoCliente"));

        if (acaocliente.equals("alterar")) {

            String idloja = request.getParameter("idloja");
            String nomeLoja = request.getParameter("nomeloja");
            String logradouro = request.getParameter("logradouro");
            String cidade = request.getParameter("cidade");
            String bairro = request.getParameter("bairro");
            String uf = request.getParameter("uf");
            String cep = request.getParameter("cep").replace("-", "").replace(".", "");
            String telefone = request.getParameter("telefone");

            //Cliente clientes = new Cliente(CPFCliente, nascimento, nomeCliente, logradouro, bairro, cidade, cep, estado, uf, email, sexo, telefone, celular, pais, RGCliente, estadocivil);
            Loja loja = new Loja(nomeLoja, logradouro, cidade, bairro, uf, cep, telefone);
            bancoLoja.atualizarLoja(loja);

            request.setAttribute("mensagem", "Cliente Alterado");

            request.getRequestDispatcher("ConsultaCli.jsp").forward(request, response);

        } else if (acaocliente.equals("excluir")) {

            deletado = bancoLoja.deletaCliente(String.valueOf(request.getParameter("cpfcliente")));

            if (deletado == true) {
                request.setAttribute("mensagem", "Cliente Deletado");

                request.getRequestDispatcher("ConsultaCli.jsp").forward(request, response);

            } else {

                System.out.println("falhou na hora de deletar");
            }

        }

    }

}
