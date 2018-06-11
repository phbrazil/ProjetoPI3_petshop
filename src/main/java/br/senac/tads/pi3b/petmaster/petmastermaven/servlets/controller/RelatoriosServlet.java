/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.petmaster.petmastermaven.servlets.controller;

import br.senac.tads.pi3b.petmaster.petmastermaven.dao.BancoSessao;
import br.senac.tads.pi3b.petmaster.petmastermaven.dao.Clientes;
import br.senac.tads.pi3b.petmaster.petmastermaven.dao.InserirCarrinho;
import br.senac.tads.pi3b.petmaster.petmastermaven.dao.ProdutosDAO;
import br.senac.tads.pi3b.petmaster.petmastermaven.dao.Relatorios;
import br.senac.tads.pi3b.petmaster.petmastermaven.model.Pets;
import br.senac.tads.pi3b.petmaster.petmastermaven.model.Produtos;
import java.awt.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author paulo.bezerra
 */
@WebServlet(name = "RelatoriosServlet", urlPatterns = {"/RelatoriosServlet"})
public class RelatoriosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acaoreport = request.getParameter("acaoreport");

        HttpSession sessao = request.getSession();

        BancoSessao bancosessao = new BancoSessao();

        String sessaoid = sessao.getId();

        String vendedor = bancosessao.Vendedor(sessaoid);

        if (vendedor != null) {

            if (acaoreport.equals("ListarClientes")) {

                ResultSet exportarclientes = null;

                Clientes bancoclientes = new Clientes();

                exportarclientes = bancoclientes.PesquisarClientesGeral();

                request.setAttribute("clientes", exportarclientes);

                request.getRequestDispatcher("EstoqueClientes.jsp").forward(request, response);

            } else if (acaoreport.equals("ListarProdutos")) {

                ResultSet exportarprodutos = null;

                ProdutosDAO bancoprodutos = new ProdutosDAO();

                exportarprodutos = bancoprodutos.PesquisarProdutosGeral();

                request.setAttribute("produtos", exportarprodutos);

                request.getRequestDispatcher("EstoqueProd.jsp").forward(request, response);

            }

        } else {

            request.setAttribute("mensagem", "Sessão Expirada");

            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sessao = request.getSession();

        String acaoreport = request.getParameter("acaoreport");

        String inicio = request.getParameter("inicio");
        String fim = request.getParameter("fim");

        Relatorios relatorios = new Relatorios();
        ResultSet vendas;
        ResultSet exportarVendas;

        BancoSessao bancosessao = new BancoSessao();

        String sessaoid = sessao.getId();

        int idloja = bancosessao.idLoja(sessaoid);

        if (acaoreport.equals("Gerar Venda")) {

            sessao.setAttribute("inicio", inicio);
            sessao.setAttribute("fim", fim);

            vendas = relatorios.Vendas(inicio, fim, idloja);

            request.setAttribute("vendas", vendas);

            request.getRequestDispatcher("ReportVendasResult.jsp").forward(request, response);

        } else if (acaoreport.equals("ExportarVendas")) {

            inicio = request.getParameter("inicio");
            fim = request.getParameter("fim");

            exportarVendas = relatorios.Vendas(inicio, fim, idloja);

            request.setAttribute("exportar", exportarVendas);

            request.getRequestDispatcher("/Exportar/ExportVendas.jsp").forward(request, response);

        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
