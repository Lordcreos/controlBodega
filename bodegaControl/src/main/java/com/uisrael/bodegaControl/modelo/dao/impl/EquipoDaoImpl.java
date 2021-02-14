package com.uisrael.bodegaControl.modelo.dao.impl;

import java.util.List;

import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.uisrael.bodegaControl.modelo.dao.EquipoDao;
import com.uisrael.bodegaControl.modelo.entidades.Equipo;

public class EquipoDaoImpl extends GenericaDaoImpl<Equipo> implements EquipoDao{

	@Override
	public void insertarEquipo(Equipo nuevoEquipo) {

		try {
			this.beginTransaction();
			this.create(nuevoEquipo);
			this.commit();	
		} catch (Exception e) {
			this.rollback();
		}
	}

	@Override
	public List<Equipo> listarEquipo() {
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Equipo> c = cb.createQuery(Equipo.class);
		Root<Equipo> equipo = c.from(Equipo.class);
		c.select(equipo);
		return this.entityManager.createQuery(c).getResultList();
	}

	
	public List<Tuple> listaridEquipo()
	{
		CriteriaBuilder cb =this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Tuple> c= cb.createTupleQuery();
		Root<Equipo>equipo = c.from(Equipo.class);
		c.select(cb.tuple(equipo.get("idEquipo"),equipo.get("nombreEquipo")));
		return this.entityManager.createQuery(c).getResultList();	
	}
	

	public Equipo buscaridEquipo(int idEquipo) {
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Equipo> c = cb.createQuery(Equipo.class);
		Root<Equipo> equipo = c.from(Equipo.class);
		c.select(equipo).where(cb.equal(equipo.get("idEquipo"), idEquipo));
		return this.entityManager.createQuery(c).getSingleResult();
	}
	

	public Equipo buscarEquipoNombre(String nombreEquipo) {
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Equipo> c = cb.createQuery(Equipo.class);
		Root<Equipo> equipo = c.from(Equipo.class);
		c.select(equipo).where(cb.equal(equipo.get("nombreEquipo"), nombreEquipo));
		return this.entityManager.createQuery(c).getSingleResult();
	}
	

	public List<Equipo> listarEquipoTQ(){
	TypedQuery<Equipo> lista = this.entityManager.createQuery("Select e From Equipo e",Equipo.class);
	return lista.getResultList();
	}
	

	public Equipo buscarEquipoNombreTQ(String nombreEquipo) {
		TypedQuery<Equipo> equipoEncontrado=this.entityManager.createQuery
		("Select e From Equipo e where e.nombreEquipo = '" + nombreEquipo + "'and e.idEquipo=5" , Equipo.class);
		return equipoEncontrado.getSingleResult();	
	}

}


