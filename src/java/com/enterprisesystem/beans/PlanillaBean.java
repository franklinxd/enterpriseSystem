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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author gerson.ruizusam
 */
@ManagedBean
@ViewScoped
public class PlanillaBean {
    private List<Planilla>listaPlanilla;
    private PlanillaDAO planillaDAO;
    private Planilla planilla;
    private String accion;
    
    @PostConstruct
    public void init(){
        planillaDAO=new PlanillaDAO();
        listaPlanilla=planillaDAO.buscarTodo();
        this.planilla = new Planilla();
        this.planilla.setIdplanillas(0);
        accion="Registrar";
    }
    public void limpiarFormulario(){
        this.listaPlanilla=planillaDAO.buscarTodo();
        this.planilla=new Planilla();
        this.planilla.setIdplanillas(0);
        accion ="Registrar";
    }
    public void acctionFormulario(){
        if(accion.equals("Registrar")){
            planillaDAO.insertar(this.planilla);
        }else if(accion.equals("Editar")){
            planillaDAO.actualizar(this.planilla);
        }
        limpiarFormulario();
    }
    public void editar(Planilla planilla){
        this.planilla=planilla;
        accion="Editar";
    }
    public void borrar (Planilla planilla){
        planillaDAO.borrar(planilla);
    }
    private void insertar(){
        planillaDAO.insertar(this.planilla);
    }
    private void actualizar(){
        planillaDAO.actualizar(this.planilla);
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
