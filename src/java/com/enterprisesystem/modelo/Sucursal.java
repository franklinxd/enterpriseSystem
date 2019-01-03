package com.enterprisesystem.modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "sucursales")
@Entity
public class Sucursal implements Serializable {

    @Id
    private Integer idsucursal;
    private String nombre;
    private String direccion;
    private String telefono;
    private Integer encargado;
    private String latitud;
    private String longitud;
    @Lob
    private byte[] image;
    
    @ManyToOne
    @JoinColumn(name = "idempresa")
    private Empresa idempresa;

    public Sucursal() {
        super();
    }

    public Sucursal(Integer idsucursal) {
        super();
        this.idsucursal = idsucursal;
    }

    public Sucursal(Integer idsucursal, String nombre, String direccion, String telefono, Integer encargado, String latitud, String longitud, byte[] image, Empresa idempresa) {
        super();
        this.idsucursal = idsucursal;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.encargado = encargado;
        this.latitud = latitud;
        this.longitud = longitud;
        this.image = image;
        this.idempresa = idempresa;
    }

    

    public Integer getIdsucursal() {
        return idsucursal;
    }

    public void setIdsucursal(Integer idsucursal) {
        this.idsucursal = idsucursal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public Integer getEncargado() {
        return encargado;
    }

    public void setEncargado(Integer encargado) {
        this.encargado = encargado;
    }

    public Empresa getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(Empresa idempresa) {
        this.idempresa = idempresa;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
    
}
