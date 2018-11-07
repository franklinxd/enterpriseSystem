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
    
    public void borrar(Integer idempresa){
        EntityManagerFactory emf = JPAUtil.getJPAFactory();
        EntityManager em = emf.createEntityManager();
        em.remove(new Empresa(idempresa));
    }
}
