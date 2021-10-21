<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="Estilos css/Estilos13.css">
<script src="https://kit.fontawesome.com/aba19095ef.js"></script>
<title>Reportes</title>
</head>
<body>
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
		
		<%
        	String mensaje = (String)request.getAttribute("mensaje");
        if (mensaje != null){
        %>
		<p align="center"><%= mensaje %></p>
		<%} %>
		<br />
		<form action="ServletReportes" method="get" target="_blank">
			<button name="accion" class="acciones" value="Usuarios">Listado
				de Usuarios</button>
			<br />
			<button name="accion" class="acciones" value="Clientes">Listado
				de Clientes</button>
			<br />
			<button name="accion" class="acciones" value="Productos">Listado
				de Productos</button>
			<br />
			<button name="accion" class="acciones" value="Ventas">Ventas
				por Cliente</button>
		</form>

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