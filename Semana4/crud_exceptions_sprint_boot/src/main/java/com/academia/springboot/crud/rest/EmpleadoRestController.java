package com.academia.springboot.crud.rest;

import java.util.List;

import com.academia.springboot.crud.entity.Empleado;
import com.academia.springboot.crud.exeption.EmpleadoNotFoundException;
import com.academia.springboot.crud.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmpleadoRestController {

	private EmpleadoService empleadoService;
	
	@Autowired
	public EmpleadoRestController(EmpleadoService theEmpleadoService) {
		empleadoService = theEmpleadoService;
	}
	
	@GetMapping("/empleados")
	public List<Empleado> mostrarTodos() {
		return empleadoService.mostrarTodos();
	}
	
	@GetMapping("/empleados/{empleadoId}")
	public Empleado getEmpleado(@PathVariable int empleadoId) {
		Empleado theEmpleado = empleadoService.buscarId(empleadoId);
		if (theEmpleado == null) {
			throw new EmpleadoNotFoundException("El id: " + empleadoId+" no esta disponible");
		}
		return theEmpleado;
	}
	
	@PostMapping("/empleados")
	public Empleado agregarEmpleado(@RequestBody Empleado theEmpleado) {
		theEmpleado.setId(0);
		empleadoService.guardar(theEmpleado);
		return theEmpleado;
	}
	@PutMapping("/empleados")
	public Empleado actualizarEmpleado(@RequestBody Empleado theEmpleado) {
		
		empleadoService.guardar(theEmpleado);
		
		return theEmpleado;
	}
	@DeleteMapping("/empleados/{empleadoId}")
	public String borrarEmpleado(@PathVariable int empleadoId) {
		Empleado tempEmpleado = empleadoService.buscarId(empleadoId);
		if (tempEmpleado == null) {
			throw new EmpleadoNotFoundException("El id: " + empleadoId+" no esta disponible");
		}
		empleadoService.borrarId(empleadoId);
		return "Se borro el empleado con el  id: " + empleadoId;
	}
	
}










