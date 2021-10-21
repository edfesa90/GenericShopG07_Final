package com.ubosque.GenericShop07.Controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ubosque.GenericShop07.DAO.ProveedorDAO;
import com.ubosque.GenericShop07.modelo.Proveedor;



@WebServlet("/ServletProveedores")
public class ServletProveedores extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ServletProveedores() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		ProveedorDAO pd = new ProveedorDAO();
		String accion = (String) request.getParameter("accion");
		ArrayList<Proveedor> lista;
		
		if(accion != null) {
			
			Integer nitproveedor = Integer.parseInt(request.getParameter("nitproveedor")!= null? request.getParameter("nitproveedor"):"");
			String ciudad_proveedor = (String) request.getParameter("ciudad_proveedor")!= null? request.getParameter("ciudad_proveedor"):"";
			String direccion_proveedor = (String) request.getParameter("direccion_proveedor")!= null? request.getParameter("direccion_proveedor"):"";
			String nombre_proveedor = (String) request.getParameter("nombre_proveedor")!= null? request.getParameter("nombre_proveedor"):"";
			String telefono_proveedor = (String) request.getParameter("telefono_proveedor")!= null? request.getParameter("telefono_proveedor"):"";
			Proveedor nit = new Proveedor(nitproveedor, ciudad_proveedor, direccion_proveedor, nombre_proveedor, telefono_proveedor);

			switch(accion) {			
			
			case "Crear":
				pd.agregarProveedor(nit);
				break;
			case "Actualizar":
				pd.actualizarProveedor(nitproveedor, nit);
				break;
				
			case "Borrar":
				pd.eliminarProveedor(nitproveedor);
				break;
		
			case "Consultar":				
				Proveedor p = pd.listarProveedor(nitproveedor);
				request.setAttribute("objProveedor", p);
				break;				
		}	
			
		}
		
		lista = pd.selectAll();
		request.setAttribute("lista", lista);
		
		request.getRequestDispatcher("proveedores.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doGet(request, response);
	}

}
