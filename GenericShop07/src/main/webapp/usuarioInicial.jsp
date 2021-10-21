<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="Estilos css/Estilos6.css">
<title>Usuario Inicial</title>
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
		
			<form action="ServletUsuarioInicial" method="get">
				<div class="form">
					<h1>Creacion Usuario Nuevo</h1>
					<div class="grupo">
					<input type="text" name="cedula_usuario" id="Cedula" class="Cedula" required><span class="barra"></span> 
					<label>Cedula:</label>
					</div>
					<div class="grupo">
					 <input type="text"  name="usuario" id="Usuario" class="Usuario" required><span class="barra"></span>  <br /> 
					<label>Usuario:</label>
					</div>
					<div class="grupo">
					<input type="text" name="nombre_usuario" id="Nombre" class="Nombre" required><span class="barra"></span> 
					<label>Nombre:</label> <br /> 
					</div>
					<div class="grupo">
					<input type="text" name="password" id="Contraseña" class="Contraseña" required><span class="barra"></span> 
					<label>Contraseña:</label>
					</div>
					<div class="grupo">
					 <input type="text"  name="email_usuario" id="Correo" class="Correo" required><span class="barra"></span>
					 <label>Correo:</label>
					 </div>
					<!--<label class="espacio"> . </label>-->
	
					
	
	
					<button name="Crear" class="acciones">Crear</button>
	
	
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