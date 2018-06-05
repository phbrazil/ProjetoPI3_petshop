/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.petmaster.petmastermaven.servlets.dao;

import br.senac.tads.pi3b.petmaster.petmastermaven.servlets.model.Grupo;
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
@WebServlet(name = "AlterarGrupo", urlPatterns = {"/AlterarGrupo"})

public class AlterarGrupo extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        boolean deletado = false;
        BancoGrupo bancogrupo = new BancoGrupo();

        String acaocliente = String.valueOf(request.getParameter("AcaoCliente"));

        if (acaocliente.equals("alterar")) {

            String nomeGrupo = request.getParameter("nomegrupo");
            String idLoja = request.getParameter("loja");            

            Grupo grupos = new Grupo(nomeGrupo, idLoja);
            bancogrupo.atualizarGrupo(grupos);

            request.setAttribute("mensagem", "Grupo Alterado");

            request.getRequestDispatcher("GerenciamentoGrupo.jsp").forward(request, response);

        } else if (acaocliente.equals("excluir")) {

            deletado = bancogrupo.deletaGrupo(String.valueOf(request.getParameter("nomegrupo")));

            if (deletado == true) {
                request.setAttribute("mensagem", "Grupo Deletado");

                request.getRequestDispatcher("ConsultaGrupo.jsp").forward(request, response);

            } else {

                System.out.println("falhou na hora de deletar");
            }

        }

    }

}
