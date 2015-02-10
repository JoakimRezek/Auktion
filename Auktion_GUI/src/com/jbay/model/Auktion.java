import java.sql.Date;


public class Auktion {
	
	private int auktionsID;
	private String produktNamn;
	private Date startDatum;
	private Date slutDatum;
	private double utg�ngsPris;
	private double maxBud;
	private double acceptPris;
	private String f�retag;
	private int provision;
	private String kontaktPerson;
	private String eMail;
	private String telefon;
	private String Kund;
	
	@Override
	public String toString() {
		return auktionsID + ". " + produktNamn;
	}

	public Auktion(int auktionsID, String produktNamn, Date startDatum,
			Date slutDatum, double utg�ngsPris, double maxBud,
			double acceptPris, String f�retag, int provision,
			String kontaktPerson, String eMail, String telefon, String kund) {
		super();
		this.auktionsID = auktionsID;
		this.produktNamn = produktNamn;
		this.startDatum = startDatum;
		this.slutDatum = slutDatum;
		this.utg�ngsPris = utg�ngsPris;
		this.maxBud = maxBud;
		this.acceptPris = acceptPris;
		this.f�retag = f�retag;
		this.provision = provision;
		this.kontaktPerson = kontaktPerson;
		this.eMail = eMail;
		this.telefon = telefon;
		Kund = kund;
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
	public double getUtg�ngsPris() {
		return utg�ngsPris;
	}
	public void setUtg�ngsPris(double utg�ngsPris) {
		this.utg�ngsPris = utg�ngsPris;
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
	public String getF�retag() {
		return f�retag;
	}
	public void setF�retag(String f�retag) {
		this.f�retag = f�retag;
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
		return Kund;
	}
	public void setKund(String kund) {
		Kund = kund;
	}
	
	

}
