/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import access.cAdUserType;
import classes.cUserType;
import java.util.List;

/**
 *
 * @author Ronald
 */
public class testUserType {
    
    
    
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        cAdUserType accUser= new cAdUserType();
        cUserType oUser = new cUserType();
           
        
              //Listar usuario
        List<cUserType> usuarioTipo = accUser.listUserType();
        for (cUserType userType : usuarioTipo) {
            System.out.println(":" + userType.getUserTypeDescription());
            System.out.println(":" + userType.getUserTypeId());
        }

        //Ingresar Modificar y eliminarusuario
        //1 Ingresar usuario
        //2 Modificar Usuario
        //3 Eliminar Usuario
//        

        oUser.setUsertypeMType(1); //gestion a realizar
        oUser.setUserTypeId(3);
        oUser.setUserTypeDescription("jorgito user");
        accUser.managementUserType(oUser);

 


    }
}
