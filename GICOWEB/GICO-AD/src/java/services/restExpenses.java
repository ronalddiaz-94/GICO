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
@Path("expenses")
public class restExpenses {

    public static class Model {

        public String message;
        public String date;
    }
    cExpenses objExpenses = new cExpenses();
    cAdExpenses objFuntionExpenses = new cAdExpenses();

    @Context
    private UriInfo context;

    public restExpenses() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        return "hola";
    }

    @POST
    @Path("managementExpenses")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.MULTIPART_FORM_DATA})
    public Model managementClient(@FormDataParam("expensesMType") Integer expensesMType, //recivimos los datos desde la ventana modal del cliente
            @FormDataParam("expensesId") Integer expensesId, 
            @FormDataParam("expensesDescription") String expensesDescription,
            @FormDataParam("expensesCost") Double expensesCost,
            @FormDataParam("businessId") Integer businessId) {
        Model model = new Model();
        try {
            objExpenses.setExpensesMType(expensesMType);
            objExpenses.setExpensesDescription(expensesDescription);
            objExpenses.setExpensesId(expensesId);
            objExpenses.setExpensesCost(expensesCost);
            objExpenses.setBusinessId(businessId);

            String rs = objFuntionExpenses.managementExpenses(objExpenses);
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
            if (rs.equals("Error!! Add Expenses")) {
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
    @Path("/listExpenses")
    @Produces(MediaType.APPLICATION_JSON)
    public List<cExpenses> listExpenses() {
        List<cExpenses> result = new ArrayList<cExpenses>();
        result = objFuntionExpenses.listExpenses();
        return result;
    }
}
