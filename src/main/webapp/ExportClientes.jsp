<%-- 
    Document   : Export
    Created on : May 31, 2018, 2:10:32 PM
    Author     : killuminatti08
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
        <h1>Report Clientes</h1>


        <table>

            <%

                ResultSet exportar = (ResultSet) request.getAttribute("exportarcliente");

                while (exportar.next()) {


            %>
            <tr>
                <td><%=exportar.getString("cpfcliente")%></td> 
                <td><%=exportar.getString("rg")%></td> 
                <td><%=exportar.getString("nome")%></td> 
                <td><%=exportar.getString("logradouro")%></td> 
                <td><%=exportar.getString("bairro")%></td> 
                <td><%=exportar.getString("cidade")%></td> 
                <td><%=exportar.getString("estado")%></td> 
                <td><%=exportar.getString("uf")%></td> 
                <td><%=exportar.getString("pais")%></td> 
                <td><%=exportar.getString("cep")%></td> 
                <td><%=exportar.getString("telefone")%></td> 
                <td><%=exportar.getString("celular")%></td> 
                <td><%=exportar.getString("email")%></td> 
                <td><%=exportar.getString("sexo")%></td> 
                <td><%=exportar.getString("estado")%></td> 
                <td><%=exportar.getString("estadocivil")%></td> 
                <td><%=exportar.getString("nascimento")%></td> 
            </tr>   
            <%
                }
                response.setContentType("application/vnd.ms-excel");
                response.setHeader("Content-Disposition", "inline; filename=" + "Clientereport.xls");
            %>
        </table>
    </body>
</html>
