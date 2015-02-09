import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;


public class Leverantör_GUI extends JFrame {

	private JPanel contentPane;
	private JDBC_Connection db;
	private JTextField textField;
	private String Leverantör;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	
	public Leverantör_GUI(String Leverantör) throws SQLException {
		this.Leverantör = Leverantör;
		db = JDBC_Connection.getSingleton();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNyOrder = new JLabel("Ny Auktion");
		panel.add(lblNyOrder);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JLabel lblSlutdatum = new JLabel("Startdatum:");
		panel.add(lblSlutdatum);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblStuff = new JLabel("Slutdatum:");
		panel.add(lblStuff);
		
		textField_1 = new JTextField();
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblStartpris = new JLabel("Utg\u00E5ngspris:");
		panel.add(lblStartpris);
		
		textField_2 = new JTextField();
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Acceptpris:");
		panel.add(lblNewLabel);
		
		textField_3 = new JTextField();
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblProduktnamn = new JLabel("Produktnamn:");
		panel.add(lblProduktnamn);
		
		textField_4 = new JTextField();
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblProduktkategori = new JLabel("Produktkategori:");
		panel.add(lblProduktkategori);
		
		JComboBox comboBox = new JComboBox();
		panel.add(comboBox);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		JButton btnSkapaAuktion = new JButton("Skapa Auktion");
		panel.add(btnSkapaAuktion);
	}

}
