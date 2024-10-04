/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import access.*;
import classes.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.media.multipart.FormDataParam;

/**
 * REST Web Service
 *
 * @author Ronald
 */
@Path("Factura")
public class restFactura {

    public static class Model {

        public String message;
        public String date;
    }
    cFactura objFactura = new cFactura();
    cProduct objProduct = new cProduct();
    cAdFactura objFuntionFactura = new cAdFactura();

    @Context
    private UriInfo context;

    public restFactura() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        return "hola";
    }

    @POST
    @Path("managementFactura")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.MULTIPART_FORM_DATA})
    public Model managementFactura(@FormDataParam("facturaMType") Integer facturaMType, //recivimos los datos desde la ventana modal del Facturae
            @FormDataParam("facturaId") Integer facturaId, 
            @FormDataParam("clientId") Integer clientId,
            @FormDataParam("facturaTotal") Double facturaTotal,
            @FormDataParam("facturaSubTotal") Double facturaSubTotal,
            @FormDataParam("facturaIva") Double facturaIva,
            @FormDataParam("facturaTime") Integer facturaTime,
            @FormDataParam("facturaState") Integer facturaState,
            @FormDataParam("facturaDate") String facturaDate) {
        Model model = new Model();
        try {
            objFactura.setFacturaMType(facturaMType);
            objFactura.setFacturaId(facturaId);
            objFactura.setClientId(clientId);
            objFactura.setFacturaTotal(facturaTotal);
            objFactura.setFacturaSubTotal(facturaSubTotal);
            objFactura.setFacturaIva(facturaIva);
            objFactura.setFacturaState(facturaState);
            objFactura.setFacturaDate(facturaDate);

            String rs = objFuntionFactura.managementFactura(objFactura);
            String message = "Sin Respuesta";
            model.message = message;
            model.date = new Date().toString();
            if (rs.equals("Successful")) {
                message = "Exito";
                model.message = message;
                model.date = new Date().toString();
            }
            if (rs.equals("There isn't connection with DB")) {
                message = "Problemas con la conexion";
                model.message = message;
                model.date = new Date().toString();
            }
            if (rs.equals("Error!! Add User")) {
                message = "Error";
                model.message = message;
                model.date = new Date().toString();
            }

        } catch (Exception e) {
            String message = "error";
            model.message = message;
            model.date = new Date().toString();
        }
        return model;
    }
    
     @POST
    @Path("managementFacturaProduct")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.MULTIPART_FORM_DATA})
    public Model managementFacturaProduct(@FormDataParam("facturaMType") Integer facturaMType, //recivimos los datos desde la ventana modal del Facturae
            @FormDataParam("productId") Integer productId, 
            @FormDataParam("facturaId") Integer facturaId, 
            @FormDataParam("productPrice") Double productPrice, 
            @FormDataParam("productCount") Double productCount,
            @FormDataParam("productIva") Double productIva,
            @FormDataParam("productUtility") Double productUtility,
            @FormDataParam("productName") String productName, 
            @FormDataParam("productDescription") String productDescription, 
            @FormDataParam("productDateExpiration") String productDateExpiration,
            @FormDataParam("productTotalValue") Double productTotalValue,
            @FormDataParam("productAveragePrice") Double productAveragePrice) {
        Model model = new Model();
        try {
            objFactura.setFacturaMType(facturaMType);
            objProduct.setProductId(productId);
            objProduct.setProductName(productName);
            objProduct.setProductDescription(productDescription);
            objProduct.setProductPrice(productPrice);
            objProduct.setProductIva(productIva);
            objProduct.setProductDateExpiration(productDateExpiration);
            objProduct.setProductCount(productCount);
            objProduct.setProductTotalValue(productTotalValue);
            objProduct.setProductUtility(productUtility);
            objProduct.setProductAveragePrice(productAveragePrice);
            objFactura.setFacturaId(facturaId);
            objFactura.setoProduct(objProduct);

            String rs = objFuntionFactura.managementFacturaProduct(objFactura);
            String message = "Sin Respuesta";
            model.message = message;
            model.date = new Date().toString();
            if (rs.equals("Successful")) {
                message = "Exito";
                model.message = message;
                model.date = new Date().toString();
            }
            if (rs.equals("There isn't connection with DB")) {
                message = "Problemas con la conexion";
                model.message = message;
                model.date = new Date().toString();
            }
            if (rs.equals("Error!! Add User")) {
                message = "Error";
                model.message = message;
                model.date = new Date().toString();
            }

        } catch (Exception e) {
            String message = "error";
            model.message = message;
            model.date = new Date().toString();
        }
        return model;
    }

    @GET
    @Path("/listFactura")
    @Produces(MediaType.APPLICATION_JSON)
    public List<cFactura> listFactura() {
        List<cFactura> result = new ArrayList<cFactura>();
        result = objFuntionFactura.listFactura();
        return result;
    }
    
    @GET
    @Path("/listfinalFactura")
    @Produces(MediaType.APPLICATION_JSON)
    public List<cFactura> listfinalFactura() {
        List<cFactura> result = new ArrayList<cFactura>();
        result = objFuntionFactura.listfinalFactura();
        return result;
    }
}
