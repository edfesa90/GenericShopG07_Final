package com.ubosque.GenericShop07.DAO;

import java.util.ArrayList;

import com.ubosque.GenericShop07.modelo.Cliente;

public interface ICliente {
	public boolean agregarCliente(Cliente c);
	public boolean eliminarCliente(int cedula_cliente);
	public boolean actualizarCliente(int cedula_cliente, Cliente c);
	public Cliente listarCliente(int cedula_cliente);	
	public ArrayList<Cliente> selectAll();
}
