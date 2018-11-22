
package com.enterprisesystem.modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author manuel.suarezusam
 */
@Table(name="ingrosmensuales")
@Entity
public class IngresoMensual implements Serializable{
     @Id
     private Integer idingresomensual; 
     @ManyToOne
     @JoinColumn(name = "idsucursal")
     private Sucursal idsucursal;
     private String mes;
     private Integer anio;
     private float ingreso;

    public IngresoMensual() {
        super();
    }

    public IngresoMensual(Integer idingresomensual, Sucursal idsucursal, String mes, Integer anio, float ingreso) {
        super();
        this.idingresomensual = idingresomensual;
        this.idsucursal = idsucursal;
        this.mes = mes;
        this.anio = anio;
        this.ingreso = ingreso;
    }

    public Integer getIdingresomensual() {
        return idingresomensual;
    }

    public void setIdingresomensual(Integer idingresomensual) {
        this.idingresomensual = idingresomensual;
    }

    public Sucursal getIdsucursal() {
        return idsucursal;
    }

    public void setIdsucursal(Sucursal idsucursal) {
        this.idsucursal = idsucursal;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public float getIngreso() {
        return ingreso;
    }

    public void setIngreso(float ingreso) {
        this.ingreso = ingreso;
    }
     
     
}
