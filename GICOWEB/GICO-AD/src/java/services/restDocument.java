/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import access.*;
import classes.cClient;
import classes.cDocument;
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
@Path("document")
public class restDocument {

   public static class Model {

        public String message;
        public String date;
    }
    cDocument objDocument = new cDocument();
    cAdDocument objFuntionDocument = new cAdDocument(); 

    @Context
    private UriInfo context;

    public restDocument() {
    }



    @POST
    @Path("managementDocument")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.MULTIPART_FORM_DATA})
    public Model managementClient(@FormDataParam("documentMType") Integer documentMType, //recivimos los datos desde la ventana modal del cliente
            @FormDataParam("documentId") Integer documentId, 
            @FormDataParam("documentName") String documentName,
            @FormDataParam("documentClient") String documentClient,
            @FormDataParam("documentCi") String documentCi,
            @FormDataParam("documentAddress") String documentAddress,
            @FormDataParam("documentValue") Double documentValue,
            @FormDataParam("documenttypeid") Integer documenttypeid) { 
        Model model = new Model();
        try { 
            objDocument.setDocumentMType(documentMType);
            objDocument.setDocumentId(documentId);
            objDocument.setDocumentName(documentName);
            objDocument.setDocumentClient(documentClient);
            objDocument.setDocumentCi(documentCi);
            objDocument.setDocumentAddress(documentAddress);
            objDocument.setDocumentValue(documentValue);
            objDocument.setDocumenttypeid(documenttypeid); 


            String rs = objFuntionDocument.managementDocument(objDocument);
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
    @Path("/listDocument") 
    @Produces(MediaType.APPLICATION_JSON) 
    public List<cDocument> listDocument() {
        List<cDocument> result = new ArrayList<cDocument>();
        result = objFuntionDocument.listDocument();
        return result;   
    }
}
