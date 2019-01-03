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
    
    @ManyToOne
    @JoinColumn(name = "idempleado")
    private Empleado encargado;
    
    @ManyToOne
    @JoinColumn(name = "idempresa")
    private Empresa idempresa;
    
    private double latitud;
    private double longitud;
    
    @Lob
    private byte[] image;
    

    public Sucursal() {
        super();
    }

    public Sucursal(Integer idsucursal) {
        super();
        this.idsucursal = idsucursal;
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

    public Empleado getEncargado() {
        return encargado;
    }

    public void setEncargado(Empleado encargado) {
        this.encargado = encargado;
    }

    public Empresa getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(Empresa idempresa) {
        this.idempresa = idempresa;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
