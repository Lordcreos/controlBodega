package com.uisrael.bodegaControl.controlador;

import java.util.List;

import javax.persistence.Tuple;

import com.uisrael.bodegaControl.modelo.entidades.Bodega;

public interface BodegaControlador {
	public void insertarBodega(Bodega nuevaBodega);
	public List<Bodega> listarBodega();
	public List<Tuple> listaridBodega();
	public Bodega buscaridBodega(int idBodega);
	public Bodega buscarBodegaNombre(String nombreBodega);
	public List<Bodega> listarBodegaTQ();
	public Bodega buscarBodegaNombreTQ(String nombreBodega);

}