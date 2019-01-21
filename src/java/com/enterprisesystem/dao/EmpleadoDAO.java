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
        List<Empleado> lista = null;
        EntityManagerFactory emf = JPAUtil.getJPAFactory();
        EntityManager em = emf.createEntityManager();
        TypedQuery consulta = em.createQuery("Select e from Empleado e", Empleado.class);
        try {
            lista = consulta.getResultList();
        } catch (Exception exception) {
            System.out.println("ERROR " + exception);
        } finally {
            em.close();
        }
        return lista;
    }

    public boolean borrar(Empleado empleado) {
        boolean flag = false;
        EntityManagerFactory emf = JPAUtil.getJPAFactory();
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(em.merge(empleado));
            em.getTransaction().commit();
            return true;
        } catch (Exception exception) {
            System.out.println("ERROR " + exception.getMessage());
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return flag;
    }

    public boolean insertar(Empleado empleado) {
        boolean flag = false;
        EntityManagerFactory emf = JPAUtil.getJPAFactory();
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(em.merge(empleado));
            em.getTransaction().commit();
            return true;
        } catch (Exception exception) {
            System.out.println("ERROR " + exception.getMessage());
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return flag;
    }

    public boolean actualizar(Empleado empleado) {
        boolean flag = false;
        EntityManagerFactory emf = JPAUtil.getJPAFactory();
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(em.merge(empleado));
            em.getTransaction().commit();
            return true;
        } catch (Exception exception) {
            System.out.println("ERROR " + exception.getMessage());
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return flag;
    }
}
