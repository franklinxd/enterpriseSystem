package com.enterprisesystem.beans;

import com.enterprisesystem.dao.EmpresaDAO;
import com.enterprisesystem.modelo.Empresa;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author franklin.ramosusam
 */
@ManagedBean
@ViewScoped
public class EmpresaBean {
    private List<Empresa> listaEmpresa;
    private EmpresaDAO empresaDAO;
    private Empresa empresa;
    private String accion;
    
    @PostConstruct
    public void init(){
        empresaDAO = new EmpresaDAO();
        listaEmpresa = empresaDAO.buscarTodo();
        this.empresa = new Empresa();
        this.empresa.setIdempresa(0);
        accion="Registrar";
    }
    
    public void limpiarFormulario(){
        this.listaEmpresa = empresaDAO.buscarTodo();
        this.empresa = new Empresa();
        this.empresa.setIdempresa(0);
        accion = "Registrar";
    }
    
    public void accionFormulario(){
        if(accion.equals("Registrar")){
            empresaDAO.insertar(this.empresa);
        }else if(accion.equals("Editar")){
            empresaDAO.actualizar(this.empresa);
        }
        limpiarFormulario();
    }
    
    public void editar(Empresa empresa){
        this.empresa = empresa;
        accion = "Editar";
    }
    public void borrar(Empresa empresa){
        empresaDAO.borrar(empresa);
        listaEmpresa = empresaDAO.buscarTodo();
    }
    
    private void insertar(){
        empresaDAO.insertar(this.empresa);
        this.listaEmpresa = empresaDAO.buscarTodo();
    }
    
    private void actualizar(){
        empresaDAO.actualizar(this.empresa);
    }

    public EmpresaBean() {
        super();
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

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }
    
    
}
