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
@Path("proforma")
public class restProforma {

    public static class Model {

        public String message;
        public String date;
    }
    cProforma objProforma = new cProforma();
    cProduct objProduct = new cProduct();
    cAdProforma objFuntionProforma = new cAdProforma();

    @Context
    private UriInfo context;

    public restProforma() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        return "hola";
    }

    @POST
    @Path("managementProforma")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.MULTIPART_FORM_DATA})
    public Model managementProforma(@FormDataParam("proformaMType") Integer ProformaMType, //recivimos los datos desde la ventana modal del Proformae
            @FormDataParam("proformaId") Integer proformaId, 
            @FormDataParam("clientId") Integer clientId,
            @FormDataParam("proformaTotal") Double proformaTotal,
            @FormDataParam("proformaTime") Integer proformaTime,
            @FormDataParam("proformaState") Integer proformaState,
            @FormDataParam("proformaDate") String proformaDate) {
        Model model = new Model();
        try {
            objProforma.setProformaMType(ProformaMType);
            objProforma.setProformaId(proformaId);
            objProforma.setClientId(clientId);
            objProforma.setProformaTotal(proformaTotal);
            objProforma.setProformaTime(proformaTime);
            objProforma.setProformaState(proformaState);
            objProforma.setProformaDate(proformaDate);

            String rs = objFuntionProforma.managementProforma(objProforma);
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
    @Path("managementProformaProduct")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.MULTIPART_FORM_DATA})
    public Model managementProformaProduct(@FormDataParam("proformaMType") Integer proformaMType, //recivimos los datos desde la ventana modal del Proformae
            @FormDataParam("productId") Integer productId, 
            @FormDataParam("proformaId") Integer proformaId, 
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
            objProforma.setProformaMType(proformaMType);
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
            objProforma.setProformaId(proformaId);
            objProforma.setoProduct(objProduct);

            String rs = objFuntionProforma.managementProformaProduct(objProforma);
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
    @Path("/listProforma")
    @Produces(MediaType.APPLICATION_JSON)
    public List<cProforma> listProforma() {
        List<cProforma> result = new ArrayList<cProforma>();
        result = objFuntionProforma.listProforma();
        return result;
    }
    
    @GET
    @Path("/listfinalProforma")
    @Produces(MediaType.APPLICATION_JSON)
    public List<cProforma> listfinalProforma() {
        List<cProforma> result = new ArrayList<cProforma>();
        result = objFuntionProforma.listfinalProforma();
        return result;
    }
}
