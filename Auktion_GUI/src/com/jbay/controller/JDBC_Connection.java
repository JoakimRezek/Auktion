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
import com.mysql.fabric.xmlrpc.base.Array;


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

	public ArrayList<String> getAllaLeverantörIDs() throws SQLException{

		ArrayList<String> arrAllaLeverantörIDs = new ArrayList<>();

		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery("SELECT Organisationsnummer FROM Leverantör");

		while(rs.next()){
			arrAllaLeverantörIDs.add(rs.getString("Organisationsnummer"));
		}

		stm.close();
		rs.close();
		return arrAllaLeverantörIDs;			
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

	public ArrayList<Auktion> getAllaPågåendeAuktioner() throws SQLException{
		ArrayList<Auktion> arrAllaPågåendeAuktioner = new ArrayList<Auktion>();

		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery("SELECT * FROM pågåendeauktioner WHERE (NOW() BETWEEN StartDatum AND SlutDatum)");

		while(rs.next()){
			arrAllaPågåendeAuktioner.add(new Auktion(rs.getInt("auktionsID"),
					rs.getString("produktNamn"),
					rs.getDate("startDatum"),
					rs.getDate("slutDatum"),
					rs.getInt("utgångsPris"),
					rs.getInt("maxBud"),
					rs.getInt("acceptPris"),
					rs.getString("företagsnamn"),
					rs.getInt("provision"),
					rs.getString("kontaktperson"),
					rs.getString("email"),
					rs.getString("telefonnummer"),
					rs.getString("kund"), 
					rs.getString("kategori")));
		}

		rs.close();
		stm.close();
		return arrAllaPågåendeAuktioner;
	}

	public ArrayList<Auktion> getAllaPågåendeAuktionerSomKundIDBudatPå(String kundID) throws SQLException{
		ArrayList<Auktion> arrAllaPågåendeAuktionerSomKundIDBudatPå = new ArrayList<Auktion>();

		PreparedStatement stm = conn.prepareStatement("SELECT * FROM pågåendeauktioner WHERE kund = '?'");
		stm.setString(1, kundID);
		ResultSet rs = stm.executeQuery();
		
		while(rs.next()){
			arrAllaPågåendeAuktionerSomKundIDBudatPå.add(new Auktion(rs.getInt("auktionsID"),
					rs.getString("produktNamn"),
					rs.getDate("startDatum"),
					rs.getDate("slutDatum"),
					rs.getInt("utgångsPris"),
					rs.getInt("maxBud"),
					rs.getInt("acceptPris"),
					rs.getString("företagsnamn"),
					rs.getInt("provision"),
					rs.getString("kontaktperson"),
					rs.getString("email"),
					rs.getString("telefonnummer"),
					rs.getString("kund"), 
					rs.getString("kategori")));
		}
		
		rs.close();
		stm.close();
		return arrAllaPågåendeAuktionerSomKundIDBudatPå;
	}

	public void läggTillNyKund( String prsNummer, String förnamn, String efternamn, String adress, 
			String postnummer, String ort, String tlfnummer, String email) throws SQLException{

		PreparedStatement stm = conn.prepareStatement("INSERT INTO Kund (PersonNummer, Förnamn, Efternamn, Adress, Postnummer, Ort, Telefonnummer, Email) "
				+ "values (?, ?, ?, ?, ?, ?, ?, ?)");
		stm.setString(1, prsNummer);
		stm.setString(2, förnamn);
		stm.setString(3, efternamn);
		stm.setString(4, adress);
		stm.setString(5, postnummer);
		stm.setString(6, ort);
		stm.setString(7, tlfnummer);
		stm.setString(8, email);
		
		stm.executeUpdate();
		
		stm.close();
	}
	

	public void läggTillNyLeverantör(String orgNummer, String företagsNamn, int provision, String kontaktPerson, String email, String telefonNummer) throws SQLException{
		
		PreparedStatement stm = conn.prepareStatement("INSERT INTO Leverantör (Organisationsnummer, Företagsnamn, Provision, Kontaktperson, Email, Telefonnummer)"
				+ "values (?, ?, ?, ?, ?, ?)");
		stm.setString(1, orgNummer);
		stm.setString(2, företagsNamn);
		stm.setInt(3, provision);
		stm.setString(4, kontaktPerson);
		stm.setString(5, email);
		stm.setString(6, telefonNummer);
		
		stm.executeUpdate();
		
		stm.close();
		
	}
	
	public void läggTillNyttBud(String auktionID, String personNummer, double bud, JLabel label) throws SQLException{
		
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
