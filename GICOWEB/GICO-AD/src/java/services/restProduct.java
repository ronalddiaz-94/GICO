package services;

import access.*;
import classes.*;
import java.util.*;
import java.util.Date;
import java.util.List;
import javax.ws.rs.core.*;
import javax.ws.rs.*;
import org.glassfish.jersey.media.multipart.FormDataParam;

@Path("product")
public class restProduct {

    public static class Model {

        public String message;
        public String date;
    }
    cProduct objProduct = new cProduct();
    cProvider oProvider = new cProvider();
    cAdProduct objFuntionProduct = new cAdProduct();

    @Context
    private UriInfo context;

    public restProduct() {
    }

    @POST
    @Path("managementProduct")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.MULTIPART_FORM_DATA})
    public Model managementProduct(@FormDataParam("productMType") Integer userMType, //recivimos los datos desde la ventana modal del cliente
            @FormDataParam("productId") Integer productId,
            @FormDataParam("productName") String productName,
            @FormDataParam("productDescription") String productDescription,
            @FormDataParam("productPrice") Double productPrice,
            @FormDataParam("productIva") Double productIva,
            @FormDataParam("productDateExpiration") String productDateExpiration,
            @FormDataParam("productCount") Double productCount,
            @FormDataParam("productTotalValue") Double productTotalValue,
            @FormDataParam("productUtility") Double productUtility,
            @FormDataParam("productAveragePrice") Double productAveragePrice,
            @FormDataParam("productDetail") String productDetail,
            @FormDataParam("productValue") Double productValue,
            @FormDataParam("productcountprocess") Double productcountprocess,
            @FormDataParam("providerId") Integer providerId
    ) {
        Model model = new Model();
        try {
            objProduct.setProductMType(userMType);
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
            objProduct.setProductDetail(productDetail);
            objProduct.setProductValue(productValue);
            objProduct.setProductcountprocess(productcountprocess);
            oProvider.setProviderId(providerId);
            objProduct.setoProvider(oProvider);

            String rs = objFuntionProduct.managementProduct(objProduct);
            String message = "Sin Respuesta";
            model.message = message;
            model.date = new Date().toString();
            if (rs.equals("Successful")) {
                message = providerId.toString();
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
    @Path("returnPrincipalProduct")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Model managementBadInventory(cProduct oProduct) {
        objProduct = oProduct;
        Model model = new Model();
        try {
            String rs = objFuntionProduct.returnPrincipalProduct(oProduct);
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
    @Path("/listProductCellar")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes({MediaType.APPLICATION_JSON})
    public List<cProduct> listProductCellar(cCellar cellar) {
        List<cProduct> result = new ArrayList<cProduct>();
        result = objFuntionProduct.listProductCellar(cellar);
        return result;
    }

    @GET
    @Path("/listProduct")
    @Produces(MediaType.APPLICATION_JSON)
    public List<cProduct> listProduct() {
        List<cProduct> result = new ArrayList<cProduct>();
        result = objFuntionProduct.listProduct();
        return result;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        return "hola";
    }

    @GET
    @Path("/listMovilProduct")
    @Produces(MediaType.APPLICATION_JSON)
    public List<cProduct> listMovilProduct() {
        List<cProduct> result = new ArrayList<cProduct>();
        result = objFuntionProduct.listMovilProduct();
        return result;
    }

}
