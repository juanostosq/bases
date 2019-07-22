/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cine;

import java.util.ArrayList;

/**
 *
 * @author Estudiantes
 */
public class Sala implements Interfaces.Precio{
    
    private boolean estado;
    private int capacidad;
    private int Boletas;
    private int Asientos;
    private int precio;
    private String pelicula;
    
    private int sala;
    private String salas;
    
    public Sala(){


        this.capacidad=0;
        this.estado=true;
        this.sala=0;
        this.precio=0;
        this.Boletas=0;
        this.salas="";
    }

    public int getAsientos() {
        return Asientos;
    }

    public void setAsientos(int Asientos) {
        this.Asientos = Asientos;
    }

    public String getNumero_sala() {
        return salas;
    }

    public void setNumero_sala(String numero_sala) {
        this.salas = numero_sala;
    }
    
    public int getCapacidad() {
        return Boletas;
    }

    public void setCapacidad(int capacidad) {
        this.Boletas = capacidad; 
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }


    public int getPrecio_individual() {
        return precio;
    }

    public void setPrecio_individual(int precio_individual) {
        this.precio = precio_individual;
    }

    public int getPrecio() {
        return sala;
    }

    public String getPelicula() {
        return pelicula;
    }

    public void setPelicula(String pelicula) {
        this.pelicula = pelicula;
    }
 
    
    
    @Override
    public void setPrecio(){
        for(int i=0;i<this.Boletas;i++){
            this.sala+=this.precio;
            this.precio-=10000;
        }
    }

    


}
