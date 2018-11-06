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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author gerson.ruizusam
 */
@Table(name = "empleados")
@Entity
public class Empleado implements Serializable {

    @Id
    private Integer ide;
    @ManyToOne
    @JoinColumn(name = "idsucursal")
    private Sucursal idsucursal;
    private String estado;
    private String codigoEmpleado;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String telefono;
    private String emal;
    private Date fechaNacimiento;
    private String cargo;
    private float salario;

    public Empleado() {
        super();
    }

    public Empleado(Integer ide) {
        super();
        this.ide = ide;
    }

    public Empleado(Integer ide, Sucursal idsucursal, String estado, String codigoEmpleado, String nombres, String apellidos, String direccion, String telefono, String emal, Date fechaNacimiento, String cargo, float salario) {
        super();
        this.ide = ide;
        this.idsucursal = idsucursal;
        this.estado = estado;
        this.codigoEmpleado = codigoEmpleado;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.emal = emal;
        this.fechaNacimiento = fechaNacimiento;
        this.cargo = cargo;
        this.salario = salario;
    }

    public Integer getIde() {
        return ide;
    }

    public void setIde(Integer ide) {
        this.ide = ide;
    }

    public Sucursal getIdsucursal() {
        return idsucursal;
    }

    public void setIdsucursal(Sucursal idsucursal) {
        this.idsucursal = idsucursal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(String codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmal() {
        return emal;
    }

    public void setEmal(String emal) {
        this.emal = emal;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

}
