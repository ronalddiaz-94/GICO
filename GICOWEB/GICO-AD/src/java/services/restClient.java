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
@Path("client")
public class restClient {

    public static class Model {

        public String message;
        public String date;
    }
    cClient objClient = new cClient();
    cAdClient objFuntionClient = new cAdClient();

    @Context
    private UriInfo context;

    public restClient() {
    }

    @POST
    @Path("managementClient")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.MULTIPART_FORM_DATA})
    public Model managementClient(@FormDataParam("clientMType") Integer clientMType, //recivimos los datos desde la ventana modal del cliente
            @FormDataParam("clientId") Integer clientId,
            @FormDataParam("clientCi") String clientCi,
            @FormDataParam("clientName") String clientName,
            @FormDataParam("clientPhone") String clientPhone,
            @FormDataParam("clientCell") String clientCell,
            @FormDataParam("clientMail") String clientMail,
            @FormDataParam("clientCredit") Double clientCredit,
            @FormDataParam("clientAddress") String clientAddress) {
        Model model = new Model();
        try {
            objClient.setClientMType(clientMType);
            objClient.setClientId(clientId);
            objClient.setClientCi(clientCi);
            objClient.setClientName(clientName);
            objClient.setClientPhone(clientPhone);
            objClient.setClientCell(clientCell);
            objClient.setClientMail(clientMail);
            objClient.setClientCredit(clientCredit);
            objClient.setClientAddress(clientAddress);

            String rs = objFuntionClient.managementClient(objClient);
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
    @Path("managementMovilClient")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Model managementMovilClient(cClient c) {
        objClient = c;
        Model model = new Model();
        try {
            String rs = objFuntionClient.managementClient(objClient);
            String message = "Sin Respuesta";
            model.message = message;
            if (rs.equals("Successful")) {
                message = "Exito";
                model.message = message;
            }
            if (rs.equals("There isn't connection with DB")) {
                message = "Problemas con la conexion";
                model.message = message;
            }
            if (rs.equals("Error!! Add User")) {
                message = "Error";
                model.message = message;
            }

        } catch (Exception e) {
            String message = "error";
            model.message = message;
        }
        return model;
    }

    @POST
    @Path("abonoClient")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Model abonoClient(cClient c) {

        objClient = c;
        Model model = new Model();
        try {
            String rs = objFuntionClient.clientPay(objClient);
            String message = "Sin Respuesta";
            model.message = message;
            if (rs.equals("Successful")) {
                message = "Exito";
                model.message = message;
            }
            if (rs.equals("There isn't connection with DB")) {
                message = "Problemas con la conexion";
                model.message = message;
            }
            if (rs.equals("Error!! Add User")) {
                message = "Error";
                model.message = message;
            }

        } catch (Exception e) {
            String message = "error";
            model.message = message;
        }
        return model;
    }

    @GET
    @Path("/listClient")
    @Produces(MediaType.APPLICATION_JSON)
    public List<cClient> listClient() {
        List<cClient> result = new ArrayList<cClient>();
        result = objFuntionClient.listClient();
        return result;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        return "hola";
    }
}
