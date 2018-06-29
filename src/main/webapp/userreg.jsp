<%-- 
    Document   : index
    Created on : 28 juin 2018, 14:38:03
    Author     : Loic
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Backoffice</title>
    </head>
    <body>
        <h1>Bienvenue sur le backoffice</h1>
        
        
    <c:if test="" >
        
    </c:if>
            <c:out value="Bonjour ${ nom }"> </c:out>
            
        
        
        <h2>Register new user</h2>
        <form method="POST" action="userreg">
            <label for="name">Name: </label>
            <input type="text" name="name" id="name" />
            <input type="submit" value="Register"/>
        </form>
    </body>
</html>
