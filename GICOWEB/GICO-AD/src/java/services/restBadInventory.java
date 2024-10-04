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
@Path("badInventory")
public class restBadInventory {

   public static class Model {

        public String message;
        public String date;
    }
    cBadInventory objInventory= new cBadInventory();
    cAdBadInventory objFuntionInventory = new cAdBadInventory();

    @Context
    private UriInfo context;

    public restBadInventory() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        return "hola";
    }

    @POST
    @Path("addInventory")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Model managementBadInventory(cBadInventory oBadInventory) {
        objInventory=oBadInventory;
        Model model = new Model();
        try {
            String rs = objFuntionInventory.managementBadInventory(objInventory);
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
    @Path("/listBadInventory")
    @Produces(MediaType.APPLICATION_JSON)
    public List<cBadInventory> listBadInventory() {
        List<cBadInventory> result = new ArrayList<cBadInventory>();
        result = objFuntionInventory.listBadInventory();
        return result;
    }
}
