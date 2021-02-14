package com.uisrael.bodegaControl.modelo.dao;

import java.util.List;

import javax.persistence.Tuple;

import com.uisrael.bodegaControl.modelo.entidades.Empleado;

public interface EmpleadoDao {
	public void insertarEmpleado(Empleado nuevoEmpleado);
	public List<Tuple> listaridEmpleado();
	public List<Empleado> listarEmpleado();
	public Empleado buscaridEmpleado(int idEmpleado);
	public Empleado buscarEmpleadoArea(String areaEmpleado);
	public List<Empleado> listarEmpleadoTQ();
	public Empleado buscarEmpleadoAreaTQ(String areaEmpleado);

}
