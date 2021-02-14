package com.uisrael.bodegaControl.controlador;

import java.util.List;

import javax.persistence.Tuple;

import com.uisrael.bodegaControl.modelo.entidades.Tipo;

public interface TipoControlador {
	public void insertarTipo(Tipo nuevoTipo);
	public List<Tipo> listarTipo();
	public List<Tuple> listaridTipo();
	public Tipo buscaridTipo(int idTipo);
	public Tipo buscarNomTipo(String nombreTipo);
	public List<Tipo> listarTipoTQ();
	public Tipo buscarNombreTipoTQ(String nombreTipo);
}
