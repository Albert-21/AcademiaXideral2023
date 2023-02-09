package com.luv2code.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springboot.cruddemo.entity.Empleado;
import com.luv2code.springboot.cruddemo.service.EmpleadoService;

@Controller
@RequestMapping("/mvc")
public class EmpleadoMvcController {
	@Autowired
	private EmpleadoService empleadoService;
	
	@GetMapping("/empleados")
	public String listaEmpleados(Model theModel) {
		
		List<Empleado> theEmpleados = empleadoService.mostrarTodos();
				
		theModel.addAttribute("empleados", theEmpleados);
		
		return "list-empleados";
	}

	@GetMapping("/formParaAgreagar")
	public String formParaAgreagar(Model theModel) {
		
		Empleado theEmpleado = new Empleado();
		
		theModel.addAttribute("empleado", theEmpleado);
		
		return "empleado-form";
	}
	
	@PostMapping("/guardarEmpleado")
	public String guardarEmpleado(@ModelAttribute("empleado") Empleado theEmpleado) {
		
		empleadoService.guardar(theEmpleado);
		
		return "redirect:/mvc/empleados";
	}
	
	@GetMapping("/formParaActualizar")
	public String formParaActualizar(@RequestParam("emleadoId") int theId,
									Model theModel) {
		
		Empleado theEmpleado = empleadoService.buscarPorId(theId);
		
		theModel.addAttribute("empleado", theEmpleado);
		
		return "empleado-form";
	}
	
	@GetMapping("/delete")
	public String borrarEmpleado(@RequestParam("emleadoId") int theId) {
		empleadoService.borrarPorId(theId);
		
		return "redirect:/mvc/empleados";
	}

}










