<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>Lista de empleados</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Academia xideral</h2>
		</div>
	</div>

	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Empleado -->
			
			<input type="button" value="Agregar" 
				   onclick="window.location.href='add-empleado-form.jsp'; return false;"
				   class="add-student-button"
			/>
			
			<table>
			
				<tr>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Correo</th>
					<th>Opciones</th>
				</tr>
				
				<c:forEach var="tempEmpleado" items="${EMPLEADO_LIST}">
					
					<!-- set up a link for each Empleado -->
					<c:url var="tempLink" value="EmpledosControllerServlet">
						<c:param name="command" value="LOAD" />
						<c:param name="empleadoId" value="${tempEmpleado.id}" />
					</c:url>

					<!--  set up a link to delete a Empleado -->
					<c:url var="deleteLink" value="EmpledosControllerServlet">
						<c:param name="command" value="DELETE" />
						<c:param name="empleadoId" value="${tempEmpleado.id}" />
					</c:url>
																		
					<tr>
						<td> ${tempEmpleado.nombre} </td>
						<td> ${tempEmpleado.apellido} </td>
						<td> ${tempEmpleado.correo} </td>
						<td> 
							<a href="${tempLink}">Actualizar</a> 
							 | 
							<a href="${deleteLink}"
							onclick="if (!(confirm('Estas seguro de eliminar el registro?'))) return false">
							Borrar</a>	
						</td>
					</tr>
				
				</c:forEach>
				
			</table>
		
		</div>
	
	</div>
</body>


</html>








