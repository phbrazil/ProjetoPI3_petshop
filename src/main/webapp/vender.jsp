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


    <form name = "acaoVenda" action="${pageContext.request.contextPath}/acaoVenda" method="POST" >

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
                        <!--img class="d-block mx-auto mb-4" src="img/LogoPetMaster.png" alt="" width="200" height="200"-->
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

                            <input type="text" class="form-control" id="cpf" name="cpfcliente" placeholder="000.000.000-00" value ="${cpfcliente}" required>

                            <div class="invalid-feedback" style="width: 100%;">
                                CPF obrigatório.
                            </div>
                        </div>
                    </div>


                    <div class="mb-3">
                        <label for="primeironome">Nome</label>
                        <div class="input-group">
                            <input type="text" class="form-control" id="primeironome" placeholder="" value="${nomecliente}" name="nomecliente" required>
                            <div class="invalid-feedback">
                                Primeiro nome necessário
                            </div>
                        </div>
                    </div>

                    <div class="mb-3">
                        <label for="codigoprod">Código do Produto <span class="text-muted">(Mandatório)</span></label>
                        <input type="number" id="codigoprod" class="form-control" placeholder="" value ="">
                        <button id="myBtn" formaction="consultaProd.jsp" onclick="Carrinho()">Pesquisar</button>

                    </div>

                    <div class="mb-3">
                        <label for="descricaoprod">Descrição Produto</label>
                        <input type="text" class="form-control" id="endereco" placeholder="" value="">

                    </div>


                    <div class="row">
                        <div class="col-md-3 mb-3">
                            <label for="valor">Valor</label>
                            <input class="form-control" id="valor" value = "" type="currency" >

                        </div>
                        
                        <div class="col-md-3 mb-3">
                            <label for="valor">Valor Desconto</label>
                            <input class="form-control" id="valor" value = "" type="currency" >

                        </div>
                        
                        <div class="col-md-3 mb-3">
                            <label for="quantidade">Quantidade</label>
                            <input class="form-control" id="valor" value = "" type="number" >

                        </div>
                        
                        <div class="col-md-3 mb-3">
                            <label for="valortotal">Valor Total</label>
                            <input class="form-control" id="valor" value = "" type="currency" >

                        </div>
                        
                        <div class="col-md-4 mb-3">
                            <label for="pagamento">Pagamento</label>
                            <select class="custom-select d-block w-100" id="pagamento" value = "" >
                                <option value = "">Selecionar...</option>
                                <option>Débito</option>
                                <option>Crédito</option>
                                <option>Cheque</option>

                            </select>
                        </div>
                    </div>
                    <hr class="mb-4">
                    <button class="btn btn-primary btn-lg btn-block" type="submit" formaction="${pageContext.request.contextPath}/finalizarVenda" name = "finalizarvenda">Finalizar Venda</button>
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

        </form>

        <script>
            var input = document.getElementById("codigoprod");
            input.addEventListener("keyup", function (event) {
                event.preventDefault();
                if (event.keyCode === 13) {
                    document.getElementById("myBtn").click();
                }
            });

        </script>

        <script>

            function Carrinho() {


                alert("shaudhsduhdsau")

        </script>



        <!-- Bootstrap core JavaScript
=== === === === === === === === === === === === === === === === == -- ><!-- Placed at the end of the document so the pages load faster -->
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
                }
                )();


        </script>


    </body>
</html>
