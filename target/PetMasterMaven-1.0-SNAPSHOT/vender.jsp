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
        <link href="vender.css" rel="stylesheet">


    <form action="vender" method="POST" >

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consultar Pet</title>
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

                <div class="container">
                    <div class="py-5 text-center">
                        <img class="d-block mx-auto mb-4" src="img/senac.jpg" alt="" width="100" height="100">
                        <h2>Vendas PetShop</h2>
                    </div>
                </div>
                <div class="col-md-8 order-md-1">
                    <h4 class="mb-3">Dados da Venda</h4>
                    <form class="needs-validation" novalidate>
                        <div class="row">
                            <div class="col-md-6 mb-3">
                                <label for="firstName">Primeiro nome</label>
                                <input type="text" class="form-control" id="firstName" placeholder="" value="" required>
                                <div class="invalid-feedback">
                                    Primeiro nome necessário
                                </div>
                            </div>
                            <div class="col-md-6 mb-3">
                                <label for="lastName">Último nome</label>
                                <input type="text" class="form-control" id="lastName" placeholder="" value="" required>
                                <div class="invalid-feedback">
                                    Último nome necessário
                                </div>
                            </div>
                        </div>

                        <div class="mb-3">
                            <label for="username">Username do Cliente</label>
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text">@</span>
                                </div>
                                <input type="text" class="form-control" id="username" placeholder="Username" required>
                                <div class="invalid-feedback" style="width: 100%;">
                                    Your username is required.
                                </div>
                            </div>
                        </div>

                        <div class="mb-3">
                            <label for="email">Email <span class="text-muted">(Opcional)</span></label>
                            <input type="email" class="form-control" id="email" placeholder="voce@exemplo.com">
                            <div class="invalid-feedback">
                                Favor inserir um email válido para o frete.
                            </div>
                        </div>

                        <div class="mb-3">
                            <label for="address">Endereço</label>
                            <input type="text" class="form-control" id="address" placeholder="Rua hum 1234" required>
                            <div class="invalid-feedback">
                                Favor inserir seu endereço de envio.
                            </div>
                        </div>


                        <div class="row">
                            <div class="col-md-5 mb-3">
                                <label for="country">País</label>
                                <select class="custom-select d-block w-100" id="country" required>
                                    <option value="">Selecionar...</option>
                                    <option>Brasil</option>
                                </select>
                                <div class="invalid-feedback">
                                    Favor selecionar o país.
                                </div>
                            </div>
                            <div class="col-md-4 mb-3">
                                <label for="state">Estado</label>
                                <select class="custom-select d-block w-100" id="state" required>
                                    <option value="">Selecionar...</option>
                                    <option>São Paulo</option>
                                    <option>Rio de Janeiro</option>
                                    <option>São Paulo</option>
                                    <option>São Paulo</option>
                                    <option>São Paulo</option>
                                    <option>São Paulo</option>

                                </select>
                                <div class="invalid-feedback">
                                    Favor selecionar um Estado..
                                </div>
                            </div>
                            <div class="col-md-3 mb-3">
                                <label for="zip">CEP</label>
                                <input type="text" class="form-control" id="zip" placeholder="" required>
                                <div class="invalid-feedback">
                                    CEP obrigatório
                                </div>
                            </div>
                        </div>
                        <hr class="mb-4">

                        <h4 class="mb-3">Pagamento</h4>

                        <div class="d-block my-3">
                            <div class="custom-control custom-radio">
                                <input id="credit" name="paymentMethod" type="radio" class="custom-control-input" checked required>
                                <label class="custom-control-label" for="credit">Cartão de crédito</label>
                            </div>
                            <div class="custom-control custom-radio">
                                <input id="debit" name="paymentMethod" type="radio" class="custom-control-input" required>
                                <label class="custom-control-label" for="debit">Cartão de débito</label>
                            </div>
                            <div class="custom-control custom-radio">
                                <input id="paypal" name="paymentMethod" type="radio" class="custom-control-input" required>
                                <label class="custom-control-label" for="paypal">Cheque</label>
                            </div>
                        </div>

                        <hr class="mb-4">
                        <button class="btn btn-primary btn-lg btn-block" type="submit">Finalizar Venda</button>
                    </form>
                </div>
            </div>

            <footer class="my-5 pt-5 text-muted text-center text-small">
                <p class="mb-1">&copy; Javazeiros - Projeto Semestre 3</p>
                <ul class="list-inline">
                    <li class="list-inline-item"><a href="#">Privacidade</a></li>
                    <li class="list-inline-item"><a href="#">Termos</a></li>
                    <li class="list-inline-item"><a href="#">Suporte</a></li>
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
