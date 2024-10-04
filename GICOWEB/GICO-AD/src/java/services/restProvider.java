
package services;

import access.cAdProvider;
import access.cAdUser;
import classes.cProvider;
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
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.media.multipart.FormDataParam;

@Path("provider")
public class restProvider {


    public static class Model {

        public String message;
        public String date;
    }
    cProvider objProvider = new cProvider();
    cAdProvider objFuntionProvider = new cAdProvider();

    @Context
    private UriInfo context;

    public restProvider() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        return "hola";
    }

    @POST
    @Path("managementProvider")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.MULTIPART_FORM_DATA})
    public Model managementProvider(@FormDataParam("providerMType") Integer providerMType, //recivimos los datos desde la ventana modal del cliente
            @FormDataParam("providerId") Integer providerId,
            @FormDataParam("providerName") String providerName, 
            @FormDataParam("providerAddress") String providerAddress, 
            @FormDataParam("providerMail") String providerMail, 
            @FormDataParam("providerPhone") String providerPhone, 
            @FormDataParam("providerCell1") String providerCell1,
            @FormDataParam("providerCell2") String providerCell2) {
        Model model = new Model();
        try {
            objProvider.setProviderMType(providerMType);
            objProvider.setProviderId(providerId);
            objProvider.setProviderName(providerName);
            objProvider.setProviderAddress(providerAddress);
            objProvider.setProviderMail(providerMail);
            objProvider.setProviderPhone(providerPhone);
            objProvider.setProviderCell1(providerCell1);
            objProvider.setProviderCell2(providerCell2);

            String rs = objFuntionProvider.managementProvider(objProvider);
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
    @Path("/listProvider")
    @Produces(MediaType.APPLICATION_JSON)
    public List<cProvider> listProvider() {
        List<cProvider> result = new ArrayList<cProvider>();
        result = objFuntionProvider.listProvider();
        return result;
    }
}
