package com.uisrael.bodegaControl.controlador;

import java.util.List;

import javax.persistence.Tuple;

import com.uisrael.bodegaControl.modelo.entidades.Detalle;

public interface DetalleControlador {
	public void insertarDetalle(Detalle nuevoDetalle);
	public List<Detalle> listarDetalle();
	public List<Tuple> listaridDetalle();
	public Detalle buscaridDetalle(int idDetalle);
	public List<Detalle> listarDetalleTQ();
	public Detalle buscarDetalleIdTQ(int idDetalle);

}
