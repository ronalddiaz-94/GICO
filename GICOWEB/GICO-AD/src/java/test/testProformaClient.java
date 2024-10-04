/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import access.cAdClient;
import access.cAdProforma;
import classes.cClient;
import classes.cProduct;
import classes.cProforma;
import java.util.List;

/**
 *
 * @author Ronald
 */
public class testProformaClient {
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        cAdProforma accProforma= new cAdProforma();
        cProforma oProforma = new cProforma();
        cProduct oProduct = new cProduct();
        
        
        
//         //Ingresar Modificar y eliminarusuario
        //1 Ingresar usuario
        //2 Modificar Usuario
        //3 Eliminar Usuario
        
        oProforma.setProformaMType(1); //gestion a realizar
        oProforma.setProformaId(90);
        oProduct.setProductId(9);
        oProduct.setProductPrice(12.00);
        oProduct.setProductIva(12.00);
        oProduct.setProductCount(12.00);
        oProduct.setProductUtility(12.00);
        oProforma.setoProduct(oProduct);
        accProforma.managementProformaProduct(oProforma);


//         List<cProforma> proforma = accProforma.listProforma();
//        for (cProforma oproforma : proforma) {
//            System.out.println("id:" + oproforma.getProformaId());
//            System.out.println("id:" + oproforma.getClientId());
//            System.out.println("precio:" + oproforma.getProformaTotal());
//            System.out.println("id:" + oproforma.getProformaTime());
//            System.out.println("id:" + oproforma.getProformaDate());
//        }
//        

    }
}
