/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.petmaster.petmastermaven.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Paulo.Bezerra
 */
@WebServlet(name = "Home", urlPatterns = {"/Home"})

public class login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username.equals("paulo@senac.com") && password.equals("123")
                || username.equals("lucas@senac.com") && password.equals("123")
                || username.equals("pedro@senac.com") && password.equals("123")
                || username.equals("andre@senac.com") && password.equals("123")) {
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            request.getRequestDispatcher("Home.jsp").forward(request, response);


        } else {
            request.getRequestDispatcher("loginerror.jsp").forward(request, response);

        }

    }

}
