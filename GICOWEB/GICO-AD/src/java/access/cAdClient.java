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
public class cAdClient {
    
    private Exception error;

    public Exception getError() {
        return error;
    }
    
    
    //-------------GESTION DE PROVEEDORES----------------------------
    public String managementClient(cClient oClient) {
        String result = "Error!! Add Client";     
        String SQL = "SELECT public.clientmanagement("+oClient.getClientMType()+","+oClient.getClientId()+",'"+oClient.getClientCi()+"','"+oClient.getClientName()+"','"+oClient.getClientPhone()+"','"+oClient.getClientCell()+"','"+oClient.getClientMail()+"',"+oClient.getClientCredit()+",'"+oClient.getClientAddress()+"');";
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
    public List<cClient> listClient() {
        List<cClient> result = new ArrayList<cClient>();

        String SQL = "select * FROM public.client";
        try {
            // Crear un AccesoDatos
            cAccesoDatos ad = new cAccesoDatos();
            if (ad.conectar() != 0) { //  Solicitar conectar a la BD
                if (ad.ejecutarSelect(SQL) != 0) {
                    ResultSet rsClient = ad.getRs();

                    while (rsClient.next()) {
                        cClient oClient = new cClient();
                        oClient.setClientId(rsClient.getInt("clientid"));
                        oClient.setClientCi(rsClient.getString("clientCi"));
                        oClient.setClientName(rsClient.getString("clientName"));
                        oClient.setClientPhone(rsClient.getString("clientPhone"));
                        oClient.setClientCell(rsClient.getString("clientCell"));
                        oClient.setClientMail(rsClient.getString("clientMail"));
                        oClient.setClientCredit(rsClient.getDouble("clientCredit"));
                        oClient.setClientAddress(rsClient.getString("clientAddress"));
                        result.add(oClient);
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
    
    public String clientPay(cClient oClient) {
        String result = "Error!! Add Client";
        String SQL = "UPDATE public.client  SET clientcredit=" + oClient.getClientCredit() + " WHERE clientid=" + oClient.getClientId() + ";";
        String DescripcionPago = "";
        if (oClient.getClientCredit() == 0) {
            DescripcionPago = "Cancelacion de la deuda";
        } else {
            DescripcionPago = "Abono de la deuda";
        }
        String date = new Date().toString();
        String SQL1 = "INSERT INTO public.activityclient( activityclientid, activityclientdescription, activityclientcost, clientid, activityclientdate) VALUES (default,'" + DescripcionPago + "'," + oClient.getClientPay() + "," + oClient.getClientId() + ",'" + date + "');";
        try {
            // Crear un AccesoDato
            cAccesoDatos ad = new cAccesoDatos();
            if (ad.conectar() != 0) { //  Solicitar conectar a la BD
                if (ad.executeUpdate(SQL) != 0) {
                    if (ad.conectar() != 0) {
                        if (ad.executeUpdate(SQL1) != 0) {
                            result = "Successful";
                        } else {
                            result = "There isn't connection with DB";
                        }
                    }else {
                        result = "There isn't connection with DB";
                    }
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
    
}
