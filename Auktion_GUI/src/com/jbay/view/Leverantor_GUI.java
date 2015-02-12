package com.jbay.view;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import java.awt.GridLayout;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;

import com.jbay.controller.JDBC_Connection;
import com.jbay.model.Auktion;
import com.jbay.model.Bud;

import java.awt.Font;

import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;


public class Leverantor_GUI extends JFrame {

	private static Leverantor_GUI singleton;

	public static Leverantor_GUI getSingleton(String leverantor) throws SQLException{
		if(singleton == null) singleton = new Leverantor_GUI(leverantor);
		return singleton;
	}


	private JPanel mainPane;
	private JDBC_Connection db;
	private JTextField startdatumField;
	private String leverantor;
	private JTextField slutdatumField;
	private JTextField utgangsprisField;
	private JTextField acceptprisField;
	private JTextField produktField;
	private JTable budTable;
	private JTable auktionTable;
	private Object[][] budTableData;
	private DefaultTableModel budModel;
	private DefaultTableModel auktionModel;
	private ArrayList<Bud> budList;
	private Object[][] auktionTableData;

	private Leverantor_GUI(String leverantor) throws SQLException {
		this.leverantor = leverantor;
		this.setResizable(false);
		db = JDBC_Connection.getSingleton();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 980, 700);
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

		utgangsprisField = new JTextField();
		nyAuktionPane.add(utgangsprisField);
		utgangsprisField.setColumns(10);

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
			try {
				db.skapaAuktion(startdatumField.getText(), Double.parseDouble(utgangsprisField.getText()), 
						Double.parseDouble(acceptprisField.getText()), slutdatumField.getText(), produktField.getText(),
						kategoriBox.getSelectedItem().toString(), leverantor);
				this.uppdateraAuktionLista();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		nyAuktionPane.add(btnSkapaAuktion);

		JPanel auktionPane = new JPanel();
		mainPane.add(auktionPane, BorderLayout.WEST);
		String[] auktionColumnNames = {"Auktion", "Produktnamn", "H\u00F6gsta bud", "Startdatum", "Slutdatum", "Utg\u00E5ngspris",
				"Acceptpris", "F\u00F6retag","Kategori"};
		auktionModel = new DefaultTableModel(auktionTableData, auktionColumnNames);
		auktionTable = new JTable(auktionModel){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {                
				return false;               
			};
		};

		auktionTable.getColumnModel().getColumn(0).setMinWidth(30);
		auktionTable.getColumnModel().getColumn(1).setMinWidth(120);
		auktionTable.getColumnModel().getColumn(2).setMinWidth(70);
		auktionTable.getColumnModel().getColumn(3).setMinWidth(95);
		auktionTable.getColumnModel().getColumn(4).setMinWidth(95);
		auktionTable.getColumnModel().getColumn(5).setMinWidth(70);
		auktionTable.getColumnModel().getColumn(6).setMinWidth(70);
		auktionTable.getColumnModel().getColumn(7).setMinWidth(80);
		auktionTable.getColumnModel().getColumn(8).setMinWidth(80);
		auktionPane.setLayout(new BorderLayout(0, 0));
		JScrollPane scrollPane = new JScrollPane(auktionTable);
		scrollPane.setPreferredSize(new Dimension(700,100));
		auktionPane.add(scrollPane);

		JLabel auktionsLbl = new JLabel("Dina Auktioner");
		auktionsLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		auktionsLbl.setHorizontalAlignment(SwingConstants.CENTER);
		auktionPane.add(auktionsLbl, BorderLayout.NORTH);

		JButton btnTillbaka = new JButton("Tillbaka");
		btnTillbaka.addActionListener(e ->{
			Inloggning.getInloggning().setVisible(true);
			dispose();
			singleton = null;
		});
		mainPane.add(btnTillbaka, BorderLayout.SOUTH);

		JPanel budTablePane = new JPanel();
		mainPane.add(budTablePane, BorderLayout.EAST);
		String[] budColumnNames = {"F\u00F6rnamn", "Efternamn", "Bud"};

		budList = new ArrayList<Bud>();
		budTableData = new Object[budList.size()][3];

		budModel = new DefaultTableModel(budTableData, budColumnNames);
		budTable = new JTable(budModel){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {                
				return false;               
			};
		};
		budTable.getColumnModel().getColumn(0).setMinWidth(10);
		budTable.getColumnModel().getColumn(1).setMinWidth(10);
		budTable.getColumnModel().getColumn(2).setMinWidth(10);
		budTablePane.setLayout(new BorderLayout(0, 0));
		JScrollPane budScrollPane = new JScrollPane(budTable);
		budScrollPane.setPreferredSize(new Dimension(250,100));
		budTablePane.add(budScrollPane);

		JLabel budLbl = new JLabel("Bud");
		budLbl.setHorizontalAlignment(SwingConstants.CENTER);
		budLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		budTablePane.add(budLbl, BorderLayout.NORTH);

		auktionTable.getSelectionModel().addListSelectionListener(e -> {

			try {
				budList = db.getBudFranAuktion(auktionTableData[auktionTable.getSelectedRow()][0].toString());
				budTableData = new Object[budList.size()][3];
				budModel.setRowCount(0);
				for(int i = 0; i < budList.size(); i++){
					budModel.addRow(new Object[] {
							budList.get(i).getFornamn(), 
							budList.get(i).getEfternamn(), 
							budList.get(i).getPris()});
				}
				if(budList.size() == 0){
					budModel.addRow(new Object[] {
							"Inga bud", 
							"", 
							""});
				}

			} catch (Exception e1) {
				e1.printStackTrace();
			}

		});

		this.uppdateraAuktionLista();

	}

	private void uppdateraAuktionLista(){

		ArrayList<Auktion> auktionList;
		try {
			auktionList = db.getAllaPagaendeAuktionerSomLeverantorIDBudatPa(leverantor);
			auktionTableData = new Object[auktionList.size()][9];
			auktionModel.setRowCount(0);
			for(int i = 0; i < auktionList.size(); i++){
				auktionModel.addRow(new Object[] {
						auktionList.get(i).getAuktionsID(), 
						auktionList.get(i).getProduktNamn(), 
						auktionList.get(i).getMaxBud(),
						auktionList.get(i).getStartDatum(),
						auktionList.get(i).getSlutDatum(),
						auktionList.get(i).getUtgangsPris(),
						auktionList.get(i).getAcceptPris(),
						auktionList.get(i).getForetag(),
						auktionList.get(i).getKategori()
				});
				auktionTableData[i][0] = auktionList.get(i).getAuktionsID();
				auktionTableData[i][1] = auktionList.get(i).getProduktNamn();
				auktionTableData[i][2] = auktionList.get(i).getMaxBud();
				auktionTableData[i][3] = auktionList.get(i).getStartDatum();
				auktionTableData[i][4] = auktionList.get(i).getSlutDatum();
				auktionTableData[i][5] = auktionList.get(i).getUtgangsPris();
				auktionTableData[i][6] = auktionList.get(i).getAcceptPris();
				auktionTableData[i][7] = auktionList.get(i).getForetag();
				auktionTableData[i][8] = auktionList.get(i).getKategori();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}


	}


}
