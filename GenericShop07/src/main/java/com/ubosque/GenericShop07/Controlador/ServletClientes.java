package com.ubosque.GenericShop07.Controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ubosque.GenericShop07.DAO.ClienteDAO;
import com.ubosque.GenericShop07.modelo.Cliente;


@WebServlet("/ServletClientes")
public class ServletClientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ServletClientes() {
        super();       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		ClienteDAO cd = new ClienteDAO();
		String accion = (String) request.getParameter("accion");
		ArrayList<Cliente> lista;
		
		if(accion != null) {
			
			Integer cedula_cliente = Integer.parseInt(request.getParameter("cedula"));
			String direccion_cliente = (String) request.getParameter("Direccion");
			String email_cliente = (String) request.getParameter("Correo");
			String nombre_cliente = (String) request.getParameter("Nombre");
			String telefono_cliente = (String) request.getParameter("Telefono");			
			Cliente cliente = new Cliente(cedula_cliente, direccion_cliente, email_cliente, nombre_cliente, telefono_cliente);
		
		switch(accion) {			
		
			case "Crear":
				cd.agregarCliente(cliente);
				break;
			case "Actualizar":
				cd.actualizarCliente(cedula_cliente, cliente);
				break;
				
			case "Borrar":
				cd.eliminarCliente(cedula_cliente);
				break;
		
			case "Consultar":
				
				Cliente a = cd.listarCliente(cedula_cliente);
				request.setAttribute("objCliente", a);
				break;				
		}						
		
		}
		
		lista = cd.selectAll();
		request.setAttribute("lista", lista);
		
		request.getRequestDispatcher("clientes.jsp").forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doGet(request, response);
		
	}

}
