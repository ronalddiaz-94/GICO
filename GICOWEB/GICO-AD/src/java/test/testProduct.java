/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import access.*;
import classes.*;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Jorge
 */
public class testProduct {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        cAdProduct accProduct = new cAdProduct();
        cProduct oProduct = new cProduct();
        cProvider oProvider = new cProvider();
        
        
        //Listar usuario
//        List<cProduct> product = accProduct.listProduct();
//        for (cProduct oproduct : product) {
//            System.out.println("id:" + oproduct.getProductId());
//            System.out.println("id:" + oproduct.getProductName());
//            System.out.println("id:" + oproduct.getProductDescription());
//            System.out.println("precio:" + oproduct.getProductPrice());
//            System.out.println("id:" + oproduct.getProductDateExpiration());
//            System.out.println("id:" + oproduct.getProductCount());
//
//        }
        
        
        //Ingresar Modificar y eliminarusuario
        //1 Ingresar usuario
        //2 Modificar Usuario
        //3 Eliminar Usuario 
////        
        oProduct.setProductMType(4); //gestion a realizar
        oProduct.setProductId(1);
        oProduct.setProductName("Papitas 7");
        oProduct.setProductDescription("Car");
        oProduct.setProductPrice(3.7);
        oProduct.setProductIva(12.0);
        oProduct.setProductDateExpiration("12-12-2019");
        oProduct.setProductCount(6.0);
        oProduct.setProductTotalValue(6.0);
        oProduct.setProductUtility(0.52); 
        oProduct.setProductAveragePrice(256.36);
        oProduct.setProductDetail("256.36");
        oProduct.setProductValue(1.0);
        oProduct.setProductcountprocess(1.0);
        oProvider.setProviderId(3);
        oProduct.setoProvider(oProvider);
        
        accProduct.managementProduct(oProduct);

 
 

    }

}