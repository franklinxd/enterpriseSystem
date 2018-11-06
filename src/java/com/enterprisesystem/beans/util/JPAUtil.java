/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enterprisesystem.beans.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author franklin.ramosusam
 */
public class JPAUtil {
    private static final EntityManagerFactory emf;
    static{
        try {
            emf=Persistence.createEntityManagerFactory("");
        } catch (Exception ex) {
            System.out.println("Creacion de sesion fallo"+ex);
            throw new ExceptionInInitializerError(ex); 
        }
    }
    public static EntityManagerFactory geEntityManagerFactory(){
        return emf;
    }
}
