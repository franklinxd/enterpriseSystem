/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enterprisesystem.beans;

import com.enterprisesystem.dao.EmpleadoDAO;
import com.enterprisesystem.modelo.Empleado;
import com.enterprisesystem.modelo.Sucursal;
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
    private Empleado empleado;
    private String accion;
    
    @PostConstruct
    public void init(){
        empleadoDAO = new EmpleadoDAO();
        listaEmpleado = empleadoDAO.buscarTodo();
        this.empleado=new Empleado();
        this.empleado.setIdsucursal(new Sucursal());
        this.empleado.setIdempleado(0);
        accion= "Registrar";
    }
    public void limpiarFormulario(){
        this.listaEmpleado = empleadoDAO.buscarTodo();
        this.empleado=new Empleado();
        empleado.setIdsucursal(new Sucursal());
        this.empleado.setIdempleado(0);
        accion= "Registrar";
    }
    public void accionFormulario(){
        if(accion.equals("Registrar")){
            empleadoDAO.insertar(this.empleado);
        }else if(accion.equals("Editar")){
            empleadoDAO.actualizar(this.empleado);
        }
        limpiarFormulario();
    }
    public void editar(Empleado empleado){
        this.empleado=empleado;
        accion="Editar";
    }
    public void borrar(Empleado empleado){
        empleadoDAO.borrar(empleado);
        listaEmpleado = empleadoDAO.buscarTodo();
    }
    private void insertar(){
        empleadoDAO.insertar(this.empleado);
    }
    private void actualizar(){
        empleadoDAO.actualizar(this.empleado);
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

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }
    
    
}
