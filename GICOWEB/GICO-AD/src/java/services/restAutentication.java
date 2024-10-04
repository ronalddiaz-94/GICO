/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import access.cAdAutentication;
import classes.cUser;
import java.util.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.media.multipart.FormDataParam;

/**
 * REST Web Service
 *
 * @author jorge
 */
@Path("restAutentication")
public class restAutentication {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RestAutenticationResource
     */
    public restAutentication() {
    }

    /**
     * Retrieves representation of an instance of services.restAutentication
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of restAutentication
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }

    cUser objUser = new cUser();
    cUser objUserAutentication = new cUser();
    cAdAutentication objFuntionAutentication = new cAdAutentication();

   @POST
    @Path("listUserAutentication")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.MULTIPART_FORM_DATA})
    public restUser.Model managementUser( //recivimos los datos desde la ventana modal del cliente
            @FormDataParam("userName") String userName, 
            @FormDataParam("userNameUser") String userNameUser, 
            @FormDataParam("userPass") String userPass) {
        restUser.Model model = new restUser.Model();
        try {
            objUser.setUserName(userName);
            objUser.setUserNameUser(userNameUser);
            objUser.setUserPass(userPass);
            
            objUserAutentication = objFuntionAutentication.autenticationUser(objUser);
            
            String message = "Sin Respuesta";
            model.message = message;
            model.date = new Date().toString();
            if (objUserAutentication.getUserLogin().equals("Successful")) {
                message = "Exito";
                model.message = message;
                model.userId=objUserAutentication.getUserId();
                model.type = objUserAutentication.getUserRolName();
                
                model.date = new Date().toString();
            }
            if (objUserAutentication.getUserLogin().equals("There isn't connection with DB")) {
                message = "Problemas con la conexion";
                model.message = message;
                model.date = new Date().toString();
            }
            if (objUserAutentication.getUserLogin().equals("Error!! Add User")) {
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
    @Path("UserMovilAutentication")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public restUser.Model UserMovilAutentication(cUser u) {
        objUser.setUserNameUser(u.getUserNameUser());
        objUser.setUserPass(u.getUserPass());
        restUser.Model model = new restUser.Model();
        try {                
            objUserAutentication = objFuntionAutentication.autenticationUser(objUser);
            
            String message = "Sin Respuesta";
            model.message = message;
            model.date = new Date().toString();
            if (objUserAutentication.getUserLogin().equals("Successful")) {
                message = "Exito";
                model.message = message;
                model.type = objUserAutentication.getUserRolName();
                model.date = new Date().toString();
            }
            if (objUserAutentication.getUserLogin().equals("There isn't connection with DB")) {
                message = "Problemas con la conexion";
                model.message = message;
                model.date = new Date().toString();
            }
            if (objUserAutentication.getUserLogin().equals("Error!! Add User")) {
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
}
