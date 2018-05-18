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

    final Map<String, String> produtosList = new HashMap<>();

    List<Produtos> produtoslistagem = new ArrayList<Produtos>();

    Produtos produtos = new Produtos(null, 0, null, null, 0, null);

    bancoProd bancoprod = new bancoProd();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sessao = request.getSession();

        String codigoprod = request.getParameter("codigoprod");

        produtos = bancoprod.PesquisarProduto(codigoprod);

        if (produtos.getNomeprod() != null) {
            

            produtoslistagem.add(produtos);
            System.out.println(produtoslistagem.size()+" tamanho");

            //System.out.println(produtoslistagem.get(0).getCodigoprod());

            sessao.setAttribute("produtos", produtoslistagem);
            sessao.setAttribute("quantidade", produtoslistagem.size());
            sessao.setAttribute("posicao", produtoslistagem.size()-1);

            request.getRequestDispatcher("vender.jsp").forward(request, response);
            
        /*} else {
            
            System.out.println("fudeu");
            sessao.setAttribute("mensagem", "Produto não encontrado");
            request.getRequestDispatcher("vender.jsp").forward(request, response);

        */
        
        }

        //HttpSession sessaoatual = null;
        //Sessao sessao = new Sessao();
        //sessaoatual = request.getSession();
        String action = request.getParameter("action");
        if (action == null) {
            action = "browse";
        }

        switch (action) {
            case "addToCart":
                this.addToCart(request, response);
                break;
            case "viewCart":
                this.viewCart(request, response);
                break;

        }

    }

    @SuppressWarnings("unchecked")
    private void viewCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Integer> cart = (Map<String, Integer>) req.getSession().getAttribute("cart");
        req.setAttribute("cart", cart);
        req.getRequestDispatcher("viewCart.jsp").forward(req, resp);
    }

    @SuppressWarnings("unchecked")
    private void addToCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer productId = Integer.parseInt(req.getParameter("productId"));

        HttpSession session = req.getSession();
        if (session.getAttribute("cart") == null) {
            session.setAttribute("cart", new HashMap<String, Integer>());
        }

        Map<String, Integer> cart = (Map<String, Integer>) session.getAttribute("cart");

        if (cart.containsKey(produtosList.get(productId))) {
            cart.put(produtosList.get(productId), cart.get(produtosList.get(productId)) + 1);
        } else {
            cart.put(produtosList.get(productId), 1);
        }

        //resp.sendRedirect("shop?action=viewCart");
    }

}
