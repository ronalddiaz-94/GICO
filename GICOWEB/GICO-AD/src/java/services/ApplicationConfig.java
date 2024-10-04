/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.Set;
import javax.ws.rs.core.Application;
import org.glassfish.jersey.media.multipart.MultiPartFeature;

/**
 *
 * @author Pedro
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
       resources.add(MultiPartFeature.class); 
        
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(services.restActivityClient.class);
        resources.add(services.restAutentication.class);
        resources.add(services.restBadInventory.class);
        resources.add(services.restBusiness.class);
        resources.add(services.restCellar.class);
        resources.add(services.restClient.class);
        resources.add(services.restDocument.class);
        resources.add(services.restExpenses.class);
        resources.add(services.restFactura.class);
        resources.add(services.restInventory.class);
        resources.add(services.restProduct.class);
        resources.add(services.restProforma.class);
        resources.add(services.restProvider.class);
        resources.add(services.restUser.class);
        resources.add(services.restUserType.class);
    }
    
}
