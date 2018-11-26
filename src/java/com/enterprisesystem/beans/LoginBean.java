
package com.enterprisesystem.beans;

import com.enterprisesystem.dao.LoginDAO;
import com.enterprisesystem.dao.UsuarioDAO;
import com.enterprisesystem.modelo.Usuario;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Jacqueline.BarreraUS
 */
@ManagedBean
@SessionScoped
public class LoginBean {

    private boolean isLogged;
    private List<Usuario> listaUsuario;
    private UsuarioDAO usuarioDAO;
    private String username;
    private String password;
    private String nombre;

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

        try {
            if (u != null) {
                isLogged = true;
                return "Menu";
            } else {
                isLogged = false;
                return "login";
            }
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            return null;
        }

    }
}