/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package access;

import classes.cClient;
import classes.cProforma;

import conection.cAccesoDatos;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author
 */
public class cAdProforma {

    private Exception error;

    public Exception getError() {
        return error;
    }


//-------------GESTION DE PROFORMA----------------------------
    public String managementProforma(cProforma oProforma) {
        String result = "Error!! Add User";
        String SQL = "SELECT public.proformamanagement("+oProforma.getProformaMType()+","+oProforma.getProformaId()+","+oProforma.getClientId()+","+oProforma.getProformaTotal()+","+oProforma.getProformaTime()+","+oProforma.getProformaState()+",'"+oProforma.getProformaDate()+"');";
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

    //-------------GESTION DE PROFORMA PRODUCTOS----------------------------
    public String managementProformaProduct(cProforma oProforma) {
        String result = "Error!! Add User";
        String SQL = "SELECT public.proforproductmamanagement("+oProforma.getProformaMType()+","+oProforma.getoProduct().getProductId()+","+oProforma.getProformaId()+","+oProforma.getoProduct().getProductPrice()+","+oProforma.getoProduct().getProductIva()+","+oProforma.getoProduct().getProductCount()+","+oProforma.getoProduct().getProductUtility()+");";
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

    
    // listar proformas
    public List<cProforma> listProforma() {
        List<cProforma> result = new ArrayList<cProforma>();

        String SQL = "select * from public.proforma p inner join public.client c on (p.clientid=c.clientid)";
        try {
            // Crear un AccesoDatos
            cAccesoDatos ad = new cAccesoDatos();
            if (ad.conectar() != 0) { //  Solicitar conectar a la BD
                if (ad.ejecutarSelect(SQL) != 0) {
                    ResultSet rsProforma = ad.getRs();

                    while (rsProforma.next()) {
                        cProforma oProforma = new cProforma();
                        cClient oClient = new cClient();
                        
                        oClient.setClientId(rsProforma.getInt("clientid"));
                        oClient.setClientCi(rsProforma.getString("clientci"));
                        oClient.setClientName(rsProforma.getString("clientname"));
                        oClient.setClientPhone(rsProforma.getString("clientphone"));
                        oClient.setClientCell(rsProforma.getString("clientcell"));
                        oClient.setClientMail(rsProforma.getString("clientmail"));
                        oClient.setClientCredit(rsProforma.getDouble("clientcredit"));
                        oClient.setClientAddress(rsProforma.getString("clientaddress"));
                        
                        oProforma.setProformaId(rsProforma.getInt("proformaid"));
                        oProforma.setClientId(rsProforma.getInt("clientid"));
                        oProforma.setProformaTotal(rsProforma.getDouble("proformatotal"));
                        oProforma.setProformaTime(rsProforma.getInt("proformatime"));
                        oProforma.setProformaState(rsProforma.getInt("proformastate"));
                        oProforma.setProformaDate(rsProforma.getString("proformadate"));
                        
                        oProforma.setoClient(oClient);
                        
                        result.add(oProforma);
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
    
    // listar proformas
    public List<cProforma> listfinalProforma() {
        List<cProforma> result = new ArrayList<cProforma>();

        String SQL = "select * from public.proforma p inner join public.client c on (p.clientid=c.clientid)ORDER BY p.proformaid DESC LIMIT 1;";
        try {
            // Crear un AccesoDatos
            cAccesoDatos ad = new cAccesoDatos();
            if (ad.conectar() != 0) { //  Solicitar conectar a la BD
                if (ad.ejecutarSelect(SQL) != 0) {
                    ResultSet rsProforma = ad.getRs();

                    while (rsProforma.next()) {
                        cProforma oProforma = new cProforma();
                        cClient oClient = new cClient();
                        
                        oClient.setClientId(rsProforma.getInt("clientid"));
                        oClient.setClientCi(rsProforma.getString("clientci"));
                        oClient.setClientName(rsProforma.getString("clientname"));
                        oClient.setClientPhone(rsProforma.getString("clientphone"));
                        oClient.setClientCell(rsProforma.getString("clientcell"));
                        oClient.setClientMail(rsProforma.getString("clientmail"));
                        oClient.setClientCredit(rsProforma.getDouble("clientcredit"));
                        oClient.setClientAddress(rsProforma.getString("clientaddress"));
                        
                        oProforma.setProformaId(rsProforma.getInt("proformaid"));
                        oProforma.setClientId(rsProforma.getInt("clientid"));
                        oProforma.setProformaTotal(rsProforma.getDouble("proformatotal"));
                        oProforma.setProformaTime(rsProforma.getInt("proformatime"));
                        oProforma.setProformaState(rsProforma.getInt("proformastate"));
                        oProforma.setProformaDate(rsProforma.getString("proformadate"));
                        
                        oProforma.setoClient(oClient);
                        
                        result.add(oProforma);
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
