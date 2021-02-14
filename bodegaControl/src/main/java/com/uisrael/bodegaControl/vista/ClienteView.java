package com.uisrael.bodegaControl.vista;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.uisrael.bodegaControl.controlador.ClienteControlador;
import com.uisrael.bodegaControl.controlador.impl.ClienteControladorImpl;
import com.uisrael.bodegaControl.modelo.entidades.Cliente;

@ManagedBean
@ViewScoped
public class ClienteView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Cliente nuevoCliente;
	private String cedulaCliente;
	private int idCliente;
	private String nombreCliente;
	private String apellidoCliente;
	private String correoCliente;
	private String direccionCliente;
	private String telefonoCliente;
	private int estadoCliente;
	private ClienteControlador clienteControlador;
	private List<Cliente>listarCliente;
	
	public ClienteView() {	
	}
	
	@PostConstruct
	public void init() {
		clienteControlador = new ClienteControladorImpl();
		listarCliente();
	}
	
	public void insertarCliente() {
		try {
			String mensaje = "";
			nuevoCliente = new Cliente();
			nuevoCliente.setCedulaCliente(cedulaCliente);
			nuevoCliente.setNombreCliente(nombreCliente);
			nuevoCliente.setApellidoCliente(apellidoCliente);
			nuevoCliente.setCorreoCliente(correoCliente);
			nuevoCliente.setDireccionCliente(direccionCliente);
			nuevoCliente.setTelefonoCliente(telefonoCliente);
			nuevoCliente.setEstadoCliente(1);

			// Si existe el idCliente ACTUALIZA
			if (idCliente > 0) {
				nuevoCliente.setIdCliente(idCliente);
				clienteControlador.actualizarCliente(nuevoCliente);
				mensaje = "Actualización exitosa";
			}else {
			// INSERTA si no existe el idCliente
				clienteControlador.insertarCliente(nuevoCliente);
				mensaje = "Dato Ingresado Correctamente";
			}
			listarCliente();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage
					(FacesMessage.SEVERITY_INFO,"Info", mensaje));
				
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Insertado"+ e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage
					(FacesMessage.SEVERITY_ERROR, "Info","Error al Insertar Dato"));
		}

	}
	
	public void eliminarCliente(int idCliente) {
		System.out.println(idCliente);
		Cliente cliente = clienteControlador.buscaridCliente(idCliente);
		cliente.setEstadoCliente(0);
		clienteControlador.eliminarCliente(cliente);
		listarCliente();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage
				(FacesMessage.SEVERITY_ERROR, "Info","Cliente eliminado correctamente"));
	}
	
	public void cargarInformacion(int idCliente) {
		System.out.println(idCliente);
		// Cargamos la información de cada cliente que se seleccione para poder actualizar la información
		Cliente cliente = clienteControlador.buscaridCliente(idCliente);
		this.idCliente = cliente.getIdCliente();
		cedulaCliente = cliente.getCedulaCliente();
		nombreCliente = cliente.getNombreCliente();
		apellidoCliente = cliente.getApellidoCliente();
		correoCliente= cliente.getCorreoCliente();
		direccionCliente = cliente.getDireccionCliente();
		telefonoCliente = cliente.getTelefonoCliente();
	}
	
	public void listarCliente() {
		listarCliente = clienteControlador.listarCliente();
	}

	public Cliente getNuevoCliente() {
		return nuevoCliente;
	}

	public void setNuevoCliente(Cliente nuevoCliente) {
		this.nuevoCliente = nuevoCliente;
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

	public ClienteControlador getClienteControlador() {
		return clienteControlador;
	}

	public void setClienteControlador(ClienteControlador clienteControlador) {
		this.clienteControlador = clienteControlador;
	}

	public List<Cliente> getListarCliente() {
		return listarCliente;
	}

	public void setListarCliente(List<Cliente> listarCliente) {
		this.listarCliente = listarCliente;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	
}
