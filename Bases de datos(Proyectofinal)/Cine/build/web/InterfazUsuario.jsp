<%-- 
    Document   : InterfazUsuario
    Created on : 25/05/2018, 07:09:28 PM
    Author     : diego
--%>

<%@page import="Cine.Sala"%>
<%@page import="Datos.DBfunciones"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="Datos.DBusuarios"%>
<%@page import="Cine.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String user=request.getParameter("user_login");
    String pass=request.getParameter("pass_login");
            
    DBusuarios db=new DBusuarios();
    DBfunciones hab=new DBfunciones();
    Sala h=new Sala();
    ResultSet habitaciones=hab.Listar_funciones();
    boolean desicion=db.login(user, pass);
    ResultSet res=db.obtener_usuario(user);
    Usuario u=new Usuario();
    if(desicion && res.next()){
        u.setNombre(res.getString("nombre"));
        u.setUsername(res.getString("usuario"));
        u.setPassword(res.getString("pass"));
        u.setSaldo(res.getInt("saldo"));
    }else{
        response.sendRedirect("Usuario.jsp");
    }
%>
<script type="text/javascript">
    history.forward();
</script>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home <%= u.getNombre()%></title>
    </head>

</html>
