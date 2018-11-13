package com.enterprisesystem.dao;

import com.enterprisesystem.modelo.Empresa;
import com.enterprisesystem.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author franklin.ramos
 */
public class EmpresaDAO {
    
    public List<Empresa> buscarTodo(){
        EntityManagerFactory emf = JPAUtil.getJPAFactory();
        EntityManager em = emf.createEntityManager();
        TypedQuery consulta = em.createQuery("Select e from Empresa e", Empresa.class);
        List<Empresa> listaEmpresa = consulta.getResultList();
        return listaEmpresa;
    }
    
    public void borrar(Empresa empresa){
        EntityManagerFactory emf = JPAUtil.getJPAFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(empresa));
        em.getTransaction().commit();
    }
    
    public void insertar(Empresa empresa){
        EntityManagerFactory emf = JPAUtil.getJPAFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(em.merge(empresa));
        em.getTransaction().commit();
    }
    
    public void actualizar(Empresa empresa){
        EntityManagerFactory emf = JPAUtil.getJPAFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(em.merge(empresa));
        em.getTransaction().commit();
    }
}
