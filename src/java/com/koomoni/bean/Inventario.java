package com.koomoni.bean;

import java.io.Serializable;

public class Inventario implements Serializable {

	private static final long serialVersionUID = 1562236245454353095L;
	private String claveProducto;
	private String descripcionProducto;
	private Integer claveAlmacen;
	private String descripcionAlmacen;
	private Integer existencia;
	private String claveAlterna;

	public String getClaveProducto() {
		return claveProducto;
	}

	public void setClaveProducto(String claveProducto) {
		this.claveProducto = claveProducto;
	}

	public String getDescripcionProducto() {
		return descripcionProducto;
	}

	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}

	public Integer getClaveAlmacen() {
		return claveAlmacen;
	}

	public void setClaveAlmacen(Integer claveAlmacen) {
		this.claveAlmacen = claveAlmacen;
	}

	public String getDescripcionAlmacen() {
		return descripcionAlmacen;
	}

	public void setDescripcionAlmacen(String descripcionAlmacen) {
		this.descripcionAlmacen = descripcionAlmacen;
	}

	public Integer getExistencia() {
		return existencia;
	}

	public void setExistencia(Integer existencia) {
		this.existencia = existencia;
	}

	public String getClaveAlterna() {
		return claveAlterna;
	}

	public void setClaveAlterna(String claveAlterna) {
		this.claveAlterna = claveAlterna;
	}
}
