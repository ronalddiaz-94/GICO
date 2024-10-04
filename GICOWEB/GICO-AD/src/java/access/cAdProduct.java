/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package access;

import classes.cCellar;
import classes.cProduct;
import classes.cProvider;

import conection.cAccesoDatos;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author
 */
public class cAdProduct {

    private Exception error;

    public Exception getError() {
        return error;
    }


//-------------GESTION DE PRODUCTOS----------------------------
    public String managementProduct(cProduct oProduct) {
        String result = "Error!! Add User";
        String SQL = "SELECT public.productmanagement("+oProduct.getProductMType()+","+oProduct.getProductId()+",'"+oProduct.getProductName()+"','"+oProduct.getProductDescription()+"',"+oProduct.getProductPrice()+","+oProduct.getProductIva()+",'"+oProduct.getProductDateExpiration()+"',"+oProduct.getProductCount()+","+oProduct.getProductTotalValue()+","+oProduct.getProductUtility()+","+oProduct.getProductAveragePrice()+",'"+oProduct.getProductDetail()+"',"+oProduct.getProductValue()+","+oProduct.getProductcountprocess()+","+oProduct.getoProvider().getProviderId()+");";
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
    public List<cProduct> listProduct() {
        List<cProduct> result = new ArrayList<cProduct>();

        String SQL = "select * FROM public.products p inner join public.providerproduct pp on (p.productid=pp.productid) inner join public.provider pr on (pp.providerid=pr.providerid) where p.productstate=1";
        try {
            // Crear un AccesoDatos
            cAccesoDatos ad = new cAccesoDatos();
            if (ad.conectar() != 0) { //  Solicitar conectar a la BD
                if (ad.ejecutarSelect(SQL) != 0) {
                    ResultSet rsProduct = ad.getRs();

                    while (rsProduct.next()) {
                        
                        cProduct oProduct = new cProduct();
                        cProvider oProvider = new cProvider();
                        
                        oProvider.setProviderId(rsProduct.getInt("providerid"));
                        oProvider.setProviderName(rsProduct.getString("providername"));
                        
                        oProduct.setProductId(rsProduct.getInt("productid"));
                        oProduct.setProductName(rsProduct.getString("productname"));
                        oProduct.setProductDescription(rsProduct.getString("productdescription"));
                        oProduct.setProductPrice(rsProduct.getDouble("productprice"));
                        oProduct.setProductIva(rsProduct.getDouble("productiva"));
                        oProduct.setProductDateExpiration(rsProduct.getString("productdateexpiration"));
                        oProduct.setProductCount(rsProduct.getDouble("productcount"));
                        oProduct.setProductTotalValue(rsProduct.getDouble("producttotalvalue"));
                        oProduct.setProductUtility(rsProduct.getDouble("productutility"));
                        oProduct.setProductAveragePrice(rsProduct.getDouble("productaverageprice"));
                        
                        oProduct.setoProvider(oProvider);
                        
                        result.add(oProduct);
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
     //reporte de todos los Usuario
    public List<cProduct> listProductInfo() {
        List<cProduct> result = new ArrayList<cProduct>();

        String SQL = "select * FROM public.products p inner join public.providerproduct pp on (p.productid=pp.productid) inner join public.provider pr on (pp.providerid=pr.providerid) inner join public.cellarproduct cp on (cp.productid=p.productid) inner join public.cellar c on (cp.cellarid = c.cellarid) where p.productstate=1";
        try {
            // Crear un AccesoDatos
            cAccesoDatos ad = new cAccesoDatos();
            if (ad.conectar() != 0) { //  Solicitar conectar a la BD
                if (ad.ejecutarSelect(SQL) != 0) {
                    ResultSet rsProduct = ad.getRs();

                    while (rsProduct.next()) {
                        cProduct oProduct = new cProduct();
                        cProvider oProvider = new cProvider();
                        cCellar oCellar = new cCellar();
                        
                        oProvider.setProviderId(rsProduct.getInt("providerid"));
                        oProvider.setProviderName(rsProduct.getString("providername"));
                        
                        oCellar.setCellarId(rsProduct.getInt("cellarid"));
                        
                        oProduct.setProductId(rsProduct.getInt("productid"));
                        oProduct.setProductName(rsProduct.getString("productname"));
                        oProduct.setProductDescription(rsProduct.getString("productdescription"));
                        oProduct.setProductPrice(rsProduct.getDouble("productprice"));
                        oProduct.setProductIva(rsProduct.getDouble("productiva"));
                        oProduct.setProductDateExpiration(rsProduct.getString("productdateexpiration"));
                        oProduct.setProductCount(rsProduct.getDouble("productcount"));
                        oProduct.setProductTotalValue(rsProduct.getDouble("producttotalvalue"));
                        oProduct.setProductUtility(rsProduct.getDouble("productutility"));
                        oProduct.setProductAveragePrice(rsProduct.getDouble("productaverageprice"));
                        
                        oProduct.setoProvider(oProvider);
                        oProduct.setoCellar(oCellar);
                        
                        result.add(oProduct);
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
   
    //reporte de todos los Productos ppara movil
    public List<cProduct> listMovilProduct() {
        List<cProduct> result = new ArrayList<cProduct>();
       String SQL = "SELECT * FROM public.products";
        
        try {
            // Crear un AccesoDatos
            cAccesoDatos ad = new cAccesoDatos();
            if (ad.conectar() != 0) { //  Solicitar conectar a la BD
                if (ad.ejecutarSelect(SQL) != 0) {
                    ResultSet rsProduct = ad.getRs();

                    while (rsProduct.next()) {
                        cProduct oProduct = new cProduct();
                        oProduct.setProductId(rsProduct.getInt("productid"));
                        oProduct.setProductName(rsProduct.getString("productname"));
                        oProduct.setProductDescription(rsProduct.getString("productdescription"));
                        oProduct.setProductPrice(rsProduct.getDouble("productprice"));
                        oProduct.setProductIva(rsProduct.getDouble("productiva"));
                        oProduct.setProductDateExpiration(rsProduct.getString("productdateexpiration"));
                        oProduct.setProductCount(rsProduct.getDouble("productcount"));
                        oProduct.setProductTotalValue(rsProduct.getDouble("producttotalvalue"));
                        oProduct.setProductUtility(rsProduct.getDouble("productutility"));
                        oProduct.setProductAveragePrice(rsProduct.getDouble("productaverageprice"));
                        result.add(oProduct);
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
    
    public List<cProduct> listProductCellar(cCellar cellar) {
        List<cProduct> result = new ArrayList<cProduct>();

        String SQL = "SELECT p.productid, p.productname,p.productdescription,p.productprice, p.productiva, p.productdateexpiration, cp.productcountcellar as productcount, p.producttotalvalue, p.productutility, p.productaverageprice     FROM public.products as p inner join public.cellarproduct as cp on (p.productid = cp.productid)where cp.cellarid="+cellar.getCellarId()+"";
        try {
            // Crear un AccesoDatos
            cAccesoDatos ad = new cAccesoDatos();
            if (ad.conectar() != 0) { //  Solicitar conectar a la BD
                if (ad.ejecutarSelect(SQL) != 0) {
                    ResultSet rsProduct = ad.getRs();

                    while (rsProduct.next()) {
                        cProduct oProduct = new cProduct();
                        oProduct.setProductId(rsProduct.getInt("productid"));
                        oProduct.setProductName(rsProduct.getString("productname"));
                        oProduct.setProductDescription(rsProduct.getString("productdescription"));
                        oProduct.setProductPrice(rsProduct.getDouble("productprice"));
                        oProduct.setProductIva(rsProduct.getDouble("productiva"));
                        oProduct.setProductDateExpiration(rsProduct.getString("productdateexpiration"));
                        oProduct.setProductCount(rsProduct.getDouble("productcount"));
                        oProduct.setProductTotalValue(rsProduct.getDouble("producttotalvalue"));
                        oProduct.setProductUtility(rsProduct.getDouble("productutility"));
                        oProduct.setProductAveragePrice(rsProduct.getDouble("productaverageprice"));
                        result.add(oProduct);
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
    
    
            
    public String returnPrincipalProduct(cProduct oProduct) {
        String result = "Error!! Return Product";
        String SQL = "UPDATE public.cellarproduct set productcountcellar= productcountcellar+"+oProduct.getProductCount()+" where cellarid=1 AND productid="+oProduct.getProductId()+";";
        String SQL1 = "DELETE FROM public.cellarproduct where cellarid="+oProduct.getProductMType()+" AND productid="+oProduct.getProductId()+";";
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
