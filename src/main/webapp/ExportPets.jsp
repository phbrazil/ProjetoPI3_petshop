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
        <h1>Report Pets</h1>


        <table>

            <%

                ResultSet exportar = (ResultSet) request.getAttribute("exportarpets");

                while (exportar.next()) {


            %>
            <tr>
                <td><%=exportar.getString("codigobarraspet")%></td>
                <td><%=exportar.getString("nomepet")%></td>
                <td><%=exportar.getString("valorpet")%></td>
                <td><%=exportar.getString("datacadastropet")%></td>
                <td><%=exportar.getString("descricaopet")%></td>
                <td><%=exportar.getString("categoriapet")%></td>
                <td><%=exportar.getString("quantidadepet")%></td>
            </tr>   
            <%
                }
                response.setContentType("application/vnd.ms-excel");
                response.setHeader("Content-Disposition", "inline; filename=" + "Petsreport.xls");
            %>
        </table>
    </body>
</html>
