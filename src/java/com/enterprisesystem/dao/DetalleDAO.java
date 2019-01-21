package com.enterprisesystem.dao;

import com.enterprisesystem.modelo.DetallePlanilla;
import com.enterprisesystem.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author gerson.ruizusam
 */
public class DetalleDAO {

    public List<DetallePlanilla> buscarTodo() {
        List<DetallePlanilla> lista = null;
        EntityManagerFactory emf = JPAUtil.getJPAFactory();
        EntityManager em = emf.createEntityManager();
        TypedQuery consulta = em.createQuery("Select u from DetallePlanilla u", DetallePlanilla.class);
        try {
            lista = consulta.getResultList();
        } catch (Exception exception) {
            System.out.println("ERROR " + exception);
            return null;
        } finally {
            em.close();
        }
        return lista;
    }

    public boolean borrar(DetallePlanilla Detalle) {
        boolean flag = false;
        EntityManagerFactory emf = JPAUtil.getJPAFactory();
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(em.merge(Detalle));
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

    public boolean insertar(DetallePlanilla Detalle) {
        boolean flag = false;
        EntityManagerFactory emf = JPAUtil.getJPAFactory();
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(em.merge(Detalle));
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

    public boolean actualizar(DetallePlanilla Detalle) {
        boolean flag = false;
        EntityManagerFactory emf = JPAUtil.getJPAFactory();
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(em.merge(Detalle));
            em.getTransaction().commit();
        } catch (Exception exception) {
            System.out.println("ERROR " + exception.getMessage());
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return flag;
    }
}
