package com.luv2code.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class EmpleadoDbUtil {

	private DataSource dataSource;

	public EmpleadoDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
	public List<Empleado> getEmpleados() throws Exception {
		
		List<Empleado> empleados = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// get a connection
			myConn = dataSource.getConnection();
			
			// create sql statement
			String sql = "select * from student order by last_name";
			
			myStmt = myConn.createStatement();
			
			// execute query
			myRs = myStmt.executeQuery(sql);
			
			// process result set
			while (myRs.next()) {
				
				// retrieve data from result set row
				int id = myRs.getInt("id");
				String nombre = myRs.getString("first_name");
				String apellido = myRs.getString("last_name");
				String correo = myRs.getString("email");
				
				// create new Empleado object
				Empleado tempEmpleado = new Empleado(id, nombre, apellido, correo);
				
				// add it to the list of empleados
				empleados.add(tempEmpleado);				
			}
			
			return empleados;		
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, myRs);
		}		
	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {

		try {
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			
			if (myConn != null) {
				myConn.close();   // doesn't really close it ... just puts back in connection pool
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public void addEmpleados(Empleado theEmpleado) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// get db connection
			myConn = dataSource.getConnection();
			
			// create sql for insert
			String sql = "insert into student "
					   + "(first_name, last_name, email) "
					   + "values (?, ?, ?)";
			
			myStmt = myConn.prepareStatement(sql);
			
			// set the param values for the Empleado
			myStmt.setString(1, theEmpleado.getNombre());
			myStmt.setString(2, theEmpleado.getApellido());
			myStmt.setString(3, theEmpleado.getCorreo());
			
			// execute sql insert
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}

	public Empleado getEmpleados(String theEmpleadoId) throws Exception {

		Empleado theEmpleado = null;
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int empleadoId;
		
		try {
			// convert Empleado id to int
			empleadoId = Integer.parseInt(theEmpleadoId);
			
			// get connection to database
			myConn = dataSource.getConnection();
			
			// create sql to get selected Empleado
			String sql = "select * from student where id=?";
			
			// create prepared statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, empleadoId);
			
			// execute statement
			myRs = myStmt.executeQuery();
			
			// retrieve data from result set row
			if (myRs.next()) {
				String nombre = myRs.getString("first_name");
				String apellido = myRs.getString("last_name");
				String correo = myRs.getString("email");
				
				// use the empleadoId during construction
				theEmpleado = new Empleado(empleadoId, nombre, apellido, correo);
			}
			else {
				throw new Exception("Could not find Empleado id: " + empleadoId);
			}				
			
			return theEmpleado;
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, myRs);
		}
	}

	public void updateEmpleado(Empleado theEmpleado) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			// get db connection
			myConn = dataSource.getConnection();
			
			// create SQL update statement
			String sql = "update student "
						+ "set first_name=?, last_name=?, email=? "
						+ "where id=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setString(1, theEmpleado.getNombre());
			myStmt.setString(2, theEmpleado.getApellido());
			myStmt.setString(3, theEmpleado.getCorreo());
			myStmt.setInt(4, theEmpleado.getId());
			
			// execute SQL statement
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}

	public void deleteEmpleado(String theEmpleadoId) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// convert Empleado id to int
			int empleadoId = Integer.parseInt(theEmpleadoId);
			
			// get connection to database
			myConn = dataSource.getConnection();
			
			// create sql to delete student
			String sql = "delete from student where id=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, empleadoId);
			
			// execute sql statement
			myStmt.execute();
		}
		finally {
			// clean up JDBC code
			close(myConn, myStmt, null);
		}	
	}
}















