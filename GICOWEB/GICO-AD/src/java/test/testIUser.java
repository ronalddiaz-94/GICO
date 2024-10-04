/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import access.*;
import classes.*;
import java.util.List;

/**
 *
 * @author Jorge
 */
public class testIUser {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        cAdUser accUser = new cAdUser();
        cUser oUsuario = new cUser();
        
        
        //Listar usuario
//        List<cUser> usuario = accUser.listUser();
//        for (cUser user : usuario) {
//            System.out.println("id:" + user.getUserId());
//            System.out.println("nombre:" + user.getUserName());
//            System.out.println("username:" + user.getUserNameUser());
//            System.out.println("pass:" + user.getUserPass());
//            System.out.println("rol:" + user.getUserTypeDescription());
//
//        }
        
        
        //Ingresar Modificar y eliminarusuario
        //1 Ingresar usuario
        //2 Modificar Usuario
        //3 Eliminar Usuario
        
        oUsuario.setUserMType(1); //gestion a realizar
        oUsuario.setUserCI("0913157038");
        oUsuario.setUserName("Carlos2");
        oUsuario.setUserNameUser("gay sigues tras de la mayrita");
        oUsuario.setUserPass("pass");
        oUsuario.setUserRol(1);
        oUsuario.setUserId(27);
        accUser.managementUser(oUsuario);
//
// 

    }

}