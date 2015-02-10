package com.jbay.view;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.JTextField;

import java.awt.Insets;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

import javax.swing.SwingConstants;

import com.jbay.controller.JDBC_Connection;


public class AddKund extends JFrame {

	private JPanel contentPane;
	private JTextField personNummerField;
	private JTextField forNamnField;
	private JTextField efterNamnField;
	private JLabel lblNewLabel_1;
	private JTextField adressField;
	private JLabel lblNewLabel_2;
	private JTextField postNummerField;
	private JLabel lblOrt;
	private JTextField ortField;
	private JLabel lblNewLabel_3;
	private JTextField telefonNummerField;
	private JLabel lblEmail;
	private JTextField emailField;
	private JButton btnRegister;
	private JButton btnAvbryt;
	
	private static AddKund frame;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddKund frame = new AddKund();
					frame.setVisible(true);
					frame.pack();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static AddKund getsingleton(){
		if (frame == null) 
			frame = new AddKund();
		
		
		return frame;
		
	}

	/**
	 * Create the frame.
	 */
	public AddKund() {
		setTitle("Registrera ny Kund");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblFrnamn = new JLabel("Personnummer:");
		GridBagConstraints gbc_lblFrnamn = new GridBagConstraints();
		gbc_lblFrnamn.insets = new Insets(10, 10, 10, 10);
		gbc_lblFrnamn.gridx = 0;
		gbc_lblFrnamn.gridy = 0;
		contentPane.add(lblFrnamn, gbc_lblFrnamn);
		
		personNummerField = new JTextField();
		GridBagConstraints gbc_personNummerField = new GridBagConstraints();
		gbc_personNummerField.gridwidth = 2;
		gbc_personNummerField.insets = new Insets(10, 10, 10, 10);
		gbc_personNummerField.fill = GridBagConstraints.HORIZONTAL;
		gbc_personNummerField.gridx = 2;
		gbc_personNummerField.gridy = 0;
		contentPane.add(personNummerField, gbc_personNummerField);
		personNummerField.setColumns(10);
		
		JLabel lblEfternamn = new JLabel("Fornamn:");
		GridBagConstraints gbc_lblEfternamn = new GridBagConstraints();
		gbc_lblEfternamn.insets = new Insets(10, 10, 10, 10);
		gbc_lblEfternamn.gridx = 0;
		gbc_lblEfternamn.gridy = 1;
		contentPane.add(lblEfternamn, gbc_lblEfternamn);
		
		forNamnField = new JTextField();
		GridBagConstraints gbc_forNamnField = new GridBagConstraints();
		gbc_forNamnField.gridwidth = 2;
		gbc_forNamnField.insets = new Insets(10, 10, 10, 10);
		gbc_forNamnField.fill = GridBagConstraints.HORIZONTAL;
		gbc_forNamnField.gridx = 2;
		gbc_forNamnField.gridy = 1;
		contentPane.add(forNamnField, gbc_forNamnField);
		forNamnField.setColumns(10);
		
		JLabel lblEfterNamn = new JLabel("Efternamn:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(10, 10, 10, 10);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		
		contentPane.add(lblEfterNamn, gbc_lblNewLabel);
		
		efterNamnField = new JTextField();
		GridBagConstraints gbc_efterNamnField = new GridBagConstraints();
		gbc_efterNamnField.gridwidth = 2;
		gbc_efterNamnField.insets = new Insets(10, 10, 10, 10);
		gbc_efterNamnField.fill = GridBagConstraints.HORIZONTAL;
		gbc_efterNamnField.gridx = 2;
		gbc_efterNamnField.gridy = 2;
		contentPane.add(efterNamnField, gbc_efterNamnField);
		efterNamnField.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Adress:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(10, 10, 10, 10);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 3;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		adressField = new JTextField();
		GridBagConstraints gbc_adressField = new GridBagConstraints();
		gbc_adressField.gridwidth = 2;
		gbc_adressField.insets = new Insets(10, 10, 10, 10);
		gbc_adressField.fill = GridBagConstraints.HORIZONTAL;
		gbc_adressField.gridx = 2;
		gbc_adressField.gridy = 3;
		contentPane.add(adressField, gbc_adressField);
		adressField.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Postnummer:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(10, 10, 10, 10);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 4;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		postNummerField = new JTextField();
		GridBagConstraints gbc_postNummerField = new GridBagConstraints();
		gbc_postNummerField.gridwidth = 2;
		gbc_postNummerField.insets = new Insets(10, 10, 10, 10);
		gbc_postNummerField.fill = GridBagConstraints.HORIZONTAL;
		gbc_postNummerField.gridx = 2;
		gbc_postNummerField.gridy = 4;
		contentPane.add(postNummerField, gbc_postNummerField);
		postNummerField.setColumns(10);
		
		lblOrt = new JLabel("Ort:");
		GridBagConstraints gbc_lblOrt = new GridBagConstraints();
		gbc_lblOrt.insets = new Insets(10, 10, 10, 10);
		gbc_lblOrt.gridx = 0;
		gbc_lblOrt.gridy = 5;
		contentPane.add(lblOrt, gbc_lblOrt);
		
		ortField = new JTextField();
		GridBagConstraints gbc_ortField = new GridBagConstraints();
		gbc_ortField.gridwidth = 2;
		gbc_ortField.insets = new Insets(10, 10, 10, 10);
		gbc_ortField.fill = GridBagConstraints.HORIZONTAL;
		gbc_ortField.gridx = 2;
		gbc_ortField.gridy = 5;
		contentPane.add(ortField, gbc_ortField);
		ortField.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Telefonnummer:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(10, 10, 10, 10);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 6;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		telefonNummerField = new JTextField();
		GridBagConstraints gbc_telefonNummerField = new GridBagConstraints();
		gbc_telefonNummerField.gridwidth = 2;
		gbc_telefonNummerField.anchor = GridBagConstraints.NORTH;
		gbc_telefonNummerField.insets = new Insets(10, 10, 10, 10);
		gbc_telefonNummerField.fill = GridBagConstraints.HORIZONTAL;
		gbc_telefonNummerField.gridx = 2;
		gbc_telefonNummerField.gridy = 6;
		contentPane.add(telefonNummerField, gbc_telefonNummerField);
		telefonNummerField.setColumns(10);
		
		lblEmail = new JLabel("E-mail:");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.insets = new Insets(10, 10, 10, 10);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 7;
		contentPane.add(lblEmail, gbc_lblEmail);
		
		emailField = new JTextField();
		GridBagConstraints gbc_emailField = new GridBagConstraints();
		gbc_emailField.gridwidth = 2;
		gbc_emailField.insets = new Insets(10, 10, 10, 10);
		gbc_emailField.fill = GridBagConstraints.HORIZONTAL;
		gbc_emailField.gridx = 2;
		gbc_emailField.gridy = 7;
		contentPane.add(emailField, gbc_emailField);
		emailField.setColumns(10);
		
		btnRegister = new JButton("Registera");
		btnRegister.setHorizontalAlignment(SwingConstants.LEFT);
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String personNummer = personNummerField.getText();
				String forNamn = forNamnField.getText();
				String efterNamn = efterNamnField.getText();
				String adress = adressField.getText();
				String postNummer = postNummerField.getText();
				String ort = ortField.getText();
				String telefonNummer = telefonNummerField.getText();
				String email = emailField.getText();
				
				try {
					JDBC_Connection.getSingleton().laggTillNyKund(personNummer, forNamn, efterNamn, adress, postNummer, ort, telefonNummer, email);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		GridBagConstraints gbc_btnRegister = new GridBagConstraints();
		gbc_btnRegister.insets = new Insets(10, 10, 10, 10);
		gbc_btnRegister.anchor = GridBagConstraints.EAST;
		gbc_btnRegister.gridx = 2;
		gbc_btnRegister.gridy = 8;
		contentPane.add(btnRegister, gbc_btnRegister);
		
		btnAvbryt = new JButton("Avbryt");
		btnAvbryt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		GridBagConstraints gbc_btnAvbryt = new GridBagConstraints();
		gbc_btnAvbryt.gridx = 3;
		gbc_btnAvbryt.gridy = 8;
		contentPane.add(btnAvbryt, gbc_btnAvbryt);
	}

}	


