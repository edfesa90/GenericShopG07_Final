package com.ubosque.GenericShop07.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ubosque.GenericShop07.Controlador.Conexion;
import com.ubosque.GenericShop07.modelo.DetalleVenta;

public class DetalleVentaDAO {
	public boolean registrarVenta(DetalleVenta venta) {
		Conexion con = new Conexion();
				
		try {
			String sql = "INSERT INTO ventas (codigo_detalle_ventas, cantidad_producto, codigo_producto, codigo_venta, valor_total, valor_venta, valoriva) VALUES (?,?,?,?,?,?,?)";
			PreparedStatement ps =  con.getConexion().prepareStatement(sql);
			ps.setInt(1, venta.getCodigo_detalle_ventas());
			ps.setInt(2, venta.getCantidad_producto());
			ps.setInt(3, venta.getCodigo_producto());
			ps.setInt(4, venta.getCodigo_venta());
			ps.setDouble(5, venta.getValor_total());
			ps.setDouble(6, venta.getValor_venta());
			ps.setDouble(7, venta.getValoriva());
			ps.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
