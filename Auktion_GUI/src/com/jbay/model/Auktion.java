package com.jbay.model;

import java.sql.Date;

public class Auktion {
	private int auktionsId;
	private Date startDatum;
	private double utgångspris;
	private double acceptPris;
	private Date slutDatum;
	private String produktNamn;
	private String produktKategori;
	private String leverantör;
	
	public Auktion(int auktionsId, Date startDatum, double utgångspris,
			double acceptPris, Date slutDatum, String produktNamn,
			String produktKategori, String leverantör) {
		this.auktionsId = auktionsId;
		this.startDatum = startDatum;
		this.utgångspris = utgångspris;
		this.acceptPris = acceptPris;
		this.slutDatum = slutDatum;
		this.produktNamn = produktNamn;
		this.produktKategori = produktKategori;
		this.leverantör = leverantör;
	}
	
	
	
	@Override
	public String toString() {
		return auktionsId + ". " + produktNamn;
	}

	public int getAuktionsId() {
		return auktionsId;
	}
	public void setAuktionsId(int auktionsId) {
		this.auktionsId = auktionsId;
	}
	public Date getStartDatum() {
		return startDatum;
	}
	public void setStartDatum(Date startDatum) {
		this.startDatum = startDatum;
	}
	public double getUtgångspris() {
		return utgångspris;
	}
	public void setUtgångspris(double utgångspris) {
		this.utgångspris = utgångspris;
	}
	public double getAcceptPris() {
		return acceptPris;
	}
	public void setAcceptPris(double acceptPris) {
		this.acceptPris = acceptPris;
	}
	public Date getSlutDatum() {
		return slutDatum;
	}
	public void setSlutDatum(Date slutDatum) {
		this.slutDatum = slutDatum;
	}
	public String getProduktNamn() {
		return produktNamn;
	}
	public void setProduktNamn(String produktNamn) {
		this.produktNamn = produktNamn;
	}
	public String getProduktKategori() {
		return produktKategori;
	}
	public void setProduktKategori(String produktKategori) {
		this.produktKategori = produktKategori;
	}
	public String getLeverantör() {
		return leverantör;
	}
	public void setLeverantör(String leverantör) {
		this.leverantör = leverantör;
	}

}
