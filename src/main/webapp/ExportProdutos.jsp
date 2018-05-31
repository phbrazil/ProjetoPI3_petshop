<%-- 
    Document   : Export
    Created on : May 31, 2018, 2:10:32 PM
    Author     : paulo.bezerra
--%>

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
        <h1>Report Produtos</h1>


        <table>

            <%

                ResultSet exportar = (ResultSet) request.getAttribute("exportarprodutos");

                while (exportar.next()) {


            %>
            <tr>
                <td><%=exportar.getString("codigobarrasprod")%></td>
                <td><%=exportar.getString("nomeprod")%></td>
                <td><%=exportar.getDouble("valor")%></td>
                <td><%=exportar.getDate("datacadastroprod")%></td>
                <td><%=exportar.getString("descricaoprod")%></td>
                <td><%=exportar.getString("categoriaprod")%></td>
                <td><%=exportar.getInt("quantidadeprod")%></td>
            </tr>   
            <%
                }
                response.setContentType("application/vnd.ms-excel");
                response.setHeader("Content-Disposition", "inline; filename=" + "Produtosreport.xls");
            %>
        </table>
    </body>
</html>
