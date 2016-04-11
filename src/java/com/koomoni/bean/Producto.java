package com.koomoni.bean;

import java.io.Serializable;

public class Producto implements Serializable {

	private static final long serialVersionUID = -5721945289576581324L;
	private String clave;
	private String descripcion;
	private String lin_prod;
	private String con_serie;
	private String uni_med;
	private String ctrl_alm;
	private String cve_imagen;
	private String status;
	private String claveAlterna;

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

	public String getLin_prod() {
		return lin_prod;
	}

	public void setLin_prod(String lin_prod) {
		this.lin_prod = lin_prod;
	}

	public String getCon_serie() {
		return con_serie;
	}

	public void setCon_serie(String con_serie) {
		this.con_serie = con_serie;
	}

	public String getUni_med() {
		return uni_med;
	}

	public void setUni_med(String uni_med) {
		this.uni_med = uni_med;
	}

	public String getCtrl_alm() {
		return ctrl_alm;
	}

	public void setCtrl_alm(String ctrl_alm) {
		this.ctrl_alm = ctrl_alm;
	}

	public String getCve_imagen() {
		return cve_imagen;
	}

	public void setCve_imagen(String cve_imagen) {
		this.cve_imagen = cve_imagen;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getClaveAlterna() {
		return claveAlterna;
	}

	public void setClaveAlterna(String claveAlterna) {
		this.claveAlterna = claveAlterna;
	}
}
