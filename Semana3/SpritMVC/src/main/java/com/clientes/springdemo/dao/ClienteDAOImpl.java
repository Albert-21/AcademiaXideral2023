package com.clientes.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.clientes.springdemo.entity.Cliente;

@Repository
public class ClienteDAOImpl implements ClienteDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Cliente> getClientes() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query<Cliente> theQuery =
				currentSession.createQuery("from Cliente order by apellido",
						Cliente.class);
		
		// execute query and get result list
		List<Cliente> customers = theQuery.getResultList();
				
		// return the results		
		return customers;
	}

	@Override
	public void guardarCliente(Cliente theCustomer) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate the cliente ... finally LOL
		currentSession.saveOrUpdate(theCustomer);
		
	}

	@Override
	public Cliente getCliente(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Cliente theCustomer = currentSession.get(Cliente.class, theId);
		
		return theCustomer;
	}

	@Override
	public void borrarCliente(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// borrar object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Cliente where id=:customerId");
		theQuery.setParameter("customerId", theId);
		
		theQuery.executeUpdate();		
	}

}











