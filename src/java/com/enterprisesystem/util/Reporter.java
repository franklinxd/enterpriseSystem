package com.enterprisesystem.util;

import com.enterprisesystem.modelo.Usuario;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRAbstractExporter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRPptxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;


public class Reporter {
    
    public static final int VIEW_PDF = 0;
    public static final int DOWNLOAD_PDF = 1;
    public static final int DOWNLOAD_DOCX = 2;
    public static final int DOWNLOAD_XLSX = 3;
    public static final int DOWNLOAD_PPTX = 4;
    
    public void getReport(List data, Map parameters, String url, String name, int format){
        try {
            //Obtener recursos
            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            HttpServletResponse response = (HttpServletResponse) context.getResponse();
            ServletOutputStream stream = response.getOutputStream();

            //Formatear parametros
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(data);
            String path = new File(context.getRealPath(url)).getAbsolutePath();

            // Solo para descargar docx, xlsx, pptx
            JRAbstractExporter exporter = null;

            if(format == VIEW_PDF){
                byte[] bytes = JasperRunManager.runReportToPdf(path, parameters, dataSource);
                response.setContentType("application/pdf");
                response.setContentLength(bytes.length);
                ServletOutputStream outStream = response.getOutputStream();
                outStream.write(bytes, 0, bytes.length);
            } else {
                // Solo para descargar reportes
                JasperPrint jasperPrint = JasperFillManager.fillReport(path, parameters, dataSource);
                if(format == DOWNLOAD_PDF){
                    response.addHeader("Content-disposition", "attachment; filename=" + name + ".pdf");
                    JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
                } else {
                    switch(format){
                        case DOWNLOAD_XLSX:
                            exporter = new JRXlsxExporter();
                            response.addHeader("Content-disposition", "attachment; filename=" + name + ".xlsx");
                            break;
                        case DOWNLOAD_PPTX: 
                            exporter = new JRPptxExporter();
                            response.addHeader("Content-disposition", "attachment; filename=" + name + ".pptx");
                            break;
                        case DOWNLOAD_DOCX:
                        default:
                            exporter = new JRDocxExporter();
                            response.addHeader("Content-disposition", "attachment; filename=" + name + ".docx");
                            break;    
                    }
                    // Se ejecuta para todos los reportes de Microsoft Office
                    exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                    exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, stream);
                    exporter.exportReport();
                }
            }

            // Se ejecuta para todos los tipos de reporte soportados
            stream.flush();
            stream.close();
            FacesContext.getCurrentInstance().responseComplete();
        } catch (JRException e){
            System.out.println("Error al Generar el reporte: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error al Obtener la ruta del reporte: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Otro error al Generar Reporte" +  e.getMessage());
        }
    }
    
//    public void viewReportPdf(List<Usuario> dataSource) throws JRException, IOException{
//        Map<String, Object> parametros = new HashMap<>();
//        parametros.put("username", "Franklin");
//        
//        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/reportes/usuario.jasper"));
//        //JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parametros, new JRBeanCollectionDataSource(dataSource));
//        byte[] bytes = JasperRunManager.runReportToPdf(jasper.getPath(), parametros, new JRBeanCollectionDataSource(dataSource));
//        
//        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
//        response.setContentType("application/pdf");
//        response.setContentLength(bytes.length);
//        ServletOutputStream outStream = response.getOutputStream();
//        outStream.write(bytes, 0, bytes.length);
//        outStream.flush();
//        outStream.close();
//        
//        FacesContext.getCurrentInstance().responseComplete();
//    }
    
//    public void downloadReportPdf(List<Usuario> dataSource) throws JRException, IOException{
//        Map<String, Object> parametros = new HashMap<>();
//        parametros.put("username", "Franklin");
//        
//        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/reportes/usuario.jasper"));
//        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parametros, new JRBeanCollectionDataSource(dataSource));
//        
//        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
//        response.addHeader("Content-disposition", "attachment; filename=usuarios.pdf");
//        ServletOutputStream stream = response.getOutputStream();
//        
//        JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
//        
//        stream.flush();
//        stream.close();
//        FacesContext.getCurrentInstance().responseComplete();
//    }
    
//    public void downloadReportDocx(List<Usuario> dataSource) throws JRException, IOException{
//        Map<String, Object> parametros = new HashMap<>();
//        parametros.put("username", "Franklin");
//        
//        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/reportes/usuario.jasper"));
//        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parametros, new JRBeanCollectionDataSource(dataSource));
//        
//        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
//        response.addHeader("Content-disposition", "attachment; filename=usuarios.docx");
//        ServletOutputStream stream = response.getOutputStream();
//        
//        JRDocxExporter exporter = new JRDocxExporter();
//        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
//        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, stream);
//        exporter.exportReport();
//        
//        stream.flush();
//        stream.close();
//        FacesContext.getCurrentInstance().responseComplete();
//    }
    
//    public void downloadReportXlsx(List<Usuario> dataSource) throws JRException, IOException{
//        Map<String, Object> parametros = new HashMap<>();
//        parametros.put("username", "Franklin");
//        
//        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/reportes/usuario.jasper"));
//        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parametros, new JRBeanCollectionDataSource(dataSource));
//        
//        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
//        response.addHeader("Content-disposition", "attachment; filename=usuarios.xlsx");
//        ServletOutputStream stream = response.getOutputStream();
//        
//        JRXlsxExporter exporter = new JRXlsxExporter();
//        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
//        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, stream);
//        exporter.exportReport();
//        
//        stream.flush();
//        stream.close();
//        FacesContext.getCurrentInstance().responseComplete();
//    }
       
//    public void downloadReportPptx(List<Usuario> dataSource) throws JRException, IOException{
//        Map<String, Object> parametros = new HashMap<>();
//        parametros.put("username", "Franklin");
//        
//        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/reportes/usuario.jasper"));
//        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parametros, new JRBeanCollectionDataSource(dataSource));
//        
//        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
//        response.addHeader("Content-disposition", "attachment; filename=usuarios.pptx");
//        ServletOutputStream stream = response.getOutputStream();
//        
//        JRPptxExporter exporter = new JRPptxExporter();
//        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
//        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, stream);
//        exporter.exportReport();
//        
//        stream.flush();
//        stream.close();
//        FacesContext.getCurrentInstance().responseComplete();
//    }
}
