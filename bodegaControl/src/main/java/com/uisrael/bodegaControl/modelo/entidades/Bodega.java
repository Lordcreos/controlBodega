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
@Table(name ="articulos de bodega")
public class Bodega implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idBodega;
	@Column(name = "Bodega", length = 15)
	private String nombreBodega;
	
	@OneToMany(cascade = CascadeType.REFRESH, mappedBy = "fkBodega")
	private List<Equipo> listEquipo = new ArrayList<Equipo>();
	
	
	public Bodega() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdBodega() {
		return idBodega;
	}
	public void setIdBodega(int idBodega) {
		this.idBodega = idBodega;
	}
	public String getNombreBodega() {
		return nombreBodega;
	}
	public void setNombreBodega(String nombreBodega) {
		this.nombreBodega = nombreBodega;
	}
	
	
	public List<Equipo> getListEquipo() {
		return listEquipo;
	}
	public void setListEquipo(List<Equipo> listEquipo) {
		this.listEquipo = listEquipo;
	}
	@Override
	public String toString() {
		return "Bodega [idBodega=" + idBodega + ", nombreBodega=" + nombreBodega + "]";
	}


	
	
}

