
package access;


import classes.cProvider;
import conection.cAccesoDatos;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class cAdProvider {
    
    private Exception error;

    public Exception getError() {
        return error;
    }
    
    
    //-------------GESTION DE PROVEEDORES----------------------------
    public String managementProvider(cProvider oProvider) {
        String result = "Error!! Add Provider";     
        String SQL = "SELECT public.providermanagement("+oProvider.getProviderMType()+","+oProvider.getProviderId()+",'"+oProvider.getProviderName()+"','"+oProvider.getProviderAddress()+"','"+oProvider.getProviderMail()+"','"+oProvider.getProviderPhone()+"','"+oProvider.getProviderCell1()+"','"+oProvider.getProviderCell2()+"');";
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
    public List<cProvider> listProvider() {
        List<cProvider> result = new ArrayList<cProvider>();

        String SQL = "select * FROM public.provider";
        try {
            // Crear un AccesoDatos
            cAccesoDatos ad = new cAccesoDatos();
            if (ad.conectar() != 0) { //  Solicitar conectar a la BD
                if (ad.ejecutarSelect(SQL) != 0) {
                    ResultSet rsProvider = ad.getRs();

                    while (rsProvider.next()) {
                        cProvider oProvider = new cProvider();
                        oProvider.setProviderId(rsProvider.getInt("providerid"));
                        oProvider.setProviderName(rsProvider.getString("providername"));
                        oProvider.setProviderAddress(rsProvider.getString("provideraddress"));
                        oProvider.setProviderMail(rsProvider.getString("providermail"));
                        oProvider.setProviderPhone(rsProvider.getString("providerphone"));
                        oProvider.setProviderCell1(rsProvider.getString("providercell1"));
                        oProvider.setProviderCell2(rsProvider.getString("providercell2"));
                        result.add(oProvider);
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
