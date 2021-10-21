package com.ubosque.GenericShop07.Controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ubosque.GenericShop07.DAO.UsuarioDAO;
import com.ubosque.GenericShop07.modelo.Usuario;

@WebServlet("/ServletUsuarios")
public class ServletUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ServletUsuarios() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		UsuarioDAO ud = new UsuarioDAO();
		String accion = (String) request.getParameter("accion");
		ArrayList<Usuario> lista;
		
		if(accion != null) {
			
		Integer Cedula = Integer.parseInt(request.getParameter("Cedula"));
		String Usuario = (String) request.getParameter("Usuario");
		String Nombre = (String) request.getParameter("Nombre");
		String password = (String) request.getParameter("password");
		String Correo = (String) request.getParameter("Correo");
		System.out.println(Cedula + Usuario + Nombre + password + Correo);
		Usuario persona = new Usuario(Cedula, Correo, Nombre, password, Usuario);
		
		switch(accion) {			
		
			case "Crear":
				ud.agregarUsuario(persona);
				break;
			case "Actualizar":
				ud.actualizarUsuario(Cedula, persona);
				break;
				
			case "Borrar":
				ud.eliminarUsuario(Cedula);
				break;
		
			case "Consultar":
				
				Usuario a = ud.listarUsuario(Cedula);
				request.setAttribute("objUsuario", a);
				break;				
		}						
		
		}
		
		lista = ud.selectAll();
		request.setAttribute("lista", lista);
		
		request.getRequestDispatcher("usuarios.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doGet(request, response);
	}

}
