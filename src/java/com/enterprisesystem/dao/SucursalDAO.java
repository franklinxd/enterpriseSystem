package com.enterprisesystem.dao;

import com.enterprisesystem.modelo.Sucursal;
import com.enterprisesystem.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

public class SucursalDAO {

    public List<Sucursal> buscarTodo() {
        List<Sucursal> lista = null;
        EntityManagerFactory emf = JPAUtil.getJPAFactory();
        EntityManager em = emf.createEntityManager();
        TypedQuery consulta = em.createQuery("Select u from Sucursal u", Sucursal.class);
        try {
            lista = consulta.getResultList();
        } catch (Exception exception) {
            System.out.println("ERROR " + exception.getMessage());
            return null;
        }
        return lista;
    }

    public boolean borrar(Sucursal sucursal) {
        boolean flag = false;
        EntityManagerFactory emf = JPAUtil.getJPAFactory();
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(em.merge(sucursal));
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

    public boolean insertar(Sucursal sucursal) {
        boolean flag = false;
        EntityManagerFactory emf = JPAUtil.getJPAFactory();
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(em.merge(sucursal));
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

    public boolean actualizar(Sucursal sucursal) {
        boolean flag = false;
        EntityManagerFactory emf = JPAUtil.getJPAFactory();
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(em.merge(sucursal));
            em.getTransaction().commit();
            return true;
        } catch (Exception exception) {
            System.out.println("ERROR " + exception);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return flag;
    }
}
