package com.jbay.model;

public class Kund {
	
	private String personNummer;
	private String forNamn;
	private String efterNamn;
	private String adress;
	private String postNummer;
	private String ort;
	private String telefon;
	private String email;
	private double total;
	
	
	public Kund(String personNummer, String forNamn, String efterNamn,
			String adress, String postNummer, String ort, String telefon,
			String email, double total) {
		super();
		this.personNummer = personNummer;
		this.forNamn = forNamn;
		this.efterNamn = efterNamn;
		this.adress = adress;
		this.postNummer = postNummer;
		this.ort = ort;
		this.telefon = telefon;
		this.email = email;
		this.total = total;
	}
	
	
	
	public String getPersonNummer() {
		return personNummer;
	}
	public void setPersonNummer(String personNummer) {
		this.personNummer = personNummer;
	}
	public String getForNamn() {
		return forNamn;
	}
	public void setForNamn(String forNamn) {
		this.forNamn = forNamn;
	}
	public String getEfterNamn() {
		return efterNamn;
	}
	public void setEfterNamn(String efterNamn) {
		this.efterNamn = efterNamn;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getPostNummer() {
		return postNummer;
	}
	public void setPostNummer(String postNummer) {
		this.postNummer = postNummer;
	}
	public String getOrt() {
		return ort;
	}
	public void setOrt(String ort) {
		this.ort = ort;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}

}
