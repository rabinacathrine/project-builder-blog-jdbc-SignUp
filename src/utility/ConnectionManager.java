package utility;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {

	public Connection getConnection() throws SQLException, ClassNotFoundException {
		//Register the driver class
		Class.forName("oracle.jdbc.OracleDriver");
//		driver = oracle.jdbc.OracleDriver
//				url=jdbc:oracle:thin:@localhost:1521:orcl
		//Create the connection object
		Connection con = null;
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","rabina98");
			
		if(con!=null)
			System.out.println("Established");
		return con;
	}
	public static Properties loadPropertiesFile() throws Exception {
		Properties prop = new Properties();	
		InputStream in =  ConnectionManager.class.getClassLoader().getResourceAsStream("jdbc.properties");
		prop.load(in);
		in.close(); 
		return prop;
	}
}



