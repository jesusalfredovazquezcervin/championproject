package com.koomoni.dto.filtro;

import java.io.Serializable;

public class AlmacenesFC implements Serializable  {
	
	private static final long serialVersionUID = -7170342955568482613L;
	private Integer currPage = 0;
	private Integer cveAlm;
	private String descripcion;
	
	public Integer getCurrPage() {
		return currPage;
	}
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	public Integer getCveAlm() {
		return cveAlm;
	}
	public void setCveAlm(Integer cveAlm) {
		this.cveAlm = cveAlm;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
