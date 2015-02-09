package com.jbay;
import java.awt.EventQueue;

import com.jbay.view.Inloggning;


public class Auktion_Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					Kund_GUI frame = new Kund_GUI();
//					frame.setVisible(true);
					Inloggning inloggning = new Inloggning();
					inloggning.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}