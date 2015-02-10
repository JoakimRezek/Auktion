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
		ArrayList<String> arrAllaKategorier = new ArrayList<String>();


		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery("SELECT KategoriID FROM Kategori");

		while(rs.next()){
			arrAllaKategorier.add(rs.getString("KategoriID"));
		}

		stm.close();
		rs.close();
		return arrAllaKategorier;		
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
					rs.getString("kund")));
		}

		rs.close();
		stm.close();
		return arrAllaPågåendeAuktioner;
	}
}




//2. En lista som returnerar samtliga pågående auktioner som en Person har budat på(Sparade som Auktions objekt från klassen i model package)