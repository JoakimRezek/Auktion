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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JButton;

import com.jbay.controller.JDBC_Connection;


public class AddLeverant�r extends JFrame {

	private JPanel contentPane;
	
	
	private static AddLeverant�r frame;
	private JTextField orgNrField;
	private JTextField f�retagField;
	private JTextField provisionField;
	private JTextField kntPersonField;
	private JTextField emailField;
	private JTextField telefonField;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddLeverant�r frame = new AddLeverant�r();
					frame.setVisible(true);
					frame.pack();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static AddLeverant�r getsingleton(){
		if (frame == null) 
			frame = new AddLeverant�r();
		
		
		return frame;
		
	}

	/**
	 * Create the frame.
	 */
	public AddLeverant�r() {
		setTitle("Registrera ny Leverantör");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblOrgNr = new JLabel("Organisationsnummer:");
		GridBagConstraints gbc_lblOrgNr = new GridBagConstraints();
		gbc_lblOrgNr.insets = new Insets(10, 10, 10, 10);
		gbc_lblOrgNr.gridx = 0;
		gbc_lblOrgNr.gridy = 0;
		contentPane.add(lblOrgNr, gbc_lblOrgNr);
		
		orgNrField = new JTextField();
		GridBagConstraints gbc_orgNrField = new GridBagConstraints();
		gbc_orgNrField.gridwidth = 2;
		gbc_orgNrField.insets = new Insets(10, 10, 10, 10);
		gbc_orgNrField.fill = GridBagConstraints.HORIZONTAL;
		gbc_orgNrField.gridx = 1;
		gbc_orgNrField.gridy = 0;
		contentPane.add(orgNrField, gbc_orgNrField);
		orgNrField.setColumns(10);
		
		JLabel lblf�retag = new JLabel("Företagsnamn:");
		GridBagConstraints gbc_lblF�retag = new GridBagConstraints();
		gbc_lblF�retag.insets = new Insets(10, 10, 10, 10);
		gbc_lblF�retag.gridx = 0;
		gbc_lblF�retag.gridy = 1;
		contentPane.add(lblf�retag, gbc_lblF�retag);
		
		f�retagField = new JTextField();
		GridBagConstraints gbc_f�retagField = new GridBagConstraints();
		gbc_f�retagField.gridwidth = 2;
		gbc_f�retagField.insets = new Insets(10, 10, 10, 10);
		gbc_f�retagField.fill = GridBagConstraints.HORIZONTAL;
		gbc_f�retagField.gridx = 1;
		gbc_f�retagField.gridy = 1;
		contentPane.add(f�retagField, gbc_f�retagField);
		f�retagField.setColumns(10);
		
		JLabel lblProvision = new JLabel("Provision:");
		GridBagConstraints gbc_lblProvision = new GridBagConstraints();
		gbc_lblProvision.insets = new Insets(10, 10, 10, 10);
		gbc_lblProvision.gridx = 0;
		gbc_lblProvision.gridy = 2;
		contentPane.add(lblProvision, gbc_lblProvision);
		
		provisionField = new JTextField();
		GridBagConstraints gbc_provisionField = new GridBagConstraints();
		gbc_provisionField.gridwidth = 2;
		gbc_provisionField.insets = new Insets(10, 10, 10, 10);
		gbc_provisionField.fill = GridBagConstraints.HORIZONTAL;
		gbc_provisionField.gridx = 1;
		gbc_provisionField.gridy = 2;
		contentPane.add(provisionField, gbc_provisionField);
		provisionField.setColumns(10);
		
		JLabel lblKontaktPerson = new JLabel("Kontaktperson:");
		GridBagConstraints gbc_lblKontaktPerson = new GridBagConstraints();
		gbc_lblKontaktPerson.insets = new Insets(10, 10, 10, 10);
		gbc_lblKontaktPerson.gridx = 0;
		gbc_lblKontaktPerson.gridy = 3;
		contentPane.add(lblKontaktPerson, gbc_lblKontaktPerson);
		
		kntPersonField = new JTextField();
		kntPersonField.setText("");
		GridBagConstraints gbc_kntPersonField = new GridBagConstraints();
		gbc_kntPersonField.gridwidth = 2;
		gbc_kntPersonField.insets = new Insets(10, 10, 10, 10);
		gbc_kntPersonField.fill = GridBagConstraints.HORIZONTAL;
		gbc_kntPersonField.gridx = 1;
		gbc_kntPersonField.gridy = 3;
		contentPane.add(kntPersonField, gbc_kntPersonField);
		kntPersonField.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail:");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.insets = new Insets(10, 10, 10, 10);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 4;
		contentPane.add(lblEmail, gbc_lblEmail);
		
		emailField = new JTextField();
		GridBagConstraints gbc_emailField = new GridBagConstraints();
		gbc_emailField.gridwidth = 2;
		gbc_emailField.insets = new Insets(10, 10, 10, 10);
		gbc_emailField.fill = GridBagConstraints.HORIZONTAL;
		gbc_emailField.gridx = 1;
		gbc_emailField.gridy = 4;
		contentPane.add(emailField, gbc_emailField);
		emailField.setColumns(10);
		
		JLabel lblTlfnr = new JLabel("Telefonnummer:");
		GridBagConstraints gbc_lblTlfnr = new GridBagConstraints();
		gbc_lblTlfnr.insets = new Insets(10, 10, 10, 10);
		gbc_lblTlfnr.gridx = 0;
		gbc_lblTlfnr.gridy = 5;
		contentPane.add(lblTlfnr, gbc_lblTlfnr);
		
		telefonField = new JTextField();
		GridBagConstraints gbc_telefonField = new GridBagConstraints();
		gbc_telefonField.gridwidth = 2;
		gbc_telefonField.insets = new Insets(10, 10, 10, 10);
		gbc_telefonField.fill = GridBagConstraints.HORIZONTAL;
		gbc_telefonField.gridx = 1;
		gbc_telefonField.gridy = 5;
		contentPane.add(telefonField, gbc_telefonField);
		telefonField.setColumns(10);
		
		JButton btnRegistrera = new JButton("Registrera");
		btnRegistrera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String orgNummer = orgNrField.getText();
				String f�retag = f�retagField.getText();
				int provision = Integer.parseInt(provisionField.getText());
				String kntPerson = kntPersonField.getText();
				String email = emailField.getText();
				String telefon = telefonField.getText();
				
				JDBC_Connection.getSingleton().l�ggTillNyLeverant�r(orgNummer, f�retag, provision, kntPerson, email, telefon);
				
			}
		});
		GridBagConstraints gbc_btnRegistrera = new GridBagConstraints();
		gbc_btnRegistrera.insets = new Insets(10, 10, 10, 10);
		gbc_btnRegistrera.gridx = 1;
		gbc_btnRegistrera.gridy = 7;
		contentPane.add(btnRegistrera, gbc_btnRegistrera);
		
		JButton btnAvbryt = new JButton("Avbryt");
		GridBagConstraints gbc_btnAvbryt = new GridBagConstraints();
		btnAvbryt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		gbc_btnAvbryt.insets = new Insets(10, 10, 10, 10);
		gbc_btnAvbryt.gridx = 2;
		gbc_btnAvbryt.gridy = 7;
		contentPane.add(btnAvbryt, gbc_btnAvbryt);
	}

}
