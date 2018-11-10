package com.enterprisesystem.beans;

import com.enterprisesystem.dao.UsuarioDAO;
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
    
    @PostConstruct
    public void init(){
        usuarioDAO = new UsuarioDAO();
        listaUsuario = usuarioDAO.buscarTodo();
    }
    
    public void borrar(Usuario usuario){
        System.out.println("entra a borrar en el bean");
        usuarioDAO.borrar(usuario);
    }

    public UsuarioBean() {
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
    
}
