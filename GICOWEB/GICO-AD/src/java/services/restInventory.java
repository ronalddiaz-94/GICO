/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import access.*;
import classes.*;
import java.util.*;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author jorge
 */
@Path("inventory")
public class restInventory {

    cInventory objInventory = new cInventory();
    cAdInventory objFuntionInventory = new cAdInventory();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of restInventory
     */
    public restInventory() {
    }

    public static class Model {

        public String message;
        public String date;
    }

    /**
     * Retrieves representation of an instance of services.restInventory
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }


    @GET
    @Path("listInventory")
    @Produces(MediaType.APPLICATION_JSON)
    public List<cInventory> listInventory() {
        List<cInventory> result = new ArrayList<cInventory>();
        result = objFuntionInventory.listInventory();
        return result;
    }
    
    @GET
    @Path("listInventoryGeneral")
    @Produces(MediaType.APPLICATION_JSON)
    public List<cInventory> listInventoryGeneral() {
        List<cInventory> result = new ArrayList<cInventory>();
        result = objFuntionInventory.listInventoryGeneral();
        return result;
    }
}
