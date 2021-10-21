<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="Estilos css/Estilos5.css">
<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
	rel="stylesheet">
<script src="https://kit.fontawesome.com/aba19095ef.js"></script>
<title>Validación Usuario</title>
</head>
<body>
	<div class="container">
		<header>
			<h1 class="logo">
				<botton>
				<i class="fas fa-home"></i></botton>
				Tienda Generica
			</h1>
		</header>

		<div>
			<h2 class="hero_header">
				<b>Gestión de Usuarios Tienda Generica</b>
			</h2>
			<br />
		</div>
		<section class="hero">


			<%
        	String mensaje = (String)request.getAttribute("mensaje");
        if (mensaje != null){
        %>
			<p><%= mensaje %></p>
			<%} %>

			<form action="ServletLogin" method="get" id="form">
				<div class="form">
					<h1>Registro</h1>
					<div class="grupo">
						<input type="text" name="usuario" id="name" required><span
							class="barra"></span> <label for="">Usuario:</label>
					</div>

					<div class="grupo">
						<input type="password" name="password" id="name" required><span
							class="barra"></span> <label for="">Contraseña:</label>

					</div>

					<button name="Aceptar" class="acciones">Aceptar</button>
					<button type="reset" name="Cancelar" class="acciones">Cancelar</button>
				</div>

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