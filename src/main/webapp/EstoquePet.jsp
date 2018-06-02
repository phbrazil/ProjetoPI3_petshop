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

        PreparedStatement listagemPets = null;
        PreparedStatement Petsqtd = null;

        ResultSet selectPet = null;
        ResultSet selectcountPet = null;

        String sqlSelectRecord = null;
        String sqlSelectqtd = null;
        int quantidadepets = 0;
        sqlSelectRecord = "SELECT * FROM pets";
        sqlSelectqtd = "SELECT COUNT(*) as quantidadepet FROM pets";

        listagemPets = conexao.prepareStatement(sqlSelectRecord);
        Petsqtd = conexao.prepareStatement(sqlSelectqtd);
        selectPet = listagemPets.executeQuery();
        selectcountPet = Petsqtd.executeQuery();

        while (selectcountPet.next()) {

            quantidadepets = selectcountPet.getInt("quantidadepet");

        }
    %>
    <head>

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
    <form name = "ConsultaProd" method="POST" >

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Estoque Pets</title>
    </head>
    <body id="page-top">

        <%@include  file="navbar.jsp" %>

        <div align ="center">
            <br>
            <br>
            <h2>Estoque de Pets</h2>
            <table border='2' cellpadding='10' width='1100'>
                <tr>
                    <td  bgcolor="#33CCCC">Linha</td>
                    <td  bgcolor="#33CCCC">Código Pet</td>
                    <td  bgcolor="#33CCCC">Nome do Pet</td>
                    <td  bgcolor="#33CCCC">Quantidade de Pets</td>
                    <td  bgcolor="#33CCCC">Categoria do Pet</td>
                    <td  bgcolor="#33CCCC">Valor</td> 
                    <td  bgcolor="#33CCCC">Alterar Pet</td> 
                    <td><button type="submit" class="button" name ="exportar" value="ExportarPets" formaction="Exportar">Exportar</button></td>

                </tr>
                <%  int linha = 1;
                    String[] listaprodutos = new String[quantidadepets];
                    while (selectPet.next()) {
                        listaprodutos[linha - 1] = selectPet.getString("codigobarraspet");

                %>
                <tr>
                    <td bgcolor="#FF9900"><%=linha%></td>
                    <td><%=selectPet.getString("codigobarraspet")%></td>
                    <td><%=selectPet.getString("nomepet")%></td>
                    <td><%=selectPet.getInt("quantidadepet")%></td>
                    <td><%=selectPet.getString("categoriapet")%></td>
                    <td>R$<%=selectPet.getString("valorpet")%></td> 
                    <td><button type="submit" class="button" formaction="ConsultaPet?ConsultaPet=<%=selectPet.getString("codigobarraspet")%>">Alterar</button></td>
                <tr>
                    <% linha++;
                        }                                 %>
            </table>
        </div>

        <%
            try {
                if (listagemPets != null) {
                    listagemPets.close();
                }
                if (selectPet != null) {
                    selectPet.close();
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
