package com.ubosque.GenericShop07.DAO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.csvreader.CsvReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ubosque.GenericShop07.Controlador.Conexion;
import com.ubosque.GenericShop07.modelo.Producto;



public class ProductosDAO {
	
	public List<Producto> imporarCSV(String archivo){
		List<Producto> producto = new ArrayList<Producto>();
		
		try {
			CsvReader leerProductos = new CsvReader(archivo);
			leerProductos.readHeaders();
			
			while(leerProductos.readRecord()) {
				Integer codigo_producto = Integer.parseInt(leerProductos.get(0));
				double ivacompra = Double.valueOf(leerProductos.get(1));
				Integer nitproveedor = Integer.parseInt(leerProductos.get(2));
				String nombre_producto = leerProductos.get(3);
				double precio_compra = Double.valueOf(leerProductos.get(4));
				double precio_venta = Double.valueOf(leerProductos.get(5));
				
				producto.add(new Producto(codigo_producto,ivacompra,nitproveedor,nombre_producto,precio_compra,precio_venta));
				
			}
			
			leerProductos.close();
			
			System.out.println("LISTA DE PRODUCTOS DEL CVS\n");
			for(Producto p : producto) {
				System.out.println(
						p.getCodigo_producto()+","+
						p.getIvacompra()+","+
						p.getNitproveedor()+","+
						p.getNombre_producto()+","+
						p.getPrecio_compra()+","+
						p.getPrecio_venta()
						);
			}
					
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return producto;
	}
	
	public void insertarMySQL(List<Producto> productos) {
        System.out.println("\nSE VAN A INSERTAR: "+productos.size()+" REGISTROS\n");
        
        Conexion con =new Conexion();           
        String sql = "INSERT INTO productos(codigo_producto, ivacompra, nitproveedor, nombre_producto, precio_compra, precio_venta) VALUES(?,?,?,?,?,?)";
                       
        try {
        	PreparedStatement ps = con.getConexion().prepareStatement(sql);
            
            for(int i = 0 ; i < productos.size() ; i++) {
                ps.setInt(1, productos.get(i).getCodigo_producto());
                ps.setFloat(2, (float) productos.get(i).getIvacompra());
                ps.setInt(3, productos.get(i).getNitproveedor());
                ps.setString(4, productos.get(i).getNombre_producto());
                ps.setFloat(5, (float) productos.get(i).getPrecio_compra());
                ps.setFloat(6, (float) productos.get(i).getPrecio_venta());
                
                ps.executeUpdate();
                
                System.out.println("Se inserto el elemento: "+(i+1)+"/"+productos.size());
            }
            
            ps.close();
            con.desconectar();
            
        } catch(SQLException e) {
        	e.printStackTrace();
        }
    }
	
	public ArrayList<Producto> selectAll() {
		ArrayList<Producto> lista = new ArrayList<Producto>();
		String sql = "SELECT * FROM productos;";
		
		try {
			Conexion con = new Conexion();
			PreparedStatement ps = con.getConexion().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			Producto tablaProductos;
			while (rs.next()) {
				tablaProductos = new Producto(rs.getInt("codigo_producto"),rs.getDouble("ivacompra"), rs.getInt("nitproveedor"), rs.getString("nombre_producto"), rs.getDouble("precio_compra"), rs.getDouble("precio_venta"));
				lista.add(tablaProductos);
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
	
	public String consultarProducto(Integer codigo_producto) {
		Conexion con = new Conexion();
		
		try {
			Statement stm =  con.getConexion().createStatement();
			String sql = "SELECT * FROM productos U WHERE U.codigo_producto ='"+codigo_producto+"'";					
			ResultSet rs =stm.executeQuery(sql);
			if(rs.next()) {
				return (rs.getString("nombre_producto"));
			}		
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}	
		
		return "";
	}
	
	public Double consultarValor(Integer codigo_producto) {
		Conexion con = new Conexion();
		
		try {
			Statement stm =  con.getConexion().createStatement();
			String sql = "SELECT * FROM productos U WHERE U.codigo_producto ='"+codigo_producto+"'";					
			ResultSet rs =stm.executeQuery(sql);
			if(rs.next()) {
				return (rs.getDouble("precio_venta"));
			}		
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}	
		
		return null;
	}
	
	public Double consultarIva(Integer codigo_producto) {
		Conexion con = new Conexion();
		
		try {
			Statement stm =  con.getConexion().createStatement();
			String sql = "SELECT * FROM productos U WHERE U.codigo_producto ='"+codigo_producto+"'";					
			ResultSet rs =stm.executeQuery(sql);
			if(rs.next()) {
				return (rs.getDouble("ivacompra"));
			}		
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}	
		
		return null;
	}
}
