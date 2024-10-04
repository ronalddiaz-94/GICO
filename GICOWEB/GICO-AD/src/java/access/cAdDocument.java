/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package access;
import classes.*;
import conection.cAccesoDatos;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Ronald
 */
public class cAdDocument {
    private Exception error;

    public Exception getError() {
        return error;
    }
    
    
    //-------------GESTION DE PROVEEDORES----------------------------
    public String managementDocument(cDocument oDocument) {
        String result = "Error!! Add Document";     
        String SQL = "SELECT public.documentmanagement("+oDocument.getDocumentMType()+","+oDocument.getDocumentId()+",'"+oDocument.getDocumentName()+"','"+oDocument.getDocumentClient()+"','"+oDocument.getDocumentCi()+"','"+oDocument.getDocumentAddress()+"',"+oDocument.getDocumentValue()+","+oDocument.getDocumenttypeid()+");";
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
    public List<cDocument> listDocument() { 
        List<cDocument> result = new ArrayList<cDocument>();

        String SQL = "select * FROM public.document where documenttypeid= 3";
        try {
            // Crear un AccesoDatos
            cAccesoDatos ad = new cAccesoDatos();
            if (ad.conectar() != 0) { //  Solicitar conectar a la BD
                if (ad.ejecutarSelect(SQL) != 0) {
                    ResultSet rsDocument = ad.getRs();

                    while (rsDocument.next()) {
                        cDocument oDocument = new cDocument();
                        oDocument.setDocumentId(rsDocument.getInt("documentId"));
                        oDocument.setDocumentName(rsDocument.getString("documentName"));
                        oDocument.setDocumentClient(rsDocument.getString("documentClient"));
                        oDocument.setDocumentCi(rsDocument.getString("documentCi"));
                        oDocument.setDocumentAddress(rsDocument.getString("documentAddress"));
                        oDocument.setDocumentValue(rsDocument.getDouble("documentValue"));
                        oDocument.setDocumenttypeid(rsDocument.getInt("documenttypeid")); 
                        result.add(oDocument);
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
