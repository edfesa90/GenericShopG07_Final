package com.ubosque.GenericShop07;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ubosque.GenericShop07.DAO.ProductosDAO;
import com.ubosque.GenericShop07.modelo.Producto;



@SpringBootApplication
public class GenericShop07Application {

	public static void main(String[] args) {
		SpringApplication.run(GenericShop07Application.class, args);
		
		/*ProductosDAO pd = new ProductosDAO();
		
		List<Producto> productos = new ArrayList<Producto>();
        
        productos = pd.imporarCSV();
        
        pd.insertarMySQL(productos);*/
		
	}

}
