package com.uisrael.bodegaControl.modelo.dao.impl;

import java.util.List;

import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.uisrael.bodegaControl.modelo.dao.BodegaDao;
import com.uisrael.bodegaControl.modelo.entidades.Bodega;

public class BodegaDaoImpl extends GenericaDaoImpl<Bodega> implements BodegaDao {


	@Override
	public void insertarBodega(Bodega nuevaBodega) {

		try {
			this.beginTransaction();
			this.create(nuevaBodega);
			this.commit();	
		} catch (Exception e) {
			this.rollback();
		}
	}

	@Override
	public List<Bodega> listarBodega() {
	
	CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Bodega> c = cb.createQuery(Bodega.class);
		Root<Bodega> bodega = c.from(Bodega.class);
		c.select(bodega);
		return this.entityManager.createQuery(c).getResultList();
		
		
//	this.beginTransaction();
		// List<Bodega> lista = this.findAll();
		//this.commit();	
		//this.commitAndCloseTransaction();
		// System.out.println(lista);
		// return lista;
		
	/*	 this.beginTransaction();
		    List<Bodega> lista = this.findAll();
		    this.closeTransaction();
		    return lista;1*/

	
	} 

	/*
	public List<Tuple> listaridBodega()
	{
		CriteriaBuilder cb =this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Tuple> c= cb.createTupleQuery();
		Root<Bodega>bodega = c.from(Bodega.class);
		c.select(cb.tuple(bodega.get("idBodega"),bodega.get("nombreBodega")));
		return this.entityManager.createQuery(c).getResultList();	
	}
	*/
	

	public Bodega buscaridBodega(int idBodega) {
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Bodega> c = cb.createQuery(Bodega.class);
		Root<Bodega> bodega = c.from(Bodega.class);
		c.select(bodega).where(cb.equal(bodega.get("idBodega"), idBodega));
		return this.entityManager.createQuery(c).getSingleResult();
	}
	

	public Bodega buscarBodegaNombre(String nombreBodega) {
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Bodega> c = cb.createQuery(Bodega.class);
		Root<Bodega> bodega = c.from(Bodega.class);
		c.select(bodega).where(cb.equal(bodega.get("nombreBodega"), nombreBodega));
		return this.entityManager.createQuery(c).getSingleResult();
	}
	

	public List<Bodega> listarBodegaTQ(){
	TypedQuery<Bodega> lista = this.entityManager.createQuery("Select b From Bodega b",Bodega.class);
	return lista.getResultList();
	}
	

	public Bodega buscarBodegaNombreTQ(String nombreBodega) {
		TypedQuery<Bodega> bodegaEncontrado=this.entityManager.createQuery
		("Select b From Bodega b where b.nombreBodega = '" + nombreBodega + "'and b.idBodega=5" , Bodega.class);
		return bodegaEncontrado.getSingleResult();	
	}

	@Override
	public List<Tuple> listaridBodega() {
		// TODO Auto-generated method stub
		return null;
	}


}

