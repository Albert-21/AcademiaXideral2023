package com.academia.springboot.crud.dao;

import java.util.List;

import com.academia.springboot.crud.entity.Empleado;

public interface EmpleadoDAO {

	public List<Empleado> mostrarTodos();
	
	public Empleado buscarId(int theId);
	
	public void guardar(Empleado theEmpleado);
	
	public void borrarId(int theId);
	
}
