<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>Lista Empleados</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Relacion de Empleados</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Customer -->
		
			<input type="button" value="Agregar Empleado"
				   onclick="window.location.href='formParaAgreagar'; return false;"
				   class="add-button"
			/>
		
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Nombre</th>
					<th>Apellidos</th>
					<th>Correo</th>
					<th>Opciones</th>
				</tr>
				
				<!-- loop over and print our empleados -->
				<c:forEach var="tempEmpleado" items="${empleados}">
				
					<!-- construct an "update" link with empleado id -->
					<c:url var="updateLink" value="/mvc/formParaActualizar">
						<c:param name="emleadoId" value="${tempEmpleado.id}" />
					</c:url>					

					<!-- construct an "delete" link with empleado id -->
					<c:url var="deleteLink" value="/mvc/delete">
						<c:param name="emleadoId" value="${tempEmpleado.id}" />
					</c:url>					
					
					<tr>
						<td> ${tempEmpleado.nombre} </td>
						<td> ${tempEmpleado.apellido} </td>
						<td> ${tempEmpleado.correo} </td>
						
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Actualizar</a>
							|
							<a href="${deleteLink}"
							   onclick="if (!(confirm('Estas seguro de eliminar el empleado?'))) return false">Eliminar</a>
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>









