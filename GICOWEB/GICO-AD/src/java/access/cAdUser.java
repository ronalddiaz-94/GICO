/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package access;

import classes.cUser;
import conection.cAccesoDatos;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author
 */
public class cAdUser {

    private Exception error;

    public Exception getError() {
        return error;
    }


//-------------AUTENTICACION----------------------------
    public List<cUser> autenticationUser() {
        List<cUser> result = new ArrayList<cUser>();

        String SQL = "SELECT *  FROM public.users as u inner join public.usertype as ut on (userrol=usertypeid)";
        try {
            // Crear un AccesoDatos
            cAccesoDatos ad = new cAccesoDatos();
            if (ad.conectar() != 0) { //  Solicitar conectar a la BD
                if (ad.ejecutarSelect(SQL) != 0) {
                    ResultSet rsUsuario = ad.getRs();

                    while (rsUsuario.next()) {
                        cUser oUser = new cUser();
                        oUser.setUserCI(rsUsuario.getString("userCI"));
                        oUser.setUserPass(rsUsuario.getString("userpass"));
                        oUser.setUserPass(rsUsuario.getString("usernameuser"));
                        result.add(oUser);
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
//-------------GESTION DE USUARIOS----------------------------
    public String managementUser(cUser oUser) {
        String result = "Error!! Add User";
        String SQL = "SELECT public.usermanagement("+oUser.getUserMType()+",'"+oUser.getUserName()+"','"+oUser.getUserCI()+"','"+oUser.getUserNameUser()+"','"+oUser.getUserPass()+"',"+oUser.getUserRol()+","+oUser.getUserId()+");";
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

    //reporte de todos los Usuario
    public List<cUser> listUser() {
        List<cUser> result = new ArrayList<cUser>();

        String SQL = "SELECT *  FROM public.users as u inner join public.usertype as ut on (userrol=usertypeid)";
        try {
            // Crear un AccesoDatos
            cAccesoDatos ad = new cAccesoDatos();
            if (ad.conectar() != 0) { //  Solicitar conectar a la BD
                if (ad.ejecutarSelect(SQL) != 0) {
                    ResultSet rsUsuario = ad.getRs();

                    while (rsUsuario.next()) {
                        cUser oUser = new cUser();
                        oUser.setUserId(rsUsuario.getInt("userid"));
                        oUser.setUserCI(rsUsuario.getString("userCI"));
                        oUser.setUserPass(rsUsuario.getString("userpass"));
                        oUser.setUserName(rsUsuario.getString("username"));
                        oUser.setUserNameUser(rsUsuario.getString("usernameuser"));
                        oUser.setUserRol(rsUsuario.getInt("userrol"));
                        oUser.setUserTypeDescription(rsUsuario.getString("usertypedescription"));
                        result.add(oUser);
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
    
    public List<cUser> listUserID(Integer userId) {
        List<cUser> result = new ArrayList<cUser>();

        String SQL = "SELECT *  FROM public.users as u inner join public.usertype as ut on (userrol=usertypeid) where userId="+userId;
        try {
            // Crear un AccesoDatos
            cAccesoDatos ad = new cAccesoDatos();
            if (ad.conectar() != 0) { //  Solicitar conectar a la BD
                if (ad.ejecutarSelect(SQL) != 0) {
                    ResultSet rsUsuario = ad.getRs();

                    while (rsUsuario.next()) {
                        cUser oUser = new cUser();
                        oUser.setUserId(rsUsuario.getInt("userid"));
                        oUser.setUserCI(rsUsuario.getString("userCI"));
                        oUser.setUserPass(rsUsuario.getString("userpass"));
                        oUser.setUserName(rsUsuario.getString("username"));
                        oUser.setUserNameUser(rsUsuario.getString("usernameuser"));
                        oUser.setUserRol(rsUsuario.getInt("userrol"));
                        oUser.setUserTypeDescription(rsUsuario.getString("usertypedescription"));
                        result.add(oUser);
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
