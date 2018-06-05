<%-- 
    Document   : consultarpet
    Created on : Mar 29, 2018, 12:13:17 PM
    Author     : paulo.bezerra
--%>
<%//@page import="br.senac.tads.pi3b.petmaster.petmastermaven.servlets.model.Produtos"%>
<%@page import="br.senac.tads.pi3b.petmaster.petmastermaven.servlets.model.Loja"%>
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
        conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/petmaster", "root", "");

        PreparedStatement listagemLojas = null;
        PreparedStatement Lojasqtd = null;

        ResultSet selectLoja = null;
        ResultSet selectcountLoja = null;

        String sqlSelectRecord = null;
        String sqlSelectqtd = null;
        int quantidadelojas = 0;
        sqlSelectRecord = "SELECT * FROM lojas";
        sqlSelectqtd = "SELECT COUNT(*) as quantidadeprod FROM produtos";

        listagemLojas = conexao.prepareStatement(sqlSelectRecord);
        Lojasqtd = conexao.prepareStatement(sqlSelectqtd);
        selectLoja = listagemLojas.executeQuery();
        selectcountLoja = Lojasqtd.executeQuery();

        while (selectcountLoja.next()) {

            quantidadelojas = selectcountLoja.getInt("quantidadeprod");

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
        <title>Lojas</title>
    </head>
    <body id="page-top">

        <%@include  file="navbar.jsp" %>

        <div align ="center">
            <br>
            <br>

            <h2>Lojas</h2>

            <br>
            <br>

            <a class="button" href="CadastrarLoja.jsp">Cadastrar uma nova loja</a>

            <br>
            <br>

            <table border='2' cellpadding='10' width='1100'>
                <tr>
                    <td  bgcolor="#33CCCC">Linha</td>
                    <td  bgcolor="#33CCCC">Nome</td>
                    <td  bgcolor="#33CCCC">Endereço</td>
                    <td  bgcolor="#33CCCC">Cidade</td>
                    <td  bgcolor="#33CCCC">Bairro</td>
                    <td  bgcolor="#33CCCC">UF</td> 
                    <td  bgcolor="#33CCCC">Alterar loja</td> 


                </tr>
                <%  int linha = 1;
                    String[] listalojas = new String[quantidadelojas];
                    while (selectLoja.next()) {
                        listalojas[linha - 1] = selectLoja.getString("idloja");

                %>
                <tr>
                    <td bgcolor="#FF9900"><%=linha%></td>
                    <td><%=selectLoja.getString("nomeloja")%></td>
                    <td><%=selectLoja.getString("logradouro")%></td>
                    <td><%=selectLoja.getString("cidade")%></td>
                    <td><%=selectLoja.getString("bairro")%></td>
                    <td><%=selectLoja.getString("uf")%></td> 
                    <td><button type="submit" class="button" formaction="ConsultaLoja?ConsultaLoja=<%=selectLoja.getString("idloja")%>">Alterar</button></td>
                <tr>
                    <% linha++;
                        }

                        ResultSet exportarprod = (ResultSet) request.getAttribute("exportarprodutos");
                        if (exportarprod != null) {
                            response.setContentType("application/vnd.ms-excel");
                            response.setHeader("Content-Disposition", "inline; filename=" + "Produtosreport.xls");
                        }


                    %>
            </table>
        </div>

        <%            try {
                if (listagemLojas != null) {
                    listagemLojas.close();
                }
                if (selectLoja != null) {
                    selectLoja.close();
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
