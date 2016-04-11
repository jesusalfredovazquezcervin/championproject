package com.koomoni.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.koomoni.bean.Inventario;

public class InventarioDTO implements Serializable {

	private static final long serialVersionUID = -7605489914452223683L;
	private List<Inventario> inventario;
	private Integer rowcount;
	private Integer currPage;
	private Integer totalPages;
	private Integer rowsPerPage;
	
	public InventarioDTO() {
		this.inventario = new ArrayList<Inventario>();
	}
	
	public void addInventario(Inventario i) {
		this.inventario.add(i);
	}

	public List<Inventario> getInventario() {
		return inventario;
	}

	public void setInventario(List<Inventario> inventario) {
		this.inventario = inventario;
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
