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
    
     public List<DetallePlanilla> buscarTodo(){
        EntityManagerFactory emf = JPAUtil.getJPAFactory();
        EntityManager em = emf.createEntityManager();
        TypedQuery consulta = em.createQuery("Select u from DetallePlanilla u", DetallePlanilla.class);
        List<DetallePlanilla> listaDetalle= consulta.getResultList();
        return listaDetalle;
    }
     public void borrar(DetallePlanilla Detalle){
        EntityManagerFactory emf = JPAUtil.getJPAFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(Detalle));
        em.getTransaction().commit();
    }
     public void insertar(DetallePlanilla Detalle){
        EntityManagerFactory emf = JPAUtil.getJPAFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(em.merge(Detalle));
        em.getTransaction().commit();
    }
      public void actualizar(DetallePlanilla Detalle){
        EntityManagerFactory emf = JPAUtil.getJPAFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(em.merge(Detalle));
        em.getTransaction().commit();
    }
      //Error
}
