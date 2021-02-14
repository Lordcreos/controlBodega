package com.uisrael.bodegaControl.modelo.dao.impl;

import java.util.List;

import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.uisrael.bodegaControl.modelo.dao.ServicioDao;
import com.uisrael.bodegaControl.modelo.entidades.Servicio;

public class ServicioDaoImpl extends GenericaDaoImpl<Servicio> implements ServicioDao {

	@Override
	public void insertarServicio(Servicio nuevoServicio) {

		try {
			this.beginTransaction();
			this.create(nuevoServicio);
			this.commit();
			
		} catch (Exception e) {
			this.rollback();
		}
	}

	@Override
	public List<Servicio> listarServicio() {
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Servicio> c = cb.createQuery(Servicio.class);
		Root<Servicio> servicio = c.from(Servicio.class);
		c.select(servicio);
		return this.entityManager.createQuery(c).getResultList();

	}
	
	public List<Tuple> listaridServicio()
	{
		CriteriaBuilder cb =this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Tuple> c= cb.createTupleQuery();
		Root<Servicio>servicio = c.from(Servicio.class);
		c.select(cb.tuple(servicio.get("idServicio"),servicio.get("estadoServicio"),servicio.get("fechaServicio")));
		return this.entityManager.createQuery(c).getResultList();
		
	}
	
	public Servicio buscaridServicio(int idServicio) {
	
	CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
	CriteriaQuery<Servicio> c = cb.createQuery(Servicio.class);
	Root<Servicio> servicio = c.from(Servicio.class);
	c.select(servicio).where(cb.equal(servicio.get("idServicio"), idServicio));
	return this.entityManager.createQuery(c).getSingleResult();
	
	}
	
	public Servicio buscarServicioFecha(String fechaServicio) {
	
	CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
	CriteriaQuery<Servicio> c = cb.createQuery(Servicio.class);
	Root<Servicio> servicio = c.from(Servicio.class);
	c.select(servicio).where(cb.equal(servicio.get("fechaServicio"), fechaServicio));
	return this.entityManager.createQuery(c).getSingleResult();
	
	}
	
	public List<Servicio> listarServicioTQ(){
		TypedQuery<Servicio> lista = this.entityManager.createQuery("Select s From Servicio s",Servicio.class);
		return lista.getResultList();
	}
	
	public Servicio buscarServicioEstadoTQ(int estadoServicio) {
		TypedQuery<Servicio> servicioEncontrado=this.entityManager.createQuery
		("Select s From Servicio s where s.estadoCliente = '" + estadoServicio + "'and s.idServicio=5" ,Servicio.class);
		return servicioEncontrado.getSingleResult();
		
		
	}


}
