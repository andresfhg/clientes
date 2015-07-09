<%-- 
    Document   : busqueda
    Created on : 9/07/2015, 01:49:50 PM
    Author     : Administrador
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Informacion</title>
       
    </head>
    <body>
         <%
            String i =  request.setParameter("id");
            String n =  request.setAttribute("nombre");            
        %>
        <h1>Hello World!</h1>
    </body>
</html>
