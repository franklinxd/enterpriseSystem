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
    
    @PostConstruct
    public void init(){
        planillaDAO=new PlanillaDAO();
        listaPlanilla=planillaDAO.buscarTodo();
    }
    public void borrar (Integer idplanillas){
        planillaDAO.borrar(idplanillas);
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
    
    
}
