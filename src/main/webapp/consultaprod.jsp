<%-- 
    Document   : consultarprod
    Created on : Mar 29, 2018, 12:13:17 PM
    Author     : paulo.bezerra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <form action="consultaprod" method="POST" >

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consultar Produto</title>
    </head>
    <body>
        <div align = "center">
            <h1>Consultar Produto</h1>
            <h2>Digite o código ou nome do produto</h2>

            <input type="text" name="consultaprod" />
            <input type="submit" name="pesquisar" value ="Pesquisar" /><br><br>
            <input type ="button" value ="Voltar" onclick="history.back()">    

        </div>
</form>
</body>
</html>
