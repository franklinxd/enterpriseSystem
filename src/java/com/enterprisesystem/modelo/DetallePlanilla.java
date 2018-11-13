/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enterprisesystem.modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author gerson.ruizusam
 */
@Table(name = "detalleplanillas")
@Entity
public class DetallePlanilla implements Serializable {

    @Id
    private Integer iddetalle;
    @ManyToOne
    @JoinColumn(name = "idplanilla")
    private Planilla idplanilla;
    @ManyToOne
    @JoinColumn(name = "idempleado")
    private Empleado idempleado;
    private float salarioBase;
    private float bono;
    private float isss;
    private float renta;
    private float afp;
    private float salarioNeto;
    private float aguinaldo;
    private float horasExtras;

    public DetallePlanilla() {
        super();
    }

    public DetallePlanilla(Integer iddetalle) {
        super();
        this.iddetalle = iddetalle;
    }

    public DetallePlanilla(Integer iddetalle, Planilla idplanilla, Empleado idempleado, float salarioBase, float bono, float isss, float renta, float afp, float salarioNeto, float aguinaldo, float horasExtras) {
        super();
        this.iddetalle = iddetalle;
        this.idplanilla = idplanilla;
        this.idempleado = idempleado;
        this.salarioBase = salarioBase;
        this.bono = bono;
        this.isss = isss;
        this.renta = renta;
        this.afp = afp;
        this.salarioNeto = salarioNeto;
        this.aguinaldo = aguinaldo;
        this.horasExtras = horasExtras;
    }

    public Integer getIddetalle() {
        return iddetalle;
    }

    public void setIddetalle(Integer iddetalle) {
        this.iddetalle = iddetalle;
    }

    public Planilla getIdplanilla() {
        return idplanilla;
    }

    public void setIdplanilla(Planilla idplanilla) {
        this.idplanilla = idplanilla;
    }
    
    public Empleado getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(Empleado idempleado) {
        this.idempleado = idempleado;
    }

    public float getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(float salarioBase) {
        this.salarioBase = salarioBase;
    }

    public float getBono() {
        return bono;
    }

    public void setBono(float bono) {
        this.bono = bono;
    }

    public float getIsss() {
        return isss;
    }

    public void setIsss(float isss) {
        this.isss = isss;
    }

    public float getRenta() {
        return renta;
    }

    public void setRenta(float renta) {
        this.renta = renta;
    }

    public float getAfp() {
        return afp;
    }

    public void setAfp(float afp) {
        this.afp = afp;
    }

    public float getSalarioNeto() {
        return salarioNeto;
    }

    public void setSalarioNeto(float salarioNeto) {
        this.salarioNeto = salarioNeto;
    }

    public float getAguinaldo() {
        return aguinaldo;
    }

    public void setAguinaldo(float aguinaldo) {
        this.aguinaldo = aguinaldo;
    }

    public float getHorasExtras() {
        return horasExtras;
    }

    public void setHorasExtras(float horasExtras) {
        this.horasExtras = horasExtras;
    }

}
