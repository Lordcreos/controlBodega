package com.uisrael.bodegaControl.controlador.impl;

import java.util.List;

import javax.persistence.Tuple;

import com.uisrael.bodegaControl.controlador.TipoControlador;
import com.uisrael.bodegaControl.modelo.dao.TipoDao;
import com.uisrael.bodegaControl.modelo.dao.impl.TipoDaoImpl;
import com.uisrael.bodegaControl.modelo.entidades.Tipo;

public class TipoControladorImpl implements TipoControlador{
	
	private TipoDao tipoDao;
	@Override
	public void insertarTipo(Tipo nuevoTipo) {
		// TODO Auto-generated method stub
		tipoDao = new TipoDaoImpl();
		tipoDao.insertarTipo(nuevoTipo);
	}
	
	@Override
	public List<Tipo> listarTipo() {
		// TODO Auto-generated method stub
		tipoDao = new TipoDaoImpl();
		return tipoDao.listarTipo();
	}
	
	public List<Tuple> listaridTipo(){
		tipoDao = new TipoDaoImpl();
		return tipoDao.listaridTipo();	
	}
	
	@Override
	public Tipo buscaridTipo(int idTipo) {
		try {
			tipoDao = new TipoDaoImpl();
			Tipo nuevo = tipoDao.buscaridTipo(idTipo);
			return nuevo;
			
		} catch (Exception e) {
			return null;
		}
	}
	
	public Tipo buscarNomTipo(String nombreTipo) {
	try {
		tipoDao = new TipoDaoImpl();
		Tipo nuevo =  tipoDao.buscarNomTipo(nombreTipo);
		return nuevo;	
	} catch (Exception e) {
		// TODO: handle exception
		return null;
	}
		}

	@Override
	public List<Tipo> listarTipoTQ() {
		// TODO Auto-generated method stub
		tipoDao = new TipoDaoImpl();	
		return tipoDao.listarTipoTQ();
	}
	

	@Override
	public Tipo buscarNombreTipoTQ(String nombreTipo) {
		// TODO Auto-generated method stub
		tipoDao = new TipoDaoImpl();
		return tipoDao.buscarNombreTipoTQ(nombreTipo);
	}

}


