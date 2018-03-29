<%-- 
    Document   : consultaprodresult
    Created on : Mar 29, 2018, 12:44:33 PM
    Author     : paulo.bezerra
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.senac.tads.pi3b.petmaster.petmastermaven.servlets.Produtos"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado</title>
    </head>
    <body>
        <h1>Dados dos produtos</h1>
        <ul>
            <li>
                <h2>Nome: <c:out value="${resultado.nome}" /></h2>
                <h3>Valor: R$<c:out value="${resultado.valor}" /></h3>
                <h4>Data de Cadastro: <fmt:formatDate type = "both" 
                                dateStyle = "short" timeStyle = "short" value ="${resultado.dtCadastro}"/></h4>

            </li>
        </ul>
        <div align = "center">
            <input type ="button" value ="Voltar" onclick="history.back()">    
        </div>

    </body>
</html>
