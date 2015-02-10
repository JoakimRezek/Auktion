package com.jbay.view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JButton;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;

import com.jbay.controller.JDBC_Connection;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Inloggning extends JFrame {

	private JPanel contentPane;
	private JComboBox<String> comboBoxLoginID;
	private JComboBox<String> comboBoxLeverantorID;
	private static Inloggning inloggning;
	
	private JDBC_Connection dBConnection;
	private JButton btnNyKund;
	private JButton btnNyLeverantr;

	public static Inloggning getInloggning(){
		if (inloggning == null) {
			try {
				inloggning = new Inloggning();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return inloggning;
	}
	
	public static void main(String[] args){
		Inloggning.getInloggning();
	}
	
	private Inloggning() throws SQLException {
		
		dBConnection = JDBC_Connection.getSingleton(); 
		
		setTitle("Logga In");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		
		comboBoxLoginID = new JComboBox<String>();
		GridBagConstraints gbc_comboBoxLoginID = new GridBagConstraints();
		gbc_comboBoxLoginID.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxLoginID.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxLoginID.gridx = 1;
		gbc_comboBoxLoginID.gridy = 0;
		for(String element : dBConnection.getAllaKundIDs()){
			comboBoxLoginID.addItem(element);
		}
		contentPane.add(comboBoxLoginID, gbc_comboBoxLoginID);
		
		comboBoxLeverantorID = new JComboBox<String>();
		GridBagConstraints gbc_comboBoxLeverant\u00F6rID = new GridBagConstraints();
		gbc_comboBoxLeverant\u00F6rID.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxLeverant\u00F6rID.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxLeverant\u00F6rID.gridx = 7;
		gbc_comboBoxLeverant\u00F6rID.gridy = 0;		
		contentPane.add(comboBoxLeverantorID, gbc_comboBoxLeverant\u00F6rID);		
		for(String element : dBConnection.getAllaLeverantorIDs()){
			comboBoxLeverantorID.addItem(element);
		}
		
		JButton btnLoggaInSomKund = new JButton("Kund Login");
		btnLoggaInSomKund.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Kund_GUI.getsingleton(comboBoxLoginID.getSelectedItem().toString()).setVisible(true);
				setVisible(false);
				System.out.println("Loggar in som kund: " + comboBoxLoginID.getSelectedItem().toString());
			}
		});
		
		GridBagConstraints gbc_btnLoggaInSomKund = new GridBagConstraints();
		gbc_btnLoggaInSomKund.insets = new Insets(0, 0, 5, 5);
		gbc_btnLoggaInSomKund.gridx = 1;
		gbc_btnLoggaInSomKund.gridy = 1;
		contentPane.add(btnLoggaInSomKund, gbc_btnLoggaInSomKund);
		
		JButton btnLoggaInSomLeverant\u00F6r = new JButton("Leverant\u00F6r Login");
		GridBagConstraints gbc_btnLoggaInSomLeverant\u00F6r = new GridBagConstraints();
		gbc_btnLoggaInSomLeverant\u00F6r.insets = new Insets(0, 0, 5, 0);
		gbc_btnLoggaInSomLeverant\u00F6r.gridx = 7;
		gbc_btnLoggaInSomLeverant\u00F6r.gridy = 1;
		contentPane.add(btnLoggaInSomLeverant\u00F6r, gbc_btnLoggaInSomLeverant\u00F6r);
		btnLoggaInSomLeverant\u00F6r.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Leverantor_GUI.getSingleton(comboBoxLeverantorID.getSelectedItem().toString()).setVisible(true);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				dispose();
				System.out.println("Loggar in som Leverant\u00F6r: " + comboBoxLeverantorID.getSelectedItem().toString());
			}
		});
		
		btnNyKund = new JButton("Ny Kund");
		GridBagConstraints gbc_btnNyKund = new GridBagConstraints();
		gbc_btnNyKund.insets = new Insets(0, 0, 0, 5);
		gbc_btnNyKund.gridx = 1;
		gbc_btnNyKund.gridy = 4;
		contentPane.add(btnNyKund, gbc_btnNyKund);
		
		btnNyLeverantr = new JButton("Ny Leverant\u00F6r");
		GridBagConstraints gbc_btnNyLeverantr = new GridBagConstraints();
		gbc_btnNyLeverantr.gridx = 7;
		gbc_btnNyLeverantr.gridy = 4;
		contentPane.add(btnNyLeverantr, gbc_btnNyLeverantr);
		pack();		
	}
}
