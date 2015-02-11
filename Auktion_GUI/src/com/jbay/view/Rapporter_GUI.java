package com.jbay.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Rapporter_GUI extends JFrame {

	private JPanel contentPane;
	private static Rapporter_GUI singleton;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
