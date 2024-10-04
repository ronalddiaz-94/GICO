/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import access.cAdCellar;
import classes.cCellar;

public class testCellar {
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        cAdCellar accCellar = new cAdCellar();
        cCellar oCellar = new cCellar();
        
        
        //Listar usuario
//        List<cProduct> product = accProduct.listProduct();
//        for (cProduct oproduct : product) {
//            System.out.println("id:" + oproduct.getProductId());
//            System.out.println("id:" + oproduct.getProductName());
//            System.out.println("id:" + oproduct.getProductDescription());
//            System.out.println("id:" + oproduct.getProductPrice());
//            System.out.println("id:" + oproduct.getProductDateExpiration());
//            System.out.println("id:" + oproduct.getProductCount());
//
//        }
        
        
        //Ingresar Modificar y eliminarusuario
        //1 Ingresar usuario
        //2 Modificar Usuario
        //3 Eliminar Usuario
//      
        oCellar.setCellarMType(3);
        oCellar.setCellarId(5);
        oCellar.setCellarName("holaaaaaaa");
        oCellar.setCellarManager("yoofwf");
        accCellar.managementCellar(oCellar);

 

    }
}
