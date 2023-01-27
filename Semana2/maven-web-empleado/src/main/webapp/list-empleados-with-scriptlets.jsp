<%@ page import="java.util.*, com.luv2code.web.jdbc.*" %>
<!DOCTYPE html>
<html>

<head>
	<title>Empleado Tracker App</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<%
	// get the empleados from the request object (sent by servlet)
	List<Empleado> theStudents = (List<Empleado>) request.getAttribute("EMPLEADO_LIST");
%>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Academia Xideral</h2>
		</div>
	</div>

	<div id="container">
	
		<div id="content">
		
			<table>
			
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
				</tr>
				
				<% for (Empleado tempEmpleado : theStudents) { %>
				
					<tr>
						<td> <%= tempEmpleado.getNombre() %> </td>
						<td> <%= tempEmpleado.getApellido() %> </td>
						<td> <%= tempEmpleado.getCorreo() %> </td>
					</tr>
				
				<% } %>
				
			</table>
		
		</div>
	
	</div>
</body>


</html>








