package com.enterprisesystem.modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author franklin.ramosusam
 */
@Table(name="usuarios")
@Entity
public class Usuario implements Serializable {
    @Id
    private Integer idusuario;
    private String nombres;
    private String apellidos;
    private String username;
    private String password;
    private String password2;
    @ManyToOne
    @JoinColumn(name="idempresa")
    private Empresa idempresa;

    public Usuario() {
        super();
    }

    public Usuario(Integer idusuario) {
        super();
        this.idusuario = idusuario;
    }

    public Usuario(Integer idusuario, String nombres, String apellidos, String username, String password, Empresa idempresa) {
        super();
        this.idusuario = idusuario;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.username = username;
        this.password = password;
        this.idempresa = idempresa;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Empresa getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(Empresa idempresa) {
        this.idempresa = idempresa;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }
    
}
