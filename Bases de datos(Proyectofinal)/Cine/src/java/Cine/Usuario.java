/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cine;

/**
 *
 * @author Estudiantes
 */
public class Usuario extends Persona{
    
    private String username;
    private String password;
    private boolean reservacion;
    private int saldo;
    
    public Usuario(){
        super();
        this.reservacion=false;
        this.username="";
        this.password="";
        this.saldo=0;
    }

    public boolean isReservacion() {
        return reservacion;
    }

    public void setReservacion(boolean reservacion) {
        this.reservacion = reservacion;
    }

    public Usuario(Usuario u){
        super(u);
        this.username=u.username;
        this.password=u.password;
    }
    
    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void actualizar_saldo(int numero){
        this.saldo=this.saldo-numero;
    }
}
