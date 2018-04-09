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



        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Produto</title>
    </head>
    <body id="page-top">

        <nav class="navbar navbar-expand-lg navbar-dark bg-info fixed-top" id="sideNav">

            <a class="navbar-brand js-scroll-trigger" href="Home.jsp>
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
                        <a class="nav-link js-scroll-trigger" href="sobre.jsp">Sobre o Sistema</a>
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


            <div class="col-md-6 mb-3">
                <form class="needs-validation" novalidate action="cadastrarprod" method="POST" >


                    <div class="row">
                        <div class="col-md-4 mb-3">
                            <label>Código do Pet</label>
                            <input name="codigoprod" type="text" class="form-control" id="primeironome" placeholder="" value="" required>
                            <div class="invalid-feedback">
                                Código obrigatório
                            </div>
                        </div>
                        <div class="col-md-8 mb-3">
                            <label>Nome do Pet</label>
                            <input name="nomeprod" type="text" class="form-control" id="primeironome" placeholder="" value="" required>
                            <div class="invalid-feedback">
                                Nome obrigatório
                            </div>
                        </div>
                        <div class="col-md-12 mb-3">
                            <label>Descrição do Pet</label>
                            <input name="descricaoprod" type="text" class="form-control" id="primeironome" placeholder="" value="" required>
                            <div class="invalid-feedback">
                                Descrição necessária
                            </div>
                        </div>
                        <div class="col-md-4 mb-3">
                            <label for="categoriaprod">Categoria</label>
                            <select name ="categoriaprod" class="custom-select d-block w-100" id="categoria" required>
                                <option value="">Selecionar...</option>
                                <option>Cão</option>
                                <option>Gato</option>
                                <option>Peixe</option>
                                <option>Réptil</option>
                                <option>Outros</option>
                            </select>

                            <div class="invalid-feedback">
                                Favor selecionar a categoria.
                            </div>
                        </div>


                        <div class="col-md-4 mb-3">
                            <label for="valorprod">Valor</label>
                            <input name="valorprod" type="number" class="form-control" id="valor" pattern = "^\d+\.\d{2}" placeholder="00,00" required>
                            <div class="invalid-feedback">
                                Favor inserir o Valor.
                            </div>
                        </div>
                        <div class="col-md-4 mb-3">
                            <label for="qtdestoque">Quantidade</label>
                            <input name="qtdestoque" type="number" class="form-control" id="qtdestoque" placeholder="1" required>
                            <div class="invalid-feedback">
                                Favor inserir a quantidade.
                            </div>
                        </div>

                    </div>

                    <hr class="mb-4">
                    <button class="btn btn-secondary btn-lg btn-block" type="submit">Gravar</button>
                </form>
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

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="../../../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
    <script src="../../../../assets/js/vendor/popper.min.js"></script>
    <script src="../../../../dist/js/bootstrap.min.js"></script>
    <script src="../../../../assets/js/vendor/holder.min.js"></script>
    <script>
        // Example starter JavaScript for disabling form submissions if there are invalid fields
        (function () {
            'use strict';

            window.addEventListener('load', function () {
                // Fetch all the forms we want to apply custom Bootstrap validation styles to
                var forms = document.getElementsByClassName('needs-validation');

                // Loop over them and prevent submission
                var validation = Array.prototype.filter.call(forms, function (form) {
                    form.addEventListener('submit', function (event) {
                        if (form.checkValidity() === false) {
                            event.preventDefault();
                            event.stopPropagation();
                        }
                        form.classList.add('was-validated');
                    }, false);
                });
            }, false);
        })();
    </script>
</div>        
</body>
</html>
