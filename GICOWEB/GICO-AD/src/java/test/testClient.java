/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import access.cAdClient;
import classes.cClient;

/**
 *
 * @author Ronald
 */
public class testClient {
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        cAdClient accClient= new cAdClient();
        cClient oClient = new cClient();
           
        //Ingresar Modificar y eliminarusuario
        //1 Ingresar usuario
        //2 Modificar Usuario
        //3 Eliminar Usuario
//        
        oClient.setClientMType(1); //gestion a realizar
        oClient.setClientId(2);
        oClient.setClientCi("Pap32222");
        oClient.setClientName("Carlos sigues tras la mairita");
        oClient.setClientPhone("122-2019");
        oClient.setClientCell("12-12019");
        oClient.setClientMail("12-12-2019");
        oClient.setClientAddress("12-1qwqeqweq2-2019");
        oClient.setClientCredit(6.0);
        accClient.managementClient(oClient);

 

    }
}
