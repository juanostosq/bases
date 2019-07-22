
<%@page import="Cine.Admin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ADMIN</title>
    </head>
    <body>
        <h1 align="center">Bienvenido</h1>
        <div align="center">Por favor ingresa con el usuario y contraseña asignados</div>
        <form action="InterfazAdmin.jsp" method="post">    
            <table align="center">
                <tr>
                    <td><input type="text" id="user" name="user" placeholder="Usuario"></td>
                </tr>
                <tr>
                    <td><input type="password" id="pass" name="pass" placeholder="Password"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Login"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
