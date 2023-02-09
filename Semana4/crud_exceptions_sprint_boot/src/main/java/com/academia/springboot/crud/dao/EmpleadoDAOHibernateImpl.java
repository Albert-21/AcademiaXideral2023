package com.academia.springboot.crud.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.academia.springboot.crud.entity.Empleado;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmpleadoDAOHibernateImpl implements EmpleadoDAO {
	private EntityManager entityManager;
	@Autowired
	public EmpleadoDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	@Override
	public List<Empleado> mostrarTodos() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Empleado> theQuery =
				currentSession.createQuery("from Empleado", Empleado.class);
		List<Empleado> empleados = theQuery.getResultList();
		return empleados;
	}
	@Override
	public Empleado buscarId(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		Empleado theEmpleado =
				currentSession.get(Empleado.class, theId);
		return theEmpleado;
	}


	@Override
	public void guardar(Empleado theEmpleado) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(theEmpleado);
	}


	@Override
	public void borrarId(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query theQuery = 
				currentSession.createQuery(
						"delete from Empleado where id=:empleadoId");
		theQuery.setParameter("empleadoId", theId);
		
		theQuery.executeUpdate();
	}

}







