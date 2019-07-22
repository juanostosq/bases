/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Datos.DBusuarios;
import Cine.Persona;
import Cine.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author diego
 */
@WebServlet(name = "RegisterUser", urlPatterns = {"/RegisterUser"})
public class RegisterUser extends HttpServlet {
    public void Asignar(Persona p,String nombre,String apellido, String ident, String tel){
        p.setNombre(nombre);
        p.setApellido(apellido);
        p.setIdentificacion(ident);
        p.setTelefono(tel);
    }
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            Usuario u =new Usuario();
            DBusuarios db=new DBusuarios();
            
            String nombre=request.getParameter("nombre_user");
            String apellido=request.getParameter("apellido_user");
            String ident=request.getParameter("identificacion_user");
            String tel=request.getParameter("tel_user");
            Asignar(u,nombre,apellido,ident,tel);
            u.setUsername(request.getParameter("user_register"));
            u.setPassword(request.getParameter("user_pass"));
            u.setSaldo(Integer.parseInt(request.getParameter("saldo_user")));
            boolean desicion=db.validar_registro(u.getUsername());
            if(desicion==false){
                db.insertar_usuario(u);
                String url="InterfazUsuario.jsp?user_login="+u.getUsername()+"&pass_login="+u.getPassword()+"";
                response.sendRedirect(url);
            }else{
                response.sendRedirect("Usuario.jsp");
                out.println("<div align='center'>El nombre de usuario ya existe, Por favor intente con otro</div>");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
