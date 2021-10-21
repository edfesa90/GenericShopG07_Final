<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ page import="com.ubosque.GenericShop07.modelo.ReporteVentas"%>
<%@ page import="com.ubosque.GenericShop07.modelo.Cliente"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.text.DecimalFormat"%>
<%@ page import="java.text.NumberFormat"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="Estilos css/Estilos7.css">
<script src="https://kit.fontawesome.com/aba19095ef.js"></script>
<title>ReporteVentas</title>
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
		<div class="dos"><h1 class="logo"><botton><i class="fas fa-user"></i></botton>Reporte De Usuarios</h1></div>
	
	<section class="hero">	
	<div class ="forma">
		<table class="tablaU">
			<thead>
				<tr>
					<th scope="col">Cedula</th>
					<th scope="col">Nombre</th>
					<th scope="col">Valor Total Ventas</th>

				</tr>
			</thead>
			<tbody>
				<% ArrayList<ReporteVentas> lista = new ArrayList<ReporteVentas>(); 
	            lista = (ArrayList<ReporteVentas>) request.getAttribute("listaFinal");
	            Double total = 0.0;
	            DecimalFormat df = new DecimalFormat("###.##");
	            if (lista.size() > 0){
	            	for (ReporteVentas objeto:lista){					
				%>
				<tr>
					<td><%=objeto.getCedula_cliente() %></td>
					<td><%=objeto.getNombre_cliente() %></td>
					<td><%=df.format(objeto.getValor_venta()) %></td>
				</tr>
				<% total = total + objeto.getValor_venta();
	            }
	            }%>
			</tbody>
		</table>
		<table class="tercera">
			<tr>
				<td>Total Ventas:</td>
				<td><%=df.format(total) %></td>

			</tr>

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