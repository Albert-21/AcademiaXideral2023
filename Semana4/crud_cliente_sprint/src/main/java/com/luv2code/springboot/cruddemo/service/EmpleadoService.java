package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import com.luv2code.springboot.cruddemo.entity.Empleado;

public interface EmpleadoService {

	public List<Empleado> mostrarTodos();
	
	public Empleado buscarPorId(int theId);
	
	public void guardar(Empleado theEmpleado);
	
	public void borrarPorId(int theId);
	
}
