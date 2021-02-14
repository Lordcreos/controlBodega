package com.uisrael.bodegaControl.vista;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.uisrael.bodegaControl.controlador.EmpleadoControlador;
import com.uisrael.bodegaControl.controlador.impl.EmpleadoControladorImpl;
import com.uisrael.bodegaControl.modelo.entidades.Empleado;

@ManagedBean
@ViewScoped
public class EmpleadoView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Empleado nuevoEmpleado;
	private String nombreEmpleado;
	private String areaEmpleado;
	private String telefonoEmpleado;
	private String correoEmpleado;
	private int estadoEmpleado;
	private EmpleadoControlador empleadoControlador;
	private List<Empleado>listarEmpleado;
	
	
	public EmpleadoView() {
	}

	@PostConstruct
	public void init() {
		empleadoControlador = new EmpleadoControladorImpl();
		listarEmpleado();
	}
	
	public void insertarEmpleado() {
		try {
			
			nuevoEmpleado = new Empleado();
			nuevoEmpleado.setNombreEmpleado(nombreEmpleado);
			nuevoEmpleado.setAreaEmpleado(areaEmpleado);
			nuevoEmpleado.setTelefonoEmpleado(telefonoEmpleado);
			nuevoEmpleado.setCorreoEmpleado(correoEmpleado);
			nuevoEmpleado.setEstadoEmpleado(1);
			empleadoControlador.insertarEmpleado(nuevoEmpleado);
			listarEmpleado();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage
					(FacesMessage.SEVERITY_INFO,"Info","Dato Ingresado Correctamente"));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Insertado"+ e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage
					(FacesMessage.SEVERITY_ERROR, "Info","Error al Insertar Dato"));
		}

			
	}
	
	public void listarEmpleado() {
		listarEmpleado = empleadoControlador.listarEmpleado();
	}

	public Empleado getNuevoEmpleado() {
		return nuevoEmpleado;
	}

	public void setNuevoEmpleado(Empleado nuevoEmpleado) {
		this.nuevoEmpleado = nuevoEmpleado;
	}

	public String getNombreEmpleado() {
		return nombreEmpleado;
	}

	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}

	public String getAreaEmpleado() {
		return areaEmpleado;
	}

	public void setAreaEmpleado(String areaEmpleado) {
		this.areaEmpleado = areaEmpleado;
	}

	public String getTelefonoEmpleado() {
		return telefonoEmpleado;
	}

	public void setTelefonoEmpleado(String telefonoEmpleado) {
		this.telefonoEmpleado = telefonoEmpleado;
	}

	public String getCorreoEmpleado() {
		return correoEmpleado;
	}

	public void setCorreoEmpleado(String correoEmpleado) {
		this.correoEmpleado = correoEmpleado;
	}

	public int getEstadoEmpleado() {
		return estadoEmpleado;
	}

	public void setEstadoEmpleado(int estadoEmpleado) {
		this.estadoEmpleado = estadoEmpleado;
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
