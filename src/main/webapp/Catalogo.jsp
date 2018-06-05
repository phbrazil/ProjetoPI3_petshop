<%-- 
    Document   : catalogo
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
        <link href="css/topodapagina.css" rel="stylesheet">
    <form action="catalogo" method="POST" >

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Catálogo</title>
    </head>
    <style>
        .dropdown {
            position: relative;
            display: inline-block;

        }

        .dropdown-content {
            display: none;
            position: absolute;
            background-color: #f9f9f9;
            min-width: 190px;
            box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
            padding: 12px 16px;
            z-index: 1;
        }

        .dropdown:hover .dropdown-content {
            display: block;
        }
    </style>
    <body id="page-top">
        <form>

            <%@include  file="navbar.jsp" %>

            <div align ="center">
                <br>

                <h1 >Catálogo de Serviços</h1><br>

                <div class="dropdown">
                    <a class="nav-link js-scroll-trigger"><img src ="img/hotelzinho.png" width="310" height="200"></a>
                    <div class="dropdown-content">
                        <p><a style="text-decoration:none;">Hotelzinho com Pet espaço. Diária R$20,00.</a></p>

                    </div>
                </div>
                <br>
                <div class="dropdown">
                    <a class="nav-link js-scroll-trigger"><img src ="img/banho_tosa.png" width="310" height="200" ></a>
                    <div class="dropdown-content">
                        <p><a style="text-decoration:none;">Pequeno: R$20,00.</a></p>
                        <p><a style="text-decoration:none;">Médio R$30,00.</a></p>
                        <p><a style="text-decoration:none;">Grande R$40,00.</a></p>

                    </div>
                    <br>
                </div>   
                <br>
                <div class="dropdown">
                    <a class="nav-link js-scroll-trigger"><img src ="img/taxi.png" width="310" height="200" ></a>
                    <div class="dropdown-content">
                        <p><a style="text-decoration:none;">Até 30km: R$40,00.</a></p>

                    </div>
                    <br>
                </div>    


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
