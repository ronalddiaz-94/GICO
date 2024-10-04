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
public class cAdActivityClient {
    private Exception error;

    public Exception getError() {
        return error;
    }

    
    //reporte de todos los Actividades de los clientes
    public List<cActivityClient> listActivityClient(cClient oClient) {
        List<cActivityClient> result = new ArrayList<cActivityClient>();

        String SQL = "select * FROM public.activityclient where clientid="+oClient.getClientId()+" order by activityclientid DESC;";
        try {
            // Crear un AccesoDatos
            cAccesoDatos ad = new cAccesoDatos();
            if (ad.conectar() != 0) { //  Solicitar conectar a la BD
                if (ad.ejecutarSelect(SQL) != 0) {
                    ResultSet rsClient = ad.getRs();

                    while (rsClient.next()) {
                        cActivityClient oActivity= new cActivityClient(); 
                        oActivity.setActivityclientid(rsClient.getInt("activityclientid"));
                        oActivity.setActivityclientdescription(rsClient.getString("activityclientdescription"));
                        oActivity.setActivityclientcost(rsClient.getDouble("activityclientcost"));
                        oActivity.setActivityclientdate(rsClient.getString("activityclientdate"));
                        oActivity.setClientid(rsClient.getInt("clientid"));
                        result.add(oActivity);
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
