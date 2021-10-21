package com.ubosque.GenericShop07.DAO;

import java.util.ArrayList;

import com.ubosque.GenericShop07.modelo.Proveedor;


public interface IProveedor {
	public boolean agregarProveedor(Proveedor p);
	public boolean eliminarProveedor(int cedula_usuario);
	public boolean actualizarProveedor(int nitproveedor, Proveedor p);
	public Proveedor listarProveedor(int nitproveedor);	
	public ArrayList<Proveedor> selectAll();


}
