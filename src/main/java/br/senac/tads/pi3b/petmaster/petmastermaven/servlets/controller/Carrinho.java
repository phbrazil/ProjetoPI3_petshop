/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.petmaster.petmastermaven.servlets.controller;

import br.senac.tads.pi3b.petmaster.petmastermaven.dao.InserirCarrinho;
import br.senac.tads.pi3b.petmaster.petmastermaven.dao.ItemVenda;
import br.senac.tads.pi3b.petmaster.petmastermaven.dao.NovaVenda;
import br.senac.tads.pi3b.petmaster.petmastermaven.dao.Pet;
import br.senac.tads.pi3b.petmaster.petmastermaven.dao.ProdutosDAO;
import br.senac.tads.pi3b.petmaster.petmastermaven.dao.BancoSessao;
import br.senac.tads.pi3b.petmaster.petmastermaven.model.Pets;
import br.senac.tads.pi3b.petmaster.petmastermaven.model.Produtos;
import br.senac.tads.pi3b.petmaster.petmastermaven.model.Vendas;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    double total = 0;
    int quantidadetotal = 0;
    String quantidade = null;
    int quantconvert = 0;

    Produtos produtos = new Produtos(null, 0, null, null, 0, null, 0);
    String codigovenda;
    String cpfcliente;
    String nomecliente;
    ProdutosDAO bancoprod = new ProdutosDAO();
    List<Produtos> carrinho = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sessao = request.getSession();

        BancoSessao bancosessao = new BancoSessao();

        InserirCarrinho bancocarrinho = new InserirCarrinho();

        String sessaoid = sessao.getId();
        
        int idloja = bancosessao.idLoja(sessaoid);
        
        System.out.println("to no servlet"+idloja);

        String vendedor = bancosessao.Vendedor(sessaoid);

        if (vendedor == null) {

            request.setAttribute("mensagem", "Sessão Expirada");

            request.getRequestDispatcher("index.jsp").forward(request, response);

        }

        codigovenda = null;

        // Obtém a sessão do usuário
        String acaovenda = request.getParameter("acaovenda");

        cpfcliente = request.getParameter("cpfcliente");
        nomecliente = request.getParameter("nomecliente");
        quantidade = request.getParameter("quantidade");

        try {

            quantconvert = Integer.parseInt(quantidade.trim());

        } catch (NumberFormatException nfe) {
            System.out.println("NumberFormatException: " + nfe.getMessage());
        }

        if (acaovenda.equals("Adicionar no Carrinho")) {

            produtos = null;

            // Recupera o nome enviado na requisição
            codigovenda = request.getParameter("codigovenda");

            produtos = bancoprod.PesquisarProduto(codigovenda);

            // Valida se nome não é nulo
            if (produtos.getNomeprod() != null) {

                quantidadetotal = quantidadetotal + quantconvert;

                produtos.setItensvenda(Integer.valueOf(quantidade));

                total = total + (produtos.getValorprod() * quantconvert);

                carrinho.add(produtos);

                bancocarrinho.GravarCarrinho(produtos, sessaoid, vendedor);

                sessao.setAttribute("total", String.format("%.2f", total));

                produtos = null;
                codigovenda = null;

                request.setAttribute("sessaoid", sessaoid);
                request.setAttribute("carrinho", carrinho);

                request.getRequestDispatcher("Vender.jsp").forward(request, response);

            } else {

                codigovenda = null;

                produtos = null;


                request.setAttribute("mensagem", "Produto não encontrado");

                request.getRequestDispatcher("Vender.jsp").forward(request, response);

            }

        } else if (acaovenda.equals("DeletarCarrinho")) {

            String deletaprod = request.getParameter("codigobarrasprod");

            bancocarrinho = new InserirCarrinho();

            bancocarrinho.DeletaProdCarrinho(sessaoid, deletaprod);

            request.setAttribute("sessaoid", sessaoid);

            request.getRequestDispatcher("Vender.jsp").forward(request, response);

        } else if (acaovenda.equals("Finalizar Venda")) {

            Vendas vendas = new Vendas();

            NovaVenda novavenda = new NovaVenda();
            ItemVenda itemvenda = new ItemVenda();

            vendas.setCPFCliente(cpfcliente);
            vendas.setTotalValor(total);
            vendas.setQuantidadeItensVenda(quantidadetotal);
            vendas.setVendedor(vendedor);
            vendas.setIdloja(idloja);

            novavenda.InsertNovaVenda(vendas);

            itemvenda.InsertItemTemp(carrinho, vendas);

            vendas = null;
            produtos = null;
            codigovenda = null;
            carrinho = new ArrayList<>();

            bancocarrinho.LimpaCarrinho(sessaoid);

            request.setAttribute("mensagem", "Venda Efetuada com Sucesso");

            request.getRequestDispatcher("PesquisarCPF.jsp").forward(request, response);

        } else if (acaovenda.equals("Cancelar Venda")) {

            bancocarrinho.LimpaCarrinho(sessaoid);

            produtos = null;
            codigovenda = null;
            carrinho = new ArrayList<>();
            request.setAttribute("mensagem", "Venda Cancelada");

            request.getRequestDispatcher("PesquisarCPF.jsp").forward(request, response);

        }
    }

}
