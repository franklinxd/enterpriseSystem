/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enterprisesystem.beans;

import com.enterprisesystem.dao.SucursalDAO;
import com.enterprisesystem.modelo.Sucursal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author gerson.ruizusam
 */
@ManagedBean
@ViewScoped
public class SucursalBean {

    private List<Sucursal> listaSucursal;
    private SucursalDAO sucursalDAO;

    @PostConstruct
    public void init() {
        sucursalDAO = new SucursalDAO();
        listaSucursal = sucursalDAO.buscarTodo();
    }

    public void borrar(Integer idSucursal) {
        sucursalDAO.borrar(idSucursal);
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

}
