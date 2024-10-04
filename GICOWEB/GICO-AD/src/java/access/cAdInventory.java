
package access;

import classes.cCellar;
import classes.cInventory;
import classes.cProduct;
import conection.cAccesoDatos;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class cAdInventory {
    
    private Exception error;

    public Exception getError() {
        return error;
    }
    
    
    //-------------GESTION DE BODEGAS----------------------------
    public String managementCellar(cCellar oCellar) {
        String result = "Error!! Add Cellar";     
        String SQL = "SELECT public.cellarmanagement("+oCellar.getCellarMType()+","+oCellar.getCellarId()+",'"+oCellar.getCellarName()+"','"+oCellar.getCellarManager()+"');";
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

    //listado de todos los productos existentes
    public List<cInventory> listInventory() {
        List<cInventory> result = new ArrayList<cInventory>();

        String SQL = "SELECT * FROM public.cellar as c inner join public.cellarproduct as cp on (c.cellarid=cp.cellarid) inner join public.products as p on (p.productid = cp.productid)";
        try {
            // Crear un AccesoDatos
            cAccesoDatos ad = new cAccesoDatos();
            if (ad.conectar() != 0) { //  Solicitar conectar a la BD
                if (ad.ejecutarSelect(SQL) != 0) {
                    ResultSet rsInventory = ad.getRs();

                    while (rsInventory.next()) {
                        cInventory oInventory = new cInventory();
                        cCellar oCellar=new cCellar();
                        cProduct oProduct = new cProduct();
                        Double totalPrice=0.0;
                        BigDecimal bd=rsInventory.getBigDecimal("productprice");
                        
                        oCellar.setCellarId(rsInventory.getInt("cellarid"));
                        oCellar.setCellarName(rsInventory.getString("cellarname"));
                        oCellar.setCellarManager(rsInventory.getString("cellarmanager"));
                        
                        oProduct.setProductId(rsInventory.getInt("productid"));
                        oProduct.setProductName(rsInventory.getString("productname"));
                        oProduct.setProductDescription(rsInventory.getString("productdescription"));
                        oProduct.setProductPrice(bd.doubleValue());
                        oProduct.setProductIva(rsInventory.getDouble("productiva"));
                        oProduct.setProductDateExpiration(rsInventory.getString("productdateexpiration"));
                        oProduct.setProductCount(rsInventory.getDouble("productcount"));
                        
                        oInventory.setProductCountCellar(rsInventory.getInt("productcountcellar"));
                        totalPrice=(rsInventory.getDouble("productprice"))*(rsInventory.getInt("productcountcellar"));
                        
                        oInventory.setTotalPrice(totalPrice);
                        oInventory.setoCellar(oCellar);
                        oInventory.setoProduct(oProduct);
                        result.add(oInventory);
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
    
    //Informacion general del invertario
    //cantidad de productos
    //cantidad en dinero de productos
    public List<cInventory> listInventoryGeneral() {
        List<cInventory> result = new ArrayList<cInventory>();

        String SQL = "SELECT sum(productprice*productcount) as productsprice, count(*) as productscount, sum((productutility*0.01)*(productprice*productcount)) as productsutility  FROM public.products;";
        try {
            // Crear un AccesoDatos
            cAccesoDatos ad = new cAccesoDatos();
            if (ad.conectar() != 0) { //  Solicitar conectar a la BD
                if (ad.ejecutarSelect(SQL) != 0) {
                    ResultSet rsInventory = ad.getRs();

                    while (rsInventory.next()) {
                        cInventory oInventory = new cInventory();

                        oInventory.setProductsPrice(rsInventory.getDouble("productsprice")); // presio de todos los productos en bodegas
                        oInventory.setProductsCount(rsInventory.getDouble("productscount"));//catidad de productos en bodega
                        oInventory.setProductsUtility(rsInventory.getDouble("productsutility")); //Utilidad de todos los productos en existencia
                        
                        result.add(oInventory);
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
