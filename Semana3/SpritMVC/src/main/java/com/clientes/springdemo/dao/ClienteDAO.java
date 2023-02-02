package com.clientes.springdemo.dao;

import java.sql.SQLException;
import java.util.List;

import com.clientes.springdemo.entity.Cliente;

public interface ClienteDAO {

	public List<Cliente> getClientes();

	public void guardarCliente(Cliente theCustomer);

	public Cliente getCliente(int theId);

	public void borrarCliente(int theId);
	
}
