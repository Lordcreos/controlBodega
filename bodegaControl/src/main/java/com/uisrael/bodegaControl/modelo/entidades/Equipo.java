package com.uisrael.bodegaControl.modelo.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="equipos")
public class Equipo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEquipo;
	@Column(name = "Nombre_de_Equipo", length = 40)
	private String nombreEquipo;
	@Column(name = "Caracteristicas_de_Equipo", length = 60)
	private String caracteristicaEquipo;
	
	@OneToMany(cascade = CascadeType.REFRESH, mappedBy = "fkEquipo")
	private List<Detalle> listDetalle = new ArrayList<Detalle>();
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.REFRESH)
	@JoinColumn(name = "fkBodega")
	private Bodega fkBodega;
	
	
	public Equipo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdEquipo() {
		return idEquipo;
	}
	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
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
	
	
	public List<Detalle> getListDetalle() {
		return listDetalle;
	}
	public void setListDetalle(List<Detalle> listDetalle) {
		this.listDetalle = listDetalle;
	}
	public Bodega getFkBodega() {
		return fkBodega;
	}
	public void setFkBodega(Bodega fkBodega) {
		this.fkBodega = fkBodega;
	}
	@Override
	public String toString() {
		return "Equipo [idEquipo=" + idEquipo + ", nombreEquipo=" + nombreEquipo + ", caracteristicaEquipo="
				+ caracteristicaEquipo + "]";
	}
	

	
}
