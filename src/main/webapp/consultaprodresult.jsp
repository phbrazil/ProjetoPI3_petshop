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



<%-- 
    Document   : consultarprod
    Created on : Mar 29, 2018, 12:13:17 PM
    Author     : paulo.bezerra
--%>


<!DOCTYPE html>
<html>
    <head>
        <!-- Bootstrap core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom fonts for this template -->
        <link href="https://fonts.googleapis.com/css?family=Saira+Extra+Condensed:100,200,300,400,500,600,700,800,900" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">
        <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet">
        <link href="vendor/devicons/css/devicons.min.css" rel="stylesheet">
        <link href="vendor/simple-line-icons/css/simple-line-icons.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/topodapagina.css" rel="stylesheet">
    <form action="consultaprod" method="POST" >

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consultar Produto</title>
    </head>
    <body id="page-top">
        <form>

            <nav class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top" id="sideNav">

                <a class="navbar-brand js-scroll-trigger" href="#page-top">
                    <span class="d-block d-lg-block">Bem-Vindo <c:out value="${username}" /></span>
                    <span class="d-none d-lg-block">
                        <!--img class="img-fluid img-profile rounded-circle mx-auto mb-2" src="img/senac.jpg" alt=""-->
                    </span>
                </a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link js-scroll-trigger" href="consultaprod.jsp">Consultar Produto</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link js-scroll-trigger" href="consultapet.jsp">Consultar Pet</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link js-scroll-trigger" href="atualizarestoque.jsp">Atualizar Estoque</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link js-scroll-trigger" href="catalogo.jsp">Catálogo de Serviços</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link js-scroll-trigger" href="vender.jsp">Vender</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link js-scroll-trigger" href="relatorios.jsp">Relatórios</a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link js-scroll-trigger" href="index.html">Sair</a>
                        </li>
                    </ul>
                </div>
            </nav>

            <div align ="center">
                <br>
                <br>
                <br>

                <h1 >Consultar Produto</h1>
                <h2>Resultado</h2>

                <input type="text" name="consultaprod" />
                <input type="submit" name="pesquisar" value ="Pesquisar" /><br><br>

            </div>   

            <li align ="center">
                <h3>Nome: <c:out value="${resultado.nome}" /></h3>
                <h3>Valor: R$<c:out value="${resultado.valor}" /></h3>
                <h3>Data de Cadastro: <fmt:formatDate type = "both" 
                                dateStyle = "short" timeStyle = "short" value ="${resultado.dtCadastro}"/></h3>
                <h3>Quantidade disponível: <c:out value="${resultado.qtdestoque}" /></h3>

            </li>
            </ul>
            <div align = "center">
                <input type ="button" value ="Voltar" onclick="history.back()">    
            </div>


    </body>
</html>


