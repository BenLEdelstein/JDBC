package connection;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class OracleConnection {
	public Connection con = null;
	public ResultSet rs = null;
	public Statement st;
	public PreparedStatement ps;
	
	public void dbConnection() throws Exception {
		if ( con==null || con.isClosed() ) {
			FileReader f = new FileReader("db.properties");
			Properties p = new Properties();
			p.load(f);
			Class.forName(p.getProperty("driver"));
			con = DriverManager.getConnection(p.getProperty("url"), p.getProperty("username"), p.getProperty("password"));   
		}
	}
}
