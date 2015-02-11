package com.jbay.model;

public class Bud {

	private int auktion;
	private String produktNamn;
	private String fornamn;
	private String efternamn;
	private double pris;
	private String kund;
	
	public Bud(int auktion, String produktNamn, String fornamn,
			String efternamn, double pris, String kund) {
		super();
		this.auktion = auktion;
		this.produktNamn = produktNamn;
		this.fornamn = fornamn;
		this.efternamn = efternamn;
		this.pris = pris;
		this.kund = kund;
	}

	public int getAuktion() {
		return auktion;
	}

	public void setAuktion(int auktion) {
		this.auktion = auktion;
	}

	public String getProduktNamn() {
		return produktNamn;
	}

	public void setProduktNamn(String produktNamn) {
		this.produktNamn = produktNamn;
	}

	public String getFornamn() {
		return fornamn;
	}

	public void setFornamn(String fornamn) {
		this.fornamn = fornamn;
	}

	public String getEfternamn() {
		return efternamn;
	}

	public void setEfternamn(String efternamn) {
		this.efternamn = efternamn;
	}

	public double getPris() {
		return pris;
	}

	public void setPris(double pris) {
		this.pris = pris;
	}

	public String getKund() {
		return kund;
	}

	public void setKund(String kund) {
		this.kund = kund;
	}

	@Override
	public String toString() {
		return "Bud [auktion=" + auktion + ", pris=" + pris + ", kund=" + kund
				+ "]";
	}
	
	
	
	
}
