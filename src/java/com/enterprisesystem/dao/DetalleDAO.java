/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enterprisesystem.dao;

import com.enterprisesystem.modelo.DetallePlanilla;
import com.enterprisesystem.modelo.Planilla;
import com.enterprisesystem.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;


public class DetalleDAO {
   public List<DetallePlanilla> buscarTodo(){
        EntityManagerFactory emf = JPAUtil.getJPAFactory();
        EntityManager em= emf.createEntityManager();
        TypedQuery consulta = em.createQuery("Select p from Planilla p",DetallePlanilla.class);
        List<DetallePlanilla> listaDetalle = consulta.getResultList();
        return listaDetalle;
    }
    public void borrar(DetallePlanilla detalle){
        EntityManagerFactory emf =JPAUtil.getJPAFactory();
        EntityManager em= emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(detalle));
        em.getTransaction().commit();
    }
    public void insertar(DetallePlanilla detalle){
        EntityManagerFactory emf =JPAUtil.getJPAFactory();
        EntityManager em= emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(em.merge(detalle));
        em.getTransaction().commit();
    }
    public void actualizar(DetallePlanilla detalle){
        EntityManagerFactory emf =JPAUtil.getJPAFactory();
        EntityManager em= emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(em.merge(detalle));
        em.getTransaction().commit();
    } 
}
