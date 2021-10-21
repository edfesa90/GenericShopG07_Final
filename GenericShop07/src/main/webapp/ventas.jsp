<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="Estilos css/Estilos3.css">
<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
	rel="stylesheet">
<script src="https://kit.fontawesome.com/aba19095ef.js"></script>

<title>Ventas</title>
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
	<div class="dos"><h1 class="logo"><botton><i class="fab fa-sellsy"></i></botton>Gestion de Ventas</h1></div>


		<section class="hero">
		
		<form action="pruebaServlet" method="get" class="">
			<div class="forma">
					<div>
					<div class="uno">
						<label>Cedula:</label> <input type="text"
						placeholder="Escriba la Cedula" name="Cedula" id="Cedula"
						class="Cedula">
						<button name="Consultar" class="acciones">Consultar</button>
						</div>
					<div>
					<label>Cliente:</label>
					<input type="text" name="Cliente" id="Cliente"
						class="Cliente">
					<label>Consec.</label>
					<input type="text" name="Consecutivo" id="Consecutivo"
						class="Consecutivo">
				
					</div>
					</div>
			<table class="tablaU">
			
			<thead>
				<tr>
					<th><label class="edit">Codigo Producto</label></th>
					<th><label class="edit">Nombre Producto</label></th>
					<th class="mas"><label class="Canti">Cant</label></th>
					<th><label class="edit">Valor Total</label></th>
				</tr>
				</thead>
				<tr>
					<td><input type="text" placeholder="Escriba codigo"
						name="Cedula" id="Cedula" class="Cedula">
						<button name="Consultar" class="acciones">Consultar</button></td>
					<td><input type="text" name="Nombre prod" id="Producto"
						class="Producto"></td>
					<td class="mas"><input type="text" name="Cant" id="Cant"
						class="Cant"></td>
					<td><input type="text" name="Valor" id="Valor" class="Valor"></td>
				</tr>

				<tr>
					<td><input type="text" placeholder="Escriba codigo"
						name="Cedula" id="Cedula" class="Cedula">
						<button name="Consultar" class="acciones">Consultar</button></td>
					<td><input type="text" name="Nombre prod" id="Producto"
						class="Producto"></td>
					<td class="mas"><input type="text" name="Cant" id="Cant"
						class="Cant"></td>
					<td><input type="text" name="Valor" id="Valor" class="Valor"></td>
				</tr>

				<tr>
					<td><input type="text" placeholder="Escriba codigo"
						name="Cedula" id="Cedula" class="Cedula">
						<button name="Consultar" class="acciones">Consultar</button></td>
					<td><input type="text" name="Nombre prod" id="Producto"
						class="Producto"></td>
					<td class="mas"><input type="text" name="Cant" id="Cant"
						class="Cant"></td>
					<td><input type="text" name="Valor" id="Valor" class="Valor"></td>
				</tr>
			</table>


			<table class="tablaU">
				
				<tr>
					<th class="tablaE"><label>Total Venta:</label></th>
					<td><input type="text" name="Venta" id="Venta" class="Venta"></td>

				</tr>
				<tr>
					<th class="tablaE"><label>Total IVA:</label></th>
					<td><input type="text" name="IVA" id="IVA" class="IVA"></td>
				</tr>
				<tr>
					<th class="tablaE"><label>Total con IVA:</label></th>
					<td><input type="text" name="Total" id="Total" class="Total"></td>

				</tr>
				<tr>
					<td colspan="2" class="tablaE"><button name="Confirmar" class="acciones">Confirmar</button></td>
				</tr>
			</table>

			
		</div>
		</form>

		</section>
	<div class="wave" style="height: 150px; /*overflow: hidden;*/">
			<svg viewBox="0 0 500 150" preserveAspectRatio="none"
				style="height: 100%; width: 100%;">
				<path
					d="M0.00,49.98 C149.99,150.00 349.20,-49.98 500.00,49.98 L500.00,150.00 L0.00,150.00 Z"
					style="stroke: none; fill: #52bad5;"></path></svg>
	</div>

</div>
</body>
</html>