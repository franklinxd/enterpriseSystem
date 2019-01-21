/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enterprisesystem.beans;

import com.enterprisesystem.dao.PlanillaDAO;
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
public class PlanillaBean {

    private List<Planilla> listaPlanilla;
    private PlanillaDAO planillaDAO;
    private Planilla planilla;
    private String accion;

    @PostConstruct
    public void init() {
        planillaDAO = new PlanillaDAO();
        listaPlanilla = planillaDAO.buscarTodo();
        planilla = new Planilla();
        planilla.setIdplanillas(0);
        accion = "Registrar";
    }

    public void limpiarFormulario() {
        this.planilla = new Planilla();
        this.planilla.setIdplanillas(0);
        accion = "Registrar";
    }

    public void acctionFormulario() {
        if (accion == "Registrar") {
            insertar();
        } else {
            actualizar();
        }
    }

    public void editar(Planilla planilla) {
        this.planilla = planilla;
        accion = "Editar";
    }

    public void borrar(Planilla planilla) {
        boolean flag = planillaDAO.borrar(planilla);
        if (flag) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO", "Su Planilla fué Borrada Exitosamente.");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        } else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Su Planilla NO fué Borrada.");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }
        listaPlanilla = planillaDAO.buscarTodo();
    }

    private void insertar() {
        boolean flag = planillaDAO.insertar(planilla);
        if (flag) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO", "Su Planilla fué Guardada Exitosamente.");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        } else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Su Planilla NO fué Guardada.");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }
        listaPlanilla = planillaDAO.buscarTodo();
        limpiarFormulario();
    }

    private void actualizar() {
        boolean flag = planillaDAO.actualizar(planilla);
        if (flag) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO", "Su Planilla fué Actualizado Correctamente.");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        } else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Su Planilla NO fué Actualizada.");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }
        listaPlanilla = planillaDAO.buscarTodo();
        limpiarFormulario();
    }

    public PlanillaBean() {
        super();
    }

    public List<Planilla> getListaPlanilla() {
        return listaPlanilla;
    }

    public void setListaPlanilla(List<Planilla> listaPlanilla) {
        this.listaPlanilla = listaPlanilla;
    }

    public PlanillaDAO getPlanillaDAO() {
        return planillaDAO;
    }

    public void setPlanillaDAO(PlanillaDAO planillaDAO) {
        this.planillaDAO = planillaDAO;
    }

    public Planilla getPlanilla() {
        return planilla;
    }

    public void setPlanilla(Planilla planilla) {
        this.planilla = planilla;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

}
