/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enterprisesystem.dao;

import com.enterprisesystem.modelo.Sucursal;
import com.enterprisesystem.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author gerson.ruizusam
 */
public class SucursalDAO {
    
    public List<Sucursal> buscarTodo(){
        EntityManagerFactory emf = JPAUtil.getJPAFactory();
        EntityManager em = emf.createEntityManager();
        TypedQuery consulta = em.createQuery("Select u from Sucursal u", Sucursal.class);
        List<Sucursal> listaSucursal = consulta.getResultList();
        return listaSucursal;
    }
    
    public void borrar (Sucursal sucursal){
        EntityManagerFactory emf = JPAUtil.getJPAFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(sucursal));
        em.getTransaction().commit();
    }
    
    public void insertar(Sucursal sucursal){
        EntityManagerFactory emf = JPAUtil.getJPAFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(em.merge(sucursal));
        em.getTransaction().commit();
    }
    
    public void actualizar(Sucursal sucursal){
        EntityManagerFactory emf = JPAUtil.getJPAFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(em.merge(sucursal));
        em.getTransaction().commit();
    }
}
