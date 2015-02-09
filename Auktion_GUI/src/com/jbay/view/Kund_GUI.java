package com.jbay.view;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;


public class Kund_GUI extends JFrame {
	
	public Kund_GUI(String PersonNummer) {
		setTitle("Kund_VY");
		setVisible(true);
		setBounds(100, 100, 800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0};
		gridBagLayout.rowHeights = new int[]{0};
		gridBagLayout.columnWeights = new double[]{Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);

	}

}
