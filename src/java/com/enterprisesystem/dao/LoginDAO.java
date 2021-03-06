/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enterprisesystem.dao;

import com.enterprisesystem.modelo.Usuario;
import com.enterprisesystem.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author Jacqueline.BarreraUS && Todos
 */
public class LoginDAO {

    public Usuario validarUsuario(String username, String password) {
        Usuario user = null;
        EntityManagerFactory emf = JPAUtil.getJPAFactory();
        EntityManager em = emf.createEntityManager();
        TypedQuery consulta = em.createQuery("SELECT u FROM Usuario u Where u.username=:username AND u.password=:password", Usuario.class);
        consulta.setParameter("username", username);
        consulta.setParameter("password", password);
        try {
            user = (Usuario)consulta.getSingleResult();
        } catch (Exception exception) {
            System.out.println("ERROR " + exception.getMessage());
            return null;
        } finally {
            em.close();
        }
        return user;
    }

}
