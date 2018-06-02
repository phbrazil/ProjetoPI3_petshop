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
        <h1>Report Clientes</h1>

        <table>

            <tr>
                <td>CPF do Cliente</td>
                <td>RG do Cliente</td>
                <td>Nome do Cliente</td>
                <td>Logradouro do Cliente</td>
                <td>Bairro do Cliente</td>
                <td>Cidade do Cliente</td>
                <td>Estado do Cliente</td>
                <td>UF do Cliente</td>
                <td>País do Cliente</td>
                <td>CEP do Cliente</td>
                <td>Telefone do Cliente</td>
                <td>Celular do Cliente</td>
                <td>Email do Cliente</td>
                <td>Sexo do Cliente</td>
                <td>Estado Civil do Cliente</td>
                <td>Nascimento do Cliente</td>

            </tr>

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
