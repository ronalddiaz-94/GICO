/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package access;

import classes.cExpenses;
import conection.cAccesoDatos;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ronald
 */
public class cAdExpenses {
    
    private Exception error;

    public Exception getError() {
        return error;
    }
    
    
    //-------------GESTION DE PROVEEDORES----------------------------
    public String managementExpenses(cExpenses oExpenses) {
        String result = "Error!! Add Expenses";     
        String SQL = "SELECT public.expensesmanagement("+oExpenses.getExpensesMType()+","+oExpenses.getExpensesId()+",'"+oExpenses.getExpensesDescription()+"',"+oExpenses.getExpensesCost()+","+oExpenses.getBusinessId()+");";
        try {
            // Crear un AccesoDato
            cAccesoDatos ad = new cAccesoDatos();
            if (ad.conectar() != 0) { //  Solicitar conectar a la BD
                if (ad.executeUpdate(SQL) != 0) {
                    result = "Successful";
                }
            } else {
                result = "There isn't connection with DB";
            }
            ad.desconectar();
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getClass().getName() + " *** " + e.getMessage());
            this.error = e;
        }
        return result;
    }

    //reporte de todos los Proveedores
    public List<cExpenses> listExpenses() {
        List<cExpenses> result = new ArrayList<cExpenses>();

        String SQL = "select * FROM public.expenses";
        try {
            // Crear un AccesoDatos
            cAccesoDatos ad = new cAccesoDatos();
            if (ad.conectar() != 0) { //  Solicitar conectar a la BD
                if (ad.ejecutarSelect(SQL) != 0) {
                    ResultSet rsExpenses = ad.getRs();

                    while (rsExpenses.next()) {
                        cExpenses oExpenses = new cExpenses();
                        oExpenses.setExpensesId(rsExpenses.getInt("expensesId"));
                        oExpenses.setExpensesDescription(rsExpenses.getString("expensesDescription"));
                        oExpenses.setExpensesCost(rsExpenses.getDouble("expensesCost"));
                        oExpenses.setBusinessId(rsExpenses.getInt("businessId"));
                        result.add(oExpenses);
                    }
                    ad.desconectar();
                }
            }

        } catch (Exception e) {
            System.err.println("ERROR: " + e.getClass().getName() + " *** " + e.getMessage());

            this.error = e;
        } finally {
            return result;
        }

    }
}
