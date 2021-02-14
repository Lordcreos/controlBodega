package com.uisrael.bodegaControl.controlador;

import java.util.List;

import javax.persistence.Tuple;

import com.uisrael.bodegaControl.modelo.entidades.Equipo;

public interface EquipoControlador {
	public void insertarEquipo(Equipo nuevoEquipo);
	public List<Equipo> listarEquipo();
	public List<Tuple> listaridEquipo();
	public Equipo buscaridEquipo(int idEquipo);
	public Equipo buscarEquipoNombre(String nombreEquipo);
	public List<Equipo> listarEquipoTQ();
	public Equipo buscarEquipoNombreTQ(String nombreEquipo);
}
