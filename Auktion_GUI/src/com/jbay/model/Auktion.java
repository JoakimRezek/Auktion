package com.jbay.model;

import java.sql.Date;

public class Auktion {
	private int auktionsId;
	private Date startDatum;
	private double utg�ngspris;
	private double acceptPris;
	private Date slutDatum;
	private String produktNamn;
	private String produktKategori;
	private String leverant�r;
	
	public Auktion(int auktionsId, Date startDatum, double utg�ngspris,
			double acceptPris, Date slutDatum, String produktNamn,
			String produktKategori, String leverant�r) {
		this.auktionsId = auktionsId;
		this.startDatum = startDatum;
		this.utg�ngspris = utg�ngspris;
		this.acceptPris = acceptPris;
		this.slutDatum = slutDatum;
		this.produktNamn = produktNamn;
		this.produktKategori = produktKategori;
		this.leverant�r = leverant�r;
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
	public double getUtg�ngspris() {
		return utg�ngspris;
	}
	public void setUtg�ngspris(double utg�ngspris) {
		this.utg�ngspris = utg�ngspris;
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
	public String getLeverant�r() {
		return leverant�r;
	}
	public void setLeverant�r(String leverant�r) {
		this.leverant�r = leverant�r;
	}

}
