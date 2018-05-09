
package br.senac.tads.pi3b.petmaster.petmastermaven.servlets.controller;

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
@WebServlet(name = "reset", urlPatterns = {"/reset"})
public class reset extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String emailreset = request.getParameter("emailreset");

        if (emailreset == null || !emailreset.contains("@")) {
            request.getRequestDispatcher("loginError.jsp").forward(request, response);

        } else {
            request.getRequestDispatcher("index.html").forward(request, response);

        }

    }

}
