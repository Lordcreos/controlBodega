package com.uisrael.bodegaControl.modelo.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;




@Entity
@Table(name="libros")
public class Libro implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int idLibro;
	private String titulo;
	private String descripcion;
	private int numPaginas;
	private int numEjemplares;
	
	
	
	
	
	
	public Libro() {
		super();
		
	}
	public int getIdLibro() {
		return idLibro;
	}
	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getNumPaginas() {
		return numPaginas;
	}
	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	}
	public int getNumEjemplares() {
		return numEjemplares;
	}
	public void setNumEjemplares(int numEjemplares) {
		this.numEjemplares = numEjemplares;
	}
	@Override
	public String toString() {
		return "Libro [IdLibro=" + idLibro + ", titulo=" + titulo + ", descripcion=" + descripcion + ", numPaginas="
				+ numPaginas + ", numEjemplares=" + numEjemplares + ", lisPrestamoLibro=" + "]";
	}

	
	
}
