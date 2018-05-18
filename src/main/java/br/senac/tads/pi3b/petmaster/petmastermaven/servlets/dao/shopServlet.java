/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.petmaster.petmastermaven.servlets.dao;

import br.senac.tads.pi3b.petmaster.petmastermaven.servlets.model.Produtos;
import br.senac.tads.pi3b.petmaster.petmastermaven.servlets.model.Sessao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
@WebServlet(name = "shopServlet", urlPatterns = {"/shopServlet"})

public class shopServlet extends HttpServlet {

    List<String> produtosListagem;
    List<String> produtosListagemCodigo;

    Produtos produtos = new Produtos(null, 0, null, null, 0, null);

    bancoProd bancoprod = new bancoProd();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        produtos = null;

        // Recupera o nome enviado na requisição
        String codigoprod = request.getParameter("codigoprod");
        produtos = bancoprod.PesquisarProduto(codigoprod);
        
        System.out.println(produtos.getNomeprod()+" nome aqui");

        // Valida se nome não é nulo
        if (produtos.getNomeprod()!=null) {

            // Obtém a sessão do usuário
            HttpSession sessao = request.getSession();

            // Se a lista de nomes não estiver na sessão, cria nova
            if (sessao.getAttribute("produtos") == null) {
                produtosListagem = new ArrayList<>();
                produtosListagemCodigo = new ArrayList<>();

                sessao.setAttribute("produtos", produtosListagem);
                sessao.setAttribute("produtosCodigo", produtosListagemCodigo);

            }

            // Recupera a lista a partir da sessão do usuário e adiciona nome
            produtosListagem = (List<String>) sessao.getAttribute("produtos");
            produtosListagemCodigo = (List<String>) sessao.getAttribute("produtosCodigo");

            produtosListagem.add(produtos.getNomeprod());
            produtosListagemCodigo.add(produtos.getCodigoprod());

            // Atualiza a lista na sessão
            sessao.setAttribute("produtos", produtosListagem);
            sessao.setAttribute("produtosCodigo", produtosListagemCodigo);
            request.getRequestDispatcher("vender.jsp").forward(request, response);

        } else {
            request.setAttribute("mensagem", "Produto não encontrado");

            request.getRequestDispatcher("vender.jsp").forward(request, response);

        }

    }

}
