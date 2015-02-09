import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class JDBC_Connection {

	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	private static final String CONNECTIONSTRING = "jdbc:mysql://localhost/auktion";
	
	private static JDBC_Connection singleton;

	private Connection conn;

	private JDBC_Connection() throws SQLException {
		conn = DriverManager.getConnection(CONNECTIONSTRING, USERNAME, PASSWORD);
		System.out.println("Connected to DB");
	}
	
	public static JDBC_Connection getSingleton() throws SQLException{
		if(singleton == null){
			singleton = new JDBC_Connection();			
		}
		System.out.println("Singleton tillagd");
		return singleton;		
	}

	public ArrayList<String> getAllaKundIDs() throws SQLException{

		ArrayList<String> arrAllaKundIDs = new ArrayList<>();

		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery("SELECT PersonNummer FROM Kund");

		while(rs.next()){
			arrAllaKundIDs.add(rs.getString("Personnummer"));
		}

		stm.close();
		rs.close();
		return arrAllaKundIDs;			
	}
	
	public ArrayList<String> getAllaLeverantörIDs() throws SQLException{

		ArrayList<String> arrAllaLeverantörIDs = new ArrayList<>();

		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery("SELECT Organisationsnummer FROM Leverantör");

		while(rs.next()){
			arrAllaLeverantörIDs.add(rs.getString("Organisationsnummer"));
		}

		stm.close();
		rs.close();
		return arrAllaLeverantörIDs;			
	}	
}