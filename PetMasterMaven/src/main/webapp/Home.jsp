<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Pet Shop</title>
    </head>
    <body>
        <br/><br/>

        <form>
            Resultado:
            <c:out value="${username}" />
            <br>

        </form>
        <input type ="button" value ="back" onclick="history.back()">    
        
    </body>
</html>