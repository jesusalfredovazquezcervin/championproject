package com.koomoni.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProveedoresDTO implements Serializable {

	private static final long serialVersionUID = 8236747314338814096L;
	private List<ProveedorDTO> proveedores;
	private Integer rowcount;
	private Integer currPage;
	private Integer totalPages;
	private Integer rowsPerPage;
	
	public ProveedoresDTO() {
		proveedores = new ArrayList<ProveedorDTO>();
	}
	
	public void addProveedor(ProveedorDTO p) {
		this.proveedores.add(p);
	}
	
	public List<ProveedorDTO> getProveedores() {
		return proveedores;
	}

	public void setProveedores(List<ProveedorDTO> proveedores) {
		this.proveedores = proveedores;
	}

	public Integer getRowcount() {
		return rowcount;
	}

	public void setRowcount(Integer rowcount) {
		this.rowcount = rowcount;
	}

	public Integer getCurrPage() {
		return currPage;
	}

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	public Integer getRowsPerPage() {
		return rowsPerPage;
	}

	public void setRowsPerPage(Integer rowsPerPage) {
		this.rowsPerPage = rowsPerPage;
	}
}
