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


                <nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0">
                    <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="#">Company name</a>
                    <input class="form-control form-control-dark w-100" type="text" placeholder="Search" aria-label="Search">
                    <ul class="navbar-nav px-3">
                        <li class="nav-item text-nowrap">
                            <a class="nav-link" href="#">Sign out</a>
                        </li>
                    </ul>
                </nav>

                <div class="container-fluid">
                    <div class="row">
                        <nav class="col-md-2 d-none d-md-block bg-light sidebar">
                            <div class="sidebar-sticky">
                                <ul class="nav flex-column">
                                    <li class="nav-item">
                                        <a class="nav-link active" href="#">
                                            <span data-feather="home"></span>
                                            Dashboard <span class="sr-only">(current)</span>
                                        </a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="#">
                                            <span data-feather="file"></span>
                                            Orders
                                        </a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="#">
                                            <span data-feather="shopping-cart"></span>
                                            Products
                                        </a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="#">
                                            <span data-feather="users"></span>
                                            Customers
                                        </a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="#">
                                            <span data-feather="bar-chart-2"></span>
                                            Reports
                                        </a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="#">
                                            <span data-feather="layers"></span>
                                            Integrations
                                        </a>
                                    </li>
                                </ul>

                                <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
                                    <span>Saved reports</span>
                                    <a class="d-flex align-items-center text-muted" href="#">
                                        <span data-feather="plus-circle"></span>
                                    </a>
                                </h6>
                                <ul class="nav flex-column mb-2">
                                    <li class="nav-item">
                                        <a class="nav-link" href="#">
                                            <span data-feather="file-text"></span>
                                            Current month
                                        </a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="#">
                                            <span data-feather="file-text"></span>
                                            Last quarter
                                        </a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="#">
                                            <span data-feather="file-text"></span>
                                            Social engagement
                                        </a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="#">
                                            <span data-feather="file-text"></span>
                                            Year-end sale
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </nav>

                        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
                            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
                                <h1 class="h2">Dashboard</h1>
                                <div class="btn-toolbar mb-2 mb-md-0">
                                    <div class="btn-group mr-2">
                                        <button class="btn btn-sm btn-outline-secondary">Share</button>
                                        <button class="btn btn-sm btn-outline-secondary">Export</button>
                                    </div>
                                    <button class="btn btn-sm btn-outline-secondary dropdown-toggle">
                                        <span data-feather="calendar"></span>
                                        This week
                                    </button>
                                </div>
                            </div>

                            <canvas class="my-4" id="myChart" width="900" height="380"></canvas>

                            <h2>Section title</h2>
                            <div class="table-responsive">
                                <table class="table table-striped table-sm">
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>Header</th>
                                            <th>Header</th>
                                            <th>Header</th>
                                            <th>Header</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>1,001</td>
                                            <td>Lorem</td>
                                            <td>ipsum</td>
                                            <td>dolor</td>
                                            <td>sit</td>
                                        </tr>
                                        <tr>
                                            <td>1,002</td>
                                            <td>amet</td>
                                            <td>consectetur</td>
                                            <td>adipiscing</td>
                                            <td>elit</td>
                                        </tr>
                                        <tr>
                                            <td>1,003</td>
                                            <td>Integer</td>
                                            <td>nec</td>
                                            <td>odio</td>
                                            <td>Praesent</td>
                                        </tr>
                                        <tr>
                                            <td>1,003</td>
                                            <td>libero</td>
                                            <td>Sed</td>
                                            <td>cursus</td>
                                            <td>ante</td>
                                        </tr>
                                        <tr>
                                            <td>1,004</td>
                                            <td>dapibus</td>
                                            <td>diam</td>
                                            <td>Sed</td>
                                            <td>nisi</td>
                                        </tr>
                                        <tr>
                                            <td>1,005</td>
                                            <td>Nulla</td>
                                            <td>quis</td>
                                            <td>sem</td>
                                            <td>at</td>
                                        </tr>
                                        <tr>
                                            <td>1,006</td>
                                            <td>nibh</td>
                                            <td>elementum</td>
                                            <td>imperdiet</td>
                                            <td>Duis</td>
                                        </tr>
                                        <tr>
                                            <td>1,007</td>
                                            <td>sagittis</td>
                                            <td>ipsum</td>
                                            <td>Praesent</td>
                                            <td>mauris</td>
                                        </tr>
                                        <tr>
                                            <td>1,008</td>
                                            <td>Fusce</td>
                                            <td>nec</td>
                                            <td>tellus</td>
                                            <td>sed</td>
                                        </tr>
                                        <tr>
                                            <td>1,009</td>
                                            <td>augue</td>
                                            <td>semper</td>
                                            <td>porta</td>
                                            <td>Mauris</td>
                                        </tr>
                                        <tr>
                                            <td>1,010</td>
                                            <td>massa</td>
                                            <td>Vestibulum</td>
                                            <td>lacinia</td>
                                            <td>arcu</td>
                                        </tr>
                                        <tr>
                                            <td>1,011</td>
                                            <td>eget</td>
                                            <td>nulla</td>
                                            <td>Class</td>
                                            <td>aptent</td>
                                        </tr>
                                        <tr>
                                            <td>1,012</td>
                                            <td>taciti</td>
                                            <td>sociosqu</td>
                                            <td>ad</td>
                                            <td>litora</td>
                                        </tr>
                                        <tr>
                                            <td>1,013</td>
                                            <td>torquent</td>
                                            <td>per</td>
                                            <td>conubia</td>
                                            <td>nostra</td>
                                        </tr>
                                        <tr>
                                            <td>1,014</td>
                                            <td>per</td>
                                            <td>inceptos</td>
                                            <td>himenaeos</td>
                                            <td>Curabitur</td>
                                        </tr>
                                        <tr>
                                            <td>1,015</td>
                                            <td>sodales</td>
                                            <td>ligula</td>
                                            <td>in</td>
                                            <td>libero</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </main>
                    </div>
                </div>

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
                            labels: ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"],
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
</html>
