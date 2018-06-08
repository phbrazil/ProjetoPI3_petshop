/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.petmaster.petmastermaven.servlets.controller;

import br.senac.tads.pi3b.petmaster.petmastermaven.servlets.dao.BancoCarrinho;
import br.senac.tads.pi3b.petmaster.petmastermaven.servlets.dao.BancoItemVenda;
import br.senac.tads.pi3b.petmaster.petmastermaven.servlets.dao.BancoNovaVenda;
import br.senac.tads.pi3b.petmaster.petmastermaven.servlets.dao.BancoPet;
import br.senac.tads.pi3b.petmaster.petmastermaven.servlets.dao.BancoProd;
import br.senac.tads.pi3b.petmaster.petmastermaven.servlets.dao.BancoSessao;
import br.senac.tads.pi3b.petmaster.petmastermaven.servlets.model.Pets;
import br.senac.tads.pi3b.petmaster.petmastermaven.servlets.model.Produtos;
import br.senac.tads.pi3b.petmaster.petmastermaven.servlets.model.Vendas;
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

    List<String> produtosListagem;
    List<String> petsListagem;

    double total = 0;
    int quantidadetotal = 0;
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
    List<Produtos> carrinho = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sessao = request.getSession();

        BancoSessao bancosessao = new BancoSessao();

        BancoCarrinho bancocarrinho = new BancoCarrinho();

        String sessaoid = sessao.getId();

        String vendedor = bancosessao.Vendedor(sessaoid);

        if (vendedor == null) {

            request.setAttribute("mensagem", "Sessão Expirada");

            request.getRequestDispatcher("index.jsp").forward(request, response);

        }

        ResultSet carrinhoresult;
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
            pets = null;

            // Recupera o nome enviado na requisição
            codigovenda = request.getParameter("codigovenda");

            produtos = bancoprod.PesquisarProduto(codigovenda);

            // Valida se nome não é nulo
            if (produtos.getNomeprod() != null) {

                quantidadetotal = quantidadetotal + quantconvert;

                produtos.setItensvenda(Integer.valueOf(quantidade));

                total = total + (produtos.getValorprod() * quantconvert);

                // Se a lista de nomes não estiver na sessão, cria nova
                if (sessao.getAttribute("carrinho") == null) {
                    carrinho = new ArrayList<>();

                }

                carrinho.add(produtos);

                bancocarrinho.GravarCarrinho(produtos, sessaoid, vendedor);

                sessao.setAttribute("total", String.format("%.2f", total));

                produtos = null;
                codigovenda = null;

                request.setAttribute("sessaoid", sessaoid);
                request.setAttribute("carrinho", carrinho);

                carrinhoresult = null;
                request.getRequestDispatcher("Vender.jsp").forward(request, response);

                //request.getRequestDispatcher("Exportar/ExportCarrinho.jsp").forward(request, response);
            } else {

                codigovenda = null;

                produtos = null;

                carrinhoresult = null;

                request.setAttribute("mensagem", "Produto não encontrado");

                request.getRequestDispatcher("Vender.jsp").forward(request, response);

            }

        } else if (acaovenda.equals("DeletarCarrinho")) {

            String deletaprod = request.getParameter("codigobarrasprod");

            bancocarrinho = new BancoCarrinho();

            bancocarrinho.DeletaProdCarrinho(sessaoid, deletaprod);

            request.setAttribute("sessaoid", sessaoid);

            request.getRequestDispatcher("Vender.jsp").forward(request, response);

        } else if (acaovenda.equals("Finalizar Venda")) {

            Vendas vendas = new Vendas();

            BancoNovaVenda novavenda = new BancoNovaVenda();
            BancoItemVenda itemvenda = new BancoItemVenda();

            vendas.setCPFCliente(cpfcliente);
            vendas.setTotalValor(total);
            vendas.setQuantidadeItensVenda(quantidadetotal);
            vendas.setVendedor(vendedor);

            novavenda.InsertNovaVenda(vendas);

            itemvenda.InsertItemTemp(carrinho, vendas);

            produtos = null;
            pets = null;
            codigovenda = null;
            carrinho = new ArrayList<>();

            request.setAttribute("mensagem", "Venda Efetuada com Sucesso");

            request.getRequestDispatcher("PesquisarCPF.jsp").forward(request, response);

        } else if (acaovenda.equals("Cancelar Venda")) {

            bancocarrinho.LimpaCarrinho(sessaoid);

            produtos = null;
            pets = null;
            codigovenda = null;
            carrinho = new ArrayList<>();
            request.setAttribute("mensagem", "Venda Cancelada");

            request.getRequestDispatcher("PesquisarCPF.jsp").forward(request, response);

        }
    }

}
