/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author User
 */
public class cAccesoDatos {

    private Connection cnn;
    private ResultSet rs;
    private Exception error;

    public cAccesoDatos() {
        this.cnn = null;
        this.error = null;
    }

    /**
     * @return the error
     */
    public Exception getError() {
        return error;
    }


    public ResultSet getRs() {
        return rs;
    }

    public Byte conectar() {
        Byte result = 0;
        try {
            Class.forName(conection.cGlobal.driverClass);
            result = 1;
            this.cnn = DriverManager.getConnection(conection.cGlobal.databaseURL, conection.cGlobal.usuarioDB, conection.cGlobal.claveDB);
            result = 2;
            //System.out.print("todo ok");
        } catch (SQLException e) {
            System.err.println("ERROR: " + e.getClass().getName() + " *** " + e.getMessage());
            //System.out.print(e.toString());
            this.error = e;
            return result = 0;
        } finally {
            return result;
        }
    }

    public Byte desconectar() {
        Byte result = 0;
        try {
            this.cnn.close();
            this.cnn = null;
            result = 1;
        } catch (SQLException e) {
            System.err.println("ERROR: " + e.getClass().getName() + " *** " + e.getMessage());

            this.error = e;
        } finally {
            return result;
        }
    }

    public Byte ejecutarSelect(String SQL) {
        Byte result = 0;
        try {
            Statement smt = this.cnn.createStatement();
            this.rs = smt.executeQuery(SQL);
            desconectar();
            if (rs != null) {
                result = 1;
            }

        } catch (SQLException e) {
            System.err.println("ERROR: " + e.getClass().getName() + " *** " + e.getMessage());

            this.error = e;
        } finally {
            return result;
        }
    }

    public Integer ejecutarComando(String SQL) {
        Integer result = 0;
        try {
            PreparedStatement smt = this.cnn.prepareStatement(SQL);
            result = smt.executeUpdate();
             desconectar();
        } catch (SQLException e) {
            System.err.println("ERROR: " + e.getClass().getName() + " *** " + e.getMessage());

            this.error = e;
        } finally {
            return result;
        }
    }

     public Byte executeUpdate(String strSQL) {
        Byte result = 0;
        try {
            result = 1;
            PreparedStatement stm = this.cnn.prepareStatement(strSQL);
            stm.executeUpdate();
            desconectar();
            this.rs = null;
        } catch (SQLException e) {
            System.err.println("ERROR: " + e.getClass().getName() + " : " + e.getMessage());
            this.error = e;
        } finally {
            return result;
        }
    }

}
