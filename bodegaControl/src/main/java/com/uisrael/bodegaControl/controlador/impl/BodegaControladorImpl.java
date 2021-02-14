package com.uisrael.bodegaControl.controlador.impl;

import java.util.List;

import javax.persistence.Tuple;

import com.uisrael.bodegaControl.controlador.BodegaControlador;
import com.uisrael.bodegaControl.modelo.dao.BodegaDao;
import com.uisrael.bodegaControl.modelo.dao.impl.BodegaDaoImpl;
import com.uisrael.bodegaControl.modelo.entidades.Bodega;

public class BodegaControladorImpl implements BodegaControlador {

	private BodegaDao bodegaDao;

	@Override
	public void insertarBodega(Bodega nuevaBodega) {
		// TODO Auto-generated method stub
		bodegaDao= new BodegaDaoImpl();
		bodegaDao.insertarBodega(nuevaBodega);	
	}

	@Override
	public List<Bodega> listarBodega() {
		bodegaDao= new BodegaDaoImpl();
		return bodegaDao.listarBodega();
	}
	

	public List<Tuple> listaridBodega(){
	bodegaDao = new BodegaDaoImpl();
	return bodegaDao.listaridBodega();
	}
	

	@Override
	public Bodega buscaridBodega(int idBodega) {
		try {
			bodegaDao = new BodegaDaoImpl();
			Bodega nuevo =  bodegaDao.buscaridBodega(idBodega);
			return nuevo;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	
	public Bodega buscarBodegaNombre(String nombreBodega) {
	try {
		bodegaDao = new BodegaDaoImpl();
		Bodega nuevo =  bodegaDao.buscarBodegaNombre(nombreBodega);
		return nuevo;	
	} catch (Exception e) {
		// TODO: handle exception
		return null;
	}
	
	}


	@Override
	public List<Bodega> listarBodegaTQ() {
		// TODO Auto-generated method stub
		bodegaDao = new BodegaDaoImpl();
		return bodegaDao.listarBodegaTQ();
	}


	@Override
	public Bodega buscarBodegaNombreTQ(String nombreBodega) {
		// TODO Auto-generated method stub
		bodegaDao = new BodegaDaoImpl();
		return bodegaDao.buscarBodegaNombreTQ(nombreBodega);
	}

}


