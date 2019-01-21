package com.enterprisesystem.beans;

import com.enterprisesystem.dao.EmpresaDAO;
import com.enterprisesystem.dao.UsuarioDAO;
import com.enterprisesystem.modelo.Empresa;
import com.enterprisesystem.modelo.Usuario;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author franklin.ramos
 */
@ManagedBean
@ViewScoped
public class UsuarioBean {

    private List<Usuario> listaUsuario;
    private List<Empresa> listaEmpresa;
    private UsuarioDAO usuarioDAO;
    private EmpresaDAO empresaDAO;
    private Usuario usuario;
    private String accion;   

    @PostConstruct
    public void init() {
        usuarioDAO = new UsuarioDAO();
        empresaDAO = new EmpresaDAO();
        listaUsuario = usuarioDAO.buscarTodo();
        listaEmpresa = empresaDAO.buscarTodo();
        this.usuario = new Usuario();
        this.usuario.setIdempresa(new Empresa());
        this.usuario.setIdusuario(0);
        accion = "Registrar";
    }

    public void limpiarFormulario() {        
        usuario = new Usuario();
        usuario.setIdempresa(new Empresa());
        usuario.setIdusuario(0);
        accion = "Registrar";
    }

    public void accionFormulario() {
        if (accion == "Registrar") {
            insertar();
        } else {
            actualizar();
        }
    }

    public void editar(Usuario usuario) {
        System.out.println("Editando...");
        this.usuario = usuario;
        accion = "Editar";
    }

    public void borrar(Usuario usuario) {
        boolean flag = usuarioDAO.borrar(usuario);
        if (flag) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO", "Su Usuaurio fué Borrado Exitosamente.");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        } else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Su Usuario NO fué Borrado.");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }
        listaUsuario = usuarioDAO.buscarTodo();
    }

    private void insertar() {
        boolean flag = usuarioDAO.insertar(usuario);
        if (flag) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO", "Su Usuario fué Guardado Exitosamente");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        } else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Su Usuario NO fué Guardado");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }
        limpiarFormulario();
        listaUsuario = usuarioDAO.buscarTodo();
    }

    private void actualizar() {
        boolean flag = usuarioDAO.actualizar(usuario);
        if (flag) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO", "Su Usuario fué Actualizado Correctamente");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        } else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Su Usuario NO fué Actualizado");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }
    }

    public UsuarioBean() {
        super();
    }

    public List<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    public void setListaUsuario(List<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    public UsuarioDAO getUsuarioDAO() {
        return usuarioDAO;
    }

    public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
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
