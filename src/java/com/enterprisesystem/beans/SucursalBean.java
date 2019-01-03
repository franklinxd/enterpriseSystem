package com.enterprisesystem.beans;

import com.enterprisesystem.dao.EmpleadoDAO;
import com.enterprisesystem.dao.EmpresaDAO;
import com.enterprisesystem.dao.SucursalDAO;
import com.enterprisesystem.modelo.Empleado;
import com.enterprisesystem.modelo.Empresa;
import com.enterprisesystem.modelo.Sucursal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.map.PointSelectEvent;

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
    
    
}
