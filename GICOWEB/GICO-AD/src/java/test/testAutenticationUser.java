/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import access.*;
import classes.*;

public class testAutenticationUser {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        cAdAutentication accInventory = new cAdAutentication();

        //Listar usuario
//        List<cInventory> inventory = accInventory.listInventory();
//        for (cInventory oInventory : inventory) {
//            System.out.println("cantidad por bodega:" + oInventory.getProductCountCellar());
//            System.out.println("id:" + oInventory.getoCellar().getCellarId());
//            System.out.println("id:" + oInventory.getoCellar().getCellarName());
//            System.out.println("id:" + oInventory.getoCellar().getCellarManager());
//            
//            System.out.println("id:" + oInventory.getoProduct().getProductId());
//            System.out.println("id:" + oInventory.getoProduct().getProductName());
//            System.out.println("id:" + oInventory.getoProduct().getProductDescription());
//            System.out.println("id:" + oInventory.getoProduct().getProductPrice());
//            System.out.println("id:" + oInventory.getoProduct().getProductIva());
//            System.out.println("id:" + oInventory.getoProduct().getProductDateExpiration());
//            System.out.println("id:" + oInventory.getoProduct().getProductCount());
//        }
        
        //listar informacion general de inventario
        cUser oUserA = new cUser();
        oUserA.setUserNameUser("jorgelu94");
        oUserA.setUserPass("1234");
         cUser oUser = accInventory.autenticationUser(oUserA);
            System.out.println("Estado:" + oUser.getUserLogin());
            System.out.println("nombre:" + oUser.getUserName());
            System.out.println("pass:" + oUser.getUserPass());
            System.out.println("rol:" + oUser.getUserRolName());
            
        
        //Ingresar Modificar y eliminarusuario
        //1 Ingresar usuario
        //2 Modificar Usuario
        //3 Eliminar Usuario
//      
//        oCellar.setCellarMType(3);
//        oCellar.setCellarId(5);
//        oCellar.setCellarName("holaaaaaaa");
//        oCellar.setCellarManager("yoofwf");
//        accCellar.managementCellar(oCellar);
//
// 
    }
}
