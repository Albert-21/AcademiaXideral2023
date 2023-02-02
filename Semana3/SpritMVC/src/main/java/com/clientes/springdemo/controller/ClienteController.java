package com.clientes.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.clientes.springdemo.service.ClienteService;
import com.clientes.springdemo.entity.Cliente;


@Controller
@RequestMapping("/cliente")
public class ClienteController {

	// need to inject our cliente service
	@Autowired
	private ClienteService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		// get customers from the service
		List<Cliente> theCustomers = customerService.getClientes();
				
		// add the customers to the model
		theModel.addAttribute("cliente", theCustomers);
		
		return "list-clientes";
	}
	
	@GetMapping("/formParaAgregar")
	public String formParaAgregar(Model theModel) {
		
		// create model attribute to bind form data
		Cliente theCustomer = new Cliente();
		
		theModel.addAttribute("cliente", theCustomer);
		
		return "clientes-form";
	}
	
	@PostMapping("/guardarCliente")
	public String guardarCliente(@ModelAttribute("cliente") Cliente theCustomer) {
		
		// save the cliente using our service
		customerService.guardarCliente(theCustomer);	
		
		return "redirect:/cliente/list";
	}
	
	@GetMapping("/formParaActualizar")
	public String formParaActualizar(@RequestParam("customerId") int theId,
									Model theModel) {
		
		// get the cliente from our service
		Cliente theCustomer = customerService.getCliente(theId);
		
		// set cliente as a model attribute to pre-populate the form
		theModel.addAttribute("cliente", theCustomer);
		
		// send over to our form		
		return "clientes-form";
	}
	
	@GetMapping("/borrar")
	public String borrarCliente(@RequestParam("customerId") int theId) {
		
		// delete the cliente
		customerService.borrarCliente(theId);
		
		return "redirect:/cliente/list";
	}
}










