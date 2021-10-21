package com.ubosque.GenericShop07.Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	private Connection con = null;
	
	public Connection getConexion () {
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
						
			try {
				con =DriverManager.getConnection("jdbc:mariadb://tiendagenerica1.c47knbsonjdi.us-east-2.rds.amazonaws.com:3306/41tiendaGenerica07?user=admin&password=Vivian27%%");
				System.out.println("Conexion Exitosa");
				
			} catch (SQLException e) {
				System.out.println("Fallo Conexion");
				e.printStackTrace();
			}
						
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Sin Acceso al Driver");
		}
		
		return con;
		
		
	}
	
	public void desconectar () {
		
		try {
			con.close();
			//System.out.println("Base de Datos desconectada");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error al desconectar base de datos");
		}
	}

}

