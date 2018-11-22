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
    private Integer idempleado;
    @ManyToOne
    @JoinColumn(name = "idsucursal")
    private Sucursal idsucursal;
    private String estado;
    private String codigoEmpleado;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String telefono;
    private String email;
    private Date fechaNacimiento;
    private String cargo;
    private float salario;
    private String sexo;
    private String EstadoCivil;
    private String DUI;
    private String NIT;
    private String NUP;
    private String afiliacionISSS;

    public Empleado() {
        super();
    }

    public Empleado(Integer ide) {
        super();
        this.idempleado = ide;
    }

    public Empleado(Integer idempleado, Sucursal idsucursal, String estado, String codigoEmpleado, String nombres, String apellidos, String direccion, String telefono, String email, Date fechaNacimiento, String cargo, float salario, String sexo, String EstadoCivil, String DUI, String NIT, String NUP, String afiliacionISSS) {
        this.idempleado = idempleado;
        this.idsucursal = idsucursal;
        this.estado = estado;
        this.codigoEmpleado = codigoEmpleado;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.cargo = cargo;
        this.salario = salario;
        this.sexo = sexo;
        this.EstadoCivil = EstadoCivil;
        this.DUI = DUI;
        this.NIT = NIT;
        this.NUP = NUP;
        this.afiliacionISSS = afiliacionISSS;
    }



    public Integer getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(Integer idempleado) {
        this.idempleado = idempleado;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstadoCivil() {
        return EstadoCivil;
    }

    public void setEstadoCivil(String EstadoCivil) {
        this.EstadoCivil = EstadoCivil;
    }

    public String getDUI() {
        return DUI;
    }

    public void setDUI(String DUI) {
        this.DUI = DUI;
    }

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

    public String getNUP() {
        return NUP;
    }

    public void setNUP(String NUP) {
        this.NUP = NUP;
    }

    public String getAfiliacionISSS() {
        return afiliacionISSS;
    }

    public void setAfiliacionISSS(String afiliacionISSS) {
        this.afiliacionISSS = afiliacionISSS;
    }

}
