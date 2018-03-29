<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Pet Shop</title>
    </head>
    <body>
        <br/><br/>

        <h1 align = "center">
            Bem-Vindo  
            <c:out value="${username}" />
            <br>

        </h1>

        <div align = "center">


            <a href ="consultaprod.jsp">Consultar Produto</a><br><br>
            <a href ="consultapet.jsp">Consultar Pet</a><br><br>
            <a href ="catalogo.jsp">Catálogo de Serviços</a><br><br>
            <a href ="consultaagend.jsp">Agendar Consulta</a><br><br>
            <a href ="vender.jsp">Vender</a><br><br>
            <a href ="atualizarestoque.jsp">Atualizar Estoque</a><br><br>
            <a href ="relatorios.jsp">Relatórios</a><br><br>

        </div>

        <div align = "center">
            <input type ="button" value ="Voltar" onclick="history.back()">    
        </div>
    </body>
</html>