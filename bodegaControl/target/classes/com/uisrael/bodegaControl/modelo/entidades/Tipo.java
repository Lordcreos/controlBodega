package com.uisrael.bodegaControl.modelo.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="tipo de servicio")
public class Tipo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTipo;
	@Column(name="tipo", length = 50)
	private String nombreTipo;
	
	@OneToMany(cascade = CascadeType.REFRESH, mappedBy = "fkTipo")
	private List<Servicio> listServicio = new ArrayList<Servicio>();
	
	
	public Tipo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}
	public String getNombreTipo() {
		return nombreTipo;
	}
	public void setNombreTipo(String nombreTipo) {
		this.nombreTipo = nombreTipo;
	}
	@Override
	public String toString() {
		return "Tipo [idTipo=" + idTipo + ", nombreTipo=" + nombreTipo + "]";
	}
	
	

}
