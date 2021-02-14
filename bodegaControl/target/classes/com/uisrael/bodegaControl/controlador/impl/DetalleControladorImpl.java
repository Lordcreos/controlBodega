package com.uisrael.bodegaControl.controlador.impl;

import java.util.List;

import javax.persistence.Tuple;

import com.uisrael.bodegaControl.controlador.DetalleControlador;
import com.uisrael.bodegaControl.modelo.dao.DetalleDao;
import com.uisrael.bodegaControl.modelo.dao.impl.DetalleDaoImpl;
import com.uisrael.bodegaControl.modelo.entidades.Detalle;

public class DetalleControladorImpl implements DetalleControlador {

	private DetalleDao detalleDao;
	
	@Override
	public void insertarDetalle(Detalle nuevoDetalle) {
		// TODO Auto-generated method stub
		detalleDao= new DetalleDaoImpl();
		detalleDao.insertarDetalle(nuevoDetalle);	
	}

	@Override
	public List<Detalle> listarDetalle() {
		detalleDao= new DetalleDaoImpl();
		return detalleDao.listarDetalle();
	}
	

	public List<Tuple> listaridDetalle(){
	detalleDao = new DetalleDaoImpl();
	return detalleDao.listaridDetalle();
	}
	

	@Override
	public Detalle buscaridDetalle(int idDetalle) {
		try {
			detalleDao = new DetalleDaoImpl();
			Detalle nuevo =  detalleDao.buscaridDetalle(idDetalle);
			return nuevo;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	


	@Override
	public List<Detalle> listarDetalleTQ() {
		// TODO Auto-generated method stub
		detalleDao = new DetalleDaoImpl();
		return detalleDao.listarDetalleTQ();
	}


	@Override
	public Detalle buscarDetalleIdTQ(int idDetalle) {
		// TODO Auto-generated method stub
		detalleDao = new DetalleDaoImpl();
		return detalleDao.buscarDetalleIdTQ(idDetalle);
	}

}
