package com.clientes.springdemo.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clientes.springdemo.entity.Cliente;

import javax.sql.DataSource;

import static org.hibernate.Hibernate.close;

@Repository
public class ClienteDAOImplJDBC implements ClienteDAO {

    @Autowired
    private DataSource dataSource;

    public ClienteDAOImplJDBC(DataSource theDataSource) {
        dataSource = theDataSource;
    }


    @Override
    public List<Cliente> getClientes() {
        List<Cliente> clientes = new ArrayList<>();

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            // get a connection
            myConn = dataSource.getConnection();

            // create sql statement
            String sql = "SELECT * FROM clientes order by apellido";

            myStmt = myConn.createStatement();

            // execute query
            myRs = myStmt.executeQuery(sql);

            // process result set
            while (myRs.next()) {

                // retrieve data from result set row
                int id = myRs.getInt("id");
                String nombre = myRs.getString("nombre");
                String apellido = myRs.getString("apellido");
                String correo = myRs.getString("correo");

                // create new Empleado object
                Cliente tempEmpleado = new Cliente(id, nombre, apellido, correo);

                // add it to the list of clientes
                clientes.add(tempEmpleado);
            }

            return clientes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // close JDBC objects
            close(myConn, myStmt, myRs);
        }
    }

    @Override
    public void guardarCliente(Cliente theCustomer) {

        Connection myConn = null;
        PreparedStatement myStmt = null;
        if (theCustomer.getId() == 0) {
            try {
                // get db connection
                myConn = dataSource.getConnection();

                // create sql for insert
                String sql = "insert into clientes "
                        + "(nombre, apellido, coreo) "
                        + "values (?, ?, ?)";

                myStmt = myConn.prepareStatement(sql);

                // set the param values for the Empleado
                myStmt.setString(1, theCustomer.getNombre());
                myStmt.setString(2, theCustomer.getApellido());
                myStmt.setString(3, theCustomer.getCorreo());

                // execute sql insert
                myStmt.execute();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                // clean up JDBC objects
                close(myConn, myStmt, null);
            }

        }else {
            try {
                // get db connection
                myConn = dataSource.getConnection();

                // create SQL update statement
                String sql = "update clientes "
                        + "set nombre=?, apellido=?, correo=? "
                        + "where id=?";

                // prepare statement
                myStmt = myConn.prepareStatement(sql);

                // set params
                myStmt.setString(1, theCustomer.getNombre());
                myStmt.setString(2, theCustomer.getApellido());
                myStmt.setString(3, theCustomer.getCorreo());
                myStmt.setInt(4, theCustomer.getId());

                // execute SQL statement
                myStmt.execute();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                // clean up JDBC objects
                close(myConn, myStmt, null);
            }
        }



    }

    @Override
    public Cliente getCliente(int theId) {
        Cliente theCliente = null;

        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;
        int clienteId = 0;

        try {

            // get connection to database
            myConn = dataSource.getConnection();

            // create sql to get selected Empleado
            String sql = "select * from student where id=?";

            // create prepared statement
            myStmt = myConn.prepareStatement(sql);

            // set params
            myStmt.setInt(1, theId);

            // execute statement
            myRs = myStmt.executeQuery();

            // retrieve data from result set row
            if (myRs.next()) {
                String nombre = myRs.getString("nombre");
                String apellido = myRs.getString("apellido");
                String correo = myRs.getString("correo");

                // use the empleadoId during construction
                theCliente = new Cliente(clienteId, nombre, apellido, correo);
            } else {
                throw new Exception("Could not find Client id: " + theId);
            }

            return theCliente;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            // clean up JDBC objects
            close(myConn, myStmt, myRs);
        }
    }

    @Override
    public void borrarCliente(int theId) {
        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {
            // get connection to database
            myConn = dataSource.getConnection();

            // create sql to delete student
            String sql = "delete from clientes where id=?";

            // prepare statement
            myStmt = myConn.prepareStatement(sql);

            // set params
            myStmt.setInt(1, theId);

            // execute sql statement
            myStmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // clean up JDBC code
            close(myConn, myStmt, null);
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
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

}











