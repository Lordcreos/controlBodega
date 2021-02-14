package com.uisrael.bodegaControl.vista;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.uisrael.bodegaControl.controlador.ClienteControlador;
import com.uisrael.bodegaControl.controlador.EmpleadoControlador;
import com.uisrael.bodegaControl.controlador.ServicioControlador;
import com.uisrael.bodegaControl.controlador.TipoControlador;
import com.uisrael.bodegaControl.controlador.impl.ClienteControladorImpl;
import com.uisrael.bodegaControl.controlador.impl.EmpleadoControladorImpl;
import com.uisrael.bodegaControl.controlador.impl.ServicioControladorImpl;
import com.uisrael.bodegaControl.controlador.impl.TipoControladorImpl;
import com.uisrael.bodegaControl.modelo.entidades.Cliente;
import com.uisrael.bodegaControl.modelo.entidades.Empleado;
import com.uisrael.bodegaControl.modelo.entidades.Servicio;
import com.uisrael.bodegaControl.modelo.entidades.Tipo;

@ManagedBean
@ViewScoped
public class ServicioView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Servicio nuevoServicio;
	private Tipo nuevoTipo;
	private Cliente nuevoCliente;
	private Empleado nuevoEmpleado;
	private Date fechaServicio;
	private int estadoServicio;
	private TipoControlador tipoControlador;
	private ServicioControlador servicioControlador;
	private ClienteControlador clienteControlador;
	private EmpleadoControlador empleadoControlador;
	private List<Servicio>listarServicio;
	private List<Tipo>listarTipo;
	private List<Cliente>listarCliente;
	private List<Empleado>listarEmpleado;
	private int idServicio;
	
	
	public ServicioView() {
	}
	
	@PostConstruct
	public void init() {
		nuevoTipo = new Tipo();
		nuevoCliente = new Cliente();
		nuevoEmpleado = new Empleado();
		servicioControlador = new ServicioControladorImpl();
		tipoControlador = new TipoControladorImpl();
		clienteControlador = new ClienteControladorImpl();
		empleadoControlador = new EmpleadoControladorImpl();
		listarServicio();
		listarTipo();
		listarCliente();
		listarEmpleado();
	}
	




	public void insertarServicio() {
		
		try {
		nuevoServicio = new Servicio();
		nuevoServicio.setFkCliente(nuevoCliente);
		nuevoServicio.setFkEmpleado(nuevoEmpleado);
		nuevoServicio.setFkTipo(nuevoTipo);
		nuevoServicio.setFechaServicio(fechaServicio);
		nuevoServicio.setEstadoServicio(1);
		nuevoServicio.setIdServicio(idServicio);
		servicioControlador.insertarServicio(nuevoServicio);
		//tipoControlador.insertarTipo(nuevoTipo);
		//empleadoControlador.insertarEmpleado(nuevoEmpleado);
		listarServicio();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage
				(FacesMessage.SEVERITY_INFO,"Info","Dato Ingresado Correctamente"));
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Insertado"+ e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage
					(FacesMessage.SEVERITY_ERROR, "Info","Error al Insertar Dato"));
		}

	}
	
	private void listarEmpleado() {
		// TODO Auto-generated method stub
		listarEmpleado = empleadoControlador.listarEmpleado();
		
	}



	private void listarCliente() {
		listarCliente = clienteControlador.listarCliente();
		
	}

	
	private void listarTipo() {
		listarTipo = tipoControlador.listarTipo();
		
	}
	
	public void listarServicio() {
		listarServicio = servicioControlador.listarServicio();
		
	}

	public Servicio getNuevoServicio() {
		return nuevoServicio;
	}

	public void setNuevoServicio(Servicio nuevoServicio) {
		this.nuevoServicio = nuevoServicio;
	}

	public Tipo getNuevoTipo() {
		return nuevoTipo;
	}

	public void setNuevoTipo(Tipo nuevoTipo) {
		this.nuevoTipo = nuevoTipo;
	}

	public Date getFechaServicio() {
		return fechaServicio;
	}

	public void setFechaServicio( Date fechaServicio) {
		this.fechaServicio = fechaServicio;
	}

	public int getEstadoServicio() {
		return estadoServicio;
	}

	public void setEstadoServicio(int estadoServicio) {
		this.estadoServicio = estadoServicio;
	}

	public TipoControlador getTipoControlador() {
		return tipoControlador;
	}

	public void setTipoControlador(TipoControlador tipoControlador) {
		this.tipoControlador = tipoControlador;
	}

	public ServicioControlador getServicioControlador() {
		return servicioControlador;
	}

	public void setServicioControlador(ServicioControlador servicioControlador) {
		this.servicioControlador = servicioControlador;
	}

	public List<Servicio> getListarServicio() {
		return listarServicio;
	}

	public void setListarServicio(List<Servicio> listarServicio) {
		this.listarServicio = listarServicio;
	}

	public List<Tipo> getListarTipo() {
		return listarTipo;
	}

	public void setListarTipo(List<Tipo> listarTipo) {
		this.listarTipo = listarTipo;
	}

	public int getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}

	public Cliente getNuevoCliente() {
		return nuevoCliente;
	}

	public void setNuevoCliente(Cliente nuevoCliente) {
		this.nuevoCliente = nuevoCliente;
	}

	public ClienteControlador getClienteControlador() {
		return clienteControlador;
	}

	public void setClienteControlador(ClienteControlador clienteControlador) {
		this.clienteControlador = clienteControlador;
	}

	public List<Cliente> getListarCliente() {
		return listarCliente;
	}

	public void setListarCliente(List<Cliente> listarCliente) {
		this.listarCliente = listarCliente;
	}

	public Empleado getNuevoEmpleado() {
		return nuevoEmpleado;
	}

	public void setNuevoEmpleado(Empleado nuevoEmpleado) {
		this.nuevoEmpleado = nuevoEmpleado;
	}

	public EmpleadoControlador getEmpleadoControlador() {
		return empleadoControlador;
	}

	public void setEmpleadoControlador(EmpleadoControlador empleadoControlador) {
		this.empleadoControlador = empleadoControlador;
	}

	public List<Empleado> getListarEmpleado() {
		return listarEmpleado;
	}

	public void setListarEmpleado(List<Empleado> listarEmpleado) {
		this.listarEmpleado = listarEmpleado;
	}
	
	
	
	
	
	
}
