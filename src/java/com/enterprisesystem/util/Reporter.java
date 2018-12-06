package com.enterprisesystem.util;

import com.enterprisesystem.modelo.Usuario;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;


public class Reporter {
    
    public void viewReportPdf(List<Usuario> dataSource) throws JRException, IOException{
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("username", "Franklin");
        
        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/reportes/usuario.jasper"));
        //JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parametros, new JRBeanCollectionDataSource(dataSource));
        byte[] bytes = JasperRunManager.runReportToPdf(jasper.getPath(), parametros, new JRBeanCollectionDataSource(dataSource));
        
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.setContentType("application/pdf");
        response.setContentLength(bytes.length);
        ServletOutputStream outStream = response.getOutputStream();
        outStream.write(bytes, 0, bytes.length);
        outStream.flush();
        outStream.close();
        
        FacesContext.getCurrentInstance().responseComplete();
    }
    
    public void downloadReportPdf(List<Usuario> dataSource) throws JRException, IOException{
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("username", "Franklin");
        
        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/reportes/usuario.jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parametros, new JRBeanCollectionDataSource(dataSource));
        
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Content-disposition", "attachment; filename=usuarios.pdf");
        ServletOutputStream stream = response.getOutputStream();
        
        JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
        
        stream.flush();
        stream.close();
        FacesContext.getCurrentInstance().responseComplete();
    }
    
    public void downloadReportDocx(List<Usuario> dataSource) throws JRException, IOException{
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("username", "Franklin");
        
        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/reportes/usuario.jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parametros, new JRBeanCollectionDataSource(dataSource));
        
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Content-disposition", "attachment; filename=usuarios.docx");
        ServletOutputStream stream = response.getOutputStream();
        
        JRDocxExporter exporter = new JRDocxExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, stream);
        exporter.exportReport();
        
        stream.flush();
        stream.close();
        FacesContext.getCurrentInstance().responseComplete();
    }
}
