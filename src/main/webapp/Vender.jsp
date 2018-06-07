<%-- 
    Document   : vender
    Created on : Mar 29, 2018, 12:13:17 PM
    Author     : paulo.bezerra
--%>

<%@page import="br.senac.tads.pi3b.petmaster.petmastermaven.servlets.dao.BancoCarrinho"%>
<%@page import="br.senac.tads.pi3b.petmaster.petmastermaven.servlets.dao.BancoCli"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.ArrayList"%>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="br.senac.tads.pi3b.petmaster.petmastermaven.servlets.model.Produtos"%>
<html>
    <head>
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
            <style>
                .button {
                    background-color: #33CCCC;
                    border: none;
                    color: white;
                    padding: 8px 16px;
                    text-align: center;
                    font-size: 16px;
                    margin: 4px 2px;
                    opacity: 0.6;
                    transition: 0.3s;
                    display: inline-block;
                    text-decoration: none;
                    cursor: pointer;
                }

                .button:hover {opacity: 2}
            </style>

            <style>
                .buttonCancel {
                    background-color: #4E2F2F;
                    border: none;
                    color: white;
                    padding: 8px 16px;
                    text-align: center;
                    font-size: 16px;
                    margin: 4px 2px;
                    opacity: 0.6;
                    transition: 0.3s;
                    display: inline-block;
                    text-decoration: none;
                    cursor: pointer;
                }

                .button:hover {opacity: 2}
            </style>



        <form name = "Carrinho" action="${pageContext.request.contextPath}/Carrinho" method="POST" >

            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Vender</title>

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

                                <input readonly type="text" class="form-control" id="cpf" name="cpfcliente" placeholder="000.000.000-00" value ="${cpfcliente}" required>

                                <div class="invalid-feedback" style="width: 100%;">
                                    CPF obrigatório.
                                </div>
                            </div>
                        </div>


                        <div class="mb-3">
                            <label for="primeironome">Nome</label>
                            <div class="input-group">
                                <input readonly type="text" class="form-control" id="primeironome" placeholder="" value="${nomecliente}" name="nomecliente" required>
                                <div class="invalid-feedback">
                                    Primeiro nome necessário
                                </div>
                            </div>
                        </div>

                        <div class="mb-3">
                            <label>Código de Barras<span class="text-muted">(Mandatório)</span></label>
                            <input type="number" name ="codigovenda" id="codigoprod" class="form-control" placeholder="" value ="" >
                            <br>
                            <input type="submit" name="acaovenda" value="Adicionar no Carrinho" class="button" action="shopServlet" ></td>

                        </div>

                        <div class="mb-3">
                            <label for="descricaoprod">Descrição Produto</label>
                            <input readonly type="text" class="form-control" id="descricao" placeholder="" value="${carrinho.get(0).getDescricaoprod()}">

                        </div>


                        <br>


                        <div class="row">
                            <div class="col-md-3 mb-3">
                                <label for="valor">Valor</label>
                                <input readonly class="form-control" id="valor" pattern = "^\d+\.\d{2}" value = "${carrinho.get(0).getValorprod()}" type="currency" >

                            </div>

                            <div class="col-md-3 mb-3">
                                <label for="valor">Valor Desconto</label>
                                <input readonly class="form-control" id="valor" value = "00.00" type="currency" >

                            </div>

                            <div class="col-md-3 mb-3">
                                <label for="quantidade">Quantidade</label>
                                <input class="form-control" id="valor" name = "quantidade" value = "1" type="number" required >

                            </div>

                            <div class="col-md-3 mb-3">
                                <label for="valortotal">Valor Total</label>
                                <input readonly class="form-control" id="valor" value = "${total}" pattern = "^\d+\.\d{2}" type="currency" >

                            </div>

                        </div>
                        <br>
                        <div class="mb-3">
                            <label for="carrinho">Carrinho</label>
                        </div>
                        <!--table border='1' cellpadding='5' width='800'>

                            <tr>
                                <td  bgcolor="#33CCCC">Nome do Produto</td>
                                <td  bgcolor="#33CCCC">Código do Produto</td>
                            </tr>





                                <c:forEach items="${sessionScope.produtos}" var="produtosNome" items="${sessionScope.produtosCodigo}" var="produtosCodigo">

                                    <tr>
                                        <td>${produtosNome}</td>
                                        <td>${produtosCodigo}</td>
                                    </tr>


                                </c:forEach>


                        </table-->



                        <table border='1' cellpadding='5' width='800'>

                            <tr>
                                <td>Código do Produto</td>
                                <td>Nome do Produto</td>
                                <td>Valor do Produto</td>
                                <td>Vendedor do Produto</td>
                                <td>Quantidade do Produto</td>
                            </tr>

                            <%

                                String sessaoid = (String) request.getAttribute("sessaoid");
                                
                                System.out.println(sessaoid);

                                BancoCarrinho bancocarrinho = new BancoCarrinho();

                                ResultSet carrinhoresult = bancocarrinho.ListarCarrinho(sessaoid);
                                

                                while (carrinhoresult.next()) {

                            %>
                            <tr>
                                <td><%=carrinhoresult.getString("codigobarrasprod")%></td>
                                <td><%=carrinhoresult.getString("nomeprod")%></td>
                                <td>R$<%=carrinhoresult.getDouble("valorprod")%></td>
                                <td><%=carrinhoresult.getString("vendedor")%></td>
                                <td><%=carrinhoresult.getInt("quantidadeitens")%></td>
                            </tr>   
                            <%
                                }
                            %>
                        </table>


                        <br>
                        <div class="col-md-4 mb-3">
                            <label name = "pagamento" for="pagamento">Pagamento</label>
                            <select class="custom-select d-block w-100" id="pagamento" value = "" >
                                <option>Débito</option>
                                <option>Crédito</option>
                                <option>Cheque</option>

                            </select>
                        </div>
                        <hr class="mb-4">
                        <input type="submit" name="acaovenda" value="Finalizar Venda" class="button" formaction="Carrinho" ></td>
                    </div>
                </div>

                <div class="col-md-10 mb-5" align ="right">

                    <input type="submit" name="acaovenda" value="Cancelar Venda" class="buttonCancel" formaction="Carrinho" ></td>



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




            <script>


                var mensagem = "${mensagem}"

                if (mensagem == "Produto não encontrado") {
                    alert(mensagem)
                }
            </script>


        </body>
</html>
