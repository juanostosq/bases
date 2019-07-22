<%-- 
    Document   : Reservacion
    Created on : 31/05/2018, 08:29:13 PM
    Author     : diego
--%>

<%@page import="Datos.DBfunciones"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String numeroHab=request.getParameter("numSal");
    String username=request.getParameter("username");
    String pass=request.getParameter("pass_login");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reservacion</title>
    </head>
    <body>
        <h1 align="center">Reservacion</h1>
        <form action="RegisterReservacion" method="post">
            <div align="center">
                Numero de boletas<input type="number" min="1" max="8" name="alojados" id="alojados" required>
            </div>
            <div align="center">    
                <input type="hidden" name="numHab" id="numHab" value="<%= numeroHab%>"></input>
            </div>
            <div align="center">    
                <input type="hidden" name="username" id="username" value="<%= username%>"></input>
                <input type="hidden" id="pass" name="opc" value="<%= pass%>"></input>
            </div>
            <div align="center">    
                <input type="submit" value="Reservar">
            </div>
        </form>
    </body>
</html>
