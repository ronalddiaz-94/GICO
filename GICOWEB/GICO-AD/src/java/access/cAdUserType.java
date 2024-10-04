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
public class cAdUserType {
    
    private Exception error;

    public Exception getError() {
        return error;
    }


//-------------GESTION DE USUARIOS----------------------------
    public String managementUserType(cUserType oUserType) {
        String result = "Error!! Add User Type";
        String SQL = "SELECT public.usertypemanagement("+oUserType.getUsertypeMType()+",'"+oUserType.getUserTypeDescription()+"',"+oUserType.getUserTypeId()+");";
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

    //reporte de todos los Usuario
    public List<cUserType> listUserType() {
        List<cUserType> result = new ArrayList<cUserType>();

        String SQL = "select * FROM public.usertype";
        try {
            // Crear un AccesoDatos
            cAccesoDatos ad = new cAccesoDatos();
            if (ad.conectar() != 0) { //  Solicitar conectar a la BD
                if (ad.ejecutarSelect(SQL) != 0) {
                    ResultSet rsUsuario = ad.getRs();

                    while (rsUsuario.next()) {
                        cUserType oUserType = new cUserType();
                        oUserType.setUserTypeId(rsUsuario.getInt("usertypeid"));
                        oUserType.setUserTypeDescription(rsUsuario.getString("usertypedescription"));
                        result.add(oUserType);
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
