package com.luv2code.springboot.cruddemo.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.luv2code.springboot.cruddemo.entity.Empleado;


@Service
public class EmpleadoServiceImpl implements EmpleadoService {

	private RestTemplate restTemplate;

	private String crmRestUrl;
		
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Autowired
	public EmpleadoServiceImpl(RestTemplate theRestTemplate, 
										@Value("${crm.rest.url}") String theUrl) {
		restTemplate = theRestTemplate;
		crmRestUrl = theUrl;
				
		logger.info("Loaded property:  crm.rest.url=" + crmRestUrl);
	}
	
	@Override
	public List<Empleado> mostrarTodos() {
		logger.info("en getCustomers(): Calling REST API " + crmRestUrl);
		ResponseEntity<List<Empleado>> responseEntity = 
											restTemplate.exchange(crmRestUrl, HttpMethod.GET, null, 
																  new ParameterizedTypeReference<List<Empleado>>() {});
		List<Empleado> empleados = responseEntity.getBody();

		logger.info("en mostrarTodos(): empleados" + empleados);
		
		return empleados;
	}

	@Override
	public Empleado buscarPorId(int theId) {
		Empleado theEmpleado =
				restTemplate.getForObject(crmRestUrl + "/" + theId, 
						Empleado.class);

		logger.info("en buscarPorId(): theEmpleado=" + theEmpleado);
		
		return theEmpleado;
	}

	@Override
	public void guardar(Empleado theEmpleado) {
		logger.info("en guardarEmpleado(): Calling REST API " + crmRestUrl);
		
		int employeeId = theEmpleado.getId();
		if (employeeId == 0) {
			restTemplate.postForEntity(crmRestUrl, theEmpleado, String.class);
		} else {
			restTemplate.put(crmRestUrl, theEmpleado);
		}

		logger.info("en Empleado guardar(): success");	
		
	}

	@Override
	public void borrarPorId(int theId) {
		logger.info("en borrarPorId(): Calling REST API " + crmRestUrl);
		restTemplate.delete(crmRestUrl + "/" + theId);
		logger.info("en borrarPorId(): deleted employee theId=" + theId);
		
	}

	

	
	
}






