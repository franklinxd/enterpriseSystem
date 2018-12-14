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
