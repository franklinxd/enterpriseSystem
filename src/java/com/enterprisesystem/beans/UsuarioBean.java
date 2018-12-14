package com.enterprisesystem.beans;

import com.enterprisesystem.dao.EmpresaDAO;
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
    private List<Empresa> listaEmpresa;
    private UsuarioDAO usuarioDAO;
    private EmpresaDAO empresaDAO;
    private Usuario usuario;
    private String accion;
    private String username;
    private String password;
    private String password2;
    private String nombre;

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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }
    
    
    
    @PostConstruct
    public void init(){
        usuarioDAO = new UsuarioDAO();
        empresaDAO = new EmpresaDAO();
        listaUsuario = usuarioDAO.buscarTodo();
        listaEmpresa = empresaDAO.buscarTodo();
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
        this.listaUsuario = usuarioDAO.buscarTodo();
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
