<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Guardar Empleado</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/css/add-customer-style.css">
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Relacion de Empleados</h2>
		</div>
	</div>

	<div id="container">
		<h3>Guardar Empleado</h3>
	
		<form:form action="guardarEmpleado" modelAttribute="empleado" method="POST">

			<!-- need to associate this data with empleado id -->
			<form:hidden path="id" />
					
			<table>
				<tbody>
					<tr>
						<td><label>Nombre:</label></td>
						<td><form:input path="nombre" /></td>
					</tr>
				
					<tr>
						<td><label>Apellidos:</label></td>
						<td><form:input path="apellido" /></td>
					</tr>

					<tr>
						<td><label>Correo:</label></td>
						<td><form:input path="correo" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Guardar" class="guardar" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/mvc/empleados">Regresar</a>
		</p>
	
	</div>

</body>

</html>










