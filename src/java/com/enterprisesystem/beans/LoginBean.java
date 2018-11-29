package com.enterprisesystem.beans;

import com.enterprisesystem.dao.LoginDAO;
import com.enterprisesystem.dao.UsuarioDAO;
import com.enterprisesystem.modelo.Usuario;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;

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

    public void saveMessage() {
        FacesContext context = FacesContext.getCurrentInstance();

        context.addMessage(null, new FacesMessage("Successful", "Your message: " + message));
        context.addMessage(null, new FacesMessage("Second Message", "Additional Message Detail"));
    }

    public String validaLogin() throws Exception {

        LoginDAO user = new LoginDAO();
        Usuario u = user.validarUsuario(username, password);
        FacesMessage message = null;
        boolean loggedIn ;
        idusuario = u.getIdusuario();
        try {
            if (u != null) {
                loggedIn = true;
                FacesContext.getCurrentInstance().getExternalContext().redirect("Menu.xhtml");
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", u.getNombres());
                return "Menu";
            } else {
                isLogged = false;
                message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Usuario o contraseña incorrecta");
                return "login";
            }
        } catch (Exception e) {
            return null;
        }

    }

}
