package com.ubosque.GenericShop07.Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ubosque.GenericShop07.DAO.ClienteDAO;
import com.ubosque.GenericShop07.DAO.ProductosDAO;
import com.ubosque.GenericShop07.modelo.Cliente;


@WebServlet("/ServletVentas")
public class ServletVentas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletVentas() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String Cedula = (request.getParameter("Cedula"));
		String NombreCliente = request.getParameter("Cliente");
		String Consecutivo = (request.getParameter("Consecutivo"));
		
		String CodigoProducto1 = (request.getParameter("CodigoProducto1"));
		String Producto1 = request.getParameter("Producto1");
		String Cant1 = (request.getParameter("Cant1"));
		String Valor1 = (request.getParameter("Valor1"));
		
		String CodigoProducto2 = (request.getParameter("CodigoProducto2"));
		String Producto2 = request.getParameter("Producto2");
		String Cant2 = (request.getParameter("Cant2"));
		String Valor2 = (request.getParameter("Valor2"));
		
		String CodigoProducto3 = (request.getParameter("CodigoProducto3"));
		String Producto3 = request.getParameter("Producto3");
		String Cant3 = (request.getParameter("Cant2"));
		String Valor3 = (request.getParameter("Valor3"));
		
		String Venta = (request.getParameter("Venta"));
		String IVA = (request.getParameter("IVA"));
		String Total = (request.getParameter("Total"));
		
		Double IVA1;
		Double IVA2;
		Double IVA3;
		
		
		String accion = request.getParameter("acciones");
		
		ProductosDAO ctrlP = new ProductosDAO();
		ClienteDAO ctrlC = new ClienteDAO();
		
		if (accion != null) {
			switch (accion) {
			case "ConsultarCliente":
				try {
				Cliente cliente = ctrlC.listarCliente(Integer.parseInt(Cedula));
				if (cliente != null) {
					NombreCliente = cliente.getNombre_cliente();
				}
				}catch(Exception e) {
					
				}
				break;
			
			case "ConsultarProducto1":
				try {
					Producto1 = ctrlP.consultarProducto(Integer.parseInt(CodigoProducto1));
				}catch(Exception e) {
					
				}
				break;
				
			case "ConsultarProducto2":
				try {
					Producto2 = ctrlP.consultarProducto(Integer.parseInt(CodigoProducto2));
				}catch(Exception e) {
					
				}
				break;
				
			case "ConsultarProducto3":
				try {
					Producto3 = ctrlP.consultarProducto(Integer.parseInt(CodigoProducto3));
				}catch(Exception e) {
					
				}
				break;
				
			case "CalcularValores":
				try {
					Valor1 = String.valueOf(ctrlP.consultarValor(Integer.parseInt(CodigoProducto1)) * Integer.parseInt(Cant1));
					Valor2 = String.valueOf(ctrlP.consultarValor(Integer.parseInt(CodigoProducto2)) * Integer.parseInt(Cant2));
					Valor3 = String.valueOf(ctrlP.consultarValor(Integer.parseInt(CodigoProducto3)) * Integer.parseInt(Cant3));
					IVA1 = (ctrlP.consultarIva(Integer.parseInt(CodigoProducto1)) * Integer.parseInt(Valor1))/100;
					IVA2 = (ctrlP.consultarIva(Integer.parseInt(CodigoProducto2)) * Integer.parseInt(Valor2))/100;
					IVA3 = (ctrlP.consultarIva(Integer.parseInt(CodigoProducto3)) * Integer.parseInt(Valor3))/100;
					Double ValorVenta = (ctrlP.consultarValor(Integer.parseInt(CodigoProducto1)) * Integer.parseInt(Cant1)) + (ctrlP.consultarValor(Integer.parseInt(CodigoProducto2)) * Integer.parseInt(Cant2)) + (ctrlP.consultarValor(Integer.parseInt(CodigoProducto3)) * Integer.parseInt(Cant3));
					Venta = String.valueOf(ValorVenta);
					Double ValorIva = IVA1+ IVA2 + IVA3;
					IVA = String.valueOf(ValorIva);
					Total = String.valueOf(ValorVenta + ValorIva);
					System.out.println(Venta);
					System.out.println(IVA);
					System.out.println(Total);
				}catch(Exception e) {
					
				}
				break;
			
			case "ConfirmarVenta":
				break;
			
			default:
				
			
			}
		}
		request.setAttribute("Cedula", Cedula);
		request.setAttribute("Cliente", NombreCliente);
		request.setAttribute("Consecutivo", Consecutivo);
		request.setAttribute("CodigoProducto1", CodigoProducto1);
		request.setAttribute("Producto1", Producto1);
		request.setAttribute("Cant1", Cant1);
		request.setAttribute("Valor1", Valor1);
		request.setAttribute("CodigoProducto2", CodigoProducto2);
		request.setAttribute("Producto2", Producto2);
		request.setAttribute("Cant2", Cant2);
		request.setAttribute("Valor2", Valor2);
		request.setAttribute("CodigoProducto3", CodigoProducto3);
		request.setAttribute("Producto3", Producto3);
		request.setAttribute("Cant3", Cant3);
		request.setAttribute("Valor3", Valor3);
		request.setAttribute("Venta", Venta);
		request.setAttribute("IVA", IVA);
		request.setAttribute("Total", Total);
		
		request.getRequestDispatcher("ventas.jsp").forward(request, response);
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
