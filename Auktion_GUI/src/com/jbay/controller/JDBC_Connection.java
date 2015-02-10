package com.jbay.controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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

	public ArrayList<String> getAllaLeverant�rIDs() throws SQLException{

		ArrayList<String> arrAllaLeverant�rIDs = new ArrayList<>();

		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery("SELECT Organisationsnummer FROM Leverant�r");

		while(rs.next()){
			arrAllaLeverant�rIDs.add(rs.getString("Organisationsnummer"));
		}

		stm.close();
		rs.close();
		return arrAllaLeverant�rIDs;			
	}	

	public ArrayList<String> getAllaKategorier() throws SQLException{
		ArrayList<String> arrAllaKategorierNamn = new ArrayList<String>();


		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery("SELECT KategoriID FROM Kategori");

		while(rs.next()){
			arrAllaKategorierNamn.add(rs.getString("KategoriNamn"));
		}

		stm.close();
		rs.close();
		return arrAllaKategorierNamn;		
	}

	public ArrayList<Auktion> getAllaP�g�endeAuktioner() throws SQLException{
		ArrayList<Auktion> arrAllaP�g�endeAuktioner = new ArrayList<Auktion>();

		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery("SELECT * FROM p�g�endeauktioner WHERE (NOW() BETWEEN StartDatum AND SlutDatum)");

		while(rs.next()){
			arrAllaP�g�endeAuktioner.add(new Auktion(rs.getInt("auktionsID"),
					rs.getString("produktNamn"),
					rs.getDate("startDatum"),
					rs.getDate("slutDatum"),
					rs.getInt("utg�ngsPris"),
					rs.getInt("maxBud"),
					rs.getInt("acceptPris"),
					rs.getString("f�retagsnamn"),
					rs.getInt("provision"),
					rs.getString("kontaktperson"),
					rs.getString("email"),
					rs.getString("telefonnummer"),
					rs.getString("kund")));
		}

		rs.close();
		stm.close();
		return arrAllaP�g�endeAuktioner;
	}

	public ArrayList<Auktion> getAllaP�g�endeAuktionerSomKundIDBudatP�(String kundID) throws SQLException{
		ArrayList<Auktion> arrAllaP�g�endeAuktionerSomKundIDBudatP� = new ArrayList<Auktion>();

		PreparedStatement stm = conn.prepareStatement("SELECT * FROM p�g�endeauktioner WHERE kund = '?'");
		stm.setString(1, kundID);
		ResultSet rs = stm.executeQuery();
		
		while(rs.next()){
			arrAllaP�g�endeAuktionerSomKundIDBudatP�.add(new Auktion(rs.getInt("auktionsID"),
					rs.getString("produktNamn"),
					rs.getDate("startDatum"),
					rs.getDate("slutDatum"),
					rs.getInt("utg�ngsPris"),
					rs.getInt("maxBud"),
					rs.getInt("acceptPris"),
					rs.getString("f�retagsnamn"),
					rs.getInt("provision"),
					rs.getString("kontaktperson"),
					rs.getString("email"),
					rs.getString("telefonnummer"),
					rs.getString("kund")));
		}
		
		rs.close();
		stm.close();
		return arrAllaP�g�endeAuktionerSomKundIDBudatP�;
	}

	public void l�ggTillNyKund( String prsNummer, String f�rnamn, String efternamn, String adress, 
			String postnummer, String ort, String tlfnummer, String email) throws SQLException{

		PreparedStatement stm = conn.prepareStatement("INSERT INTO Kund (PersonNummer, F�rnamn, Efternamn, Adress, Postnummer, Ort, Telefonnummer, Email) "
				+ "values (?, ?, ?, ?, ?, ?, ?, ?)");
		stm.setString(1, prsNummer);
		stm.setString(2, f�rnamn);
		stm.setString(3, efternamn);
		stm.setString(4, adress);
		stm.setString(5, postnummer);
		stm.setString(6, ort);
		stm.setString(7, tlfnummer);
		stm.setString(8, email);
		
		stm.executeUpdate();
		
		stm.close();
	}
}





//2. En lista som returnerar samtliga p�g�ende auktioner som en Person har budat p�(Sparade som Auktions objekt fr�n klassen i model package)