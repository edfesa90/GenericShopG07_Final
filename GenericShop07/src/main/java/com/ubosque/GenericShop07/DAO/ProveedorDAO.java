package com.ubosque.GenericShop07.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ubosque.GenericShop07.Controlador.Conexion;
import com.ubosque.GenericShop07.modelo.Proveedor;

public class ProveedorDAO implements IProveedor  {

	@Override
	public boolean agregarProveedor(Proveedor p) {
		Conexion con = new Conexion();
		
		try {
			String sql = "INSERT INTO proveedores (nitproveedor, ciudad_proveedor, direccion_proveedor, nombre_proveedor, telefono_proveedor) VALUES (?,?,?,?,?)";
			PreparedStatement ps =  con.getConexion().prepareStatement(sql);
			ps.setInt(1, p.getNitProveedor());
			ps.setString(2, p.getCiudad_proveedor());
			ps.setString(3, p.getDireccion_proveedor());
			ps.setString(4, p.getNombre_proveeedor());
			ps.setString(5, p.getTelefono_proveedor());
			ps.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}		
		return false;		
	}

	@Override
	public boolean eliminarProveedor(int nitproveedor) {
		String sql = "DELETE FROM proveedores WHERE nitproveedor = ?;";
		try {
			Conexion con =new Conexion();
			PreparedStatement ps = con.getConexion().prepareStatement(sql);
			ps.setInt(1, nitproveedor);
			if (ps.executeUpdate()== 1) {
				System.out.println("Resgistro Eliminado");
				return true;
			}else {
				System.out.println("Resgistro NO se ha Eliminado");
			}
			con.desconectar();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;		
	}

	@Override
	public boolean actualizarProveedor(int nitproveedor, Proveedor p) {
		String sql = "UPDATE proveedores SET ciudad_proveedor = ?, direccion_proveedor = ?, nombre_proveedor = ?, telefono_proveedor = ? WHERE nitproveedor= ?;";			
		try {
			Conexion con =new Conexion();
			PreparedStatement ps = con.getConexion().prepareStatement(sql);
			ps.setString(1, p.getCiudad_proveedor());
			ps.setString(2, p.getDireccion_proveedor());
			ps.setString(3, p.getNombre_proveeedor());
			ps.setString(4, p.getTelefono_proveedor());
			ps.setInt(5, p.getNitProveedor());
			if(ps.executeUpdate() == 1){
				System.out.println("Usuario Actualizado");
				return true;
				
			}else {
				System.out.println("No se ha podido Actualizar");
			}
			con.desconectar();
						
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public Proveedor listarProveedor(int nitproveedor) {
		Conexion con = new Conexion();
		
		try {
			Statement stm =  con.getConexion().createStatement();
			String sql = "SELECT * FROM proveedores U WHERE U.nitproveedor ='"+nitproveedor+"'";					
			ResultSet rs =stm.executeQuery(sql);
			if(rs.next()) {
				return (new Proveedor(rs.getInt("nitproveedor"),rs.getString("ciudad_proveedor"),rs.getString("direccion_proveedor"),rs.getString("nombre_proveedor"), rs.getString("telefono_proveedor")));
			}		
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}	
		
		return null;
	}

	
	@Override
	public ArrayList<Proveedor> selectAll() {
		ArrayList<Proveedor> lista = new ArrayList<Proveedor>();
		String sql = "SELECT * FROM proveedores;";
		
		try {
			Conexion con = new Conexion();
			PreparedStatement ps = con.getConexion().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			Proveedor tablaProveedores;
			while (rs.next()) {
				tablaProveedores = new Proveedor(rs.getInt("nitproveedor"),rs.getString("ciudad_proveedor"), rs.getString("direccion_proveedor"), rs.getString("nombre_proveedor"), rs.getString("telefono_proveedor"));
				lista.add(tablaProveedores);
			}
			
			if (lista.size()< 0) {
				System.out.println("No hay ningun registro");
			}
			con.desconectar();			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		//System.out.println(lista);
		return lista;
	}

}
