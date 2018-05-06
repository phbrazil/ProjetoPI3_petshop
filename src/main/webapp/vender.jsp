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


    <form name = "vender" action="${pageContext.request.contextPath}/vender" method="POST" >

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vender</title>

    </head>
    <body id="page-top">
        <form>
            <div id="includedContent"></div>

            <%@include  file="navbar.html" %>


            <div align ="center">
                <br>

                <div class="container">
                    <div class="py-5 text-center">
                        <img class="d-block mx-auto mb-4" src="img/LogoPetMaster.png" alt="" width="200" height="200">
                        <h2>Vendas PetShop</h2>
                    </div>
                </div>


                <div class="col-md-8 order-md-1">

                    <div class="mb-3">
                        <label for="cpf">CPF do cliente</label>
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <span class="input-group-text"></span>
                            </div>

                            <input type="text" class="form-control" id="cpf" name="cpfcliente" placeholder="000.000.000-00" value ="${resultado.cpfCliente}">

                            <div class="invalid-feedback" style="width: 100%;">
                                CPF obrigatório.
                            </div>
                        </div>
                    </div>


                    <div class="mb-3">
                        <label for="primeironome">Nome</label>
                        <div class="input-group">
                            <input type="text" class="form-control" id="primeironome" placeholder="" value="${resultado.nomeCliente}" required>
                            <div class="invalid-feedback">
                                Primeiro nome necessário
                            </div>
                        </div>
                    </div>

                    <div class="mb-3">
                        <label for="email">Email <span class="text-muted">(Opcional)</span></label>
                        <input type="email" class="form-control" id="email" placeholder="voce@exemplo.com" value ="${resultado.email}">
                        <div class="invalid-feedback">
                            Favor inserir um email válido para o frete.
                        </div>
                    </div>

                    <div class="mb-3">
                        <label for="endereco">Endereço</label>
                        <input type="text" class="form-control" id="endereco" placeholder="Rua hum 1234" value="${resultado.logradouro}"required>
                        <div class="invalid-feedback">
                            Favor inserir seu endereço de envio.
                        </div>
                    </div>


                    <div class="row">
                        <div class="col-md-5 mb-3">
                            <label for="pais">País</label>
                            <select class="custom-select d-block w-100" id="pais"  required>
                                <option value = "${resultado.pais}"</option>
                                <option>Brasil</option>
                            </select>
                            <div class="invalid-feedback">
                                Favor selecionar o país.
                            </div>
                        </div>
                        <div class="col-md-4 mb-3">
                            <label for="estado">Estado</label>
                            <select class="custom-select d-block w-100" id="estado"  required>
                                <option value = "${resultado.estado}"</option>
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
                            <label for="cep">CEP</label>
                            <input type="text" class="form-control" id="cep" placeholder="" value = "${resultado.cep}" required>
                            <div class="invalid-feedback">
                                CEP obrigatório
                            </div>
                        </div>
                        <div class="col-md-3 mb-3">
                            <label for="codigoprod">Código do produto</label>
                            <input type="text" class="form-control" id="codigoprod" placeholder="" required>
                            <div class="invalid-feedback">
                                Código do produto obrigatório
                            </div>
                        </div>
                        <div class="col-md-6 mb-6">
                            <label for="descricao">Descrição</label>
                            <input type="text" class="form-control" id="descricao" placeholder="" required>
                            <div class="invalid-feedback">
                                Descrição obrigatória
                            </div>
                        </div>

                        <div class="col-md-3 mb-3">
                            <label for="valor">Valor</label>
                            <input type="text" class="form-control" id="valor" placeholder="" required>
                            <div class="invalid-feedback">
                                Valor obrigatório
                            </div>
                        </div>
                        <div class="col-md-3 mb-3">
                            <label for="desconto">Desconto</label>
                            <input type="text" class="form-control" id="desconto" placeholder="">
                        </div>
                        <div class="col-md-3 mb-3">
                            <label for="total">Valor Total</label>
                            <input type="text" class="form-control" id="total" placeholder="" required>
                            <div class="invalid-feedback">
                                Total obrigatório
                            </div>
                        </div>
                    </div>
                    <hr class="mb-4">


                    <div class="row">
                        <div class="col-md-5 mb-3">
                            <label for="pagamento">Pagamento</label>
                            <select class="custom-select d-block w-100" id="pagamento"required>
                                <option>Débito</option>
                                <option>Crédito</option>
                                <option>Cheque</option>

                            </select>
                            <div class="invalid-feedback">
                                Favor selecionar o pagamento.
                            </div>
                        </div>

                        <hr class="mb-4">
                        <button class="btn btn-primary btn-lg btn-block" type="submit" name = "finalizarvenda">Finalizar Venda</button>
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

            <script>
                function pesquisarCPF() {

                    var CPF = document.vender.cpfcliente.value


                    //alert("O resultado é "+CPF)

                }

            </script>
    </body>
</html>
