/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enterprisesystem.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author gerson.ruizusam
 */
@Table(name = "planillas")
@Entity
public class Planilla implements Serializable{

    @Id
    private Integer idplanillas;
    private Date fechaInicio;
    private Date fechaFin;
    private String estado;
    private String tipoPlanilla;

    public Planilla() {
        super();
    }

    public Planilla(Integer idplanillas) {
        super();
        this.idplanillas = idplanillas;
    }

    public Planilla(Integer idplanillas, Date fechaInicio, Date fechaFin, String estado, String tipoPlanilla) {
        this.idplanillas = idplanillas;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
        this.tipoPlanilla = tipoPlanilla;
    }

    public Integer getIdplanillas() {
        return idplanillas;
    }

    public void setIdplanillas(Integer idplanillas) {
        this.idplanillas = idplanillas;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipoPlanilla() {
        return tipoPlanilla;
    }

    public void setTipoPlanilla(String tipoPlanilla) {
        this.tipoPlanilla = tipoPlanilla;
    }

}
