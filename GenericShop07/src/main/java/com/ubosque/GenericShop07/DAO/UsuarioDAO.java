package com.ubosque.GenericShop07.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ubosque.GenericShop07.Controlador.Conexion;
import com.ubosque.GenericShop07.modelo.Usuario;



public class UsuarioDAO implements IUsuario {

	@Override
	public boolean agregarUsuario(Usuario u) {
		Conexion con = new Conexion();
				
		try {
			String sql = "INSERT INTO usuarios (cedula_usuario, email_usuario, nombre_usuario, password, usuario) VALUES (?,?,?,?,?)";
			PreparedStatement ps =  con.getConexion().prepareStatement(sql);
			ps.setInt(1, u.getCedula_usuario());
			ps.setString(2, u.getEmail_usuario());
			ps.setString(3, u.getNombre_usuario());
			ps.setString(4, u.getPassword());
			ps.setString(5, u.getUsuario());
			ps.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean eliminarUsuario(int cedula_usuario) {
		String sql = "DELETE FROM usuarios WHERE cedula_usuario = ?;";
		try {
			Conexion con =new Conexion();
			PreparedStatement ps = con.getConexion().prepareStatement(sql);
			ps.setInt(1, cedula_usuario);
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
	public boolean actualizarUsuario(int cedula_usuario, Usuario u) {
		String sql = "UPDATE usuarios SET email_usuario = ?, nombre_usuario = ?, password = ?, usuario = ? WHERE cedula_usuario= ?;";			
		try {
			Conexion con =new Conexion();
			PreparedStatement ps = con.getConexion().prepareStatement(sql);
			ps.setString(1, u.getEmail_usuario());
			ps.setString(2, u.getNombre_usuario());
			ps.setString(3, u.getPassword());
			ps.setString(4, u.getUsuario());
			ps.setInt(5, u.getCedula_usuario());
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
	public Usuario listarUsuario(int cedula_usuario) {
		Conexion con = new Conexion();
		
		try {
			Statement stm =  con.getConexion().createStatement();
			String sql = "SELECT * FROM usuarios U WHERE U.cedula_usuario ='"+cedula_usuario+"'";					
			ResultSet rs =stm.executeQuery(sql);
			if(rs.next()) {
				return (new Usuario(rs.getInt("cedula_usuario"),rs.getString("email_usuario"),rs.getString("nombre_usuario"),rs.getString("password"), rs.getString("usuario")));
			}		
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}	
		
		return null;
	}

	@Override
	public boolean validarUsuario(String usuario, String password) {
		Conexion con = new Conexion();
		try {
			Statement stm =  con.getConexion().createStatement();
			String sql = "SELECT * FROM usuarios U WHERE U.usuario ='"+usuario+"' and password = '"+password+"'";
					
			ResultSet rs =stm.executeQuery(sql);
			if(rs.next()) {
				return true;
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public ArrayList<Usuario> selectAll() {
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		String sql = "SELECT * FROM usuarios;";
		
		try {
			Conexion con = new Conexion();
			PreparedStatement ps = con.getConexion().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			Usuario tablaUsuarios;
			
			while (rs.next()) {
				tablaUsuarios = new Usuario(rs.getInt("cedula_usuario"),rs.getString("email_usuario"), rs.getString("nombre_usuario"), rs.getString("password"), rs.getString("usuario"));
				lista.add(tablaUsuarios);
			}
			
			if (lista.size()< 0) {
				System.out.println("No hay ningun registro");
			}
			con.desconectar();	
									
		}catch(SQLException e) {
			
		}
		//System.out.println("La lista tiene:  "+lista);
		return lista;
	}

}
