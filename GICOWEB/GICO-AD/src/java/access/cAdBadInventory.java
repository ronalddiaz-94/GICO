/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package access;

import classes.*;
import conection.cAccesoDatos;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Ronald
 */
public class cAdBadInventory {
    
    private Exception error;

    public Exception getError() {
        return error;
    }

    //-------------GESTION DE PROVEEDORES----------------------------
    public String managementBadInventory(cBadInventory oBadInventory) {
        String result = "Error!! Add BadInventory";
        String SQL = "SELECT public.managementbadinventory(" + oBadInventory.getReturnedProductId()+ ",'" + oBadInventory.getProductName()+ "'," +oBadInventory.getProductId()+ "," +oBadInventory.getProductCount() + ");";
        try {
            // Crear un AccesoDato
            cAccesoDatos ad = new cAccesoDatos();
            if (ad.conectar() != 0) { //  Solicitar conectar a la BD
                if (ad.executeUpdate(SQL) != 0) {
                    result = "Successful";
                }
            } else {
                result = "There isn't connection with DB";
            }
            ad.desconectar();
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getClass().getName() + " *** " + e.getMessage());
            this.error = e;
        }
        return result;
    }


    //reporte de todos los Proveedores
    public List<cBadInventory> listBadInventory() {
        List<cBadInventory> result = new ArrayList<cBadInventory>();

        String SQL = "select * FROM public.badinventory";
        try {
            // Crear un AccesoDatos
            cAccesoDatos ad = new cAccesoDatos();
            if (ad.conectar() != 0) { //  Solicitar conectar a la BD
                if (ad.ejecutarSelect(SQL) != 0) {
                    ResultSet rsBadInventory = ad.getRs();

                    while (rsBadInventory.next()) {
                        cBadInventory oBadInventory = new cBadInventory();
                        oBadInventory.setProductName(rsBadInventory.getString("productName"));
                        oBadInventory.setProductId(rsBadInventory.getInt("productId"));
                        oBadInventory.setProductCount(rsBadInventory.getInt("productCount"));
                        oBadInventory.setReturnedProductId(rsBadInventory.getInt("returnedProductId"));
                        result.add(oBadInventory);
                    }
                    ad.desconectar();
                }
            }

        } catch (Exception e) {
            System.err.println("ERROR: " + e.getClass().getName() + " *** " + e.getMessage());

            this.error = e;
        } finally {
            return result;
        }

    }
    
}
