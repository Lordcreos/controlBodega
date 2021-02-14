package com.uisrael.bodegaControl.vista;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.uisrael.bodegaControl.controlador.BodegaControlador;
import com.uisrael.bodegaControl.controlador.impl.BodegaControladorImpl;
import com.uisrael.bodegaControl.modelo.entidades.Bodega;

@ManagedBean
@ViewScoped
public class BodegaView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Bodega nuevaBodega;
	private String nombreBodega;
	private BodegaControlador bodegaControlador;
	private List<Bodega>listarBodega;
	
	
	public BodegaView() {
	}
	
	@PostConstruct
	public void init() {
		bodegaControlador = new BodegaControladorImpl();
		listarBodega();
	}
	
	public void insertarBodega() {
		try {
			nuevaBodega = new Bodega();
			nuevaBodega.setNombreBodega(nombreBodega);
			bodegaControlador.insertarBodega(nuevaBodega);
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
	
	public void listarBodega() {
		listarBodega = bodegaControlador.listarBodega();
	}

	public Bodega getNuevaBodega() {
		return nuevaBodega;
	}

	public void setNuevaBodega(Bodega nuevaBodega) {
		this.nuevaBodega = nuevaBodega;
	}

	public String getNombreBodega() {
		return nombreBodega;
	}

	public void setNombreBodega(String nombreBodega) {
		this.nombreBodega = nombreBodega;
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
	
	
	

}
