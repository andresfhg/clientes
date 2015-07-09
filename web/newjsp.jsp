<%-- 
    Document   : newjsp
    Created on : 9/07/2015, 11:51:23 AM
    Author     : Administrador
--%>
<%@page import="java.sql.Connection"%>
<%@page import="Controller.conectadb"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio</title>
    </head>
    <body>

        <form class="form-horizontal" action="Servletautenticacion" method="post">
            <center><label>Id</label> <input type="text" name="BuscarId" value="" /></center> <br>
            <center><label>Nombre</label> <input type="text" name="BuscarNombre" value="" /></center> <br>
            <center><input type="submit" value="Buscar" name="Buscar" /></center>
        </form>

        <%
            conectadb sqlite = new conectadb();
            Connection cn = sqlite.Conectar();

            String res = "";
 
            if (cn != null) {
                res = "Conexión Exitosa!";
                
            } else {
                res = "Conexión Fallida :(";
            }
        %>

        <input type="submit" value="Conexion" onclick = "alert('<%= res%>')"/>
    </body>
</html>
