package com.jbay.controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JLabel;

import com.jbay.model.Auktion;


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
		System.out.println("Singleton tillagd");
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
		ResultSet rs = stm.executeQuery("SELECT * FROM p\u00E5g\u00E5endeauktioner WHERE (NOW() BETWEEN StartDatum AND SlutDatum)");

		while(rs.next()){
			arrAllaPagaendeAuktioner.add(new Auktion(rs.getInt("auktionsID"),
					rs.getString("produktNamn"),
					rs.getDate("startDatum"),
					rs.getDate("slutDatum"),
					rs.getInt("utg\u00E5ngsPris"),
					rs.getInt("maxBud"),
					rs.getInt("acceptPris"),
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

		PreparedStatement stm = conn.prepareStatement("SELECT * FROM p\u00E5g\u00E5endeauktioner WHERE kund =?");
		stm.setString(1, kundID);
		ResultSet rs = stm.executeQuery();
		
		while(rs.next()){
			arrAllaPagaendeAuktionerSomKundIDBudatPa.add(new Auktion(rs.getInt("auktionsID"),
					rs.getString("produktNamn"),
					rs.getDate("startDatum"),
					rs.getDate("slutDatum"),
					rs.getInt("utg\u00E5ngsPris"),
					rs.getInt("maxBud"),
					rs.getInt("acceptPris"),
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
		ArrayList<Auktion> arrAllaPagaendeAuktionerSomLeverantorIDBudatPa = new ArrayList<Auktion>();


		PreparedStatement stm = conn.prepareStatement("SELECT * FROM p\u00E5g\u00E5endeauktioner WHERE organisationsnummer = ?");
		stm.setString(1, leverantorID);
		ResultSet rs = stm.executeQuery();
		
		while(rs.next()){
			arrAllaPagaendeAuktionerSomLeverantorIDBudatPa.add(new Auktion(rs.getInt("auktionsID"),
					rs.getString("produktNamn"),
					rs.getDate("startDatum"),
					rs.getDate("slutDatum"),
					rs.getInt("utg\u00E5ngsPris"),
					rs.getInt("maxBud"),
					rs.getInt("acceptPris"),
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
		return arrAllaPagaendeAuktionerSomLeverantorIDBudatPa;
	}
	
	public void laggTillNyKund( String prsNummer, String fornamn, String efternamn, String adress, 
			String postnummer, String ort, String tlfnummer, String email) throws SQLException{

		PreparedStatement stm = conn.prepareStatement("INSERT INTO Kund (PersonNummer, F�rnamn, Efternamn, Adress, Postnummer, Ort, Telefonnummer, Email) "
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
	
	public void laggTillNyttBud(String auktionID, String personNummer, double bud, JLabel label) throws SQLException{
		
		conn.setAutoCommit(false);
		PreparedStatement stm = conn.prepareStatement("INSERT INTO auktion.bud (Auktion, Kund, Pris) VALUES (?, ?, ?)",
				ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		stm.setString(1, auktionID);
		stm.setString(2, personNummer);
		stm.setDouble(3, bud);
		
			
		stm.executeUpdate();
		conn.commit();
		
		stm.close();
		
		label.setText("Ditt bud har blivit godtagen");
	}
}
