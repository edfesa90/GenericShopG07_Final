package com.ubosque.GenericShop07.Controlador;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.ubosque.GenericShop07.DAO.ProductosDAO;
import com.ubosque.GenericShop07.modelo.Producto;




@WebServlet("/ServletProductos")
@MultipartConfig
public class ServletProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ServletProductos() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doGet(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		PrintWriter out = response.getWriter();
		out.println("Bienvenido");		
		String nomb = request.getParameter("nombre");
		Part arch = request.getPart("archivo");
		InputStream is = arch.getInputStream();
		File f = new File("/"+nomb);
		FileOutputStream ous = new FileOutputStream(f);
		int dato = is.read();
		ProductosDAO pd = new ProductosDAO();
		List<Producto> l = pd.imporarCSV(nomb);
		pd.insertarMySQL(l);
		
		while(dato != -1) {
			ous.write(dato);			
			dato = is.read();			
		}
		
		ous.close();
		is.close();
		
	}	

}
