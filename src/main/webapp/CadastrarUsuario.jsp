<%-- 
    Document   : vender
    Created on : Mar 29, 2018, 12:13:17 PM
    Author     : paulo.bezerra
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.awt.List"%>
<%@page import="java.util.ArrayList"%>
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


    <form name = "CadastrarUsuario" action="${pageContext.request.contextPath}/CadastrarUsuario" method="POST" >

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Loja</title>


    </head>
    <body id="page-top">
        <form>
            <div id="includedContent"></div>

            <%@include  file="navbar.jsp" %>


            <div align ="center">
                <br>

                <div class="container">
                    <div class="py-5 text-center">
                        <!--img class="d-block mx-auto mb-4" src="img/LogoPetMaster.png" alt="" width="200" height="200"-->
                        <h2>Cadastrar usuário</h2>
                    </div>
                </div>

                <div class="col-md-8 order-md-1">

                    <div class="mb-3">
                        <label for="primeironome">Nome do usuario</label>
                        <div class="input-group">
                            <input name="nomeusuario" type="text" class="form-control" id="nomeusuario" placeholder="" value="" name="nomeusuario" required>
                            <div class="invalid-feedback">
                                Primeiro nome necessário
                            </div>
                        </div>
                    </div>

                    <div class="mb-3">
                        <label for="email">Username <span class="text-muted">(Mandatorio)</span></label>
                        <input name ="username" type="email" class="form-control" id="email" placeholder="voce@exemplo.com" value ="">
                        <div class="invalid-feedback">
                            Favor inserir um username válido para o frete.
                        </div>
                    </div>
                    <div class="mb-3">
                        <label for="password">Password</label>
                        <input name ="password" type="password" class="form-control" id="password" placeholder="Password" value=""required>
                        <div class="invalid-feedback">
                            Favor inserir o password.
                        </div>
                    </div>


                    <div class="col-md-4 mb-3">
                        <label  for="estado">Filial</label>
                        <select name = "idfilial" class="custom-select d-block w-100" id="filial" value = "" required>
                            <c:forEach items="${filiais}" var="filiais">
                                <%
                                    ResultSet listafiliais = (ResultSet) request.getAttribute("listafiliais");

                                    while (listafiliais.next()) {

                                %>
                                <option><%=listafiliais.getString("nomeloja")%></option>


                                <%}

                                %>

                            </c:forEach>
                        </select>
                        <div class="invalid-feedback">
                            Favor selecionar uma Filial..
                        </div>
                    </div>
                    <div class="col-md-4 mb-3">
                        <label  for="grupo">Grupo</label>
                        <select name = "idgrupo" class="custom-select d-block w-100" id="grupo" value = "" required>
                            <option>Vendedores</option>
                            <option>Administradores</option>


                        </select>

                        <div class="invalid-feedback">
                            Favor selecionar uma Grupo..
                        </div>
                    </div>

                    <hr class="mb-4">
                    <button class="btn btn-primary btn-lg btn-block" type="submit" name = "gravarUsuario">Gravar</button>
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
            }
            )();


        </script>



        <script>


            var mensagem = "${mensagem}"



            if (mensagem == "Usuario cadastrado com sucesso!") {
                alert(mensagem)

            } else if (mensagem == "Usuário já se encontra cadastrado") {

                alert(mensagem)
            }
        </script>

    </body>
</html>
