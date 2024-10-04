/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import access.*;
import classes.*;

/**
 *
 * @author Ronald
 */
public class testExpenses {
    
    public static void main(String[] args) {
        cAdExpenses accExpenses= new cAdExpenses();
        cExpenses oExpenses = new cExpenses();
           
        //Ingresar Modificar y eliminarusuario
        //1 Ingresar usuario
        //2 Modificar Usuario
        //3 Eliminar Usuario
//        
        oExpenses.setExpensesMType(1); //gestion a realizar
        oExpenses.setExpensesId(1);
        oExpenses.setExpensesDescription("Gasolina");
        oExpenses.setExpensesCost(3820.80);
        oExpenses.setBusinessId(1);
        accExpenses.managementExpenses(oExpenses);

 

    }
}
