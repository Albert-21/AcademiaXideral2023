package com.luv2code.web.jdbc;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class EmpledosControllerServlet
 */
@WebServlet("/EmpledosControllerServlet")
public class EmpledosControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EmpleadoDbUtil empleadoDbUtil;
	
	@Resource(name="jdbc/web_student_tracker")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		// create our Empleado db util ... and pass in the conn pool / datasource
		try {
			empleadoDbUtil = new EmpleadoDbUtil(dataSource);
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			// read the "command" parameter
			String theCommand = request.getParameter("command");
			
			// if the command is missing, then default to listing empleados
			if (theCommand == null) {
				theCommand = "LIST";
			}
			
			// route to the appropriate method
			switch (theCommand) {
			
			case "LIST":
				mostrarEmpleados(request, response);
				break;
				
			case "ADD":
				agregarEmpleado(request, response);
				break;
				
			case "LOAD":
				cargarEmpleado(request, response);
				break;
				
			case "UPDATE":
				actualizarEmpleado(request, response);
				break;
			
			case "DELETE":
				eliminarEmpleado(request, response);
				break;
				
			default:
				mostrarEmpleados(request, response);
			}
				
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}

	private void eliminarEmpleado(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		// read Empleado id from form data
		String theEmpleadoId = request.getParameter("empleadoId");
		
		// delete Empleado from database
		empleadoDbUtil.deleteEmpleado(theEmpleadoId);
		
		// send them back to "list empleados" page
		mostrarEmpleados(request, response);
	}

	private void actualizarEmpleado(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		// read Empleado info from form data
		int id = Integer.parseInt(request.getParameter("empleadoId"));
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String correo = request.getParameter("correo");
		
		// create a new Empleado object
		Empleado theEmpleado = new Empleado(id, nombre, apellido, correo);
		
		// perform update on database
		empleadoDbUtil.updateEmpleado(theEmpleado);
		
		// send them back to the "list empleados" page
		mostrarEmpleados(request, response);
		
	}

	private void cargarEmpleado(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {

		// read Empleado id from form data
		String theEmpleadoId = request.getParameter("empleadoId");
		
		// get Empleado from database (db util)
		Empleado theEmpleado = empleadoDbUtil.getEmpleados(theEmpleadoId);
		
		// place Empleado in the request attribute
		request.setAttribute("THE_EMPLEADO", theEmpleado);
		
		// send to jsp page: update-Empleado-form.jsp
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/update-empleados-form.jsp");
		dispatcher.forward(request, response);		
	}

	private void agregarEmpleado(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// read Empleado info from form data
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String correo = request.getParameter("correo");		
		
		// create a new Empleado object
		Empleado theEmpleado = new Empleado(nombre, apellido, correo);
		
		// add the Empleado to the database
		empleadoDbUtil.addEmpleados(theEmpleado);
				
		// send back to main page (the Empleado list)
		mostrarEmpleados(request, response);
	}

	private void mostrarEmpleados(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {

		// get empleados from db util
		List<Empleado> empleados = empleadoDbUtil.getEmpleados();
		
		// add empleados to the request
		request.setAttribute("EMPLEADO_LIST", empleados);
				
		// send to JSP page (view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-empleados.jsp");
		dispatcher.forward(request, response);
	}

}













