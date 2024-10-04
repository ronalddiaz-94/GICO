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
import java.util.List;

/**
 *
 * @author Ronald
 */
public class cAdBusiness {
    
    private Exception error;

    public Exception getError() {
        return error;
    }
    
    
    //-------------GESTION DE DATOS DE EMPRESA----------------------------
    public String managementBusiness(cBusiness oBusiness) {
        String result = "Error!! Add Business";     
        String SQL = "SELECT public.businessmanagement("+oBusiness.getBusinessMType()+","+oBusiness.getBusinessId()+",'"+oBusiness.getBusinessMission()+"','"+oBusiness.getBusinessView()+"','"+oBusiness.getBusinessName()+"','"+oBusiness.getBusinessAddress()+"','"+oBusiness.getBusinessPhon()+"','"+oBusiness.getBusinessCell()+"');";
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
    public List<cBusiness> listBusiness() {
        List<cBusiness> result = new ArrayList<cBusiness>();

        String SQL = "select * From public.business order by businessid ASC limit 1;";
        try {
            // Crear un AccesoDatos
            cAccesoDatos ad = new cAccesoDatos();
            if (ad.conectar() != 0) { //  Solicitar conectar a la BD
                if (ad.ejecutarSelect(SQL) != 0) {
                    ResultSet rsCellar = ad.getRs();

                    while (rsCellar.next()) {
                        cBusiness oBusiness = new cBusiness();
                        oBusiness.setBusinessId(rsCellar.getInt("businessid")); 
                        oBusiness.setBusinessMission(rsCellar.getString("businessmission"));
                        oBusiness.setBusinessView(rsCellar.getString("businessview"));
                        oBusiness.setBusinessName(rsCellar.getString("businessname"));
                        oBusiness.setBusinessAddress(rsCellar.getString("businessaddress")); 
                        oBusiness.setBusinessPhon(rsCellar.getString("businessphon"));
                        oBusiness.setBusinessCell(rsCellar.getString("businesscell"));
                        result.add(oBusiness);
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
