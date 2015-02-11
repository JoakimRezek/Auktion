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
	private DefaultTableModel model;
	private ArrayList<Bud> budList;
	
	private Leverantor_GUI(String leverantor) throws SQLException {
		this.leverantor = leverantor;
		this.setMinimumSize(new Dimension(600,400));
		db = JDBC_Connection.getSingleton();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 682, 600);
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
			System.out.println("pushed");
		});
		nyAuktionPane.add(btnSkapaAuktion);
		
		JPanel auktionPane = new JPanel();
		mainPane.add(auktionPane, BorderLayout.WEST);
		System.out.println(leverantor);
		ArrayList<Auktion> auktionList = db.getAllaPagaendeAuktionerSomLeverantorIDBudatPa(leverantor);
		Object[][] tableData = new Object[auktionList.size()][9];
		String[] columnNames = {"Auktion", "Produktnamn", "H\u00F6gsta bud", "Startdatum", "Slutdatum", "Utg\u00E5ngspris", "Acceptpris", "F\u00F6retag","Kategori"};
		for(int i = 0; i < auktionList.size(); i++){
			tableData[i][0] = auktionList.get(i).getAuktionsID();
			tableData[i][1] = auktionList.get(i).getProduktNamn();
			tableData[i][2] = auktionList.get(i).getMaxBud();
			tableData[i][3] = auktionList.get(i).getStartDatum();
			tableData[i][4] = auktionList.get(i).getSlutDatum();
			tableData[i][5] = auktionList.get(i).getUtgangsPris();
			tableData[i][6] = auktionList.get(i).getAcceptPris();
			tableData[i][7] = auktionList.get(i).getForetag();
			tableData[i][8] = auktionList.get(i).getKategori();
		}
		
		auktionTable = new JTable(tableData,columnNames){
	        private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	                return false;               
	        };
	    };
	    auktionTable.getColumnModel().getColumn(0).setMinWidth(20);
	    auktionTable.getColumnModel().getColumn(1).setMinWidth(80);
	    auktionTable.getColumnModel().getColumn(2).setMinWidth(50);
	    auktionTable.getColumnModel().getColumn(3).setMinWidth(70);
	    auktionTable.getColumnModel().getColumn(4).setMinWidth(70);
	    auktionTable.getColumnModel().getColumn(5).setMinWidth(50);
	    auktionTable.getColumnModel().getColumn(6).setMinWidth(50);
	    auktionTable.getColumnModel().getColumn(7).setMinWidth(60);
	    auktionTable.getColumnModel().getColumn(8).setMinWidth(60);
		auktionPane.setLayout(new BorderLayout(0, 0));
		JScrollPane scrollPane = new JScrollPane(auktionTable);
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
		String[] budColumnNames = {"F\u00F6rnamn", "Efternamn", "Pris"};
		
		budList = new ArrayList<Bud>();
		budTableData = new Object[budList.size()][3];
		
		for(int i = 0; i < budList.size(); i++){
			budTableData[i][0] = budList.get(i).getFornamn();
			budTableData[i][1] = budList.get(i).getEfternamn();
			budTableData[i][2] = budList.get(i).getPris();
		}
		
		model = new DefaultTableModel(budTableData, budColumnNames);
		budTable = new JTable(model){
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
		budScrollPane.setPreferredSize(new Dimension(200,100));
		budTablePane.add(budScrollPane);
		
		JLabel budLbl = new JLabel("Bud");
		budLbl.setHorizontalAlignment(SwingConstants.CENTER);
		budLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		budTablePane.add(budLbl, BorderLayout.NORTH);
		
		auktionTable.getSelectionModel().addListSelectionListener(e -> {
			
			try {
				budList = db.getBudFranAuktion(tableData[auktionTable.getSelectedRow()][0].toString());
				budTableData = new Object[budList.size()][3];
				model.setRowCount(0);
				for(int i = 0; i < budList.size(); i++){
					model.addRow(new Object[] {
							budList.get(i).getFornamn(), 
							budList.get(i).getEfternamn(), 
							budList.get(i).getPris()});
				}
//			    model.fireTableDataChanged();
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
		});
		
		
	}

	
}
