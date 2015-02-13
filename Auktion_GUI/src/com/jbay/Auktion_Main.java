package com.jbay;
import java.awt.EventQueue;

import javax.swing.UIManager;

import com.jbay.view.Inloggning;

import de.javasoft.plaf.synthetica.SyntheticaBlackEyeLookAndFeel;


public class Auktion_Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new SyntheticaBlackEyeLookAndFeel());
					Inloggning.getInloggning().setVisible(true);
					
					//Test Area
//					JDBC_Connection dBConnection = JDBC_Connection.getSingleton();
//					dBConnection.läggTillNyttBud("1", "900209-2937", 234);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}