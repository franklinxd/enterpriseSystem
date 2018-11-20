/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enterprisesystem.dao;

import com.enterprisesystem.modelo.Empleado;
import com.enterprisesystem.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author gerson.ruizusam
 */
public class EmpleadoDAO {

    public List<Empleado> buscarTodo() {
        EntityManagerFactory emf = JPAUtil.getJPAFactory();
        EntityManager em = emf.createEntityManager();
        TypedQuery consulta = em.createQuery("Select e from Empleado e", Empleado.class);
        List<Empleado> listaEmpleado = consulta.getResultList();
        return listaEmpleado;
    }

    public void borrar(Empleado empleado) {
        EntityManagerFactory emf = JPAUtil.getJPAFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(empleado));
        em.getTransaction().commit();
    }

    public void insertar(Empleado empleado) {
        EntityManagerFactory emf = JPAUtil.getJPAFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(em.merge(empleado));
        em.getTransaction().commit();
    }

    public void actualizar(Empleado empleado) {
        EntityManagerFactory emf = JPAUtil.getJPAFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(em.merge(empleado));
        em.getTransaction().commit();

    }
}
