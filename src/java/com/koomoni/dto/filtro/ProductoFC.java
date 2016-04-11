package com.koomoni.dto.filtro;

import java.io.Serializable;

public class ProductoFC implements Serializable {

	private static final long serialVersionUID = 7732167909189351703L;
	private String clave;
	private String descripcion;
	private String familia;
	private String claveAlterna;

	private Integer currPage = 0;

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFamilia() {
		return familia;
	}

	public void setFamilia(String familia) {
		this.familia = familia;
	}

	public Integer getCurrPage() {
		return currPage;
	}

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	public String getClaveAlterna() {
		return claveAlterna;
	}

	public void setClaveAlterna(String claveAlterna) {
		this.claveAlterna = claveAlterna;
	}
}
