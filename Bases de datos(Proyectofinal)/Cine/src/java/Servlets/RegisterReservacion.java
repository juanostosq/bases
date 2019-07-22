/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Datos.DBfunciones;
import Datos.DBreservaciones;
import Datos.DBusuarios;
import Cine.Sala;
import Cine.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author FAMILIA
 */
public class RegisterReservacion extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            DBfunciones db=new DBfunciones();
            Sala h=new Sala();
            Usuario u=new Usuario();
            DBreservaciones rese=new DBreservaciones();
            u.setUsername(request.getParameter("username"));
            u.setPassword(request.getParameter("pass"));
            ResultSet res=db.cargar_Funcion(request.getParameter("numHab")); h.setAsientos(Integer.parseInt(request.getParameter("Asientos")));
            h.setNumero_sala(request.getParameter("numSal"));
            rese.realizar_reservacion(h, u);
            out.println("<br><br><br><div align=\"center\">");
            out.println("<td><h3>La reservacion ha sido exitosa</h3></td>");
            String url="InterfazUsuario.jsp?user_login="+u.getUsername()+"&pass_login="+u.getPassword()+"/";
            out.println("<td><a href=\'"+url+"\'><input type=\"button\" value=\"Regresar\"></input></a></td>");
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
