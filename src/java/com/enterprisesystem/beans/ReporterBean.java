package com.enterprisesystem.beans;

import com.enterprisesystem.dao.EmpresaDAO;
import com.enterprisesystem.dao.PlanillaDAO;
import com.enterprisesystem.dao.UsuarioDAO;
import com.enterprisesystem.modelo.Empresa;
import com.enterprisesystem.modelo.Planilla;
import com.enterprisesystem.modelo.Usuario;
import com.enterprisesystem.util.Reporter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    private List<Planilla> listaPlanilla;
    private PlanillaDAO planillaDAO;
    private List<Empresa> listaEmpresa;
    private EmpresaDAO empresaDAO;
    private Reporter reporter;
    Map<String, Object> parametros;

    @PostConstruct
    public void init(){
        usuarioDAO = new UsuarioDAO();
        listaUsuario = usuarioDAO.buscarTodo();
        planillaDAO = new PlanillaDAO();
        listaPlanilla = planillaDAO.buscarTodo();
        empresaDAO = new EmpresaDAO();
        listaEmpresa = empresaDAO.buscarTodo();
        reporter = new Reporter();
        
        parametros = new HashMap<>();
        parametros.put("username", "Franklin");
        
        System.out.println("Inicializado...");
    } 
    
    public void getReport(){
        reporter.getReport(listaUsuario, parametros, "/reportes/usuario.jasper","Reporte_de_Usuarios", Reporter.VIEW_PDF);
    }
    
    public void viewReportPdf(){
        reporter.getReport(listaUsuario, parametros, "/reportes/usuario.jasper","Reporte_de_Usuarios", Reporter.VIEW_PDF);
    }
    
    public void viewReportPdfs(){
        reporter.getReport(listaPlanilla, parametros, "/reportes/planilla.jasper","Reporte_de_Planilla", Reporter.VIEW_PDF);
    }
    
    public void viewReportPdfss(){
        reporter.getReport(listaEmpresa, parametros, "/reportes/Empresa.jasper","Reporte_de_Empresa", Reporter.VIEW_PDF);
    }
    
    public void downloadReportPdf(){
        reporter.getReport(listaUsuario, parametros, "/reportes/usuario.jasper","Reporte_de_Usuarios", Reporter.DOWNLOAD_PDF);
    }
    
    public void downloadReportDocx(){
        reporter.getReport(listaUsuario, parametros, "/reportes/usuario.jasper","Reporte_de_Usuarios", Reporter.DOWNLOAD_DOCX);
    }
    
    public void downloadReportXlsx(){
        reporter.getReport(listaUsuario, parametros, "/reportes/usuario.jasper","Reporte_de_Usuarios", Reporter.DOWNLOAD_XLSX);
    }
    
    public void downloadReportPptx(){
        reporter.getReport(listaUsuario, parametros, "/reportes/usuario.jasper","Reporte_de_Usuarios", Reporter.DOWNLOAD_PPTX);
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
