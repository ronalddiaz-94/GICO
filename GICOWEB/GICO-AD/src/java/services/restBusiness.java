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
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
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
@Path("business")
public class restBusiness {

    public static class Model { 

        public String message;
        public String date;
    }
    cBusiness objBusiness = new cBusiness();
    cAdBusiness objFuntionBusiness = new cAdBusiness();

    @Context
    private UriInfo context;

    public restBusiness() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        return "hola";
    }

    @POST
    @Path("managementBusiness")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.MULTIPART_FORM_DATA})
    public Model managementBusiness(@FormDataParam("businessMType") Integer businessMType, //recivimos los datos desde la ventana modal del cliente
            @FormDataParam("businessId") Integer businessId,
            @FormDataParam("businessMission") String businessMission, 
            @FormDataParam("businessView") String businessView, 
            @FormDataParam("businessName") String businessName,
            @FormDataParam("businessAddress") String businessAddress, 
            @FormDataParam("businessPhon") String businessPhon, 
            @FormDataParam("businessCell") String businessCell) {
        Model model = new Model();
        try {
            objBusiness.setBusinessMType(businessMType);
            objBusiness.setBusinessId(businessId);
            objBusiness.setBusinessMission(businessMission);
            objBusiness.setBusinessView(businessView);
            objBusiness.setBusinessName(businessName);
            objBusiness.setBusinessAddress(businessAddress);
            objBusiness.setBusinessPhon(businessPhon);
            objBusiness.setBusinessCell(businessCell);

            String rs = objFuntionBusiness.managementBusiness(objBusiness);
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
    @Path("/listBusiness")
    @Produces(MediaType.APPLICATION_JSON)
    public List<cBusiness> listBusiness() {
        List<cBusiness> result = new ArrayList<cBusiness>();
        result = objFuntionBusiness.listBusiness();
        return result;
    }
}
