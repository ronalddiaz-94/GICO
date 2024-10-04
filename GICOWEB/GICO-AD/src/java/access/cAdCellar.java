
package access;

import classes.cCellar;
import conection.cAccesoDatos;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class cAdCellar {
    
    private Exception error;

    public Exception getError() {
        return error;
    }
    
    
    //-------------GESTION DE BODEGAS----------------------------
    public String managementCellar(cCellar oCellar) {
        String result = "Error!! Add Cellar";     
        String SQL = "SELECT public.cellarmanagement("+oCellar.getCellarMType()+","+oCellar.getCellarId()+",'"+oCellar.getCellarName()+"','"+oCellar.getCellarManager()+"');";
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
    public List<cCellar> listCellar() {
        List<cCellar> result = new ArrayList<cCellar>();

        String SQL = "select * FROM public.cellar";
        try {
            // Crear un AccesoDatos
            cAccesoDatos ad = new cAccesoDatos();
            if (ad.conectar() != 0) { //  Solicitar conectar a la BD
                if (ad.ejecutarSelect(SQL) != 0) {
                    ResultSet rsCellar = ad.getRs();

                    while (rsCellar.next()) {
                        cCellar oCellar = new cCellar();
                        oCellar.setCellarId(rsCellar.getInt("cellarid")); 
                        oCellar.setCellarName(rsCellar.getString("cellarname"));
                        oCellar.setCellarManager(rsCellar.getString("cellarmanager"));
                        result.add(oCellar);
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
    
    //reporte de todos los Proveedores
    public List<cCellar> listMovilCellar() {
        List<cCellar> result = new ArrayList<cCellar>();

        String SQL = "select * FROM public.cellar where cellarid!=1";
        try {
            // Crear un AccesoDatos
            cAccesoDatos ad = new cAccesoDatos();
            if (ad.conectar() != 0) { //  Solicitar conectar a la BD
                if (ad.ejecutarSelect(SQL) != 0) {
                    ResultSet rsCellar = ad.getRs();

                    while (rsCellar.next()) {
                        cCellar oCellar = new cCellar();
                        oCellar.setCellarId(rsCellar.getInt("cellarid")); 
                        oCellar.setCellarName(rsCellar.getString("cellarname"));
                        oCellar.setCellarManager(rsCellar.getString("cellarmanager"));
                        result.add(oCellar);
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
