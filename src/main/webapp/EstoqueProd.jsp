<%-- 
    Document   : consultarpet
    Created on : Mar 29, 2018, 12:13:17 PM
    Author     : paulo.bezerra
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        Connection conexao = null;

        Class.forName("com.mysql.jdbc.Driver").newInstance();
        conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/PetMaster", "root", "admin");

        PreparedStatement listagemProdutos = null;
        ResultSet selectProduto = null;
        String sqlSelectRecord = null;

        sqlSelectRecord = "SELECT * FROM produtos";
        listagemProdutos = conexao.prepareStatement(sqlSelectRecord);
        selectProduto = listagemProdutos.executeQuery();
    %>
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
    <form name = "consultaprod" action="${pageContext.request.contextPath}/consultaProd" method="POST" >

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Estoque Produtos</title>
    </head>
    <body id="page-top">

        <%@include  file="navbar.html" %>

        <div align ="center">
            <br>
            <br>
            <br>
            <h1>Estoque Produtos</h1>
            <table border='2' cellpadding='10' width='900'>
                <tr>
                    <td  bgcolor="#33CCCC">Linha</td>
                    <td  bgcolor="#33CCCC">Produto ID</td>
                    <td  bgcolor="#33CCCC">Nome do Produto</td>
                    <td  bgcolor="#33CCCC">Quantitade do Produto</td>
                    <td  bgcolor="#33CCCC">Categoria do Produto</td>
                    <td  bgcolor="#33CCCC">Valor</td> 
                    <td  bgcolor="#33CCCC">Alterar Produto</td> 
                </tr>
                <%
                    int linha = 1;
                    while (selectProduto.next()) {
                %>
                <tr>
                    <td bgcolor="#FF9900"><%=linha%></td>
                    <td><%=selectProduto.getInt("idprod")%></td>
                    <td><%=selectProduto.getString("nomeprod")%></td>
                    <td><%=selectProduto.getInt("quantidadeprod")%></td>
                    <td><%=selectProduto.getString("categoriaprod")%></td>
                    <td><%=selectProduto.getString("valor")%></td> 
                
                
                <td><input type="submit" name="alterar" value ="Alterar" /><br>
                    <!--span lang="en-us"><a href="consultaProdResult.jsp">Alterar</a></span--></b></td>
                <tr>
                    <%
                            linha++;
                        }
                    %>
            </table>
        </div>

        <%
            try {
                if (listagemProdutos != null) {
                    listagemProdutos.close();
                }
                if (selectProduto != null) {
                    selectProduto.close();
                }

                if (conexao != null) {
                    conexao.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        %>


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
</body>



<!-- Placed at the end of the document so the pages load faster -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="../../../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
<script src="../../../../assets/js/vendor/popper.min.js"></script>
<script src="../../../../dist/js/bootstrap.min.js"></script>
<script src="../../../../assets/js/vendor/holder.min.js"></script>


</html>
