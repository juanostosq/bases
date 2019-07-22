/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cine;

/**
 *
 * @author diego
 */
public class Persona {
    
    private String nombre;
    private String apellido;
    private String identificacion;
    private String telefono;
    
    public Persona(){
        this.nombre="";
        this.apellido="";
        this.identificacion="";
        this.telefono="";
    }
    
    public Persona(Persona p){
        this.nombre=p.nombre;
        this.apellido=p.apellido;
        this.identificacion=p.identificacion;
        this.telefono=p.telefono;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
}
