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
@Table(name ="clientes")
public class Cliente implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCliente;
	
	@Column(name = "Cedula", length = 12)
	private String cedulaCliente;
	
	@Column(name = "Nombre", length = 30)
	private String nombreCliente;
	
	@Column(name = "Apellido", length = 30)
	private String apellidoCliente;
	
	@Column(name = "Correo", length = 30)
	private String correoCliente;
	
	@Column(name = "Direccion", length = 40)
	private String direccionCliente;
	
	@Column(name = "Telefono", length = 20)
	private String telefonoCliente;
	
	private int estadoCliente;
	
	
	@OneToMany(cascade = CascadeType.REFRESH, mappedBy = "fkCliente")
	private List<Servicio> listServicio = new ArrayList<Servicio>();

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getCedulaCliente() {
		return cedulaCliente;
	}

	public void setCedulaCliente(String cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getApellidoCliente() {
		return apellidoCliente;
	}

	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}

	public String getCorreoCliente() {
		return correoCliente;
	}

	public void setCorreoCliente(String correoCliente) {
		this.correoCliente = correoCliente;
	}

	public String getDireccionCliente() {
		return direccionCliente;
	}

	public void setDireccionCliente(String direccionCliente) {
		this.direccionCliente = direccionCliente;
	}

	public String getTelefonoCliente() {
		return telefonoCliente;
	}

	public void setTelefonoCliente(String telefonoCliente) {
		this.telefonoCliente = telefonoCliente;
	}

	public int getEstadoCliente() {
		return estadoCliente;
	}

	public void setEstadoCliente(int estadoCliente) {
		this.estadoCliente = estadoCliente;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", cedulaCliente=" + cedulaCliente + ", nombreCliente="
				+ nombreCliente + ", apellidoCliente=" + apellidoCliente + ", correoCliente=" + correoCliente
				+ ", direccionCliente=" + direccionCliente + ", telefonoCliente=" + telefonoCliente + ", estadoCliente="
				+ estadoCliente + "]";
	}
	


}
