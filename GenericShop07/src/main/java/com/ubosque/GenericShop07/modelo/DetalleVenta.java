package com.ubosque.GenericShop07.modelo;

public class DetalleVenta {
	private Integer codigo_detalle_ventas, cantidad_producto, codigo_producto, codigo_venta;
	private Double  valor_total, valor_venta, valoriva;
	
	
	public Integer getCodigo_detalle_ventas() {
		return codigo_detalle_ventas;
	}
	public void setCodigo_detalle_ventas(Integer codigo_detalle_ventas) {
		this.codigo_detalle_ventas = codigo_detalle_ventas;
	}
	public Integer getCantidad_producto() {
		return cantidad_producto;
	}
	public void setCantidad_producto(Integer cantidad_producto) {
		this.cantidad_producto = cantidad_producto;
	}
	public Integer getCodigo_producto() {
		return codigo_producto;
	}
	public void setCodigo_producto(Integer codigo_producto) {
		this.codigo_producto = codigo_producto;
	}
	public Integer getCodigo_venta() {
		return codigo_venta;
	}
	public void setCodigo_venta(Integer codigo_venta) {
		this.codigo_venta = codigo_venta;
	}
	public Double getValor_total() {
		return valor_total;
	}
	public void setValor_total(Double valor_total) {
		this.valor_total = valor_total;
	}
	public Double getValor_venta() {
		return valor_venta;
	}
	public void setValor_venta(Double valor_venta) {
		this.valor_venta = valor_venta;
	}
	public Double getValoriva() {
		return valoriva;
	}
	public void setValoriva(Double valoriva) {
		this.valoriva = valoriva;
	}
	
}