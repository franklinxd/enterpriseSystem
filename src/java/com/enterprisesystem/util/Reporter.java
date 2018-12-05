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
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


public class Reporter {
    
    public void descargarPdf(List<Usuario> dataSource) throws JRException, IOException{
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("username", "Franklin");
        
        for(Usuario u: dataSource){
            System.out.println("id: " + u.getIdusuario() + " nombre: " + u.getNombres());
        }
        
        
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
}
