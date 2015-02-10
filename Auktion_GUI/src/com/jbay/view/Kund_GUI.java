package com.jbay.view;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.jbay.model.Auktion;


public class Kund_GUI extends JFrame {
	private JTextField textField;
	private JTable table;
	private static Kund_GUI singleton;
	private List<Auktion> auktionList;
	private Object[][] data = {};
	
	public static Kund_GUI getsingleton(String personNummer){
		if (singleton == null) {
			singleton = new Kund_GUI(personNummer);
		}
		return singleton;
	}
	
	private Kund_GUI(String personNummer) {
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
		
		JButton minaBudgivningar = new JButton("Mina p\u00E5g\u00E5ende budgivningar");
		minaBudgivningar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_1.add(minaBudgivningar);
		
		JButton allaAuktioner = new JButton("Alla auktioner");
		allaAuktioner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_1.add(allaAuktioner);
		
		JButton btnMeny = new JButton("Meny");
		btnMeny.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Inloggning.getInloggning().setVisible(true);
			}
		});
		panel_1.add(btnMeny);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		textField = new JTextField();
		panel_2.add(textField);
		textField.setColumns(10);
		
		JButton btnLggBud = new JButton("L\u00E4gg bud");
		btnLggBud.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_2.add(btnLggBud);
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);

	}

}
