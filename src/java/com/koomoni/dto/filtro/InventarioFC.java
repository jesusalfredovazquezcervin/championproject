package com.koomoni.dto.filtro;

import java.io.Serializable;

public class InventarioFC implements Serializable {

	private static final long serialVersionUID = -3672820838068389755L;
	private Integer currPage = 0;
	private String claveProducto;
	private String descripcion;
	private String claveAlmacen;
	private String claveAlterna;

	public Integer getCurrPage() {
		return currPage;
	}

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	public String getClaveProducto() {
		return claveProducto;
	}

	public void setClaveProducto(String claveProducto) {
		this.claveProducto = claveProducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getClaveAlmacen() {
		return claveAlmacen;
	}

	public void setClaveAlmacen(String claveAlmacen) {
		this.claveAlmacen = claveAlmacen;
	}

	public String getClaveAlterna() {
		return claveAlterna;
	}

	public void setClaveAlterna(String claveAlterna) {
		this.claveAlterna = claveAlterna;
	}
}
