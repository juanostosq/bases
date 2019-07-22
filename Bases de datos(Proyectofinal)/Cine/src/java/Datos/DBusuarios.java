/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Cine.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Estudiantes
 */
public class DBusuarios {
    
    DBconexion db;
    
    public DBusuarios(){
        this.db=new DBconexion();
    }
    
    public void insertar_usuario(Usuario u){
        try{
            String sql="insert into usuarios(nombre,"
                    + "apellido,"
                    + "identificacion,"
                    + "telefono,"
                    + "usuario,"
                    + "pass,"
                    + "saldo)"
                    + "values(?,?,?,?,?,?,?)";
            PreparedStatement pstm=db.getConexion().prepareStatement(sql);
            pstm.setString(1, u.getNombre());
            pstm.setString(2, u.getApellido());
            pstm.setString(3, u.getIdentificacion());
            pstm.setString(4, u.getTelefono());
            pstm.setString(5, u.getUsername());
            pstm.setString(6, u.getPassword());
            pstm.setInt(7, u.getSaldo());
            
            pstm.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public boolean validar_registro(String username) throws SQLException{ //en uso
        String sql="select * from usuarios";
        PreparedStatement pstm=db.getConexion().prepareStatement(sql);
        ResultSet res=pstm.executeQuery();
        while(res.next()){
            if(res.getString("usuario").equals(username)){
                return true;
            }
        }
        return false;
    }
    
    public boolean login(String user,String pass) throws SQLException{ //en uso
        String sql="select usuario,pass from usuarios";
        PreparedStatement pstm=db.getConexion().prepareStatement(sql);
        ResultSet res=pstm.executeQuery();
        while(res.next()){
            if(res.getString("usuario").equals(user) && res.getString("pass").equals(pass)){
                return true;
            }
        }
        return false;
    }
    
    public ResultSet obtener_usuario(String username) throws SQLException{ //en uso
        String sql="select * from usuarios where usuario = ?";
        PreparedStatement pstm=db.getConexion().prepareStatement(sql);
        pstm.setString(1, username);
        ResultSet res=pstm.executeQuery();
        return res;
    }
    
    public void actualizar_saldo(Usuario u,int restar){
        String sql="update usuarios set saldo = ? where usuario = ?";
        try {
            PreparedStatement pstm=db.getConexion().prepareStatement(sql);
            u.actualizar_saldo(restar);
            pstm.setInt(1, u.getSaldo());
            pstm.setString(2, u.getUsername());
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void actualizar_reservacion(Usuario u,boolean reservacion){
        String sql="update usuarios set reservacion = ? where usuario = ?";
        try{
            PreparedStatement pstm=db.getConexion().prepareStatement(sql);
            u.setReservacion(reservacion);
            if(u.isReservacion()){
                pstm.setInt(1, 0);
            }else{
                pstm.setInt(1, 1);
            }            
            
            pstm.setString(2, u.getUsername());
            pstm.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }
}
