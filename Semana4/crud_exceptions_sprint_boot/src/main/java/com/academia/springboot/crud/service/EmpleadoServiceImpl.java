package com.academia.springboot.crud.service;

import java.util.List;

import com.academia.springboot.crud.entity.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.academia.springboot.crud.dao.EmpleadoDAO;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

	private EmpleadoDAO empleadoDAO;
	
	@Autowired
	public EmpleadoServiceImpl(EmpleadoDAO theEmpleadoDAO) {
		empleadoDAO = theEmpleadoDAO;
	}
	
	@Override
	@Transactional
	public List<Empleado> mostrarTodos() {
		return empleadoDAO.mostrarTodos();
	}

	@Override
	@Transactional
	public Empleado buscarId(int theId) {
		return empleadoDAO.buscarId(theId);
	}

	@Override
	@Transactional
	public void guardar(Empleado theEmpleado) {
		empleadoDAO.guardar(theEmpleado);
	}

	@Override
	@Transactional
	public void borrarId(int theId) {
		empleadoDAO.borrarId(theId);
	}

}






