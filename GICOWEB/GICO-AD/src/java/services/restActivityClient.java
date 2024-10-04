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
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.media.multipart.FormDataParam;

/**
 * REST Web Service
 *
 * @author Ronald
 */
@Path("activityClient")
public class restActivityClient {

    public static class Model {

        public String message;
        public String date;
    }
    cActivityClient objActClient = new cActivityClient();
    cAdActivityClient objFuntionActClient = new cAdActivityClient();

    @Context
    private UriInfo context;

    public restActivityClient() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        return "hola";
    }

    

    
    @POST
    @Path("/listActivityClient1")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes({MediaType.APPLICATION_JSON})
    public List<cActivityClient> listActivityClient1(cClient c){
        List<cActivityClient> result = new ArrayList<cActivityClient>();
        result = objFuntionActClient.listActivityClient(c);
        return result;
    }
}
