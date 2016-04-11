package com.koomoni.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProductosDTO implements Serializable {

	private static final long serialVersionUID = 8749700784914940540L;
	private List<ProductoDTO> productos;
	private Integer rowcount;
	private Integer currPage;
	private Integer totalPages;
	private Integer rowsPerPage;
	
	public ProductosDTO() {
		productos = new ArrayList<ProductoDTO>();
	}
	
	public void addProducto(ProductoDTO p) {
		this.productos.add(p);
	}

	public List<ProductoDTO> getProductos() {
		return productos;
	}

	public void setProductos(List<ProductoDTO> productos) {
		this.productos = productos;
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
