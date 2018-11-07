package com.enterprisesystem.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author franklin
 */
public class JPAUtil {
    private static final EntityManagerFactory emf;
    
    static{
        try {
            emf=Persistence.createEntityManagerFactory("enterpriseSystemPU");
        } catch (Exception ex) {
            System.out.println("Creacion de la EntityManagerFactory fallo"+ex);
            throw new ExceptionInInitializerError(ex); 
        }
    }
    
    public static EntityManagerFactory getJPAFactory(){
        return emf;
    }
}
