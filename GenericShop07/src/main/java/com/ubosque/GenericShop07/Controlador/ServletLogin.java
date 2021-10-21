package com.ubosque.GenericShop07.Controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ubosque.GenericShop07.DAO.UsuarioDAO;
import com.ubosque.GenericShop07.modelo.Usuario;




@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ServletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String nombre = request.getParameter("usuario");
		String password = request.getParameter("password");
		
		//PrintWriter out = response.getWriter();
		
		UsuarioDAO ud = new UsuarioDAO();		
		
		
		List<Usuario> lista = ud.selectAll();
		if(lista.size() > 0) {
			if(ud.validarUsuario(nombre, password)) {
				response.sendRedirect("principal.jsp");
			}else {
				request.setAttribute("mensaje", "Error nombre de usuario y/o clave");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			
		}else {
			String usuarioDefecto = "admininicial";
			String passwordDefecto = "admin123456";
			if (usuarioDefecto.equals(nombre) && passwordDefecto.equals(password)) {
				request.getRequestDispatcher("usuarioInicial.jsp").forward(request, response);;
			}else {
				request.setAttribute("mensaje", "Error nombre de usuario y/o clave POR DEFECTO");
				request.getRequestDispatcher("index.jsp").forward(request, response);
				
				//out.print("Usuario Inicial incorrecto");
				//response.sendRedirect("principal.jsp");
				}
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
