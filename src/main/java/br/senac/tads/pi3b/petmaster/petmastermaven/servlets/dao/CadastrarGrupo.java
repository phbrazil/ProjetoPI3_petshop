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
@WebServlet(name = "CadastrarGrupo", urlPatterns = {"/CadastrarGrupo"})

public class CadastrarGrupo extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idgrupo = request.getParameter("idgrupo");
        String nomeGrupo = request.getParameter("nomegrupo");
        String idloja = request.getParameter("idloja");
        
        BancoGrupo bancoGrupo = new BancoGrupo();

        int qtdclicadastrado = bancoGrupo.ValidaCadastradoLoja(nomeGrupo);

        if (qtdclicadastrado == 0) {
            
            Grupo grupo = new Grupo(nomeGrupo, idloja);
            
            bancoGrupo.gravarGrupo(grupo);
            request.setAttribute("nomeloja", nomeGrupo);
            request.setAttribute("mensagem", "Loja cadastrada com sucesso!");

            request.getRequestDispatcher("CadastrarLoja.jsp").forward(request, response);

        } else {

            request.setAttribute("nomeGrupo", nomeGrupo);
            request.setAttribute("mensagem", "falha");

            request.getRequestDispatcher("CadastrarCliente.jsp").forward(request, response);

        }

    }

}
