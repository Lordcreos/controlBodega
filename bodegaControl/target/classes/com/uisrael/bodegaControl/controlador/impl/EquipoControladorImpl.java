package com.uisrael.bodegaControl.controlador.impl;

import java.util.List;

import javax.persistence.Tuple;

import com.uisrael.bodegaControl.controlador.EquipoControlador;
import com.uisrael.bodegaControl.modelo.dao.EquipoDao;
import com.uisrael.bodegaControl.modelo.dao.impl.EquipoDaoImpl;
import com.uisrael.bodegaControl.modelo.entidades.Equipo;

public class EquipoControladorImpl implements EquipoControlador {
	
	private EquipoDao equipoDao;


	@Override
	public void insertarEquipo(Equipo nuevoEquipo) {
		// TODO Auto-generated method stub
		equipoDao= new EquipoDaoImpl();
		equipoDao.insertarEquipo(nuevoEquipo);	
	}

	@Override
	public List<Equipo> listarEquipo() {
		equipoDao= new EquipoDaoImpl();
		return equipoDao.listarEquipo();
	}
	

	public List<Tuple> listaridEquipo(){
	equipoDao = new EquipoDaoImpl();
	return equipoDao.listaridEquipo();
	}
	

	@Override
	public Equipo buscaridEquipo(int idEquipo) {
		try {
			equipoDao = new EquipoDaoImpl();
			Equipo nuevo =  equipoDao.buscaridEquipo(idEquipo);
			return nuevo;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	
	public Equipo buscarEquipoNombre(String nombreCliente) {
	try {
		equipoDao = new EquipoDaoImpl();
		Equipo nuevo =  equipoDao.buscarEquipoNombre(nombreCliente);
		return nuevo;	
	} catch (Exception e) {
		// TODO: handle exception
		return null;
	}
	
	}


	@Override
	public List<Equipo> listarEquipoTQ() {
		// TODO Auto-generated method stub
		equipoDao = new EquipoDaoImpl();
		return equipoDao.listarEquipoTQ();
	}


	@Override
	public Equipo buscarEquipoNombreTQ(String nombreCliente) {
		// TODO Auto-generated method stub
		equipoDao = new EquipoDaoImpl();
		return equipoDao.buscarEquipoNombreTQ(nombreCliente);
	}
	
}



