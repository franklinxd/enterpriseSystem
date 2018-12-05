package com.enterprisesystem.beans;

import com.enterprisesystem.dao.UsuarioDAO;
import com.enterprisesystem.modelo.Usuario;
import com.enterprisesystem.util.Reporter;
import java.io.IOException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import net.sf.jasperreports.engine.JRException;

@ManagedBean
@ViewScoped
public class ReporterBean {    
    private List<Usuario> listaUsuario;
    private UsuarioDAO usuarioDAO;
    private Reporter reporter;

    @PostConstruct
    public void init(){
        usuarioDAO = new UsuarioDAO();
        listaUsuario = usuarioDAO.buscarTodo();
        reporter = new Reporter();
        System.out.println("Inicializado...");
    }
    
    
    public void getReport(ActionEvent ev){
        System.out.println("Obteniendo Reportes...");
        try{
            reporter.descargarPdf(listaUsuario);
        } catch(IOException | JRException e){
            System.out.println("Error al Generar Reporte: " + e.getMessage());
        }
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
