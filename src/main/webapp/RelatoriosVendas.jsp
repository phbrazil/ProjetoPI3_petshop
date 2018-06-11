
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.senac.tads.pi3b.petmaster.petmastermaven.model.Produtos"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="br.senac.tads.pi3b.petmaster.petmastermaven.model.Pets"%>




<%-- 
    Document   : consultapetresult
    Created on : Mar 29, 2018, 12:13:17 PM
    Author     : paulo.bezerra
--%>


<!DOCTYPE html>
<html>
    <head>
        <style>
            .button {
                background-color: #33CCCC;
                border: none;
                color: white;
                padding: 8px 4px;
                text-align: center;
                font-size: 16px;
                margin: 32px 4px;
                opacity: 0.6;
                transition: 0.3s;
                display: inline-block;
                text-decoration: none;
                cursor: pointer;
            }

            .button:hover {opacity: 2}
        </style>

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

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Relatórios</title>
    </head>
    <body id="page-top">
        <form action="${pageContext.request.contextPath}/RelatoriosServlet" method="POST" >

            <%@include  file="navbar.jsp" %>
            <br>
            <br>
            <br>

            <div align = "center">
            <h1>Relatórios Vendas</h1>

                <div class="col-md-3 mb-3">
                    <label for="inicio">Inicio</label>
                    <input name = "inicio" type="date" class="form-control" id="cep" placeholder="dd/mm/aaaa" maxlength="10" value = "" required>
                    <label for="fim">Fim</label>
                    <input name = "fim" type="date" class="form-control" id="cep" placeholder="dd/mm/aaaa" maxlength="10" value = "" required>
                    <div class="invalid-feedback">
                        Inicio obrigatório
                    </div>
                    <input type="submit" name="acaoreport" value="Gerar Venda" class="button" action="RelatoriosServlet" >

                </div>


            </div>

        </div>

    </form>



    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="../../../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
    <script src="../../../../assets/js/vendor/popper.min.js"></script>
    <script src="../../../../dist/js/bootstrap.min.js"></script>

    <!-- Icons -->
    <script src="https://unpkg.com/feather-icons/dist/feather.min.js"></script>
    <script>
        feather.replace()
    </script>

    <!-- Graphs -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.min.js"></script>
    <script>
        var ctx = document.getElementById("myChart");
        var myChart = new Chart(ctx, {
            type: 'line',
            data: {
                labels: ["Domingo", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado"],
                datasets: [{
                        data: [15339, 21345, 18483, 24003, 23489, 24092, 12034],
                        lineTension: 0,
                        backgroundColor: 'transparent',
                        borderColor: '#007bff',
                        borderWidth: 4,
                        pointBackgroundColor: '#007bff'
                    }]
            },
            options: {
                scales: {
                    yAxes: [{
                            ticks: {
                                beginAtZero: false
                            }
                        }]
                },
                legend: {
                    display: false,
                }
            }
        });
    </script>
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
    <script>



        var mensagem = "${mensagem}"


        if (mensagem == "Nenhum dado encontrado") {
            alert(mensagem)

        } 



    </script>
</html>


