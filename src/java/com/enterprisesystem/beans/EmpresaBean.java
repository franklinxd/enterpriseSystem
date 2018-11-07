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
    
    @PostConstruct
    public void init(){
        empresaDAO = new EmpresaDAO();
        listaEmpresa = empresaDAO.buscarTodo();
    }
    
    public void borrar(Empresa empresa){
        empresaDAO.borrar(empresa.getIdempresa());
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
    
    
}
