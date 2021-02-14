package com.uisrael.bodegaControl.controlador.impl;

import java.util.List;

import javax.persistence.Tuple;

import com.uisrael.bodegaControl.controlador.EmpleadoControlador;
import com.uisrael.bodegaControl.modelo.dao.EmpleadoDao;
import com.uisrael.bodegaControl.modelo.dao.impl.EmpleadoDaoImpl;
import com.uisrael.bodegaControl.modelo.entidades.Empleado;

public class EmpleadoControladorImpl implements EmpleadoControlador {

	private EmpleadoDao empleadoDao;
	
	@Override
	public void insertarEmpleado(Empleado nuevoEmpleado) {
		// TODO Auto-generated method stub
		empleadoDao= new EmpleadoDaoImpl();
		empleadoDao.insertarEmpleado(nuevoEmpleado);	
	}

	@Override
	public List<Empleado> listarEmpleado() {
		empleadoDao= new EmpleadoDaoImpl();
		return empleadoDao.listarEmpleado();
	}
	

	public List<Tuple> listaridEmpleado(){
	empleadoDao = new EmpleadoDaoImpl();
	return empleadoDao.listaridEmpleado();
	}
	

	@Override
	public Empleado buscaridEmpleado(int idEmpleado) {
		try {
			empleadoDao = new EmpleadoDaoImpl();
			Empleado nuevo =  empleadoDao.buscaridEmpleado(idEmpleado);
			return nuevo;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	
	public Empleado buscarEmpleadoArea(String areaEmpleado) {
	try {
		empleadoDao = new EmpleadoDaoImpl();
		Empleado nuevo =  empleadoDao.buscarEmpleadoArea(areaEmpleado);
		return nuevo;	
	} catch (Exception e) {
		// TODO: handle exception
		return null;
	}
	
	}


	@Override
	public List<Empleado> listarEmpleadoTQ() {
		// TODO Auto-generated method stub
		empleadoDao = new EmpleadoDaoImpl();
		return empleadoDao.listarEmpleadoTQ();
	}


	@Override
	public Empleado buscarEmpleadoAreaTQ(String areaEmpleado){
		// TODO Auto-generated method stub
		empleadoDao = new EmpleadoDaoImpl();
		return empleadoDao.buscarEmpleadoAreaTQ(areaEmpleado);
	}
}

