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


        <table border='1' cellpadding='5' width='800'>

            <tr>
                <td>Código do Produto</td>
                <td>Nome do Produto</td>
                <td>Valor do Produto</td>
                <td>Vendedor do Produto</td>
                <td>Quantidade do Produto</td>
            </tr>

            <%
                request.setAttribute("carrinho",null);

                ResultSet exportar = (ResultSet) request.getAttribute("carrinho");

                while (exportar.next()) {


            %>
            <tr>
                <td><%=exportar.getString("codigobarrasprod")%></td>
                <td><%=exportar.getString("nomeprod")%></td>
                <td>R$<%=exportar.getDouble("valorprod")%></td>
                <td><%=exportar.getString("vendedor")%></td>
                <td><%=exportar.getInt("quantidadeitens")%></td>
            </tr>   
            <%
                    // }
                }
                //response.setContentType("application/vnd.ms-excel");
                //response.setHeader("Content-Disposition", "inline; filename=" + "Produtosreport.xls");
            %>
        </table>
    </body>
</html>
