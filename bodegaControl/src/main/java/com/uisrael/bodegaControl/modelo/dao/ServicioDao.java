package com.uisrael.bodegaControl.modelo.dao;

import java.util.List;

import javax.persistence.Tuple;

import com.uisrael.bodegaControl.modelo.entidades.Servicio;

public interface ServicioDao {
	public void insertarServicio(Servicio nuevoServicio);
	public List<Servicio> listarServicio();
	public List<Tuple> listaridServicio();
	public Servicio buscaridServicio(int idServicio);
	public Servicio buscarServicioFecha(String fechaServicio);
	public List<Servicio> listarServicioTQ();
	public Servicio buscarServicioEstadoTQ(int estadoServicio);


}
