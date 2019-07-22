
<%@page import="java.sql.ResultSet"%>
<%@page import="Datos.DBfunciones"%>
<%@page import="Cine.Sala"%>
<%@page import="Cine.Admin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Admin admin=new Admin();
    String user=request.getParameter("user");
    String pass=request.getParameter("pass");
    boolean decision=admin.validar_admin(user, pass);
    Sala h=new Sala(){};
    DBfunciones db=new DBfunciones();
    
    ResultSet Funciones=db.Listar_funciones();
    if(!decision){
        response.sendRedirect("Admin.jsp");
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin</title>
        <link href='EstiloTablas.css' rel='stylesheet' type='text/css'>
    </head>
    <body>
        <h1 align="center">CREAR FUNCION</h1>
    <form action="CrearHabitacion" method="get">
        <table align="center">
            <tr>
                <td>Seleccione clase:</td>
                <td>
                    <select id="clase" name="clase" required>
                        <option></option>
                        <option value="0">Preferencial</option>
                        <option value="1">General</option>
 
                    </select>
                </td>
            </tr>
            <tr>
                <td>Ingrese el numero de sala</td>
                <td><input type="number" id="numeroHab" name="numeroHab"></td>
            </tr>
            <tr>
                <td align="center" colspan="2"><input type="submit" value="Enviar"></td>
            </tr>
        </table>
    </form>
        <br><br>
        <table align="center" border="+1">
            <tr><td>ID</td><td>CLASE</td><td>CAPACIDAD</td><td>ALOJADOS</td><td>ESTADO</td><td>PRECIO INDIVIDUAL</td><td>NUMERO DE HABITACION</td><td>USUARIO</td></tr>

        <% }%>
        </table>
        <br>
        <h1 align="center">Establecer precios habitaciones</h1>
        <form action="EditarHabitacion" method="get">
            <table align="center" border="+1">
            <tr>
                <td>Seleccione clase:</td>
                <td>
                    <select id="clase" name="clase" required>
                        <option></option>
                        <option value="0">Preferencial</option>
                        <option value="1">General</option>

                    </select>
                </td>
            </tr>
                <tr>
                    <td>Precio: </td>
                    <td>
                        <input type="number" id="precioIndividual" name="precioIndividual">
                    </td>
                </tr>
                <tr><td colspan="2" align="center"><input type="submit" value="Editar"></td></tr>
            </table>
        </form>
        <br>
        <div align="center">
            <td><a href="index.jsp">LOGOUT</a><</td>
        </div>
    </body>
</html>
