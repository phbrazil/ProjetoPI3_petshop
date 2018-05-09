<%-- 
    Document   : consultarpet
    Created on : Mar 29, 2018, 12:13:17 PM
    Author     : paulo.bezerra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Bootstrap core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="css/tableprod.css" rel="stylesheet">

        <!-- Custom fonts for this template -->
        <link href="https://fonts.googleapis.com/css?family=Saira+Extra+Condensed:100,200,300,400,500,600,700,800,900" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">
        <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet">
        <link href="vendor/devicons/css/devicons.min.css" rel="stylesheet">
        <link href="vendor/simple-line-icons/css/simple-line-icons.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/topodapagina.css" rel="stylesheet">
    <form action="${pageContext.request.contextPath}/consultaPet" method="POST" >

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consultar Pet</title>
    </head>
    <body id="page-top">
        <form>

            <%@include  file="navbar.html" %>

            <div align ="center">
                <br>
                <br>
                <br>
                <h1 >Consultar Pet</h1>
                <h2>Digite o código ou nome do Pet</h2>

                <div class="col-md-5 order-md-1">

                    <input class="form-control" type="text" name="consultapet" form-control required/>
                    <div class="invalid-feedback" style="width: 100%;">
                        Valor obrigatório.
                    </div>
                    <br>
                    <input type="submit" name="pesquisar" value ="Pesquisar" /><br><br>

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
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="../../../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
    <script src="../../../../assets/js/vendor/popper.min.js"></script>
    <script src="../../../../dist/js/bootstrap.min.js"></script>
    <script src="../../../../assets/js/vendor/holder.min.js"></script>
    <script>
                    var table = document.getElementById('table'),
                            selected = table.getElementsByClassName('selected');
                    table.onclick = highlight;
                    function highlight(e) {
                        if (selected[0])
                            selected[0].className = '';
                        e.target.parentNode.className = 'selected';
                    }
                    function fnselect() {
                        var $row = $(this).parent().find('td');
                        var clickeedID = $row.eq(0).text();
                        alert(clickeedID);
                    }
    </script>
</html>
