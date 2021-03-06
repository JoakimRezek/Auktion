package com.jbay.controller;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JLabel;

import com.jbay.model.Auktion;
import com.jbay.model.Bud;
import com.jbay.model.Kund;
import com.jbay.model.Manad;



public class JDBC_Connection {

	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	private static final String CONNECTIONSTRING = "jdbc:mysql://localhost/auktion";

	private static JDBC_Connection singleton;

	private Connection conn;

	private JDBC_Connection() throws SQLException {
		conn = DriverManager.getConnection(CONNECTIONSTRING, USERNAME, PASSWORD);
		System.out.println("Connected to DB");
	}

	public static JDBC_Connection getSingleton() throws SQLException{
		if(singleton == null){
			singleton = new JDBC_Connection();			
		}
		return singleton;		
	}

	public ArrayList<String> getAllaKundIDs() throws SQLException{

		ArrayList<String> arrAllaKundIDs = new ArrayList<>();

		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery("SELECT PersonNummer FROM Kund");

		while(rs.next()){
			arrAllaKundIDs.add(rs.getString("Personnummer"));
		}

		stm.close();
		rs.close();
		return arrAllaKundIDs;			
	}

	public ArrayList<String> getAllaLeverantorIDs() throws SQLException{

		ArrayList<String> arrAllaLeverantorIDs = new ArrayList<>();

		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery("SELECT Organisationsnummer FROM Leverant\u00F6r");

		while(rs.next()){
			arrAllaLeverantorIDs.add(rs.getString("Organisationsnummer"));
		}

		stm.close();
		rs.close();
		return arrAllaLeverantorIDs;			
	}	

	public ArrayList<String> getAllaKategorier() throws SQLException{
		ArrayList<String> arrAllaKategorierNamn = new ArrayList<String>();


		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery("SELECT KategoriNamn FROM Kategori");

		while(rs.next()){
			arrAllaKategorierNamn.add(rs.getString("KategoriNamn"));
		}

		stm.close();
		rs.close();
		return arrAllaKategorierNamn;		
	}

	public ArrayList<Auktion> getAllaPagaendeAuktioner() throws SQLException{
		ArrayList<Auktion> arrAllaPagaendeAuktioner = new ArrayList<Auktion>();

		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery("SELECT * FROM p\u00E5g\u00E5endeauktioner WHERE (NOW() BETWEEN StartDatum AND SlutDatum ) and avslutad = '0'");

		while(rs.next()){
			arrAllaPagaendeAuktioner.add(new Auktion(rs.getInt("auktionsID"),
					rs.getString("produktNamn"),
					rs.getDate("startDatum"),
					rs.getDate("slutDatum"),
					rs.getDouble("utg\u00E5ngsPris"),
					rs.getDouble("maxBud"),
					rs.getDouble("acceptPris"),
					rs.getString("f\u00F6retagsnamn"),
					rs.getInt("provision"),
					rs.getString("kontaktperson"),
					rs.getString("email"),
					rs.getString("telefonnummer"),
					rs.getString("kund"), 
					rs.getString("kategori")));
		}

		rs.close();
		stm.close();
		return arrAllaPagaendeAuktioner;
	}

	public ArrayList<Auktion> getAllaPagaendeAuktionerSomKundIDBudatPa(String kundID) throws SQLException{
		ArrayList<Auktion> arrAllaPagaendeAuktionerSomKundIDBudatPa = new ArrayList<Auktion>();

		PreparedStatement stm = conn.prepareStatement("SELECT auktionsID, p\u00E5g\u00E5endeauktioner.produktnamn, startdatum,"
				+ " slutdatum, utg\u00E5ngsPris,"
				+ "maxBud, acceptPris, f\u00F6retagsnamn, provision, kontaktperson, email, telefonnummer, "
				+ "p\u00E5g\u00E5endeauktioner.kund,"
				+ "kategori FROM p\u00E5g\u00E5endeauktioner JOIN budhistorik ON p\u00E5g\u00E5endeauktioner.AuktionsID "
				+ "= auktion AND budhistorik.kund = ?");
		stm.setString(1, kundID);
		ResultSet rs = stm.executeQuery();

		while(rs.next()){
			arrAllaPagaendeAuktionerSomKundIDBudatPa.add(new Auktion(rs.getInt("auktionsID"),
					rs.getString("produktNamn"),
					rs.getDate("startDatum"),
					rs.getDate("slutDatum"),
					rs.getDouble("utg\u00E5ngsPris"),
					rs.getDouble("maxBud"),
					rs.getDouble("acceptPris"),
					rs.getString("f\u00F6retagsnamn"),
					rs.getInt("provision"),
					rs.getString("kontaktperson"),
					rs.getString("email"),
					rs.getString("telefonnummer"),
					rs.getString("kund"), 
					rs.getString("kategori")));
		}

		rs.close();
		stm.close();
		return arrAllaPagaendeAuktionerSomKundIDBudatPa;
	}

	public ArrayList<Auktion> getAllaPagaendeAuktionerSomLeverantorIDBudatPa(String leverantorID) throws SQLException{
		ArrayList<Auktion> arrAllaPagaendeAuktionerSomTillhorLeverantorID = new ArrayList<Auktion>();


		PreparedStatement stm = conn.prepareStatement("SELECT * FROM p\u00E5g\u00E5endeauktioner WHERE organisationsnummer = ?");
		stm.setString(1, leverantorID);
		ResultSet rs = stm.executeQuery();

		while(rs.next()){
			arrAllaPagaendeAuktionerSomTillhorLeverantorID.add(new Auktion(rs.getInt("auktionsID"),
					rs.getString("produktNamn"),
					rs.getDate("startDatum"),
					rs.getDate("slutDatum"),
					rs.getDouble("utg\u00E5ngsPris"),
					rs.getDouble("maxBud"),
					rs.getDouble("acceptPris"),
					rs.getString("f\u00F6retagsnamn"),
					rs.getInt("provision"),
					rs.getString("kontaktperson"),
					rs.getString("email"),
					rs.getString("telefonnummer"),
					rs.getString("kund"), 
					rs.getString("kategori")));
		}

		rs.close();
		stm.close();
		return arrAllaPagaendeAuktionerSomTillhorLeverantorID;
	}

	public void laggTillNyKund( String prsNummer, String fornamn, String efternamn, String adress, 
			String postnummer, String ort, String tlfnummer, String email) throws SQLException{

		PreparedStatement stm = conn.prepareStatement("INSERT INTO Kund (PersonNummer, F\u00F6rnamn, Efternamn, Adress, Postnummer, Ort, Telefonnummer, Email) "
				+ "values (?, ?, ?, ?, ?, ?, ?, ?)");
		stm.setString(1, prsNummer);
		stm.setString(2, fornamn);
		stm.setString(3, efternamn);
		stm.setString(4, adress);
		stm.setString(5, postnummer);
		stm.setString(6, ort);
		stm.setString(7, tlfnummer);
		stm.setString(8, email);

		stm.executeUpdate();

		stm.close();
	}

	public void laggTillNyLeverantor(String orgNummer, String foretagsNamn, int provision, String kontaktPerson, String email, String telefonNummer) throws SQLException{

		PreparedStatement stm = conn.prepareStatement("INSERT INTO Leverant\u00F6r (Organisationsnummer, F\u00F6retagsnamn, Provision, Kontaktperson, Email, Telefonnummer)"
				+ "values (?, ?, ?, ?, ?, ?)");
		stm.setString(1, orgNummer);
		stm.setString(2, foretagsNamn);
		stm.setInt(3, provision);
		stm.setString(4, kontaktPerson);
		stm.setString(5, email);
		stm.setString(6, telefonNummer);

		stm.executeUpdate();

		stm.close();

	}

	public void laggTillNyttBud(int auktionID, String personNummer, double bud, JLabel label) throws SQLException{

		conn.setAutoCommit(false);
		PreparedStatement stm = conn.prepareStatement("INSERT INTO auktion.bud (Auktion, Kund, Pris) VALUES (?, ?, ?)",
				ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		stm.setInt(1, auktionID);
		stm.setString(2, personNummer);
		stm.setDouble(3, bud);


		stm.executeUpdate();
		conn.commit();

		stm.close();

		label.setText("Ditt bud har blivit godtaget.");
	}

	public ArrayList<Bud> getBudFranAuktion(String AuktionID) throws SQLException{
		ArrayList<Bud> arrBudFranAuktion = new ArrayList<Bud>();


		PreparedStatement stm = conn.prepareStatement("SELECT * FROM budhistorik WHERE auktion = ?");
		stm.setString(1, AuktionID);
		ResultSet rs = stm.executeQuery();

		while(rs.next()){
			arrBudFranAuktion.add(new Bud(
					rs.getInt("auktion"),
					rs.getString("produktNamn"),
					rs.getString("f\u00F6rnamn"),
					rs.getString("efternamn"),
					rs.getDouble("pris"),
					rs.getString("kund")));
		}

		rs.close();
		stm.close();
		return arrBudFranAuktion;
	}

	public ArrayList<Kund> getAllaKunderSomHarVunnit() throws SQLException{
		ArrayList<Kund> kundListaMedTotaltOrdervarde = new ArrayList<Kund>();

		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery("SELECT PersonNummer, F\u00F6rnamn, Efternamn, Adress, Postnummer, Ort, Telefonnummer, Email, sum(hogstaBud.pris) as Total FROM Kund "
				+ "inner join hogstaBud on hogstaBud.kund = PersonNummer "
				+ "inner join Auktion on Auktion.AuktionsId = hogstaBud.auktion "
				+ "where Auktion.AvslutadAuktion = 1 "
				+ "group by PersonNummer;");

		while(rs.next()){
			kundListaMedTotaltOrdervarde.add(new Kund(rs.getString("personNummer"),
					rs.getString("F\u00F6rnamn"),
					rs.getString("Efternamn"),
					rs.getString("Adress"),
					rs.getString("Postnummer"),
					rs.getString("Ort"),
					rs.getString("Telefonnummer"),
					rs.getString("Email"),
					rs.getDouble("Total")));
		}

		rs.close();
		stm.close();
		return kundListaMedTotaltOrdervarde;
	}

	public void kopAuktionNu(int auktionsID, String KundID, JLabel label) throws SQLException{
		conn.setAutoCommit(false);

		PreparedStatement stm = conn.prepareStatement("UPDATE auktion SET avslutadAuktion = 1 WHERE AuktionsID = ?", 
				ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		stm.setInt(1, auktionsID);
		stm.executeUpdate();

		PreparedStatement stm2 = conn.prepareStatement("INSERT INTO bud (Auktion, Kund, Pris) "
				+ "VALUES (?, ?, (SELECT AcceptPris FROM Auktion WHERE auktionsID = ?))", 
				ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		stm2.setInt(1, auktionsID);
		stm2.setString(2, KundID);
		stm2.setInt(3, auktionsID);

		stm2.executeUpdate();

		label.setText("Produkten k\u00F6pt f\u00F6r acceptpriset");

		conn.commit();
		stm.close();
	}

	public void skapaAuktion(String startdatum, double utgangspris, double acceptpris, String slutdatum, String produktnamn, String kategori, String leverantor) throws SQLException{

		conn.setAutoCommit(false);
		PreparedStatement stm = conn.prepareStatement("INSERT INTO Auktion "
				+ "(Startdatum, Utg\u00E5ngspris, Acceptpris, Slutdatum, Produktnamn, Produktkategori, Leverant\u00F6r) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)",
				ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		stm.setString(1, startdatum);
		stm.setDouble(2, utgangspris);
		stm.setDouble(3, acceptpris);
		stm.setString(4, slutdatum);
		stm.setString(5, produktnamn);
		stm.setInt(6, this.getKategoriID(kategori));
		stm.setString(7, leverantor);


		stm.executeUpdate();
		conn.commit();

		stm.close();

		skapaAuktionsEvent(produktnamn, slutdatum);
	}

	public void skapaAuktionsEvent(String produktnamn, String slutdatum) throws SQLException{

		Statement stm1 = conn.createStatement();
		ResultSet rs = stm1.executeQuery("SELECT MAX(auktionsID) FROM Auktion");

		rs.next();
		int auktionsID = rs.getInt("MAX(auktionsID)");
		String eventNamn = "auktionsID_" + Integer.toString(auktionsID) + "_event";
		System.out.println(eventNamn);

		PreparedStatement stm2 = conn.prepareStatement("CREATE EVENT "+ eventNamn + " ON SCHEDULE AT ? DO UPDATE Auktion SET AvslutadAuktion = 1 WHERE auktionsID = ?",
				ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		stm2.setString(1, slutdatum);
		stm2.setInt(2, auktionsID);		
		stm2.execute();

		stm2.close();
		stm1.close();
		rs.close();
	}

	public int getKategoriID(String kategori) throws SQLException{
		PreparedStatement stm = conn.prepareStatement("SELECT KategoriID FROM Kategori WHERE kategorinamn = ?");
		stm.setString(1, kategori);
		ResultSet rs = stm.executeQuery();

		rs.next();
		int retur = rs.getInt("KategoriID");
		rs.close();
		stm.close();
		return retur;
	}

	public ArrayList<Manad> getAllaManaderMedProvision() throws SQLException{
		ArrayList<Manad> totalProvisionPerManad = new ArrayList<Manad>();

		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery("SELECT MONTHNAME(SlutDatum) as M\u00E5nad, sum(Maxbud * (Provision * 0.01)) AS Provision FROM p\u00E5g\u00E5endeAuktioner "
				+ "WHERE Avslutad = 1 "
				+ "GROUP BY MONTH(SlutDatum);");

		while(rs.next()){
			totalProvisionPerManad.add(new Manad(rs.getString("M\u00E5nad"),
					rs.getDouble("Provision")));
		}

		rs.close();
		stm.close();
		return totalProvisionPerManad;
	}

	public ArrayList<Auktion> getAllaAuktionerSomAvslutasUnderIntervall(Date start, Date slut) throws SQLException{
		ArrayList<Auktion> arrAllaPagaendeAuktioner = new ArrayList<Auktion>();

		PreparedStatement stm = conn.prepareStatement("select * from p\u00E5g\u00E5endeAuktioner "
				+ "where (SlutDatum BETWEEN ? and ?) "
				+ "group by AuktionsID;");
		stm.setDate(1, start);
		stm.setDate(2, slut);
		ResultSet rs = stm.executeQuery();

		while(rs.next()){
			arrAllaPagaendeAuktioner.add(new Auktion(rs.getInt("auktionsID"),
					rs.getString("produktNamn"),
					rs.getDate("startDatum"),
					rs.getDate("slutDatum"),
					rs.getDouble("utg\u00E5ngsPris"),
					rs.getDouble("maxBud"),
					rs.getDouble("acceptPris"),
					rs.getString("f\u00F6retagsnamn"),
					rs.getInt("provision"),
					rs.getString("kontaktperson"),
					rs.getString("email"),
					rs.getString("telefonnummer"),
					rs.getString("kund"), 
					rs.getString("kategori")));
		}

		rs.close();
		stm.close();
		return arrAllaPagaendeAuktioner;
	}
}
