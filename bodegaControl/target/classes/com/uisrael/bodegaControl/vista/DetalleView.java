package com.uisrael.bodegaControl.vista;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.uisrael.bodegaControl.controlador.DetalleControlador;
import com.uisrael.bodegaControl.controlador.EquipoControlador;
import com.uisrael.bodegaControl.controlador.ServicioControlador;
import com.uisrael.bodegaControl.controlador.impl.DetalleControladorImpl;
import com.uisrael.bodegaControl.controlador.impl.EquipoControladorImpl;
import com.uisrael.bodegaControl.controlador.impl.ServicioControladorImpl;
import com.uisrael.bodegaControl.modelo.entidades.Detalle;
import com.uisrael.bodegaControl.modelo.entidades.Equipo;
import com.uisrael.bodegaControl.modelo.entidades.Servicio;

@ManagedBean
@ViewScoped
public class DetalleView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idDetalle;
	private int idEquipo;
	private int idServicio;
	private Detalle nuevoDetalle;
	private Servicio nuevoServicio;
	private Equipo nuevoEquipo;
	private DetalleControlador detalleControlador;
	private EquipoControlador equipoControlador;
	private ServicioControlador servicioControlador;
	private List<Detalle>listarDetalle;
	private List<Equipo>listarEquipo;
	private List<Servicio>listarServicio;
	
	
	
	public DetalleView() {
		
	}
	
	
	@PostConstruct
	public void init() {
		nuevoEquipo = new Equipo();
		nuevoServicio = new Servicio();
		detalleControlador = new DetalleControladorImpl();
		equipoControlador = new EquipoControladorImpl();
		servicioControlador = new ServicioControladorImpl();
		listarDetalle = new ArrayList<Detalle>();
		listarDetalle();
		listarEquipo();
		listarServicio();
		
		
	}
	
	public void insertarDetalle() {
		try {
			nuevoDetalle = new Detalle();
			nuevoDetalle.setFkEquipo(nuevoEquipo);
			nuevoDetalle.setFkServicio(nuevoServicio);
			detalleControlador.insertarDetalle(nuevoDetalle);
			listarDetalle();
			listarEquipo();
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
	
	
	public void listarDetalle() {
		listarDetalle = detalleControlador.listarDetalle();	
		
	}
	
	public void listarEquipo() {
		listarEquipo = equipoControlador.listarEquipo();
	}
	
	public void listarServicio() {
		listarServicio = servicioControlador.listarServicio();
	}


	public Detalle getNuevoDetalle() {
		return nuevoDetalle;
	}


	public void setNuevoDetalle(Detalle nuevoDetalle) {
		this.nuevoDetalle = nuevoDetalle;
	}


	public Servicio getNuevoServicio() {
		return nuevoServicio;
	}


	public void setNuevoServicio(Servicio nuevoServicio) {
		this.nuevoServicio = nuevoServicio;
	}


	public Equipo getNuevoEquipo() {
		return nuevoEquipo;
	}


	public void setNuevoEquipo(Equipo nuevoEquipo) {
		this.nuevoEquipo = nuevoEquipo;
	}


	public DetalleControlador getDetalleControlador() {
		return detalleControlador;
	}


	public void setDetalleControlador(DetalleControlador detalleControlador) {
		this.detalleControlador = detalleControlador;
	}


	public List<Detalle> getListarDetalle() {
		return listarDetalle;
	}


	public void setListarDetalle(List<Detalle> listarDetalle) {
		this.listarDetalle = listarDetalle;
	}


	public List<Equipo> getListarEquipo() {
		return listarEquipo;
	}


	public void setListarEquipo(List<Equipo> listarEquipo) {
		this.listarEquipo = listarEquipo;
	}


	public EquipoControlador getEquipoControlador() {
		return equipoControlador;
	}


	public void setEquipoControlador(EquipoControlador equipoControlador) {
		this.equipoControlador = equipoControlador;
	}


	public List<Servicio> getListarServicio() {
		return listarServicio;
	}


	public void setListarServicio(List<Servicio> listarServicio) {
		this.listarServicio = listarServicio;
	}


	public ServicioControlador getServicioControlador() {
		return servicioControlador;
	}


	public void setServicioControlador(ServicioControlador servicioControlador) {
		this.servicioControlador = servicioControlador;
	}


	public int getIdDetalle() {
		return idDetalle;
	}


	public void setIdDetalle(int idDetalle) {
		this.idDetalle = idDetalle;
	}


	public int getIdServicio() {
		return idServicio;
	}


	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}


	public int getIdEquipo() {
		return idEquipo;
	}


	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}

	
	
}



