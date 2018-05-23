<%-- 
    Document   : vender
    Created on : Mar 29, 2018, 12:13:17 PM
    Author     : paulo.bezerra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <link href="topodapagina.css" rel="stylesheet">


    <form action="${pageContext.request.contextPath}/AcaoCadastrar" method="POST" >

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar</title>
    </head>

    <body

<body id="page-top">
    <form>


        <%@include  file="navbar.jsp" %>

        <div align ="center">
            <br>
            <br>
            <br>
            <form  action="AcaoCadastrar"  method="POST">

                <div class="col-md-4 mb-3">
                    <select name ="AcaoCadastrar" class="custom-select d-block w-100" id="acaoproduto" required>
                        <option value="">Selecionar...</option>
                        <option name ="incluir" >Cadastrar Produto</option>
                        <option name ="consultar" >Cadastrar Pet</option>


                    </select>
                    <br>

                    <input type="submit" name="entrar" value ="Entrar" /><br><br>

                </div>  

            </form>

            </body>

            </html>
