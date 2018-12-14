/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enterprisesystem.beans;

import com.enterprisesystem.dao.EmpresaDAO;
import com.enterprisesystem.dao.SucursalDAO;
import com.enterprisesystem.modelo.Empresa;
import com.enterprisesystem.modelo.Sucursal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import net.bootsfaces.render.A;

/**
 *
 * @author gerson.ruizusam
 */
@ManagedBean
@ViewScoped
public class SucursalBean {

    private List<Sucursal> listaSucursal;
    private List<Empresa> listaEmpresa;
    private SucursalDAO sucursalDAO;
    private EmpresaDAO empresaDAO;
    private Sucursal sucursal;
    private String accion;

    @PostConstruct
    public void init() {
        sucursalDAO = new SucursalDAO();
        empresaDAO = new EmpresaDAO();
        listaSucursal = sucursalDAO.buscarTodo();
        listaEmpresa = empresaDAO.buscarTodo();
        this.sucursal = new Sucursal();
        this.sucursal.setIdempresa(new Empresa());
        this.sucursal.setIdsucursal(0);
        accion = "Registrar";
        
    }
    
    public void limpiarFormulario(){
        this.listaSucursal = sucursalDAO.buscarTodo();
        this.sucursal = new Sucursal();
        sucursal.setIdempresa(new Empresa());
        this.sucursal.setIdsucursal(0);
        accion = "Registrar";
    }
    
    public void accionFormulario(){
        if(accion.equals("Registrar")){
            sucursalDAO.insertar(this.sucursal);
        }else if(accion.equals("Editar")){
            sucursalDAO.actualizar(this.sucursal);
        }
        limpiarFormulario();
    }
    
    public void editar(Sucursal sucursal){
        System.out.println("Editando..");
        this.sucursal = sucursal;
        accion = "Editar";
    }
    

    public void borrar(Sucursal sucursal) {
        sucursalDAO.borrar(sucursal);
        listaSucursal = sucursalDAO.buscarTodo();
    }
    
    private void insertar(){
        sucursalDAO.insertar(this.sucursal);
    }
    
    private void actualñizar(){
        sucursalDAO.actualizar(this.sucursal);
    }

    public SucursalBean() {
        super();
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
    
    public String getAccion(){
        return accion;
    }
    
    public void setAccion(String accion){
        this.accion = accion;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public List<Empresa> getListaEmpresa() {
        return listaEmpresa;
    }

    public void setListaEmpresa(List<Empresa> listaEmpresa) {
        this.listaEmpresa = listaEmpresa;
    }

    public EmpresaDAO getEmpresaDAO() {
        return empresaDAO;
    }

    public void setEmpresaDAO(EmpresaDAO empresaDAO) {
        this.empresaDAO = empresaDAO;
    }
    
    
}
