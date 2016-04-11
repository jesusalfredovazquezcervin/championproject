package com.koomoni.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class OrdenCompraDTO implements Serializable{

	/**
	 * Las variables tienen nombres identicos al archivo MOD
	 */
	private static final long serialVersionUID = 2263565184284467888L;
	
	private String cveClpv;
	private String numAlma;
	private String cvePedi;
	private String esquema;
	private String desTot;
	private String desFin;
	private String cveVend;
	private String comTot;
	private String numMoned;
	private String tipCamb;
	private String strObs;
	private String entrega;
	private String suRefer;
	private String totInd;
	private String modulo;
	private String condicion;
	
	private List<PartidaDTO> partidas;

	public OrdenCompraDTO(){
		this.partidas = new ArrayList<PartidaDTO>();
	}
	
	public void addPartida(PartidaDTO p){
		this.partidas.add(p);
	}
	
	public String getCveClpv() {
		return cveClpv;
	}

	public void setCveClpv(String cveClpv) {
		this.cveClpv = cveClpv;
	}

	public String getNumAlma() {
		return numAlma;
	}

	public void setNumAlma(String numAlma) {
		this.numAlma = numAlma;
	}

	public String getCvePedi() {
		return cvePedi;
	}

	public void setCvePedi(String cvePedi) {
		this.cvePedi = cvePedi;
	}

	public String getEsquema() {
		return esquema;
	}

	public void setEsquema(String esquema) {
		this.esquema = esquema;
	}

	public String getDesTot() {
		return desTot;
	}

	public void setDesTot(String desTot) {
		this.desTot = desTot;
	}

	public String getDesFin() {
		return desFin;
	}

	public void setDesFin(String desFin) {
		this.desFin = desFin;
	}

	public String getCveVend() {
		return cveVend;
	}

	public void setCveVend(String cveVend) {
		this.cveVend = cveVend;
	}

	public String getComTot() {
		return comTot;
	}

	public void setComTot(String comTot) {
		this.comTot = comTot;
	}

	public String getNumMoned() {
		return numMoned;
	}

	public void setNumMoned(String numMoned) {
		this.numMoned = numMoned;
	}

	public String getTipCamb() {
		return tipCamb;
	}

	public void setTipCamb(String tipCamb) {
		this.tipCamb = tipCamb;
	}

	public String getStrObs() {
		return strObs;
	}

	public void setStrObs(String strObs) {
		this.strObs = strObs;
	}

	public String getEntrega() {
		return entrega;
	}

	public void setEntrega(String entrega) {
		this.entrega = entrega;
	}

	public String getSuRefer() {
		return suRefer;
	}

	public void setSuRefer(String suRefer) {
		this.suRefer = suRefer;
	}

	public String getTotInd() {
		return totInd;
	}

	public void setTotInd(String totInd) {
		this.totInd = totInd;
	}

	public String getModulo() {
		return modulo;
	}

	public void setModulo(String modulo) {
		this.modulo = modulo;
	}

	public String getCondicion() {
		return condicion;
	}

	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}

	public List<PartidaDTO> getPartidas() {
		return partidas;
	}

	public void setPartidas(List<PartidaDTO> partidas) {
		this.partidas = partidas;
	}
	
	
	
	
	
}
