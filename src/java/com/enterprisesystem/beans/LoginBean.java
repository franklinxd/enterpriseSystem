package com.enterprisesystem.beans;

import com.enterprisesystem.dao.LoginDAO;
import com.enterprisesystem.dao.UsuarioDAO;
import com.enterprisesystem.modelo.Usuario;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


/**
 *
 * @author Jacqueline.BarreraUS
 */
@ManagedBean
@SessionScoped
public class LoginBean {

    private String message;
    private boolean isLogged;
    private List<Usuario> listaUsuario;
    private UsuarioDAO usuarioDAO;
    private String username;
    private String password;
    private String nombre;
    private static int idusuario;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    public boolean isIsLogged() {
        return isLogged;
    }

    public void setIsLogged(boolean isLogged) {
        this.isLogged = isLogged;
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

    public String validaLogin() throws Exception {

        LoginDAO user = new LoginDAO();
        Usuario u = user.validarUsuario(username, password);
         String adv = "";
        try {
            if (u != null) {
                isLogged = true;

                FacesContext.getCurrentInstance().getExternalContext().redirect("Menu.xhtml");
                
                return "Menu";
            } else {
                isLogged = false;
                adv="¡Los datos no son correctos!";
                FacesMessage msg = new FacesMessage(adv); 
                FacesContext.getCurrentInstance().addMessage(null, msg);
                return "login";

            }
        } catch (Exception e) {
            System.out.println("Error"+e);
            return null;
        }

    }

}
