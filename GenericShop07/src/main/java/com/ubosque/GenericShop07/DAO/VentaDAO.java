package com.ubosque.GenericShop07.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ubosque.GenericShop07.Controlador.Conexion;
import com.ubosque.GenericShop07.modelo.Venta;


public class VentaDAO {
	public ArrayList<Venta> datosReporte(){
		ArrayList<Venta> lista = new ArrayList<Venta>();
		String sql = "SELECT * FROM ventas;";
		
		try {
			Conexion con = new Conexion();
			PreparedStatement ps = con.getConexion().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			Venta tablaVentas;
			while (rs.next()) {
				tablaVentas = new Venta(rs.getInt("cedula_cliente"),rs.getDouble("valor_venta"));
				lista.add(tablaVentas);
			}
			
			if (lista.size()< 0) {
				System.out.println("No hay ningun registro");
			}
			con.desconectar();			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		List<Integer> cedulas = new ArrayList<>();
		for (Venta obtenerC:lista) {
			cedulas.add(obtenerC.getCedula_cliente());
		}
		Set<Integer> set = new HashSet<>(cedulas);
		cedulas.clear();
		cedulas.addAll(set);
		
		lista.clear();
		
		try {
			Conexion con = new Conexion();
			
			for (Integer i:cedulas) {
				Double valor = 0.0;
				PreparedStatement ps = con.getConexion().prepareStatement("SELECT valor_venta FROM ventas WHERE cedula_cliente = " + i);
				ResultSet rs = ps.executeQuery();
				Venta tablaVentas;
				while (rs.next()) {
					valor = valor + (rs.getDouble("valor_venta"));	
				}
				tablaVentas = new Venta(i, valor);
				lista.add(tablaVentas);
			}	
			
		}catch (Exception e) {
			
		}

		System.out.println(lista);
		return lista;
		
	}
	
	public ArrayList<Venta> selectAll(){
		ArrayList<Venta> lista = new ArrayList<Venta>();
		String sql = "SELECT * FROM ventas;";
		
		try {
			Conexion con = new Conexion();
			PreparedStatement ps = con.getConexion().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			Venta tablaVentas;
			while (rs.next()) {
				tablaVentas = new Venta(rs.getInt("codigo_venta"), rs.getInt("cedula_cliente"), rs.getInt("cedula_usuario"), rs.getDouble("ivaventa"), rs.getDouble("total_venta") ,rs.getDouble("valor_venta"));
				lista.add(tablaVentas);
			}
			
			if (lista.size()< 0) {
				System.out.println("No hay ningun registro");
			}
			con.desconectar();			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return lista;
		
	}
	
	public boolean registrarVenta(Venta venta) {
		Conexion con = new Conexion();
				
		try {
			String sql = "INSERT INTO ventas (codigo_venta, cedula_cliente, cedula_usuario, ivaventa, total_venta, valor_venta) VALUES (?,?,?,?,?,?)";
			PreparedStatement ps =  con.getConexion().prepareStatement(sql);
			ps.setInt(1, venta.getCodigo_venta());
			ps.setInt(2, venta.getCedula_cliente());
			ps.setInt(3, venta.getCedula_usuario());
			ps.setDouble(4, venta.getIvaventa());
			ps.setDouble(5, venta.getTotal_venta());
			ps.setDouble(6, venta.getValor_venta());
			ps.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	
}
