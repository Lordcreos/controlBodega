 package com.uisrael.bodegaControl.vista;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.uisrael.bodegaControl.controlador.BodegaControlador;
import com.uisrael.bodegaControl.controlador.EquipoControlador;
import com.uisrael.bodegaControl.controlador.impl.BodegaControladorImpl;
import com.uisrael.bodegaControl.controlador.impl.EquipoControladorImpl;
import com.uisrael.bodegaControl.modelo.entidades.Bodega;
import com.uisrael.bodegaControl.modelo.entidades.Equipo;

@ManagedBean
@ViewScoped
public class EquipoView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombreEquipo;
	private String caracteristicaEquipo;
	private int idBodega;
	private Equipo nuevoEquipo;
	private Bodega nuevaBodega;
	private List<Bodega>listarBodega;
	private List<Equipo>listarEquipo;
	private EquipoControlador equipoControlador;
	private BodegaControlador bodegaControlador;
	
	
	
	public EquipoView() {
		
	}
	
	@PostConstruct
	public void init() {
		System.out.println(idBodega);
		equipoControlador = new EquipoControladorImpl();
		bodegaControlador = new BodegaControladorImpl();
		listarEquipo();
		listarBodega();
	}
	
	public void insertarEquipo() {
		try {
			nuevoEquipo = new Equipo();
			nuevoEquipo.setNombreEquipo(nombreEquipo);
			nuevoEquipo.setCaracteristicaEquipo(caracteristicaEquipo);
			
			nuevaBodega = new Bodega();
			nuevaBodega.setIdBodega(idBodega);
			nuevoEquipo.setFkBodega(nuevaBodega);
			
		

			equipoControlador.insertarEquipo(nuevoEquipo);	
			listarEquipo();
			listarBodega();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage
					(FacesMessage.SEVERITY_INFO,"Info","Dato Ingresado Correctamente"));
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Insertado"+ e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage
					(FacesMessage.SEVERITY_ERROR, "Info","Error al Insertar Dato"));
		}

	}

	public Equipo getNuevoEquipo() {
		return nuevoEquipo;
	}

	public void setNuevoEquipo(Equipo nuevoEquipo) {
		this.nuevoEquipo = nuevoEquipo;
	}

	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	public String getCaracteristicaEquipo() {
		return caracteristicaEquipo;
	}

	public void setCaracteristicaEquipo(String caracteristicaEquipo) {
		this.caracteristicaEquipo = caracteristicaEquipo;
	}

	public EquipoControlador getEquipoControlador() {
		return equipoControlador;
	}

	public void setEquipoControlador(EquipoControlador equipoControlador) {
		this.equipoControlador = equipoControlador;
	}

	public List<Equipo> getListarEquipo() {
		return listarEquipo;
	}

	public void setListarEquipo(List<Equipo> listarEquipo) {
		this.listarEquipo = listarEquipo;
	}

	public void listarEquipo() {
		listarEquipo = equipoControlador.listarEquipo();
	}
	public void listarBodega() {
		listarBodega = bodegaControlador.listarBodega();
	}


	public BodegaControlador getBodegaControlador() {
		return bodegaControlador;
	}

	public void setBodegaControlador(BodegaControlador bodegaControlador) {
		this.bodegaControlador = bodegaControlador;
	}

	public List<Bodega> getListarBodega() {
		return listarBodega;
	}

	public void setListarBodega(List<Bodega> listarBodega) {
		this.listarBodega = listarBodega;
	}

	public int getIdBodega() {
		return idBodega;
	}

	public void setIdBodega(int idBodega) {
		this.idBodega = idBodega;
	}

	public Bodega getNueva() {
		return nuevaBodega;
	}

	public void setNueva(Bodega nueva) {
		this.nuevaBodega = nueva;
	}
	
	

	
	
	
}

