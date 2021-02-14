package com.uisrael.bodegaControl.controlador.impl;

import java.util.List;

import javax.persistence.Tuple;

import com.uisrael.bodegaControl.controlador.ClienteControlador;
import com.uisrael.bodegaControl.modelo.dao.ClienteDao;
import com.uisrael.bodegaControl.modelo.dao.impl.ClienteDaoImpl;
import com.uisrael.bodegaControl.modelo.entidades.Cliente;

public class ClienteControladorImpl implements ClienteControlador {

	private ClienteDao clienteDao;

	@Override
	public void insertarCliente(Cliente nuevoCliente) {
		// TODO Auto-generated method stub
		clienteDao= new ClienteDaoImpl();
		clienteDao.insertarCliente(nuevoCliente);	
	}

	@Override
	public List<Cliente> listarCliente() {
		clienteDao= new ClienteDaoImpl();
		return clienteDao.listarCliente();
	}
	

	public List<Tuple> listaridCliente(){
	clienteDao = new ClienteDaoImpl();
	return clienteDao.listaridCliente();
	}
	

	@Override
	public Cliente buscaridCliente(int idCliente) {
		try {
			clienteDao = new ClienteDaoImpl();
			Cliente nuevo =  clienteDao.buscaridCliente(idCliente);
			return nuevo;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	
	public Cliente buscarClienteCorreo(String correoCliente) {
	try {
		clienteDao = new ClienteDaoImpl();
		Cliente nuevo =  clienteDao.buscarClienteCorreo(correoCliente);
		return nuevo;	
	} catch (Exception e) {
		// TODO: handle exception
		return null;
	}
	
	}


	@Override
	public List<Cliente> listarClienteTQ() {
		// TODO Auto-generated method stub
		clienteDao = new ClienteDaoImpl();
		return clienteDao.listarClienteTQ();
	}


	@Override
	public Cliente buscarClienteDireccionTQ(String direccionCliente) {
		// TODO Auto-generated method stub
		clienteDao = new ClienteDaoImpl();
		return clienteDao.buscarClienteDireccionTQ(direccionCliente);
	}

	@Override
	public void actualizarCliente(Cliente nuevoCliente) {
		clienteDao= new ClienteDaoImpl();
		clienteDao.actualizarCliente(nuevoCliente);
	}

	@Override
	public void eliminarCliente(Cliente eliminarCliente) {
		clienteDao= new ClienteDaoImpl();
		clienteDao.eliminarCliente(eliminarCliente);
	}

}
