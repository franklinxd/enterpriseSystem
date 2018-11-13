/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enterprisesystem.beans;

import com.enterprisesystem.dao.DetalleDAO;
import com.enterprisesystem.modelo.DetallePlanilla;
import com.enterprisesystem.modelo.Empleado;
import com.enterprisesystem.modelo.Planilla;
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
public class DetalleBean {

    private List<DetallePlanilla> listaDetalle;
    private DetalleDAO detalleDAO;
    private DetallePlanilla Detalle;
    private String accion;
    
    @PostConstruct
    public void init() {
        detalleDAO = new DetalleDAO();
        listaDetalle = detalleDAO.buscarTodo();
        this.Detalle = new DetallePlanilla();
        this.Detalle.setIdplanilla(new Planilla());
        this.Detalle.setIdempleado(new Empleado());
        this.Detalle.setIddetalle(0);
        accion = "Registrar";
    }

    public void limpiarFormulario() {
        listaDetalle = detalleDAO.buscarTodo();
        this.Detalle = new DetallePlanilla();
        Detalle.setIdplanilla(new Planilla());
        Detalle.setIdempleado(new Empleado());
        this.Detalle.setIddetalle(0);
        accion = "Registrar";
    }
    
    public void accionFormulario() {
        if (accion.equals("Registrar")) {
            detalleDAO.insertar(this.Detalle);
        } else if (accion.equals("Editar")) {
            detalleDAO.actualizar(this.Detalle);
        }
        limpiarFormulario();
    }

    public void editar(DetallePlanilla Detalle) {
        this.Detalle = Detalle;
        accion = "Editar";
    }

    public void borrar(DetallePlanilla Detalle) {
        detalleDAO.borrar(Detalle);
        listaDetalle = detalleDAO.buscarTodo();
    }

    private void insertar() {
        detalleDAO.insertar(this.Detalle);
    }

    private void actualizar() {
        detalleDAO.actualizar(this.Detalle);
    }

    public DetalleBean() {
        super();
    }
    
    public List<DetallePlanilla> getListaDetalle() {
        return listaDetalle;
    }
    
    public void setListaDetalle(List<DetallePlanilla> listaDetalle) {
        this.listaDetalle = listaDetalle;
    }
    
    public DetalleDAO getDetalleDAO() {
        return detalleDAO;
    }
    
    public void setDetalleDAO(DetalleDAO detalleDAO) {
        this.detalleDAO = detalleDAO;
    }
    
    public DetallePlanilla getDetalle() {
        return Detalle;
    }
    
    public void setDetalle(DetallePlanilla Detalle) {
        this.Detalle = Detalle;
    }
    
    public String getAccion() {
        return accion;
    }
    
    public void setAccion(String accion) {
        this.accion = accion;
    }
    
}
