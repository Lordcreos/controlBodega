package com.uisrael.bodegaControl.modelo.dao.impl;

import java.util.List;

import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.uisrael.bodegaControl.modelo.dao.ClienteDao;
import com.uisrael.bodegaControl.modelo.entidades.Cliente;

public class ClienteDaoImpl extends GenericaDaoImpl<Cliente> implements ClienteDao {

	@Override
	public void insertarCliente(Cliente nuevoCliente) {

		try {
			this.beginTransaction();
			this.create(nuevoCliente);
			this.commit();	
		} catch (Exception e) {
			this.rollback();
		} 
	}

	@Override
	public List<Cliente> listarCliente() {
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Cliente> c = cb.createQuery(Cliente.class);
		Root<Cliente> cliente = c.from(Cliente.class);
		c.select(cliente);
		return this.entityManager.createQuery(c).getResultList();
	}

	
	public List<Tuple> listaridCliente()
	{
		CriteriaBuilder cb =this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Tuple> c= cb.createTupleQuery();
		Root<Cliente>cliente = c.from(Cliente.class);
		c.select(cb.tuple(cliente.get("idCliente"),cliente.get("nombreCliente"),cliente.get("apellidoCliente")));
		return this.entityManager.createQuery(c).getResultList();	
	}
	

	public Cliente buscaridCliente(int idCliente) {
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Cliente> c = cb.createQuery(Cliente.class);
		Root<Cliente> cliente = c.from(Cliente.class);
		c.select(cliente).where(cb.equal(cliente.get("idCliente"), idCliente));
		return this.entityManager.createQuery(c).getSingleResult();
	}
	

	public Cliente buscarClienteCorreo(String correoCliente) {
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Cliente> c = cb.createQuery(Cliente.class);
		Root<Cliente> cliente = c.from(Cliente.class);
		c.select(cliente).where(cb.equal(cliente.get("correoCliente"), correoCliente));
		return this.entityManager.createQuery(c).getSingleResult();
	}
	

	public List<Cliente> listarClienteTQ(){
	TypedQuery<Cliente> lista = this.entityManager.createQuery("Select c From Cliente c",Cliente.class);
	return lista.getResultList();
	}
	

	public Cliente buscarClienteDireccionTQ(String direccionCliente) {
		TypedQuery<Cliente> clienteEncontrado=this.entityManager.createQuery
		("Select c From Cliente c where c.direccionCliente = '" + direccionCliente + "'and c.idCliente=5" , Cliente.class);
		return clienteEncontrado.getSingleResult();	
	}

	@Override
	public void actualizarCliente(Cliente nuevoCliente) {
		try {
			this.beginTransaction();
			this.update(nuevoCliente);
			this.commit();	
		} catch (Exception e) {
			this.rollback();
		} 
	}

	@Override
	public void eliminarCliente(Cliente eliminarCliente) {
		try {
			this.beginTransaction();
			this.delete(eliminarCliente);
			this.commit();	
		} catch (Exception e) {
			this.rollback();
		} 
	}

}
