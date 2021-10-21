<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@page import="com.ubosque.GenericShop07.modelo.Proveedor"%>
    <%@ page import= "java.util.ArrayList" %>
    
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="Estilos css/Estilos9.css">
	<link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap" rel="stylesheet">
	<title>Proveedores</title>
	<script src="https://kit.fontawesome.com/aba19095ef.js"></script>
</head>
<body>
	<%
	Proveedor p = (Proveedor)request.getAttribute("objProveedor");
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
			 <div class="dos"><h1 class="logo"><botton><i class="fas fa-people-arrows"></i></botton>Gestion de Proveedores</h1></div>
		
		<section class="hero">
        
        	<form action="./ServletProveedores" method="get">
            	<div class="">
            		<%if(p != null){ %>
            	
	            	<div class="grupo">        
	                <input required type="number" name="nitproveedor" id="NIT" class="NIT" value ="<%=p.getNitProveedor()%>"><span class="barra"></span>
	                <label>NIT:</label>
	                <br /> 
	                </div>
	                
	                <div class="grupo">
	                <input type="text" name="telefono_proveedor" id="Telefono" class="Telefono" value ="<%=p.getTelefono_proveedor()%>"><span class="barra"></span>
	                <label>Telefono:</label>
	                </div>
	                
	                <div class="grupo">
	                
	                <input type="text"  name="nombre_proveedor" id="Nombre" class="Nombre"value ="<%=p.getNombre_proveeedor()%>"><span class="barra"></span>
	                <label>Nombre:</label>
	                <br /> 
	                </div>
	                <div class="grupo"> 
	                <input type="text"  name="ciudad_proveedor" id="Ciudad" class="Ciudad"value ="<%=p.getCiudad_proveedor()%>"><span class="barra"></span>
	                <label>Ciudad:</label>
	                <br /> 
	                </div>
	                <div class="grupo">
	                <input type="text"  name="direccion_proveedor" id="Dirección" class="Dirección" value ="<%=p.getDireccion_proveedor()%>"><span class="barra"></span>
	                <label>Dirección:</label>
	                </div>
	                <%}else{%>
	                <div class="grupo">
	                <input required type="number"  name="nitproveedor" id="NIT" class="NIT"><span class="barra"></span>
	                <label>NIT:</label>
	                <br /> 
	                </div>
	                <div class="grupo">            
	                <input type="text"  name="telefono_proveedor" id="Telefono" class="Telefono"><span class="barra"></span>
	                <label>Telefono:</label>
	                <br />
	                </div>
	                <div class="grupo">
	                <input type="text" name="nombre_proveedor" id="Nombre" class="Nombre"><span class="barra"></span>
	                <label>Nombre:</label>
	                <br /> 
	                </div>
	                <div class="grupo">               
	                <input type="text"  name="ciudad_proveedor" id="Ciudad" class="Ciudad"><span class="barra"></span>
	                <label>Ciudad:</label>
	                <br />
	                </div> 
	                <div class="grupo"> 	                
	                <input type="text"  name="direccion_proveedor" id="Dirección" class="Dirección"><span class="barra"></span>
	                <label>Dirección:</label>
	                </div> 
	                
	                <%}%>
	                
                
	                <br />
	                <button type = "submit" name="accion" value="Consultar" class="acciones">Consultar</button>
	                <button type = "submit" name="accion" value="Crear" class="acciones">Crear</button>
	                <button type = "submit" name="accion" value="Actualizar" class="acciones">Actualizar</button>
	                <button type = "submit" name="accion" value="Borrar" class="acciones">Borrar</button>
            </div>
        </form>

        <div class="forma">
           
            <table class=tablaU>
            <caption> Proveedores</caption>
	            <thead>
	                <tr>
			                <th scope="col">NIT</th>
			                <th scope="col">Nombre</th>
			                <th scope="col">Ciudad</th>
			                <th scope="col">Telefono</th>
			                <th scope="col">Direccion</th>                    
	                </tr>
                </thead>
                <tbody>
		            <% ArrayList<Proveedor> lista = new ArrayList<Proveedor>(); 
		            lista = (ArrayList<Proveedor>) request.getAttribute("lista");
		            if (lista.size() > 0){
		            	for (Proveedor proveedor:lista){					
					%>
					<tr>
		               	<td><%=proveedor.getNitProveedor() %></td>
		               	<td><%=proveedor.getNombre_proveeedor() %></td>
		               	<td><%=proveedor.getCiudad_proveedor() %></td>
		               	<td><%=proveedor.getTelefono_proveedor() %></td>
		               	<td><%=proveedor.getDireccion_proveedor() %></td>
		            </tr>
		            <%	}
		            }%>
		        </tbody>
				</table>

        	</div>
    	</section>
    	<section class="main">
       	</section>
       	<div class="wave" style="height: 150px; overflow: hidden;" ><svg viewBox="0 0 500 150" preserveAspectRatio="none" style="height: 100%; width: 100%;"><path d="M0.00,49.98 C149.99,150.00 349.20,-49.98 500.00,49.98 L500.00,150.00 L0.00,150.00 Z" style="stroke: none; fill: #52bad5;"></path></svg></div>
       	
    </div>
</body>
</html>