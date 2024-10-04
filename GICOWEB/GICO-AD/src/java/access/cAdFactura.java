/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package access;

import classes.cClient;
import classes.cFactura;

import conection.cAccesoDatos;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author
 */
public class cAdFactura {

    private Exception error;

    public Exception getError() {
        return error;
    }


//-------------GESTION DE Factura----------------------------
    public String managementFactura(cFactura oFactura) {
        String result = "Error!! Add User";
        String SQL = "SELECT public.facturamanagement("+oFactura.getFacturaMType()+","+oFactura.getFacturaId()+","+oFactura.getClientId()+","+oFactura.getFacturaTotal()+","+oFactura.getFacturaState()+","+oFactura.getFacturaDate()+","+oFactura.getFacturaIva()+","+oFactura.getFacturaSubTotal()+");";
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

    //-------------GESTION DE Factura PRODUCTOS----------------------------
    public String managementFacturaProduct(cFactura oFactura) {
        String result = "Error!! Add User";
        String SQL = "SELECT public.proforproductmamanagement("+oFactura.getFacturaMType()+","+oFactura.getoProduct().getProductId()+","+oFactura.getFacturaId()+","+oFactura.getoProduct().getProductPrice()+","+oFactura.getoProduct().getProductIva()+","+oFactura.getoProduct().getProductCount()+","+oFactura.getoProduct().getProductUtility()+");";
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

    
    // listar Facturas
    public List<cFactura> listFactura() {
        List<cFactura> result = new ArrayList<cFactura>();

        String SQL = "select * from public.Factura p inner join public.client c on (p.clientid=c.clientid)";
        try {
            // Crear un AccesoDatos
            cAccesoDatos ad = new cAccesoDatos();
            if (ad.conectar() != 0) { //  Solicitar conectar a la BD
                if (ad.ejecutarSelect(SQL) != 0) {
                    ResultSet rsFactura = ad.getRs();

                    while (rsFactura.next()) {
                        cFactura oFactura = new cFactura();
                        cClient oClient = new cClient();
                        
                        oClient.setClientId(rsFactura.getInt("clientid"));
                        oClient.setClientCi(rsFactura.getString("clientci"));
                        oClient.setClientName(rsFactura.getString("clientname"));
                        oClient.setClientPhone(rsFactura.getString("clientphone"));
                        oClient.setClientCell(rsFactura.getString("clientcell"));
                        oClient.setClientMail(rsFactura.getString("clientmail"));
                        oClient.setClientCredit(rsFactura.getDouble("clientcredit"));
                        oClient.setClientAddress(rsFactura.getString("clientaddress"));
                        
                        oFactura.setFacturaId(rsFactura.getInt("facturaid"));
                        oFactura.setClientId(rsFactura.getInt("clientid"));
                        oFactura.setFacturaTotal(rsFactura.getDouble("facturatotal"));
                        oFactura.setFacturaState(rsFactura.getInt("facturastate"));
                        oFactura.setFacturaDate(rsFactura.getString("facturadate"));
                        oFactura.setFacturaIva(rsFactura.getDouble("facturaiva"));
                        oFactura.setFacturaSubTotal(rsFactura.getDouble("facturasubtotal"));
                        
                        oFactura.setoClient(oClient);
                        
                        result.add(oFactura);
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
    
    // listar Facturas
    public List<cFactura> listfinalFactura() {
        List<cFactura> result = new ArrayList<cFactura>();

        String SQL = "select * from public.Factura p inner join public.client c on (p.clientid=c.clientid)ORDER BY p.Facturaid DESC LIMIT 1;";
        try {
            // Crear un AccesoDatos
            cAccesoDatos ad = new cAccesoDatos();
            if (ad.conectar() != 0) { //  Solicitar conectar a la BD
                if (ad.ejecutarSelect(SQL) != 0) {
                    ResultSet rsFactura = ad.getRs();

                    while (rsFactura.next()) {
                        cFactura oFactura = new cFactura();
                        cClient oClient = new cClient();
                        
                        oClient.setClientId(rsFactura.getInt("clientid"));
                        oClient.setClientCi(rsFactura.getString("clientci"));
                        oClient.setClientName(rsFactura.getString("clientname"));
                        oClient.setClientPhone(rsFactura.getString("clientphone"));
                        oClient.setClientCell(rsFactura.getString("clientcell"));
                        oClient.setClientMail(rsFactura.getString("clientmail"));
                        oClient.setClientCredit(rsFactura.getDouble("clientcredit"));
                        oClient.setClientAddress(rsFactura.getString("clientaddress"));
                        
                        oFactura.setFacturaId(rsFactura.getInt("Facturaid"));
                        oFactura.setClientId(rsFactura.getInt("clientid"));
                        oFactura.setFacturaTotal(rsFactura.getDouble("Facturatotal"));
                        oFactura.setFacturaState(rsFactura.getInt("Facturastate"));
                        oFactura.setFacturaDate(rsFactura.getString("Facturadate"));
                        
                        oFactura.setoClient(oClient);
                        
                        result.add(oFactura);
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
