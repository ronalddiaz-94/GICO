/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import access.cAdProvider;
import classes.cProvider;

/**
 *
 * @author Ronald
 */
public class teestProvider {
    
     public static void main(String[] args) {
        cAdProvider accProvider = new cAdProvider();
        cProvider oProvider = new cProvider();
        
        oProvider.setProviderMType(2); //gestion a realizar
        oProvider.setProviderId(2);
        oProvider.setProviderName("Papitas 2");
        oProvider.setProviderAddress("Carlosssssss sigues tras la mairita");
        oProvider.setProviderMail("45454@gmail.com");
        oProvider.setProviderPhone("1254698");
        oProvider.setProviderCell1("1271219");
        oProvider.setProviderCell2("46565");
        accProvider.managementProvider(oProvider);

 

    }
}
