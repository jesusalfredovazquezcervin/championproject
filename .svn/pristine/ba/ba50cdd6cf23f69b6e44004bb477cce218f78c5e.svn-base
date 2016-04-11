package com.koomoni.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AlmacenesDTO implements Serializable {

	private static final long serialVersionUID = -5123047828896810094L;
	private List<AlmacenDTO> almacenes;
	private Integer rowcount;
	private Integer currPage;
	private Integer totalPages;
	private Integer rowsPerPage;

	public AlmacenesDTO() {
		this.almacenes = new ArrayList<AlmacenDTO>();
	}
	
	public void addAlmacen(AlmacenDTO a) {
		this.almacenes.add(a);
	}
	
	public List<AlmacenDTO> getAlmacenes() {
		return almacenes;
	}

	public void setAlmacenes(List<AlmacenDTO> almacenes) {
		this.almacenes = almacenes;
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
