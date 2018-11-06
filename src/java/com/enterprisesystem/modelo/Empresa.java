/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enterprisesystem.modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author franklin.ramosusam
 */
@Table(name = "empresas")
@Entity
public class Empresa implements Serializable{

    @Id
    private Integer idempresa;
    private String nit;
    private String direccion;
    private String telefono;
    private String email;

    public Empresa() {
        super();
    }

    public Empresa(Integer idempresa) {
        super();
        this.idempresa = idempresa;
    }

    public Empresa(Integer idempresa, String nit, String direccion, String telefono, String email) {
        super();
        this.idempresa = idempresa;
        this.nit = nit;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    public Integer getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(Integer idempresa) {
        this.idempresa = idempresa;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
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

}
