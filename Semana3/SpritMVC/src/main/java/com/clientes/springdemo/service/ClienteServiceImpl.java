package com.clientes.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clientes.springdemo.dao.ClienteDAO;
import com.clientes.springdemo.entity.Cliente;

@Service
public class ClienteServiceImpl implements ClienteService {

	// need to inject cliente dao
	@Autowired
	@Qualifier("clienteDAOImpl")
	private ClienteDAO clienteDAO;
	
	@Override
	@Transactional
	public List<Cliente> getClientes() {
		return clienteDAO.getClientes();
	}

	@Override
	@Transactional
	public void guardarCliente(Cliente theCustomer) {

		clienteDAO.guardarCliente(theCustomer);
	}

	@Override
	@Transactional
	public Cliente getCliente(int theId) {
		
		return clienteDAO.getCliente(theId);
	}

	@Override
	@Transactional
	public void borrarCliente(int theId) {
		
		clienteDAO.borrarCliente(theId);
	}
}





