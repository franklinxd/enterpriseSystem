/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enterprisesystem.beans;

import com.enterprisesystem.dao.IngresoDAO;
import com.enterprisesystem.dao.SucursalDAO;
import com.enterprisesystem.modelo.IngresoMensual;
import com.enterprisesystem.modelo.Sucursal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class IngresosBean {

    private List<IngresoMensual> listaIngres;
    private List<Sucursal> listaSucursal;
    private IngresoDAO ingresoDAO;
    private SucursalDAO sucursalDAO;
    private IngresoMensual ingreso;
    private String accion;

    @PostConstruct
    public void init() {
        ingresoDAO = new IngresoDAO();
        sucursalDAO = new SucursalDAO();
        listaIngres = ingresoDAO.buscarTodo();
        listaSucursal = sucursalDAO.buscarTodo();
        this.ingreso = new IngresoMensual();
        this.ingreso.setIdsucursal(new Sucursal());
        this.ingreso.setIdingresomensual(0);
        accion = "Registrar";
    }

    public void limpiarFormulario() {
        this.listaIngres = ingresoDAO.buscarTodo();
        this.ingreso = new IngresoMensual();
        ingreso.setIdsucursal(new Sucursal());
        this.ingreso.setIdingresomensual(0);
        accion = "Registrar";
    }

    public void accionFormulario() {
        if (accion.equals("Registrar")) {
            ingresoDAO.insertar(this.ingreso);
        } else if (accion.equals("Editar")) {
            ingresoDAO.actualizar(this.ingreso);
        }
        limpiarFormulario();
    }

    public void editar(IngresoMensual ingreso) {
        System.out.println("Editando . . .");
        this.ingreso = ingreso;
        accion = "Editar";
    }

    public void borrar(IngresoMensual ingreso) {
        ingresoDAO.borrar(ingreso);
        this.listaIngres = ingresoDAO.buscarTodo();
    }

    private void insertar() {
        ingresoDAO.insertar(this.ingreso);
    }

    private void actualizar() {
        ingresoDAO.actualizar(this.ingreso);
    }

    public List<IngresoMensual> getListaIngres() {
        return listaIngres;
    }

    public void setListaIngres(List<IngresoMensual> listaIngres) {
        this.listaIngres = listaIngres;
    }

    public IngresoDAO getIngresoDAO() {
        return ingresoDAO;
    }

    public void setIngresoDAO(IngresoDAO ingresoDAO) {
        this.ingresoDAO = ingresoDAO;
    }

    public IngresoMensual getIngreso() {
        return ingreso;
    }

    public void setIngreso(IngresoMensual ingreso) {
        this.ingreso = ingreso;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public List<Sucursal> getListaSucursal() {
        return listaSucursal;
    }

    public void setListaSucursal(List<Sucursal> listaSucursal) {
        this.listaSucursal = listaSucursal;
    }

    public SucursalDAO getSucursalDAO() {
        return sucursalDAO;
    }

    public void setSucursalDAO(SucursalDAO sucursalDAO) {
        this.sucursalDAO = sucursalDAO;
    }

}
