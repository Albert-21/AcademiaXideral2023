<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Customers</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Manejo de los Clientes</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Customer -->
		
			<input type="button" value="Agregar Cliente"
				   onclick="window.location.href='formParaAgregar'; return false;"
				   class="add-button"
			/>
		
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Correo</th>
					<th>Opciones</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempCliente" items="${cliente}">
				
					<!-- construct an "update" link with cliente id -->
					<c:url var="linkActualizar" value="/cliente/formParaActualizar">
						<c:param name="customerId" value="${tempCliente.id}" />
					</c:url>					

					<!-- construct an "borrar" link with cliente id -->
					<c:url var="linkBorrar" value="/cliente/borrar">
						<c:param name="customerId" value="${tempCliente.id}" />
					</c:url>					
					
					<tr>
						<td> ${tempCliente.nombre} </td>
						<td> ${tempCliente.apellido} </td>
						<td> ${tempCliente.correo} </td>
						
						<td>
							<!-- display the update link -->
							<a href="${linkActualizar}">Actualizar</a>
							|
							<a href="${linkBorrar}"
							   onclick="if (!(confirm('Estas seguro de borrar al cliente?'))) return false">Borrar</a>
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>









