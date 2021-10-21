package com.ubosque.GenericShop07.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ubosque.GenericShop07.Controlador.Conexion;
import com.ubosque.GenericShop07.modelo.Cliente;

public class ClienteDAO implements ICliente{

	@Override
	public boolean agregarCliente(Cliente c) {
		Conexion con = new Conexion();
		
		try {
			String sql = "INSERT INTO clientes (cedula_cliente, email_cliente, nombre_cliente, direccion_cliente, telefono_cliente) VALUES (?,?,?,?,?)";
			PreparedStatement ps =  con.getConexion().prepareStatement(sql);
			ps.setInt(1, c.getCedula_cliente());
			ps.setString(2, c.getEmail_cliente());
			ps.setString(3, c.getNombre_cliente());
			ps.setString(4, c.getDireccion_cliente());
			ps.setString(5, c.getTelefono_cliente());
			ps.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean eliminarCliente(int cedula_cliente) {
		String sql = "DELETE FROM clientes WHERE cedula_cliente = ?;";
		try {
			Conexion con =new Conexion();
			PreparedStatement ps = con.getConexion().prepareStatement(sql);
			ps.setInt(1, cedula_cliente);
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
	public boolean actualizarCliente(int cedula_cliente, Cliente c) {
		String sql = "UPDATE clientes SET email_cliente = ?, nombre_cliente = ?, telefono_cliente = ?, direccion_cliente = ? WHERE cedula_cliente= ?;";			
		try {
			Conexion con =new Conexion();
			PreparedStatement ps = con.getConexion().prepareStatement(sql);
			ps.setString(1, c.getEmail_cliente());
			ps.setString(2, c.getNombre_cliente());
			ps.setString(3, c.getTelefono_cliente());
			ps.setString(4, c.getDireccion_cliente());
			ps.setInt(5, c.getCedula_cliente());
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
	public Cliente listarCliente(int cedula_cliente) {
Conexion con = new Conexion();
		
		try {
			Statement stm =  con.getConexion().createStatement();
			String sql = "SELECT * FROM clientes U WHERE U.cedula_cliente ='"+cedula_cliente+"'";					
			ResultSet rs =stm.executeQuery(sql);
			if(rs.next()) {
				return (new Cliente(rs.getInt("cedula_cliente"),rs.getString("direccion_cliente"),rs.getString( "email_cliente"),rs.getString( "nombre_cliente"), rs.getString("telefono_cliente")));
			}		
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}	
		
		return null;
	}

	@Override
	public ArrayList<Cliente> selectAll() {
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		String sql = "SELECT * FROM clientes;";
		
		try {
			Conexion con = new Conexion();
			PreparedStatement ps = con.getConexion().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			Cliente tablaClientes;
			while (rs.next()) {
				tablaClientes = new Cliente(rs.getInt("cedula_cliente"),rs.getString("direccion_cliente"), rs.getString("email_cliente"), rs.getString("nombre_cliente"), rs.getString("telefono_cliente"));
				lista.add(tablaClientes);
			}
			
			if (lista.size()< 0) {
				System.out.println("No hay ningun registro");
			}
			con.desconectar();			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		System.out.println(lista);
		return lista;
	}

}
