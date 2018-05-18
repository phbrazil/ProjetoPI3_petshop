<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Pet Shop</title>

        <!-- Bootstrap core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom fonts for this template -->
        <link href="https://fonts.googleapis.com/css?family=Saira+Extra+Condensed:100,200,300,400,500,600,700,800,900" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">
        <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet">
        <link href="vendor/devicons/css/devicons.min.css" rel="stylesheet">
        <link href="vendor/simple-line-icons/css/simple-line-icons.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <!--link href="css/homepage.css" rel="stylesheet"-->
    </head>
    <body id="page-top">

        <%@include  file="navbar.jsp" %>

        <br>
        <br>
        <br>
        <br>
        <div align ="center">
            <h1 class="mb-0">Já existe um produto com o código <c:out value = "${codigobarras}"></c:out>
                <span class="text-primary"><c:out value="${username}"/></span>
            </h1>
            <img class="mb-4" src="img/LogoPetMaster.png" alt="logo PetMaster" width="200" height="200">


        </div>

        <footer class="my-5 pt-5 text-muted text-center text-small">
            <p class="mb-1">&copy; Javazeiros - Projeto Semestre 3</p>
            <ul class="list-inline">
                <li class="list-inline-item"><a href="#">Privacidade</a></li>
                <li class="list-inline-item"><a href="#">Termos</a></li>
                <li class="list-inline-item"><a href="https://www.google.com">Suporte</a></li>
            </ul>
        </footer>

    </body>

</html>