package com.jbay.view;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.jbay.controller.JDBC_Connection;
import com.jbay.model.Auktion;
import com.mysql.jdbc.JDBC4CallableStatement;

import javax.swing.JLabel;


public class Kund_GUI extends JFrame {
	private JTextField textField;
	private JTable table;
	private String personNummer;
	JLabel lblInloggadSom;
	private static Kund_GUI singleton;
	private List<Auktion> auktionList;
	private String[] columnNames = {"Auktion", "Produktnamn", "Kategori", "Högsta bud", "Startdatum", "Slutdatum", "Utgångspris", "Maxbud", "Acceptpris", "Företag"};
	private Object[][] data = {};

	public static Kund_GUI getsingleton(String personNummer){
		if (singleton == null) {
			singleton = new Kund_GUI(personNummer);
		}
		return singleton;
	}

	private Kund_GUI(String personNummer) {
		this.personNummer = personNummer;
		setTitle("Kund_VY");
		setVisible(true);
		setBounds(100, 100, 800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);

		table = new JTable(data, columnNames);
		scrollPane.setViewportView(table);

		JButton minaBudgivningar = new JButton("Mina p\u00E5g\u00E5ende budgivningar");
		minaBudgivningar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				try {
					auktionList = JDBC_Connection.getSingleton().getAllaPagaendeAuktionerSomKundIDBudatPa(Kund_GUI.this.personNummer);
					System.out.println(Kund_GUI.this.personNummer);
					data = new Object[auktionList.size()][10];

					for (int i = 0; i < auktionList.size(); i++) {
						data[i][0] = auktionList.get(i).getAuktionsID();
						data[i][1] = auktionList.get(i).getProduktNamn();
						data[i][2] = auktionList.get(i).getKategori();
						data[i][3] = auktionList.get(i).getKund();
						data[i][4] = auktionList.get(i).getStartDatum();
						data[i][5] = auktionList.get(i).getSlutDatum();
						data[i][6] = auktionList.get(i).getUtgangsPris();
						data[i][7] = auktionList.get(i).getMaxBud();
						data[i][8] = auktionList.get(i).getAcceptPris();
						data[i][9] = auktionList.get(i).getForetag();
					}

					table.setModel(new DefaultTableModel(data, columnNames));								


				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});
		panel_1.add(minaBudgivningar);

		JButton allaAuktioner = new JButton("Alla auktioner");
		allaAuktioner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					auktionList = JDBC_Connection.getSingleton().getAllaPagaendeAuktioner();
					data = new Object[auktionList.size()][10];

					for (int i = 0; i < auktionList.size(); i++) {
						data[i][0] = auktionList.get(i).getAuktionsID();
						data[i][1] = auktionList.get(i).getProduktNamn();
						data[i][2] = auktionList.get(i).getKategori();
						data[i][3] = auktionList.get(i).getKund();
						data[i][4] = auktionList.get(i).getStartDatum();
						data[i][5] = auktionList.get(i).getSlutDatum();
						data[i][6] = auktionList.get(i).getUtgangsPris();
						data[i][7] = auktionList.get(i).getMaxBud();
						data[i][8] = auktionList.get(i).getAcceptPris();
						data[i][9] = auktionList.get(i).getForetag();
					}

					table.setModel(new DefaultTableModel(data, columnNames));									


				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		panel_1.add(allaAuktioner);

		JButton btnMeny = new JButton("Meny");
		btnMeny.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Inloggning.getInloggning().setVisible(true);
				singleton = null;
				dispose();
			}
		});
		panel_1.add(btnMeny);

		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		lblInloggadSom = new JLabel("Inloggad som: " + this.personNummer);
		panel_2.add(lblInloggadSom);

		textField = new JTextField();
		panel_2.add(textField);
		textField.setColumns(10);

		JLabel vidUppdatering = new JLabel("");

		JButton btnLggBud = new JButton("L\u00E4gg bud");
		btnLggBud.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				System.out.println(Kund_GUI.this.personNummer);
				if(!textField.getText().isEmpty()){
					if(Double.parseDouble(textField.getText()) > auktionList.get(table.getSelectedRow()).getMaxBud() && table.getSelectedRow() >= 0){			
						try {
							JDBC_Connection.getSingleton().laggTillNyttBud(auktionList.get(table.getSelectedRow()).getAuktionsID(),Kund_GUI.this.personNummer ,Double.parseDouble(textField.getText()), vidUppdatering);
						} catch (NumberFormatException e1) {
							vidUppdatering.setText("Felaktig inmatning");
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
					else{
						vidUppdatering.setText("Ditt bud måste vara högre än " + auktionList.get(table.getSelectedRow()).getMaxBud());
					}
				}
			}
		});
		panel_2.add(btnLggBud);
		panel_2.add(vidUppdatering);







	}

}
