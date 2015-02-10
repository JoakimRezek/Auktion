package com.jbay.model;
import java.sql.Date;


public class Auktion {
	
	private int auktionsID;
	private String produktNamn;
	private Date startDatum;
	private Date slutDatum;
	private double utgangsPris;
	private double maxBud;
	private double acceptPris;
	private String foretag;
	private int provision;
	private String kontaktPerson;
	private String eMail;
	private String telefon;
	private String kund;
	private String kategori;
	
	public String getKategori() {
		return kategori;
	}

	public void setKategori(String kategori) {
		this.kategori = kategori;
	}

	@Override
	public String toString() {
		return auktionsID + ". " + produktNamn;
	}

	public Auktion(int auktionsID, String produktNamn, Date startDatum,
			Date slutDatum, double utgangsPris, double maxBud,
			double acceptPris, String foretag, int provision,
			String kontaktPerson, String eMail, String telefon, String kund, String kategori) {
		super();
		this.auktionsID = auktionsID;
		this.produktNamn = produktNamn;
		this.startDatum = startDatum;
		this.slutDatum = slutDatum;
		this.utgangsPris = utgangsPris;
		this.maxBud = maxBud;
		this.acceptPris = acceptPris;
		this.foretag = foretag;
		this.provision = provision;
		this.kontaktPerson = kontaktPerson;
		this.eMail = eMail;
		this.telefon = telefon;
		this.kund = kund;
		this.kategori = kategori;
	}

	public int getAuktionsID() {
		return auktionsID;
	}
	
	public void setAuktionsID(int auktionsID) {
		this.auktionsID = auktionsID;
	}
	public String getProduktNamn() {
		return produktNamn;
	}
	public void setProduktNamn(String produktNamn) {
		this.produktNamn = produktNamn;
	}
	public Date getStartDatum() {
		return startDatum;
	}
	public void setStartDatum(Date startDatum) {
		this.startDatum = startDatum;
	}
	public Date getSlutDatum() {
		return slutDatum;
	}
	public void setSlutDatum(Date slutDatum) {
		this.slutDatum = slutDatum;
	}
	public double getUtgangsPris() {
		return utgangsPris;
	}
	public void setUtgangsPris(double utgangsPris) {
		this.utgangsPris = utgangsPris;
	}
	public double getMaxBud() {
		return maxBud;
	}
	public void setMaxBud(double maxBud) {
		this.maxBud = maxBud;
	}
	public double getAcceptPris() {
		return acceptPris;
	}
	public void setAcceptPris(double acceptPris) {
		this.acceptPris = acceptPris;
	}
	public String getForetag() {
		return foretag;
	}
	public void setForetag(String foretag) {
		this.foretag = foretag;
	}
	public int getProvision() {
		return provision;
	}
	public void setProvision(int provision) {
		this.provision = provision;
	}
	public String getKontaktPerson() {
		return kontaktPerson;
	}
	public void setKontaktPerson(String kontaktPerson) {
		this.kontaktPerson = kontaktPerson;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public String getKund() {
		return kund;
	}
	public void setKund(String kund) {
		this.kund = kund;
	}
	
	

}
