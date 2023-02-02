package com.clientes.springdemo.service;

import java.util.List;

import com.clientes.springdemo.entity.Cliente;

public interface ClienteService {

	public List<Cliente> getClientes();

	public void guardarCliente(Cliente theCustomer);

	public Cliente getCliente(int theId);

	public void borrarCliente(int theId);
	
}
