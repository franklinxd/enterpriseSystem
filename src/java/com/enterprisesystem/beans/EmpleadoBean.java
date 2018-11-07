/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enterprisesystem.beans;

import com.enterprisesystem.dao.EmpleadoDAO;
import com.enterprisesystem.modelo.Empleado;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author gerson.ruizusam
 */
@ManagedBean
@ViewScoped
public class EmpleadoBean {
    private List<Empleado> listaEmpleado;
    private EmpleadoDAO empleadoDAO;
    
    @PostConstruct
    public void init(){
        empleadoDAO = new EmpleadoDAO();
        listaEmpleado = empleadoDAO.buscarTodo();
    }
    public void borrar(Integer ide){
        empleadoDAO.borrar(ide);
    }

    public EmpleadoBean() {
    super();
    }

    public List<Empleado> getListaEmpleado() {
        return listaEmpleado;
    }

    public void setListaEmpleado(List<Empleado> listaEmpleado) {
        this.listaEmpleado = listaEmpleado;
    }

    public EmpleadoDAO getEmpleadoDAO() {
        return empleadoDAO;
    }

    public void setEmpleadoDAO(EmpleadoDAO empleadoDAO) {
        this.empleadoDAO = empleadoDAO;
    }
    
    
}
