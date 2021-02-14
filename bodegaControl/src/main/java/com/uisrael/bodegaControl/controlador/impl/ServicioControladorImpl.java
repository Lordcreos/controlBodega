package com.uisrael.bodegaControl.controlador.impl;

import java.util.List;

import javax.persistence.Tuple;

import com.uisrael.bodegaControl.controlador.ServicioControlador;
import com.uisrael.bodegaControl.modelo.dao.ServicioDao;
import com.uisrael.bodegaControl.modelo.dao.impl.ServicioDaoImpl;
import com.uisrael.bodegaControl.modelo.entidades.Servicio;

public class ServicioControladorImpl implements ServicioControlador {
	
	private  ServicioDao servicioDao;
	@Override
	public void insertarServicio(Servicio nuevoServicio) {
		// TODO Auto-generated method stub
		servicioDao= new ServicioDaoImpl();
		servicioDao.insertarServicio(nuevoServicio);
		
		
	}

	@Override
	public List<Servicio> listarServicio() {
		servicioDao= new ServicioDaoImpl();
		return servicioDao.listarServicio();

	}
	
	public List<Tuple> listaridServicio(){
	servicioDao = new ServicioDaoImpl();
	return servicioDao.listaridServicio();
	}
	
	@Override
	public Servicio buscaridServicio(int idServicio) {
		try {
			servicioDao = new ServicioDaoImpl();
			Servicio nuevo =  servicioDao.buscaridServicio(idServicio);
			return nuevo;
			
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
		
	public Servicio buscarServicioFecha(String fechaServicio) {
	try {
		servicioDao = new ServicioDaoImpl();
		Servicio nuevo =  servicioDao.buscarServicioFecha(fechaServicio);
		return nuevo;
		
	} catch (Exception e) {
		// TODO: handle exception
		return null;
	}

		
	}

	@Override
	public List<Servicio> listarServicioTQ() {
		// TODO Auto-generated method stub
		servicioDao = new ServicioDaoImpl();
		return servicioDao.listarServicioTQ();
	}

	@Override
	public Servicio buscarServicioEstadoTQ(int estadoServicio) {
		// TODO Auto-generated method stub
		servicioDao = new ServicioDaoImpl();
		return servicioDao.buscarServicioEstadoTQ(estadoServicio);
		
	}

}

