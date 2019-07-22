/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Cine.Sala;
import Cine.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */
public class DBreservaciones {
    
    DBconexion db;
    
    public DBreservaciones(){
        this.db=new DBconexion();
    }
    
    public boolean validar_reservacion(int capacidad){//Revisa si hay disponible una habitacion con las espificaciones del usuario
        Sala h=new Sala();
        String sql="select * from salas";
        PreparedStatement pstm;
        try {
            pstm = db.getConexion().prepareStatement(sql);
            ResultSet res=pstm.executeQuery();
            while(res.next()){
                if (res.getInt("capacidad")>=capacidad  && res.getInt("estado")==1){
                    return true;
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return false;
    }
    
    public void realizar_reservacion(Sala h, Usuario u){ //en uso
        try {
            String sql="update habitaciones set estado = ?, alojados = ?, usuario = ? where numSal = ?";
            PreparedStatement pstm=db.getConexion().prepareStatement(sql);
            pstm.setInt(1, 0);
            pstm.setInt(2, h.getCapacidad());
            pstm.setString(3, u.getUsername());
            pstm.setString(4, h.getNumero_sala());
            
            pstm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public boolean validar_saldo(Usuario u, int precio) throws SQLException{
        String sql="select * from usuarios where usuario = ?";
        PreparedStatement pstm=db.getConexion().prepareStatement(sql);
        ResultSet res=pstm.executeQuery();
        pstm.setString(1, u.getUsername());
        if(res.getInt("saldo")<precio){
            return false;
        }else{
            return true;
        }
    }
    
    public void cancelar_reservacion(Usuario u, Sala h){ //en uso
        try {
            String sql="update habitaciones set estado = ?, alojados = ?, usuario = ? where numSal = ?";
            PreparedStatement pstm = db.getConexion().prepareStatement(sql);
            pstm.setInt(1,1);
            pstm.setInt(2,0);
            pstm.setString(3, "");
            pstm.setString(4, h.getNumero_sala());

            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
