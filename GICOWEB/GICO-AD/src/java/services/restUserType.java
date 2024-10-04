/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import access.cAdUserType;
import classes.cUserType;
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
@Path("usertype")
public class restUserType {

    public static class Model {

        public String message;
        public String date;
    }
    cUserType objUserType = new cUserType();
    cAdUserType objFuntionUser = new cAdUserType();

    @Context
    private UriInfo context;

    public restUserType() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        return "hola";
    }

    @POST
    @Path("managementUserType")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.MULTIPART_FORM_DATA})
    public Model managementUserType(@FormDataParam("userTypeMType") Integer userTypeMType, //recivimos los datos desde la ventana modal del cliente 
            @FormDataParam("userTypeDescription") String userTypeDescription,
            @FormDataParam("userTypeId") Integer userTypeId) {
        Model model = new Model();
        try {
            objUserType.setUsertypeMType(userTypeMType);
            objUserType.setUserTypeDescription(userTypeDescription);
            objUserType.setUserTypeId(userTypeId);

            String rs = objFuntionUser.managementUserType(objUserType);
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
    @Path("/listUserType")
    @Produces(MediaType.APPLICATION_JSON)
    public List<cUserType> listUser() {
        List<cUserType> result = new ArrayList<cUserType>();
        result = objFuntionUser.listUserType();
        return result;
    }


}
