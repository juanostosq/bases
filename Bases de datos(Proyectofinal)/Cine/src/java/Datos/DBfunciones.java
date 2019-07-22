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
 * @author Estudiantes
 */
public class DBfunciones {
    
    DBconexion db;
    
    public DBfunciones(){
        this.db=new DBconexion();
    }
    
    public void crear_Funcion(Sala h,int clase){ //en uso
        try{
            String sql="insert into habitaciones(clase,"
                    + "capacidad,"
                    + "Asientos,"
                    + "estado,"
                    + "precioIndividual,"
                    + "numSal,"
                    + "usuario)"
                    + "values(?,?,?,?,?,?,?)";
        
            PreparedStatement pstm=db.getConexion().prepareStatement(sql);
            String sala=h.getNumero_sala();
            pstm.setString(1, sala);
            pstm.setInt(2, h.getCapacidad());
            pstm.setInt(3, h.getAsientos());
            pstm.setInt(4, 1); //la habitacion esta vacia por eso el 1, acaba de ser creada
            pstm.setDouble(5, h.getPrecio());
            pstm.setString(6, h.getNumero_sala());
            pstm.setString(7, "");
            
            pstm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public ResultSet mostrar_Funcion_disponible(Sala h, int clase) throws SQLException{
        String sql="select * from habitaciones where (clase = ?) and (estado = ?)";
        PreparedStatement pstm=db.getConexion().prepareStatement(sql);
        pstm.setString(1, h.getNumero_sala());
        pstm.setInt(2, 1);
        ResultSet res=pstm.executeQuery();
        if(res.getInt("capacidad")>=h.getAsientos()){
            return res;
        }
        return null;
    }
    
    public ResultSet cargar_Funcion(String numSal){
        String sql="select * from Salas where numSal = ?";
        PreparedStatement pstm;
        try {
            pstm = db.getConexion().prepareStatement(sql);
            pstm.setString(1, numSal);
            ResultSet res=pstm.executeQuery();
            return res;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }
    
    public ResultSet Listar_funciones() throws SQLException{ //en uso
        String sql="select * from habitaciones";
        PreparedStatement pstm=db.getConexion().prepareStatement(sql);
        ResultSet res=pstm.executeQuery();
        return res;
    }
    
    public void actualizar_precio(Sala h, int clase){ //en uso
        String sql="update habitaciones set precioIndividual = ? where clase = ?";
        try {
            PreparedStatement pstm=db.getConexion().prepareStatement(sql);
            pstm.setInt(1, h.getPrecio_individual());
            pstm.setString(2, h.getNumero_sala());
            
            pstm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public boolean validarSal(String numSal) throws SQLException{ //en uso
        String sql="select numSal from habitaciones";
        PreparedStatement pstm=db.getConexion().prepareStatement(sql);
        ResultSet res=pstm.executeQuery();
        while(res.next()){
            if(res.getString("numSal").equals(numSal)){
                return true;
            }
        }
        return false;
    }
    
}
