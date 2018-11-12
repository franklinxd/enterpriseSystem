/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enterprisesystem.dao;

import com.enterprisesystem.modelo.Planilla;
import com.enterprisesystem.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author gerson.ruizusam
 */
public class PlanillaDAO {
    
    public List<Planilla> buscarTodo(){
        EntityManagerFactory emf = JPAUtil.getJPAFactory();
        EntityManager em= emf.createEntityManager();
        TypedQuery consulta = em.createQuery("Select p from Planilla p",Planilla.class);
        List<Planilla> listaPlanilla = consulta.getResultList();
        return listaPlanilla;
    }
    public void borrar(Planilla planilla){
        EntityManagerFactory emf =JPAUtil.getJPAFactory();
        EntityManager em= emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(planilla));
        em.getTransaction().commit();
    }
    public void insertar(Planilla planilla){
        EntityManagerFactory emf =JPAUtil.getJPAFactory();
        EntityManager em= emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(em.merge(planilla));
        em.getTransaction().commit();
    }
    public void actualizar(Planilla planilla){
        EntityManagerFactory emf =JPAUtil.getJPAFactory();
        EntityManager em= emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(em.merge(planilla));
        em.getTransaction().commit();
    }
}
