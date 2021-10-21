package com.ubosque.GenericShop07.modelo;

public class Proveedor {
	
	private int nitProveedor;
	private String ciudad_proveedor, direccion_proveedor, nombre_proveeedor, telefono_proveedor;
	
	public Proveedor() {
		
	}

	public Proveedor(int nitProveedor, String ciudad_proveedor, String direccion_proveedor, String nombre_proveeedor,
			String telefono_proveedor) {
		this.nitProveedor = nitProveedor;
		this.ciudad_proveedor = ciudad_proveedor;
		this.direccion_proveedor = direccion_proveedor;
		this.nombre_proveeedor = nombre_proveeedor;
		this.telefono_proveedor = telefono_proveedor;
	}

	public Integer getNitProveedor() {
		return nitProveedor;
	}

	public void setNitProveedor(int nitProveedor) {
		this.nitProveedor = nitProveedor;
	}

	public String getCiudad_proveedor() {
		return ciudad_proveedor;
	}

	public void setCiudad_proveedor(String ciudad_proveedor) {
		this.ciudad_proveedor = ciudad_proveedor;
	}

	public String getDireccion_proveedor() {
		return direccion_proveedor;
	}

	public void setDireccion_proveedor(String direccion_proveedor) {
		this.direccion_proveedor = direccion_proveedor;
	}

	public String getNombre_proveeedor() {
		return nombre_proveeedor;
	}

	public void setNombre_proveeedor(String nombre_proveeedor) {
		this.nombre_proveeedor = nombre_proveeedor;
	}

	public String getTelefono_proveedor() {
		return telefono_proveedor;
	}

	public void setTelefono_proveedor(String telefono_proveedor) {
		this.telefono_proveedor = telefono_proveedor;
	}
	
	
	

}
