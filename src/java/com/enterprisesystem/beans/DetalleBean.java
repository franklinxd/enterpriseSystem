/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enterprisesystem.beans;

import com.enterprisesystem.dao.DetalleDAO;
import com.enterprisesystem.dao.EmpleadoDAO;
import com.enterprisesystem.dao.PlanillaDAO;
import com.enterprisesystem.modelo.DetallePlanilla;
import com.enterprisesystem.modelo.Empleado;
import com.enterprisesystem.modelo.Planilla;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author gerson.ruizusam
 */
@ManagedBean
@ViewScoped
public class DetalleBean {

    private List<DetallePlanilla> listaDetalle;
    private List<Planilla> listaPlanilla;
    private List<Empleado> listaEmpleado;
    private DetalleDAO detalleDAO;
    private PlanillaDAO planillaDAO;
    private EmpleadoDAO empleadoDAO;
    private DetallePlanilla Detalle;
    private String accion;

    @PostConstruct
    public void init() {
        detalleDAO = new DetalleDAO();
        planillaDAO = new PlanillaDAO();
        empleadoDAO = new EmpleadoDAO();
        listaDetalle = detalleDAO.buscarTodo();
        listaPlanilla = planillaDAO.buscarTodo();
        listaEmpleado = empleadoDAO.buscarTodo();
        Detalle = new DetallePlanilla();
        Detalle.setIdplanilla(new Planilla());
        Detalle.setIdempleado(new Empleado());
        Detalle.setIddetalle(0);
        accion = "Registrar";
    }

    public void limpiarFormulario() {
        listaDetalle = detalleDAO.buscarTodo();
        Detalle = new DetallePlanilla();
        Detalle.setIdplanilla(new Planilla());
        Detalle.setIdempleado(new Empleado());
        Detalle.setIddetalle(0);
        accion = "Registrar";
    }

    public void accionFormulario() {
        if (accion == "Registrar") {
            insertar();
        } else {
            actualizar();
        }
    }

    public void editar(DetallePlanilla Detalle) {
        this.Detalle = Detalle;
        accion = "Editar";
    }

    public void borrar(DetallePlanilla Detalle) {
        boolean flag = detalleDAO.borrar(Detalle);
        if (flag) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO", "Su Detalle fué Borrado Exitosamente.");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        } else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Su Detalle NO fué Borrado.");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }
        listaDetalle = detalleDAO.buscarTodo();
    }

    private void insertar() {
        boolean flag = detalleDAO.insertar(Detalle);
        if (flag) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO", "Su Detalle fué Guardado Exitosamente.");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        } else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Su Detalle NO fué Guardado.");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }
        listaDetalle = detalleDAO.buscarTodo();
        limpiarFormulario();
    }

    private void actualizar() {
        boolean flag = detalleDAO.actualizar(Detalle);
        if (flag) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO", "Su Detalle fué Actualizado Exitosamente.");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        } else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Su Detalle NO fué Actualizado.");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }
        listaDetalle = detalleDAO.buscarTodo();
        limpiarFormulario();
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

    public List<Planilla> getListaPlanilla() {
        return listaPlanilla;
    }

    public void setListaPlanilla(List<Planilla> listaPlanilla) {
        this.listaPlanilla = listaPlanilla;
    }

    public List<Empleado> getListaEmpleado() {
        return listaEmpleado;
    }

    public void setListaEmpleado(List<Empleado> listaEmpleado) {
        this.listaEmpleado = listaEmpleado;
    }

    public PlanillaDAO getPlanillaDAO() {
        return planillaDAO;
    }

    public void setPlanillaDAO(PlanillaDAO planillaDAO) {
        this.planillaDAO = planillaDAO;
    }

    public EmpleadoDAO getEmpleadoDAO() {
        return empleadoDAO;
    }

    public void setEmpleadoDAO(EmpleadoDAO empleadoDAO) {
        this.empleadoDAO = empleadoDAO;
    }

}
