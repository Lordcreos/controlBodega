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
@Table(name ="empleados")
public class Empleado implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEmpleado;
	@Column(name = "Nombre", length = 30)
	private String nombreEmpleado;
	@Column(name = "Area", length = 30)
	private String areaEmpleado;
	@Column(name = "telefono", length = 10)
	private String telefonoEmpleado;
	@Column(name = "correo", length = 30)
	private String correoEmpleado;
	private int estadoEmpleado;
	
	@OneToMany(cascade = CascadeType.REFRESH, mappedBy = "fkEmpleado")
	private List<Servicio> listServicio = new ArrayList<Servicio>();
	
	public Empleado() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
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
	@Override
	public String toString() {
		return "Empleado [idEmpleado=" + idEmpleado + ", nombreEmpleado=" + nombreEmpleado + ", areaEmpleado="
				+ areaEmpleado + ", telefonoEmpleado=" + telefonoEmpleado + ", correoEmpleado=" + correoEmpleado
				+ ", estadoEmpleado=" + estadoEmpleado + "]";
	}
	
	

}
