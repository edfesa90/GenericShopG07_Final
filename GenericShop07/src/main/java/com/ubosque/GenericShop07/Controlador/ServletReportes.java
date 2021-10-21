package com.ubosque.GenericShop07.Controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ubosque.GenericShop07.DAO.ClienteDAO;
import com.ubosque.GenericShop07.DAO.ProductosDAO;
import com.ubosque.GenericShop07.DAO.UsuarioDAO;
import com.ubosque.GenericShop07.DAO.VentaDAO;
import com.ubosque.GenericShop07.modelo.Cliente;
import com.ubosque.GenericShop07.modelo.Producto;
import com.ubosque.GenericShop07.modelo.ReporteVentas;
import com.ubosque.GenericShop07.modelo.Usuario;
import com.ubosque.GenericShop07.modelo.Venta;


@WebServlet("/ServletReportes")
public class ServletReportes extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletReportes() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		UsuarioDAO ctrl= new UsuarioDAO();
		ClienteDAO ctrlC = new ClienteDAO();
		VentaDAO ctrlV= new VentaDAO();
		ProductosDAO ctrlP = new ProductosDAO();
		String accion = (String) request.getParameter("accion");
		
		switch(accion) {			
		
		case "Usuarios":
			ArrayList<Usuario> listaUsuarios;
			listaUsuarios = ctrl.selectAll();
			if (listaUsuarios.size() > 0) {
				request.setAttribute("lista", listaUsuarios);
				request.getRequestDispatcher("ReporteUsuarios.jsp").forward(request, response);
			}else {
				request.setAttribute("mensaje", "No se encontraron datos para mostrar");
				request.getRequestDispatcher("reportes.jsp").forward(request, response);
			}
			
			break;
		
			
		case "Clientes":
			ArrayList<Cliente> listaClientes;
			listaClientes = ctrlC.selectAll();
			if (listaClientes.size() > 0) {
				request.setAttribute("lista", listaClientes);
				request.getRequestDispatcher("ReporteClientes.jsp").forward(request, response);
			}else {
				request.setAttribute("mensaje", "No se encontraron datos para mostrar");
				request.getRequestDispatcher("reportes.jsp").forward(request, response);
			}
			
			break;
		
			
		case "Ventas":
			ArrayList<Venta> listaVentas;
			listaVentas = ctrlV.datosReporte();
			if (listaVentas.size() > 0) {
				ArrayList<ReporteVentas> listaFinal = new ArrayList<ReporteVentas>();
				for(Venta vt:listaVentas) {
					String nombre = ctrlC.listarCliente(vt.getCedula_cliente()).getNombre_cliente();
					ReporteVentas r = new ReporteVentas(vt.getCedula_cliente(), nombre, vt.getValor_venta());
					listaFinal.add(r);
				}
		
				request.setAttribute("listaFinal", listaFinal);
				request.getRequestDispatcher("ReporteVentas.jsp").forward(request, response);
				
			}else {
				request.setAttribute("mensaje", "No se encontraron datos para mostrar");
				request.getRequestDispatcher("reportes.jsp").forward(request, response);
			}
			
			break;
		
		case "Productos":
			ArrayList<Producto> listaProductos;
			listaProductos = ctrlP.selectAll();
			if (listaProductos.size() > 0) {
				request.setAttribute("lista", listaProductos);
				request.getRequestDispatcher("ReporteProductos.jsp").forward(request, response);
			}else {
				request.setAttribute("mensaje", "No se encontraron datos para mostrar");
				request.getRequestDispatcher("reportes.jsp").forward(request, response);
			}
			
			break;
			
		default:
			request.getRequestDispatcher("reportes.jsp").forward(request, response);
		}
	}

		

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
