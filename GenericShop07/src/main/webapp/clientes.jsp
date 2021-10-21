<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="com.ubosque.GenericShop07.modelo.Cliente"%>
<%@ page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="Estilos css/Estilos9.css">
<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
	rel="stylesheet">
<script src="https://kit.fontawesome.com/aba19095ef.js"></script>
<title>Clientes</title>
</head>
<body>
	<%
	Cliente p = (Cliente)request.getAttribute("objCliente");
	%>
	<div class="container">
		<header>
			<nav class="menu">
				<div class="espacio">
					<ul>
						<li><botton>
							<i class="fas fa-home"></i>
							<a href="principal.jsp"> Tienda generica</a></botton></li>
						<li><botton>
							<i class="fas fa-user"></i>
							<a href=ServletUsuarios> Usuarios</a></botton></li>
						<li><botton>
							<i class="fas fa-users"></i>
							<a href=ServletClientes> Clientes</a></botton></li>
						<li><botton>
							<i class="fas fa-people-arrows"></i>
							<a href=ServletProveedores> Proveedores</a></botton></li>
						<li><botton>
							<i class="fas fa-gifts"></i>
							<a href="productos.jsp"> Productos</a></botton></li>
						<li><botton>
							<i class="fab fa-sellsy"></i>
							<a href="ventas.jsp"> Ventas</a></botton></li>
						<li><botton>
							<i class="far fa-file"></i>
							<a href="reportes.jsp"> Reportes</a></botton></li>
						<li><botton>
							<i class="fas fa-times"></i>
							<a href="index.jsp"> Salir</a></botton></li>
					</ul>
				</div>
			</nav>
		</header>
		<div class="tres">
			<h1 class="logo">
				<botton>
				<i class="fas fa-users"></i></botton>
				Gestion de Clientes</a>
			</h1>
		</div>

		<section class="hero">

			<form action="ServletClientes" method="get">
				<div class="">
					<%if(p != null){ %>
					<div class="grupo">
						<input required type="number" name="Cedula" id="Cedula"	class="cedula" value="<%=p.getCedula_cliente()%>"><span class="barra"></span> 
						<label for="">Cedula:</label> <br />
					</div>
					<div class="grupo"> 
						<input required type="number" name="Usuario" id="Usuario" class="Telefono" value="<%=p.getTelefono_cliente() %>"><span class="barra"></span>
						<label for="">Telefono:</label> <br />
					</div>

					<div class="grupo">
						<input type="text" name="Usuario" id="Usuario" class="Nombre"
							value="<%=p.getNombre_cliente() %>"><span class="barra"></span>
						<label for="">Nombre:</label> <br />
					</div>

					<div class="grupo">
						<input type="text" name="Correo" id="Correo" class="Correo"
							value="<%=p.getEmail_cliente() %>"><span class="barra"></span>
						<label>Correo:</label> <br />
					</div>

					<div class="grupo">
						<input type="text" name="Direccion" id="Direccion"
							class="Direccion" value="<%=p.getDireccion_cliente() %>"><span
							class="barra"></span> <label>Dirección:</label>
					</div>
					<%}else{%>
					<div class="grupo">

						<input required type="number" name="cedula" id="cedula"
							class="cedula"><span class="barra"></span> <label>Cedula:</label>
						<br />
					</div>

					<div class="grupo">
						<input type="text" placeholder="Escriba el Telefono"
							name="Telefono" id="Telefono" class="Telefono"><span
							class="barra"></span> <label>Telefono:</label> <br />
					</div>

					<div class="grupo">
						<input type="text" placeholder="Escriba el Nombre Completo"
							name="Nombre" id="Nombre" class="Nombre"><span
							class="barra"></span> <label>Nombre:</label> <br />
					</div>

					<div class="grupo">
						<input type="text" placeholder="Escriba el Correo" name="Correo"
							id="Correo" class="Correo"><span class="barra"></span> <label>Correo:</label>
						<br />
					</div>

					<div class="grupo">
						<input type="text" placeholder="Escriba la Dirección"
							name="Direccion" id="Direccion" class="Direccion"><span
							class="barra"></span> <label>Dirección:</label>
					</div>
					<%}%>
					<br />

					<button type="submit" name="accion" value="Consultar"
						class="acciones">Consultar</button>
					<button type="submit" name="accion" value="Crear" class="acciones">Crear</button>
					<button type="submit" name="accion" value="Actualizar"
						class="acciones">Actualizar</button>
					<button type="submit" name="accion" value="Borrar" class="acciones">Borrar</button>
				</div>

			</form>

			<div class="forma">

				<table class="tablaU">
					<caption>Clientes</caption>
					<thead>
						<tr>
							<th scope="col">Cedula</th>
							<th scope="col">Telefono</th>
							<th scope="col">Nombre</th>
							<th scope="col">Correo</th>
							<th scope="col">Dirección</th>
						</tr>
					</thead>
					<tbody>
						<% ArrayList<Cliente> lista = new ArrayList<Cliente>(); 
		            lista = (ArrayList<Cliente>) request.getAttribute("lista");
		            if (lista.size() > 0){
		            	for (Cliente persona:lista){					
					%>
						<tr>
							<td><%=persona.getCedula_cliente() %></td>
							<td><%=persona.getTelefono_cliente() %></td>
							<td><%=persona.getNombre_cliente() %></td>
							<td><%=persona.getEmail_cliente() %></td>
							<td><%=persona.getDireccion_cliente() %></td>
						</tr>
						<%	}
		            }%>
					</tbody>
				</table>

			</div>
		</section>
		<div class="wave" style="height: 150px; overflow: hidden;">
			<svg viewBox="0 0 500 150" preserveAspectRatio="none"
				style="height: 100%; width: 100%;">
				<path
					d="M0.00,49.98 C149.99,150.00 349.20,-49.98 500.00,49.98 L500.00,150.00 L0.00,150.00 Z"
					style="stroke: none; fill: #52bad5;"></path></svg>
		</div>


	</div>
</body>
</html>