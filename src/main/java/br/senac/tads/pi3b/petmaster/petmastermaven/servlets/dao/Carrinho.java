/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.petmaster.petmastermaven.servlets.dao;

import br.senac.tads.pi3b.petmaster.petmastermaven.servlets.model.Pets;
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
@WebServlet(name = "Carrinho", urlPatterns = {"/Carrinho"})

public class Carrinho extends HttpServlet {

    List<Produtos> carrinho = new ArrayList<>();

    List<String> produtosListagem;
    List<String> petsListagem;

    double total = 0;
    String quantidade = null;
    int quantconvert = 0;

    List<String> produtosListagemCodigo;
    List<String> petsListagemCodigo;

    Produtos produtos = new Produtos(null, 0, null, null, 0, null);
    Pets pets = new Pets(null, 0, null, null, 0, null);
    String codigovenda;
    String cpfcliente;
    String nomecliente;
    BancoProd bancoprod = new BancoProd();
    BancoPet bancopet = new BancoPet();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acaovenda = request.getParameter("acaovenda");

        cpfcliente = request.getParameter("cpfcliente");
        nomecliente = request.getParameter("nomecliente");
        quantidade = request.getParameter("quantidade");

        try {
            // the String to int conversion happens here
            quantconvert = Integer.parseInt(quantidade.trim());

            // print out the value after the conversion
            System.out.println("int quantconvert = " + quantconvert);
        } catch (NumberFormatException nfe) {
            System.out.println("NumberFormatException: " + nfe.getMessage());
        }

        if (acaovenda.equals("Adicionar no Carrinho")) {

            produtos = null;
            pets = null;
            codigovenda = null;

            // Recupera o nome enviado na requisição
            codigovenda = request.getParameter("codigovenda");

            produtos = bancoprod.PesquisarProduto(codigovenda);

            // Valida se nome não é nulo
            if (produtos.getNomeprod() != null) {

                carrinho.add(produtos);

                carrinho.get(0).getValorprod();

                total = total + (produtos.getValorprod() * quantconvert);

                // Obtém a sessão do usuário
                HttpSession sessao = request.getSession();

                // Se a lista de nomes não estiver na sessão, cria nova
                if (sessao.getAttribute("produtosNome") == null) {
                    produtosListagem = new ArrayList<>();
                    produtosListagemCodigo = new ArrayList<>();
                    sessao.setAttribute("produtosNome", produtosListagem);
                    sessao.setAttribute("produtosCodigo", produtosListagemCodigo);

                }

                // Recupera a lista a partir da sessão do usuário e adiciona nome
                produtosListagem = (List<String>) sessao.getAttribute("produtosNome");
                produtosListagemCodigo = (List<String>) sessao.getAttribute("produtosCodigo");
                produtosListagem.add(produtos.getNomeprod());
                produtosListagemCodigo.add(produtos.getCodigoprod());

                // Atualiza a lista na sessão
                sessao.setAttribute("produtosNome", produtosListagem);
                sessao.setAttribute("produtosCodigo", produtosListagemCodigo);
                sessao.setAttribute("nomecliente", nomecliente);
                sessao.setAttribute("cpfcliente", cpfcliente);
                sessao.setAttribute("total", total);

                sessao.setAttribute("carrinho", carrinho);

                request.getRequestDispatcher("Vender.jsp").forward(request, response);

            } else {
                request.setAttribute("mensagem", "Produto não encontrado");

                request.getRequestDispatcher("Vender.jsp").forward(request, response);

            }

        } else if (acaovenda.equals("Finalizar Venda")) {

            HttpSession sessao = request.getSession();
            sessao.invalidate();
            request.getRequestDispatcher("VendaSuccess.jsp").forward(request, response);

        }
    }

}
