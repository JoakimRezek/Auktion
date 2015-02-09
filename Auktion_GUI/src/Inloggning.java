import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JButton;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Inloggning extends JFrame {

	private JPanel contentPane;
	private JComboBox<String> comboBoxLoginID;
	private JComboBox<String> comboBoxLeverant�rID;
	
	private JDBC_Connection dBConnection;

	
	public Inloggning() throws SQLException {
		
		dBConnection = JDBC_Connection.getSingleton(); 
		
		setTitle("Logga In");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JButton btnLoggaInSomKund = new JButton("Kund Login");
		btnLoggaInSomKund.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Kund_GUI(dBConnection);
				System.out.println("Loggar in som kund: " + comboBoxLoginID.getSelectedItem().toString());
			}
		});
		
		GridBagConstraints gbc_btnLoggaInSomKund = new GridBagConstraints();
		gbc_btnLoggaInSomKund.insets = new Insets(0, 0, 5, 5);
		gbc_btnLoggaInSomKund.gridx = 1;
		gbc_btnLoggaInSomKund.gridy = 0;
		contentPane.add(btnLoggaInSomKund, gbc_btnLoggaInSomKund);
		
		JButton btnLoggaInSomLeverant�r = new JButton("Leverant\u00F6r Login");
		GridBagConstraints gbc_btnLoggaInSomLeverant�r = new GridBagConstraints();
		gbc_btnLoggaInSomLeverant�r.insets = new Insets(0, 0, 5, 0);
		gbc_btnLoggaInSomLeverant�r.gridx = 7;
		gbc_btnLoggaInSomLeverant�r.gridy = 0;
		contentPane.add(btnLoggaInSomLeverant�r, gbc_btnLoggaInSomLeverant�r);
		
		comboBoxLoginID = new JComboBox<String>();
		GridBagConstraints gbc_comboBoxLoginID = new GridBagConstraints();
		gbc_comboBoxLoginID.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxLoginID.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxLoginID.gridx = 1;
		gbc_comboBoxLoginID.gridy = 1;
		for(String element : dBConnection.getAllaKundIDs()){
			comboBoxLoginID.addItem(element);
		}
		contentPane.add(comboBoxLoginID, gbc_comboBoxLoginID);
		
		comboBoxLeverant�rID = new JComboBox<String>();
		GridBagConstraints gbc_comboBoxLeverant�rID = new GridBagConstraints();
		gbc_comboBoxLeverant�rID.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxLeverant�rID.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxLeverant�rID.gridx = 7;
		gbc_comboBoxLeverant�rID.gridy = 1;		
		for(String element : dBConnection.getAllaLeverant�rIDs()){
			comboBoxLeverant�rID.addItem(element);
		}
		contentPane.add(comboBoxLeverant�rID, gbc_comboBoxLeverant�rID);		
		pack();		
	}
}
