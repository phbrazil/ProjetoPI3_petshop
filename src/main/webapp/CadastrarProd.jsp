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
    <form class="needs-validation" novalidate action="${pageContext.request.contextPath}/CadastrarProd" method="POST" >



        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Produto</title>
    </head>
    <body id="page-top">

        <%@include  file="navbar.jsp" %>

        <div align ="center">
            <br>
            <br>
            <h1>Cadastrar Produto</h1>


            <div class="col-md-6 mb-3">


                <div class="row">
                    <div class="col-md-4 mb-3">
                        <label>Código do Produto</label>
                        <input name="codigoprod" type="text" class="form-control" id="primeironome" placeholder="" value="" maxlength ="30" required>
                        <div class="invalid-feedback">
                            Código obrigatório
                        </div>
                    </div>
                    <div class="col-md-8 mb-3">
                        <label>Nome do Produto</label>
                        <input name="nomeprod" type="text" class="form-control" id="primeironome" placeholder="" value="" maxlength ="80" required>
                        <div class="invalid-feedback">
                            Nome obrigatório
                        </div>
                    </div>
                    <div class="col-md-12 mb-3">
                        <label>Descrição do Produto</label>
                        <input name="descricaoprod" type="text" class="form-control" id="primeironome" placeholder="" value="" maxlength ="80" required>
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


        </div>        
    </body>
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

    <script>


        var mensagem = "${mensagem}"
        var codigo = "${codigobarras}"

        if (mensagem == "Produto Cadastrado com sucesso!") {
            alert(mensagem)


        } else if (mensagem == "Já Cadastrado") {
            alert("O Produto com código " + codigo + " já se encontra cadastrado")

        }
    </script>
</html>
