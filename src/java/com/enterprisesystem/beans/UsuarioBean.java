package com.enterprisesystem.beans;

import com.enterprisesystem.dao.UsuarioDAO;
import com.enterprisesystem.modelo.Empresa;
import com.enterprisesystem.modelo.Usuario;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author franklin.ramos
 */

@ManagedBean
@ViewScoped
public class UsuarioBean {
    private List<Usuario> listaUsuario;
    private UsuarioDAO usuarioDAO;
    private Usuario usuario;
    private String accion;
    
    @PostConstruct
    public void init(){
        usuarioDAO = new UsuarioDAO();
        listaUsuario = usuarioDAO.buscarTodo();
        this.usuario = new Usuario();
        this.usuario.setIdempresa(new Empresa());
        this.usuario.setIdusuario(0);
        accion = "Registrar";
    }
    
    public void limpiarFormulario(){
        this.listaUsuario = usuarioDAO.buscarTodo();
        this.usuario = new Usuario();
        usuario.setIdempresa(new Empresa());
        this.usuario.setIdusuario(0);
        accion = "Registrar";
        
    }
    
    public void accionFormulario(){
        if(accion.equals("Registrar")){
            usuarioDAO.insertar(this.usuario);
        } else if(accion.equals("Editar")){
            usuarioDAO.actualizar(this.usuario);
        }
        
        limpiarFormulario();
    }
    
    public void editar(Usuario usuario){
        System.out.println("Editando...");
        this.usuario = usuario;
        accion = "Editar";
    }
    
    public void borrar(Usuario usuario){
        usuarioDAO.borrar(usuario);
    }
    
    private void insertar(){
        usuarioDAO.insertar(this.usuario);
    }
    
    private void actualizar(){
        usuarioDAO.actualizar(this.usuario);
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
}
