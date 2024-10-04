
package access;

import classes.cUser;
import conection.cAccesoDatos;
import java.sql.ResultSet;

public class cAdAutentication {
    
    private Exception error;

    public Exception getError() {
        return error;
    }
    
    
    //reporte de todos los Usuario para autenticacion
    public cUser autenticationUser(cUser oUserAutentication) {
        String user=oUserAutentication.getUserNameUser();
        String pass=oUserAutentication.getUserPass();
        cUser oUser = new cUser();
        oUser.setUserLogin("Error!! Add User");
        String SQL = "SELECT *  FROM public.users u inner join public.usertype ut on (u.userrol=ut.usertypeid) where usernameuser='"+user+"' and userpass = '"+pass+"';";
        try {
            // Crear un AccesoDatos
            cAccesoDatos ad = new cAccesoDatos();
            if (ad.conectar() != 0) { //  Solicitar conectar a la BD
                if (ad.ejecutarSelect(SQL) != 0) {
                    oUser.setUserLogin("Successful");
                    ResultSet rsUsuario = ad.getRs();
                    rsUsuario.next();
                    try {
                        //user data in objectuser
                        oUser.setUserName(rsUsuario.getString("username"));
                        oUser.setUserId(rsUsuario.getInt("userid"));
                        oUser.setUserPass(rsUsuario.getString("userpass"));
                        oUser.setUserCI(rsUsuario.getString("userci"));
                        oUser.setUserNameUser(rsUsuario.getString("usernameuser"));
                        oUser.setUserRolName(rsUsuario.getString("usertypedescription"));
                        oUser.setUserLogin("Successful");

                    } catch (Exception e) {
                        oUser.setUserLogin("Error!! Add User");
                    }
                    ad.desconectar();
                }
            } else {
                oUser.setUserLogin("There isn't connection with DB");
            }

        } catch (Exception e) {
            System.err.println("ERROR: " + e.getClass().getName() + " *** " + e.getMessage());
            this.error = e;
        } finally {
            return oUser;
        }
    }
    
    
}
