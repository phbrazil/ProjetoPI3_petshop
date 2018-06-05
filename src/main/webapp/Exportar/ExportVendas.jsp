<%-- 
    Document   : Export
    Created on : May 31, 2018, 2:10:32 PM
    Author     : paulo.bezerra
--%>

<%@page import="br.senac.tads.pi3b.petmaster.petmastermaven.servlets.dao.Relatorios"%>
<%@page import="br.senac.tads.pi3b.petmaster.petmastermaven.servlets.model.Cliente"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Export</title>
    </head>
    <body>
        <h1>Report de Vendas</h1>


        <table>
            <tr>
                <td>CPF do Cliente</td>

            </tr>

            <%
                Relatorios vendas = new Relatorios();

                String inicio = (String) request.getAttribute("inicio");
                String fim = (String) request.getAttribute("fim");

                ResultSet exportar = vendas.Vendas(inicio, fim);


                while (exportar.next()) {


            %>
            <tr>
                <td><%=exportar.getString("cpfcliente")%></td>

            </tr>   
            <%
                }
                response.setContentType("application/vnd.ms-excel");
                response.setHeader("Content-Disposition", "inline; filename=" + "VendasReport.xls");
            %>
        </table>
    </body>
</html>
