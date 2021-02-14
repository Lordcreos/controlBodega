package com.uisrael.bodegaControl.vista;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.uisrael.bodegaControl.controlador.TipoControlador;
import com.uisrael.bodegaControl.controlador.impl.TipoControladorImpl;
import com.uisrael.bodegaControl.modelo.entidades.Tipo;

@ManagedBean
@ViewScoped
public class TipoView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Tipo nuevoTipo;
	private String tipo;
	private TipoControlador tipoControlador;
	private List<Tipo>listarTipo;
	
	public TipoView() {
		
	}

	@PostConstruct
	public void init() {
		tipoControlador = new TipoControladorImpl();
		listarTipo();
		
	}
	
	public void insertarTipo() {
		try {
			nuevoTipo = new Tipo();
			nuevoTipo.setNombreTipo(tipo);
			tipoControlador.insertarTipo(nuevoTipo);
			listarTipo();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage
					(FacesMessage.SEVERITY_INFO,"Info","Dato Ingresado Correctamente"));	
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Insertado"+ e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage
					(FacesMessage.SEVERITY_ERROR, "Info","Error al Insertar Dato"));
		}

		
	}
	
	public void listarTipo() {
		listarTipo = tipoControlador.listarTipo();
	}

	public Tipo getNuevoTipo() {
		return nuevoTipo;
	}

	public void setNuevoTipo(Tipo nuevoTipo) {
		this.nuevoTipo = nuevoTipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public TipoControlador getTipoControlador() {
		return tipoControlador;
	}

	public void setTipoControlador(TipoControlador tipoControlador) {
		this.tipoControlador = tipoControlador;
	}

	public List<Tipo> getListarTipo() {
		return listarTipo;
	}

	public void setListarTipo(List<Tipo> listarTipo) {
		this.listarTipo = listarTipo;
	}
	
	
}
