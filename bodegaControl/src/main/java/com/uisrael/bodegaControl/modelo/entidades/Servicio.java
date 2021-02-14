package com.uisrael.bodegaControl.modelo.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name ="servicio")
public class Servicio implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idServicio;
	@Temporal(TemporalType.DATE)
	private Date fechaServicio;
	private int estadoServicio;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.REFRESH)
	@JoinColumn(name = "fkCliente")
	private Cliente fkCliente;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.REFRESH)
	@JoinColumn(name = "fkTipo")
	private Tipo fkTipo;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.REFRESH)
	@JoinColumn(name = "fkEmpleado")
	private Empleado fkEmpleado;
	
	@OneToMany(cascade = CascadeType.REFRESH, mappedBy = "fkServicio")
	private List<Detalle> listDetalle = new ArrayList<Detalle>();
	
	public Servicio() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdServicio() {
		return idServicio;
	}
	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}
	public Date getFechaServicio() {
		return fechaServicio;
	}
	public void setFechaServicio(Date fechaServicio) {
		this.fechaServicio = fechaServicio;
	}
	public int getEstadoServicio() {
		return estadoServicio;
	}
	public void setEstadoServicio(int estadoServicio) {
		this.estadoServicio = estadoServicio;
	}
	
	
	public Cliente getFkCliente() {
		return fkCliente;
	}
	public void setFkCliente(Cliente fkCliente) {
		this.fkCliente = fkCliente;
	}
	public Tipo getFkTipo() {
		return fkTipo;
	}
	public void setFkTipo(Tipo fkTipo) {
		this.fkTipo = fkTipo;
	}
	public Empleado getFkEmpleado() {
		return fkEmpleado;
	}
	public void setFkEmpleado(Empleado fkEmpleado) {
		this.fkEmpleado = fkEmpleado;
	}
	@Override
	public String toString() {
		return "Servicio [idServicio=" + idServicio + ", fechaServicio=" + fechaServicio + ", estadoServicio="
				+ estadoServicio + "]";
	}
	
	

}
