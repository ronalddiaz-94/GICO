/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import access.cAdCellar;
import classes.cCellar;
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
@Path("cellar")
public class restCellar {

    public restCellar(UriInfo context) {
        this.context = context;
    }

    public static class Model {

        public String message;
        public String date;
    }
    cCellar objCellar = new cCellar();
    cAdCellar objFuntionCellar = new cAdCellar();

    @Context
    private UriInfo context;

    public restCellar() {
    }

    @POST
    @Path("managementCellar")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.MULTIPART_FORM_DATA})
    public Model managementCellar(@FormDataParam("cellarMType") Integer cellarMType, //recivimos los datos desde la ventana modal del cliente
            @FormDataParam("cellarId") Integer cellarId,
            @FormDataParam("cellarName") String cellarName,
            @FormDataParam("cellarManager") String cellarManager) {
        Model model = new Model();
        try {
            objCellar.setCellarMType(cellarMType);
            objCellar.setCellarId(cellarId);
            objCellar.setCellarName(cellarName);
            objCellar.setCellarManager(cellarManager);

            String rs = objFuntionCellar.managementCellar(objCellar);
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
    @Path("/listCellar")
    @Produces(MediaType.APPLICATION_JSON)
    public List<cCellar> listCellar() {
        List<cCellar> result = new ArrayList<cCellar>();
        result = objFuntionCellar.listCellar();
        return result;
    }

    @GET
    @Path("/listMovilCellar")
    @Produces(MediaType.APPLICATION_JSON)
    public List<cCellar> listMovilCellar() {
        List<cCellar> result = new ArrayList<cCellar>();
        result = objFuntionCellar.listMovilCellar();
        return result;
    }
      @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        return "Exito json";
    }
}
