package com.jbay.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.jbay.controller.JDBC_Connection;
import com.jbay.model.Auktion;
import com.jbay.model.Kund;
import com.jbay.model.Manad;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.List;

public class Rapporter_GUI extends JFrame {

	private JPanel contentPane;
	private static Rapporter_GUI singleton;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private String[] columnNames = {""};
	private Object[][] data = {};
	private List<Auktion> auktionList;
	private List<Kund> kundList;
	private List<Manad> manadList;

	public static Rapporter_GUI getsingleton(){
		if (singleton == null) {
			singleton = new Rapporter_GUI() ;
		}
		return singleton;
	}

	/**
	 * Create the frame.
	 */
	private Rapporter_GUI() {
		setTitle("Rapporter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 861, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		scrollPane.setViewportView(table);

		JLabel lblStartdatum = new JLabel("|Startdatum");
		panel.add(lblStartdatum);

		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblSlutdatum = new JLabel("Slutdatum");
		panel.add(lblSlutdatum);

		textField_1 = new JTextField();
		panel.add(textField_1);
		textField_1.setColumns(10);

		JButton btnAuktionsprovisioner = new JButton("Auktionsprovisioner");
		btnAuktionsprovisioner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	
				data = new Object[auktionList.size()][9];
				String[] columnNames = {"Auktion", "Produkt", "Kategori", "Startdatum", "Slutdatum", "Kund", "Maxbud", "Företag", "Provision"};

				for (int i = 0; i < auktionList.size(); i++) {
					data[i][0] = auktionList.get(i).getAuktionsID();
					data[i][1] = auktionList.get(i).getProduktNamn();
					data[i][2] = auktionList.get(i).getKategori();
					data[i][3] = auktionList.get(i).getStartDatum();
					data[i][4] = auktionList.get(i).getSlutDatum();
					data[i][5] = auktionList.get(i).getKund();
					data[i][6] = auktionList.get(i).getMaxBud();
					data[i][7] = auktionList.get(i).getForetag();
					data[i][8] = auktionList.get(i).getMaxBud() * (auktionList.get(i).getProvision() * 0.1);
				}
				table.setModel(new DefaultTableModel(data, columnNames));
			}
		});
		panel.add(btnAuktionsprovisioner);

		JLabel label = new JLabel("|");
		panel.add(label);

		JButton btnKund = new JButton("Kundbest\u00E4llningar");
		btnKund.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String[] columnNames = {"Personnummer", "Förnamn", "Efternamn", "Adress", "Postnummer", "Ort", "Telefon", "Email", "Total"};
					kundList = JDBC_Connection.getSingleton().getAllaKunderSomHarVunnit();				
					data = new Object[kundList.size()][9];
					
					for (int i = 0; i < kundList.size(); i++) {
						data[i][0] = kundList.get(i).getPersonNummer();
						data[i][1] = kundList.get(i).getForNamn();
						data[i][2] = kundList.get(i).getEfterNamn();
						data[i][3] = kundList.get(i).getAdress();
						data[i][4] = kundList.get(i).getPostNummer();
						data[i][5] = kundList.get(i).getOrt();
						data[i][6] = kundList.get(i).getTelefon();
						data[i][7] = kundList.get(i).getEmail();					
						data[i][8] = kundList.get(i).getTotal();
					}
					
					table.setModel(new DefaultTableModel(data, columnNames));
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		panel.add(btnKund);

		JLabel label_1 = new JLabel("|");
		panel.add(label_1);

		JButton btnMnadsrapport = new JButton("M\u00E5nadsrapport");
		btnMnadsrapport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
				try {
					manadList = JDBC_Connection.getSingleton().getAllaManaderMedProvision();
					String[] columnNames = {"M\u00E5nad", "Provision"};				
					data = new Object[manadList.size()][2];
					
					for (int i = 0; i < manadList.size(); i++) {
						data[i][0] = manadList.get(i).getManad();
						data[i][1] = manadList.get(i).getProvision();
					}
					
					table.setModel(new DefaultTableModel(data, columnNames));
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				
			}
		});
		panel.add(btnMnadsrapport);

		JLabel label_2 = new JLabel("|");
		panel.add(label_2);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnMeny = new JButton("Meny");
		btnMeny.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Inloggning.getInloggning().setVisible(true);
				singleton = null;
				dispose();
				
			}
		});
		panel_1.add(btnMeny);

	}

}
