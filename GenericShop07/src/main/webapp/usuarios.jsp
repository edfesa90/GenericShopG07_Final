<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="com.ubosque.GenericShop07.modelo.Usuario"%>
<%@ page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="Estilos css/Estilos8.css">
<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
	rel="stylesheet">
<script src="https://kit.fontawesome.com/aba19095ef.js"></script>
<title>Usuarios</title>
</head>
<body>
	<%
	Usuario p = (Usuario)request.getAttribute("objUsuario");
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
		<div class="dos"><h1 class="logo"><botton><i class="fas fa-user"></i></botton>Gestion de Usuarios</h1></div>


		<section class="hero">

			<form action="ServletUsuarios" method="get">
				<div class="">
					<%if(p != null){ %>

					<div class="grupo">
						<input required type="number" name="Cedula" id="Cedula"
							class="Cedula" value="<%= p.getCedula_usuario() %>"><span
							class="barra"></span> <label for="">Cedula:</label> <br />
					</div>
					<div class="grupo">
						<input required type="text" name="Usuario" id="Usuario" class="Usuario"
							value="<%= p.getUsuario() %>"><span class="barra"></span>
						<label for="">Usuario:</label> <br />
					</div>

					<div class="grupo">
						<input required type="text" name="Nombre" id="Nombre" class="Nombre"
							value="<%= p.getNombre_usuario() %>"><span class="barra"></span>
						<label>Nombre:</label>
					</div>

					<div class="grupo">
						<input type="password" name="password"
							id="password" class="password" value="<%= p.getPassword() %>"><span
							class="barra"></span>
							<label>Contraseña:</label>
					</div>

					<div class="grupo">
						<input type="text" name="Correo"
							id="Correo" class="Correo" value="<%= p.getEmail_usuario() %>"><span
							class="barra"></span> 
						<label>Correo:</label> 
					</div>
					<%}else{%>
					<div class="grupo">
						 <input required type="number" name="Cedula"
							id="Cedula" class="Cedula"><span class="barra"></span>
						<label>Cedula:</label>
					</div>
					<div class="grupo">
						<input type="text" name="Usuario"
							id="Usuario" class="Usuario"><span class="barra"></span>
						<label>Usuario:</label> 
					</div>
					<div class="grupo">
						 <input type="text" name="Nombre"
							id="Nombre" class="Nombre"><span class="barra"></span> 
						<label>Nombre:</label>
					</div>
					<div class="grupo">
						 <input type="password" name="password"
							id="password" class="password"><span class="barra"></span>
						<label>Contraseña:</label>
					</div>
					<div class="grupo">
						 <input type="text" name="Correo"
							id="Correo" class="Correo"><span class="barra"></span>
						<label>Correo:</label>
					</div>
					<%}%>
					
					<div class="centrar">
					<button type="submit" name="accion" value="Consultar"
						class="acciones">Consultar</button>
					<button type="submit" name="accion" value="Crear" class="acciones">Crear</button>
					</div>
					
					<div class="centrar">
					<button type="submit" name="accion" value="Actualizar"
						class="acciones">Actualizar</button>
					<button type="submit" name="accion" value="Borrar" class="acciones">Borrar</button>
					</div>				
				</div>
			</form>

			<%String user = (String)request.getAttribute("nombre"); %>
			<h3 class="user"><%= user %></h3>

			<div class="forma">

				<table class="tablaU">
					<caption>Usuarios</caption>
					<thead>
						<tr>
							<th scope="col">Cedula</th>
							<th scope="col">Usuario</th>
							<th scope="col">Nombre</th>
							<th scope="col">Email</th>
							<th scope="col">Password</th>
						</tr>
					</thead>
					<tbody>
						<% ArrayList<Usuario> lista = new ArrayList<Usuario>(); 
		            lista = (ArrayList<Usuario>) request.getAttribute("lista");
		            if (lista.size() > 0){
		            	for (Usuario usuario:lista){					
					%>
						<tr>
							<td><%=usuario.getCedula_usuario() %></td>
							<td><%=usuario.getUsuario() %></td>
							<td><%=usuario.getNombre_usuario() %></td>
							<td><%=usuario.getEmail_usuario() %></td>
							<td><%=usuario.getPassword() %></td>
						</tr>
						<%	}
		            }%>
					</tbody>
				</table>

			</div>
		</section>

		<section class="main"></section>
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