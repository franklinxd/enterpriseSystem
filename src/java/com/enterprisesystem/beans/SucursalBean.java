package com.enterprisesystem.beans;

import com.enterprisesystem.dao.EmpleadoDAO;
import com.enterprisesystem.dao.EmpresaDAO;
import com.enterprisesystem.dao.SucursalDAO;
import com.enterprisesystem.modelo.Empleado;
import com.enterprisesystem.modelo.Empresa;
import com.enterprisesystem.modelo.Sucursal;
import java.io.IOException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.apache.commons.io.IOUtils;
import org.primefaces.event.map.PointSelectEvent;
import org.primefaces.model.UploadedFile;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

@ManagedBean
@ViewScoped
public class SucursalBean {

    private List<Sucursal> listaSucursal;
    private List<Empresa> listaEmpresa;
    private List<Empleado> listaEmpleado;
    private SucursalDAO sucursalDAO;
    private EmpresaDAO empresaDAO;
    private EmpleadoDAO empleadoDAO;
    private Sucursal sucursal;
    private String accion;
    private UploadedFile file;
    private MapModel model;
  
    
    
    @PostConstruct
    public void init() {
        sucursalDAO = new SucursalDAO();
        empresaDAO = new EmpresaDAO();
        empleadoDAO = new EmpleadoDAO();
        listaSucursal = sucursalDAO.buscarTodo();
        listaEmpresa = empresaDAO.buscarTodo();
        listaEmpleado = empleadoDAO.buscarTodo();
        this.sucursal = new Sucursal();
        this.sucursal.setIdempresa(new Empresa());
        this.sucursal.setEncargado(new Empleado());
        this.sucursal.setIdsucursal(0);
        accion = "Registrar";
        
        
        model = new DefaultMapModel();
        for(Sucursal sucursal :listaSucursal){
            LatLng coord = new LatLng(sucursal.getLatitud(), sucursal.getLongitud());
            model.addOverlay(new Marker(coord,sucursal.getNombre()));
            
        }
        
        
        
        
    }
    
    public void onPointSelect(PointSelectEvent event){
        sucursal.setLatitud(event.getLatLng().getLat());
        sucursal.setLongitud(event.getLatLng().getLng());
    }
    
    public void limpiarFormulario(){
        this.listaSucursal = sucursalDAO.buscarTodo();
        this.sucursal = new Sucursal();
        sucursal.setIdempresa(new Empresa());
        sucursal.setEncargado(new Empleado());
        this.sucursal.setIdsucursal(0);
        accion = "Registrar";
    }
    
    public void accionFormulario(){
        
        try {
            if((IOUtils.toByteArray(file.getInputstream())).length > 0){
                this.sucursal.setImage(IOUtils.toByteArray(file.getInputstream()));
            }
            
            System.out.println("IMG: " + IOUtils.toString(file.getInputstream()));
            System.out.println("Longitud: " + (IOUtils.toByteArray(file.getInputstream())).length);
            
        } catch(IOException e){
            System.out.println("Error de imagen: " + e.getMessage());
        }
        
        
        if(accion.equals("Registrar")){
            sucursalDAO.insertar(this.sucursal);
        }else if(accion.equals("Editar")){
            sucursalDAO.actualizar(this.sucursal);
        }
        limpiarFormulario();
    }
    
    public void editar(Sucursal sucursal){
        System.out.println("Editando..");
        this.sucursal = sucursal;
        accion = "Editar";
    }
    

    public void borrar(Sucursal sucursal) {
        sucursalDAO.borrar(sucursal);
        listaSucursal = sucursalDAO.buscarTodo();
    }
    
    private void insertar(){
        sucursalDAO.insertar(this.sucursal);
    }
    
    private void actualñizar(){
        sucursalDAO.actualizar(this.sucursal);
    }

    public SucursalBean() {
        super();
    }

    public List<Sucursal> getListaSucursal() {
        return listaSucursal;
    }

    public void setListaSucursal(List<Sucursal> listaSucursal) {
        this.listaSucursal = listaSucursal;
    }

    public List<Empleado> getListaEmpleado() {
        return listaEmpleado;
    }

    public void setListaEmpleado(List<Empleado> listaEmpleado) {
        this.listaEmpleado = listaEmpleado;
    }

    public EmpleadoDAO getEmpleadoDAO() {
        return empleadoDAO;
    }

    public void setEmpleadoDAO(EmpleadoDAO empleadoDAO) {
        this.empleadoDAO = empleadoDAO;
    }

    public SucursalDAO getSucursalDAO() {
        return sucursalDAO;
    }

    public void setSucursalDAO(SucursalDAO sucursalDAO) {
        this.sucursalDAO = sucursalDAO;
    }
    
    public String getAccion(){
        return accion;
    }
    
    public void setAccion(String accion){
        this.accion = accion;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
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

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public MapModel getModel() {
        return model;
    }

    public void setModel(MapModel model) {
        this.model = model;
    }
    
    
}


