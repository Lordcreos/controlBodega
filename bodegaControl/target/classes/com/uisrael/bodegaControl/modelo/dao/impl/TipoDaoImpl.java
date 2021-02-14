package com.uisrael.bodegaControl.modelo.dao.impl;

import java.util.List;

import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.uisrael.bodegaControl.modelo.dao.TipoDao;
import com.uisrael.bodegaControl.modelo.entidades.Tipo;

public class TipoDaoImpl extends GenericaDaoImpl<Tipo> implements TipoDao {

	@Override
	public void insertarTipo(Tipo nuevoTipo) {
		// TODO Auto-generated method stub
		try {
			this.beginTransaction();
			this.create(nuevoTipo);
			this.commit();
			
		} catch (Exception e) {
			this.rollback();
		}
		
	}

	@Override
	public List<Tipo> listarTipo() {
		// TODO Auto-generated method stub
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Tipo> c = cb.createQuery(Tipo.class);
		Root<Tipo> tipo = c.from(Tipo.class);
		c.select(tipo);
		return this.entityManager.createQuery(c).getResultList();
	}
	
	public List<Tuple> listaridTipo(){
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Tuple> c = cb.createTupleQuery();
		Root<Tipo> tipo = c.from(Tipo.class);
		c.select(cb.tuple(tipo.get("idTipo"),tipo.get("nombreTipo")));
		return this.entityManager.createQuery(c).getResultList();
	}
	
	public Tipo buscaridTipo(int idTipo) {
	CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
	CriteriaQuery<Tipo> c = cb.createQuery(Tipo.class);
	Root<Tipo> tipo = c.from(Tipo.class);
	c.select(tipo).where(cb.equal(tipo.get("idTipo"), idTipo));
	return this.entityManager.createQuery(c).getSingleResult();
	}


	public Tipo buscarNomTipo(String nombreTipo) {
	CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
	CriteriaQuery<Tipo> c = cb.createQuery(Tipo.class);
	Root<Tipo> tipo = c.from(Tipo.class);
	c.select(tipo).where(cb.equal(tipo.get("nombretipo"), nombreTipo));
	return this.entityManager.createQuery(c).getSingleResult();

	}

	public List<Tipo> listarTipoTQ(){
	TypedQuery<Tipo> lista = this.entityManager.createQuery("Select t From Tipo t ",Tipo.class);
	return lista.getResultList();
	}

	public Tipo buscarNombreTipoTQ(String nombreTipo) {
	TypedQuery<Tipo> tipoEncontrado = this.entityManager.createQuery("Select t From Tipo t where t.nombreTipo = '" + nombreTipo + "'and t.idTipo=1" ,Tipo.class);		
	return tipoEncontrado.getSingleResult();

	}



}

