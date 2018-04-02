<%-- 
    Document   : reset
    Created on : Mar 23, 2018, 5:30:06 PM
    Author     : Paulo.Bezerra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Esqueci minha senha</title>
    </head>
    <body>
        <form align = "center" action="reset" method="POST" >
            <h1>Redefinir Senha</h1>
            <table align = "center" width="30%">

                <tr> 
                    <td width="48%">Email</td>
                    <td width="52%">
                        <input type="text" name="emailreset" />
                    </td>
                </tr>
                <br>
            </table>
            <p> 
                <input type="submit" name="Submit" value="Submit" />
                <input type ="button" value ="back" onclick="history.back()">    

            <p>
        </form>
    </body>
</html>
