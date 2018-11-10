package com.enterprisesystem.dao;

import com.enterprisesystem.modelo.Empresa;
import com.enterprisesystem.modelo.Usuario;
import com.enterprisesystem.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author franklin.ramos
 */
public class UsuarioDAO {
    
    public List<Usuario> buscarTodo(){
        EntityManagerFactory emf = JPAUtil.getJPAFactory();
        EntityManager em = emf.createEntityManager();
        TypedQuery consulta = em.createQuery("Select u from Usuario u", Usuario.class);
        List<Usuario> listaUsuario = consulta.getResultList();
        return listaUsuario;
    }
    
    public void borrar(Usuario usuario){
        EntityManagerFactory emf = JPAUtil.getJPAFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(usuario));
        em.getTransaction().commit();
    }
    
    public void insertar(Usuario usuario){
        EntityManagerFactory emf = JPAUtil.getJPAFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(em.merge(usuario));
        em.getTransaction().commit();
    }
    
    public void actualizar(Usuario usuario){
        EntityManagerFactory emf = JPAUtil.getJPAFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(em.merge(usuario));
        em.getTransaction().commit();
    }
    
}
