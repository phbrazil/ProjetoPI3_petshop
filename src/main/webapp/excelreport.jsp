<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html">
<%@page import="java.util.List"%>
<%@page import="br.senac.tads.pi3b.petmaster.petmastermaven.servlets.model.Produtos"%>
<html>
    <head>
    <form name = "Carrinho" action="${pageContext.request.contextPath}/Carrinho" method="POST" >

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Export Excel</title>
    </head>
    <body>
        <h1>Export to Excel Example</h1>
        <table cellpadding="1"  cellspacing="1" border="1" bordercolor="gray">
            <tr>
                <td>First Name</td>
                <td>Last Name</td>
                <td>Age</td>
            </tr>
            <%
                List<Produtos> employees = (List<Produtos>) request.getAttribute("employees");
                if (employees != null) {
                    response.setContentType("application/vnd.ms-excel");
                    response.setHeader("Content-Disposition", "inline; filename=" + "employeereport.xls");
                }
                for (Produtos e : employees) {
            %>
            <tr>
                <td><%=e.getNomeprod()%></td>   
                <td><%=e.getCodigoprod()%></td>
                <td><%=e.getDescricaoprod()%></td>
            </tr>
            <%
                }
            %>
        </table>
    </body>
</form>
</html>