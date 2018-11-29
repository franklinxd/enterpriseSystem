/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enterprisesystem.beans;

import com.enterprisesystem.dao.IngresoDAO;
import com.enterprisesystem.modelo.IngresoMensual;
import com.enterprisesystem.modelo.Sucursal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class IngresosBean {
    private List<IngresoMensual> listaIngreso;
    private IngresoDAO ingresoDAO;
    private IngresoMensual ingreso;
    private String accion;
    
    @PostConstruct
    public void init(){
        ingresoDAO = new IngresoDAO();
        listaIngreso = ingresoDAO.buscarTodo();
        this.ingreso = new IngresoMensual();
        this.ingreso.setIdsucursal(new Sucursal());
        this.ingreso.setIdingresomensual(0);
        accion = "Registrar";        
    }
    
    public void limpiarFormulario(){
        this.listaIngreso = ingresoDAO.buscarTodo();
        this.ingreso = new IngresoMensual();
        ingreso.setIdsucursal(new Sucursal());
        this.ingreso.setIdingresomensual(0);
        accion = "Registrar";
    }
    
    public void accionFormulario(){
        if(accion.equals("Registrar")){
            ingresoDAO.insertar(this.ingreso);
        }else if(accion.equals("Editar")){
            ingresoDAO.actualizar(this.ingreso);
        }
        limpiarFormulario();
    }
    
    public void editar(IngresoMensual ingreso){
        System.out.println("Editando . . .");
        this.ingreso = ingreso;
        accion = "Editar";
    }
    
    public void borrar(IngresoMensual ingreso){
        ingresoDAO.borrar(ingreso);
        this.listaIngreso = ingresoDAO.buscarTodo();
    }
    
    private void insertar(){
        ingresoDAO.insertar(this.ingreso);
    }
    
    private void actualizar(){
        ingresoDAO.actualizar(this.ingreso);
    }

    public List<IngresoMensual> getListaIngreso() {
        return listaIngreso;
    }

    public void setListaIngreso(List<IngresoMensual> listaIngreso) {
        this.listaIngreso = listaIngreso;
    }

    public IngresoDAO getIngresoDAO() {
        return ingresoDAO;
    }

    public void setIngresoDAO(IngresoDAO ingresoDAO) {
        this.ingresoDAO = ingresoDAO;
    }

    public IngresoMensual getIngreso() {
        return ingreso;
    }

    public void setIngreso(IngresoMensual ingreso) {
        this.ingreso = ingreso;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }
    
}
