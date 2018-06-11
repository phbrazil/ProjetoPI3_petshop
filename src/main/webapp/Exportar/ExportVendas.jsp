<%-- 
    Document   : Export
    Created on : May 31, 2018, 2:10:32 PM
    Author     : paulo.bezerra
--%>

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
                <td>Data da Venda</td>
                <td>Quantidade de itens</td>
                <td>Vendedor</td>
                <td>Total Valor</td>

            </tr>

            <%

                ResultSet exportar = (ResultSet) request.getAttribute("exportar");

                while (exportar.next()) {


            %>
            <tr>
                <td><%=exportar.getString("cpfcliente")%></td>
                <td><%=exportar.getString("datavenda")%></td>
                <td><%=exportar.getString("quantidadeitens")%></td>
                <td><%=exportar.getString("vendedor")%></td>
                <td>R$<%=exportar.getString("totalvalor")%></td>
            </tr>   
            <%
                }
                response.setContentType("application/vnd.ms-excel");
                response.setHeader("Content-Disposition", "inline; filename=" + "VendasReport.xls");
            %>
        </table>
    </body>
</html>
