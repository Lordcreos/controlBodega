package com.uisrael.bodegaControl.modelo.dao.impl;

import java.util.List;

import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.uisrael.bodegaControl.modelo.dao.DetalleDao;
import com.uisrael.bodegaControl.modelo.entidades.Detalle;

public class DetalleDaoImpl extends GenericaDaoImpl<Detalle> implements DetalleDao {


	@Override
	public void insertarDetalle(Detalle nuevoDetalle) {
		try {
			
			this.beginTransaction();
			this.create(nuevoDetalle);
			this.commit();	
		} catch (Exception e) {
			this.rollback();
		}
	}
	

	@Override
	public List<Detalle> listarDetalle() {
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Detalle> c = cb.createQuery(Detalle.class);
		Root<Detalle> detalle = c.from(Detalle.class);
		c.select(detalle);
		return this.entityManager.createQuery(c).getResultList();
	}

	
	public List<Tuple> listaridDetalle()
	{
		CriteriaBuilder cb =this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Tuple> c= cb.createTupleQuery();
		Root<Detalle>detalle = c.from(Detalle.class);
		c.select(cb.tuple(detalle.get("idDetalle")));
		return this.entityManager.createQuery(c).getResultList();	
	}
	

	public Detalle buscaridDetalle(int idDetalle) {
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Detalle> c = cb.createQuery(Detalle.class);
		Root<Detalle> detalle = c.from(Detalle.class);
		c.select(detalle).where(cb.equal(detalle.get("idDetalle"), idDetalle));
		return this.entityManager.createQuery(c).getSingleResult();
	}
	


	public List<Detalle> listarDetalleTQ(){
	TypedQuery<Detalle> lista = this.entityManager.createQuery("Select d From Detalle d",Detalle.class);
	return lista.getResultList();
	}
	

	public Detalle buscarDetalleIdTQ(int idDetalle) {
		TypedQuery<Detalle> detalleEncontrado=this.entityManager.createQuery
		("Select d From Detalle d where d.idDetalle = '" + idDetalle + "'and d.idDetalle=1" , Detalle.class);
		return detalleEncontrado.getSingleResult();	
	}

}
