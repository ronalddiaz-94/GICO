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
public class testDocument {
    public static void main(String[] args) {
        cAdDocument accDocument= new cAdDocument();
        cDocument oDocument = new cDocument();
           
        //Ingresar Modificar y eliminarusuario
        //1 Ingresar usuario
        //2 Modificar Usuario
        //3 Eliminar Usuario
//        
        oDocument.setDocumentMType(1); //gestion a realizar
        oDocument.setDocumentId(1);
        oDocument.setDocumentAddress("Gasasdasdaolina");
        oDocument.setDocumentCi("41256369");
        oDocument.setDocumentClient("yorrrrr");
        oDocument.setDocumentName("dfffff");
        oDocument.setDocumentValue(8888.00);
        oDocument.setDocumenttypeid(3);
        accDocument.managementDocument(oDocument);
    }
}
