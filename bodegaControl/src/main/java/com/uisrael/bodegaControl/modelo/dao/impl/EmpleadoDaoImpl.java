package com.uisrael.bodegaControl.modelo.dao.impl;

import java.util.List;

import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.uisrael.bodegaControl.modelo.dao.EmpleadoDao;
import com.uisrael.bodegaControl.modelo.entidades.Empleado;

public class EmpleadoDaoImpl extends GenericaDaoImpl<Empleado> implements EmpleadoDao {

	@Override
	public void insertarEmpleado(Empleado nuevoEmpleado) {

		try {
			this.beginTransaction();
			this.create(nuevoEmpleado);
			this.commit();	
		} catch (Exception e) {
			this.rollback();
		}
	}

	@Override
	public List<Empleado> listarEmpleado() {
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Empleado> c = cb.createQuery(Empleado.class);
		Root<Empleado> empleado = c.from(Empleado.class);
		c.select(empleado);
		return this.entityManager.createQuery(c).getResultList();
	}

	
	public List<Tuple> listaridEmpleado()
	{
		CriteriaBuilder cb =this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Tuple> c= cb.createTupleQuery();
		Root<Empleado>empleado = c.from(Empleado.class);
		c.select(cb.tuple(empleado.get("idEmpleado"),empleado.get("nombreEmpleado"),empleado.get("areaEmpleado")));
		return this.entityManager.createQuery(c).getResultList();	
	}
	

	public Empleado buscaridEmpleado(int idEmpleado) {
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Empleado > c = cb.createQuery(Empleado.class);
		Root<Empleado> empleado  = c.from(Empleado .class);
		c.select(empleado ).where(cb.equal(empleado .get("idEmpleado "), idEmpleado ));
		return this.entityManager.createQuery(c).getSingleResult();
	}
	

	public Empleado buscarEmpleadoArea(String areaEmpleado) {
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Empleado> c = cb.createQuery(Empleado.class);
		Root<Empleado> empleado = c.from(Empleado.class);
		c.select(empleado).where(cb.equal(empleado.get("areaEmpleado"), areaEmpleado));
		return this.entityManager.createQuery(c).getSingleResult();
	}
	

	public List<Empleado> listarEmpleadoTQ(){
	TypedQuery<Empleado> lista = this.entityManager.createQuery("Select e From Empleado e",Empleado.class);
	return lista.getResultList();
	}
	

	public Empleado buscarEmpleadoAreaTQ(String areaEmpleado) {
		TypedQuery<Empleado> empleadoEncontrado=this.entityManager.createQuery
		("Select e From Empleado e where e.areaEmpleado = '" + areaEmpleado + "'and e.idEmpleado=1" , Empleado.class);
		return empleadoEncontrado.getSingleResult();	
	}

}
