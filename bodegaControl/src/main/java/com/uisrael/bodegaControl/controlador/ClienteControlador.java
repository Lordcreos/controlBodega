package com.uisrael.bodegaControl.controlador;

import java.util.List;

import javax.persistence.Tuple;

import com.uisrael.bodegaControl.modelo.entidades.Cliente;

public interface ClienteControlador {
	public void insertarCliente(Cliente nuevoCliente);
	public void actualizarCliente(Cliente nuevoCliente);
	public void eliminarCliente(Cliente eliminarCliente);
	public List<Cliente> listarCliente();
	public List<Tuple> listaridCliente();
	public Cliente buscaridCliente(int idCliente);
	public Cliente buscarClienteCorreo(String correoCliente);
	public List<Cliente> listarClienteTQ();
	public Cliente buscarClienteDireccionTQ(String direccionCliente);

}
