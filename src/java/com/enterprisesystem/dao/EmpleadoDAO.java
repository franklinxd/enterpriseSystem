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
        TypedQuery consulta = em.createQuery("Select e from Empresa e", Empleado.class);
        List<Empleado> listaEmpleado = consulta.getResultList();
        return listaEmpleado;
    }
    public void borrar(Integer ide){
        EntityManagerFactory emf = JPAUtil.getJPAFactory();
        EntityManager em= emf.createEntityManager();
        em.remove(new Empleado(ide));
    } 
}
