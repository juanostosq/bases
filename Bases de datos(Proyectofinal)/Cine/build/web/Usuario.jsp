
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuario</title>
        <link href='EstiloTablas.css' rel='stylesheet' type='text/css'>
    </head>
    <body>
        <form action="InterfazUsuario.jsp" method="post">
            <table align="right" border="1">
                <thead>
                    <tr>
                        <th colspan="2">LOGIN</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>USERNAME:</td>
                        <td><input type="text" id="user" name="user_login" required></td>
                    </tr>
                    <tr>
                        <td>PASSWORD:</td>
                        <td><input type="password" id="pass" name="pass_login" required></td>
                    </tr>
                    <tr>
                        <td align="center" colspan="2"><input type="submit" value="Ingresar"></td>
                    </tr>
                </tbody>
            </table>
        </form>
        <br><br><br><br><br><br><br><br><br>
        <form action="RegisterUser" method="post">
            <table align="right" border="1" width="400">
                <thead>
                    <tr>
                        <th colspan="2">REGISTRO</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Nombre:</td>
                        <td><input type="text" id="nombre_user" name="nombre_user" required></td>
                    </tr>
                    <tr>
                        <td>Apellido:</td>
                        <td><input type="text" id="apellido_user" name="apellido_user" required></td>
                    </tr>
                    <tr>
                        <td>Identificacion:</td>
                        <td><input type="number" id="identificacion_user" name="identificacion_user" min="100000" required></td>
                    </tr>
                    <tr>
                        <td>Telefono Celular:</td>
                        <td><input type="number" id="tel_user" name="tel_user" min="1000000000" required></td>
                    </tr>
                    <tr>
                        <td>Username:</td>
                        <td><input type="text" id="user_register" name="user_register" required></td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td><input type="password" id="user_pass" name="user_pass" required></td>
                    </tr>
                    <tr>
                        <td>Saldo:</td>
                        <td><input type="number" id="saldo_user" name="saldo_user" required></td>
                    </tr>
                    <tr>
                        <td align="center" colspan="2"><input type="submit" value="Registrar"></td>
                    </tr>
                </tbody>
            </table>
        </form>
        <br><br><br><br><br><br><br><br><br>
        <br><br><br><br><br><br><br><br><br>
        <br><br><br>
        <form>
        <table align="right" border="1" width="400">
            <thead>
                <tr>
                    <th><a href="index.jsp">Volver al Inicio</a></th>
                </tr>
            </thead>
        </table>
        </form>
    </body>
</html>
