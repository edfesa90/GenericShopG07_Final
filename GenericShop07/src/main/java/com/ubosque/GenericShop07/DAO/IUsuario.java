package com.ubosque.GenericShop07.DAO;

import java.util.ArrayList;

import com.ubosque.GenericShop07.modelo.Usuario;


public interface IUsuario {
	public boolean agregarUsuario(Usuario u);
	public boolean eliminarUsuario(int cedula_usuario);
	public boolean actualizarUsuario(int cedula_usuario, Usuario u);
	public Usuario listarUsuario(int cedula_usuario);
	public boolean validarUsuario(String usuario, String password);
	public ArrayList<Usuario> selectAll();

}
