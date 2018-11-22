/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enterprisesystem.dao;

import com.enterprisesystem.modelo.IngresoMensual;
import com.enterprisesystem.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author manuel.suarezusam
 */
public class IngresoDAO {
    
    public List<IngresoMensual> buscarTodo(){
        EntityManagerFactory emf = JPAUtil.getJPAFactory();
        EntityManager em = emf.createEntityManager();
        TypedQuery consulta = em.createQuery("Select i from IngresoMensual i", IngresoMensual.class);
        List<IngresoMensual> listaIngreso = consulta.getResultList();
        return listaIngreso;
    }
    
    public void borrar (IngresoMensual ingreso){
        EntityManagerFactory emf = JPAUtil.getJPAFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(ingreso));
        em.getTransaction().commit();
    }
    
    public void insertar(IngresoMensual ingreso){
        EntityManagerFactory emf = JPAUtil.getJPAFactory();
        EntityManager em  = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(em.merge(ingreso));
        em.getTransaction().commit();
    }
    
    public void actualizar (IngresoMensual ingreso){
        EntityManagerFactory emf = JPAUtil.getJPAFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(em.merge(ingreso));
        em.getTransaction().commit();
    }
}
