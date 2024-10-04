/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import access.*;
import classes.*;

/**
 *
 * @author Ronald
 */
public class testBusiness {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        cAdBusiness accBusiness = new cAdBusiness();
        cBusiness oBusiness = new cBusiness();
        
        
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
        
   
        oBusiness.setBusinessMType(1);
        oBusiness.setBusinessId(1);
        oBusiness.setBusinessMission("holaaaaaaa");
        oBusiness.setBusinessView("no veo");
        oBusiness.setBusinessName("GICO");
        oBusiness.setBusinessAddress("por ahi");
        oBusiness.setBusinessPhon("1234568");
        oBusiness.setBusinessCell("1234568"); 
        accBusiness.managementBusiness(oBusiness);

 

    }
}
