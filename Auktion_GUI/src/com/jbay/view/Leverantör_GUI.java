package com.jbay.view;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;

import com.jbay.controller.JDBC_Connection;
import java.awt.Font;


public class Leverant�r_GUI extends JFrame {

	private static Leverant�r_GUI singleton;
	
	public static Leverant�r_GUI getSingleton(String leverant�r) throws SQLException{
		if(singleton == null) singleton = new Leverant�r_GUI(leverant�r);
		return singleton;
	}
	
	
	private JPanel mainPane;
	private JDBC_Connection db;
	private JTextField startdatumField;
	private String Leverant�r;
	private JTextField slutdatumField;
	private JTextField utg�ngsprisField;
	private JTextField acceptprisField;
	private JTextField produktField;
	
	private Leverant�r_GUI(String leverant�r) throws SQLException {
		this.Leverant�r = leverant�r;
		db = JDBC_Connection.getSingleton();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		mainPane = new JPanel();
		mainPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPane);
		mainPane.setLayout(new BorderLayout(0, 0));
		
		JPanel nyAuktionPane = new JPanel();
		mainPane.add(nyAuktionPane, BorderLayout.NORTH);
		nyAuktionPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNyOrder = new JLabel("Ny Auktion");
		lblNyOrder.setFont(new Font("Tahoma", Font.BOLD, 13));
		nyAuktionPane.add(lblNyOrder);
		
		JPanel tomPane1 = new JPanel();
		nyAuktionPane.add(tomPane1);
		
		JLabel lblSlutdatum = new JLabel("Startdatum:");
		nyAuktionPane.add(lblSlutdatum);
		
		startdatumField = new JTextField();
		nyAuktionPane.add(startdatumField);
		startdatumField.setColumns(10);
		
		JLabel lblStuff = new JLabel("Slutdatum:");
		nyAuktionPane.add(lblStuff);
		
		slutdatumField = new JTextField();
		nyAuktionPane.add(slutdatumField);
		slutdatumField.setColumns(10);
		
		JLabel lblStartpris = new JLabel("Utg\u00E5ngspris:");
		nyAuktionPane.add(lblStartpris);
		
		utg�ngsprisField = new JTextField();
		nyAuktionPane.add(utg�ngsprisField);
		utg�ngsprisField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Acceptpris:");
		nyAuktionPane.add(lblNewLabel);
		
		acceptprisField = new JTextField();
		nyAuktionPane.add(acceptprisField);
		acceptprisField.setColumns(10);
		
		JLabel lblProduktnamn = new JLabel("Produktnamn:");
		nyAuktionPane.add(lblProduktnamn);
		
		produktField = new JTextField();
		nyAuktionPane.add(produktField);
		produktField.setColumns(10);
		
		JLabel lblProduktkategori = new JLabel("Produktkategori:");
		nyAuktionPane.add(lblProduktkategori);
		
		JComboBox<String> kategoriBox = new JComboBox<String>();
		for(String s : db.getAllaKategorier()) kategoriBox.addItem(s);
		nyAuktionPane.add(kategoriBox);
		
		JPanel tomPane2 = new JPanel();
		nyAuktionPane.add(tomPane2);
		
		JButton btnSkapaAuktion = new JButton("Skapa Auktion");
		btnSkapaAuktion.addActionListener(e -> {
			System.out.println("pushed");
		});
		nyAuktionPane.add(btnSkapaAuktion);
		
	}

}
