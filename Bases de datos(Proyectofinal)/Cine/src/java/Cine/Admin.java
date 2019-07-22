/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cine;

import Interfaces.AdminInterface;

/**
 *
 * @author diego
 */
public class Admin implements AdminInterface{
    
    private final String AdminName="ADMIN";
    private final String Password="TRIVAGO";

    public String getAdminName() {
        return AdminName;
    }

    public String getPassword() {
        return Password;
    }
    
    @Override
    public boolean validar_admin(String user,String pass){
        if(this.Password.equals(pass) && this.AdminName.equals(user)){
            return true;
        }else{
            return false;
        }
    }
    
}
