<%-- 
    Document   : relatorios
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
        <!--link href="css/homepage.min.css" rel="stylesheet"-->
        <link href="topodapagina.css" rel="stylesheet">

    <form action="relatorios" method="POST" >

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Relatórios</title>
    </head>
    <body id="page-top">
        <form>


            <nav class="navbar navbar-expand-lg navbar-dark bg-info fixed-top" id="sideNav">

                <a class="navbar-brand js-scroll-trigger" href="Home.jsp">
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

                <h1 >Relatórios</h1><br>

                <div class="col-md-4 mb-3">
                    <label for="tiporeport">Tipo de relatório</label>
                    <select class="custom-select d-block w-100" id="estado" required>
                        <option value="">Selecionar...</option>
                        <option>Todos os Produtos</option>
                        <option>Todos os Pets</option>

                    </select>
                    <br>


                    <input type="submit" name="exportar" value ="Exportar" /><br><br>





                </div>        

                <footer class="my-5 pt-5 text-muted text-center text-small">
                    <p class="mb-1">&copy; Javazeiros - Projeto Semestre 3</p>
                    <ul class="list-inline">
                        <li class="list-inline-item"><a href="#">Privacidade</a></li>
                        <li class="list-inline-item"><a href="#">Termos</a></li>
                        <li class="list-inline-item"><a href="https://www.google.com">Suporte</a></li>
                    </ul>
                </footer>
            </div>
    </body>
</html>
