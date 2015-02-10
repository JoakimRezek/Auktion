package com.jbay.view;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class Kund_GUI extends JFrame {
	private JTextField textField;
	private JTable table;
	private static Kund_GUI singleton;
	
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
		
		JButton btnMinaPgendeBudgivningar = new JButton("Mina p\u00E5g\u00E5ende budgivningar");
		panel_1.add(btnMinaPgendeBudgivningar);
		
		JButton btnAllaAuktioner = new JButton("Alla auktioner");
		panel_1.add(btnAllaAuktioner);
		
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
