package com.koomoni.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ContactosDTO implements Serializable {
	
	private static final long serialVersionUID = 7367998536600307218L;
	private List<ContactoDTO> contacto;
	private Integer rowcount;
	private Integer currPage;
	private Integer totalPages;
	private Integer rowsPerPage;
	
	public ContactosDTO() {
		this.contacto = new ArrayList<ContactoDTO>();
	}
	
	public void addContacto(ContactoDTO c) {
		this.contacto.add(c);
	}
	
	public List<ContactoDTO> getContacto() {
		return contacto;
	}
	public void setContacto(List<ContactoDTO> contacto) {
		this.contacto = contacto;
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
