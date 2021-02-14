package com.uisrael.bodegaControl.modelo.entidades;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="detalle del servicio")
public class Detalle implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDetalle;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.REFRESH)
	@JoinColumn(name = "fkServicio")
	private Servicio fkServicio;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.REFRESH)
	@JoinColumn(name = "fkEquipo")
	private Equipo fkEquipo;

	public Detalle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdDetalle() {
		return idDetalle;
	}

	public void setIdDetalle(int idDetalle) {
		this.idDetalle = idDetalle;
	}

	
	
	public Servicio getFkServicio() {
		return fkServicio;
	}

	public void setFkServicio(Servicio fkServicio) {
		this.fkServicio = fkServicio;
	}

	public Equipo getFkEquipo() {
		return fkEquipo;
	}

	public void setFkEquipo(Equipo fkEquipo) {
		this.fkEquipo = fkEquipo;
	}

	@Override
	public String toString() {
		return "Detalle [idDetalle=" + idDetalle + "]";
	}
	
	
	

}
