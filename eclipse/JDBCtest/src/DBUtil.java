import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Connection;

public class DBUtil {
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	static{
		Properties prop = new Properties();
		try {
			Reader in = new FileReader("src\\config.properties");
			prop.load(in);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver = prop.getProperty("driver");
		url = prop.getProperty("url");;
		username = prop.getProperty("username");;
		password = prop.getProperty("password");;
	}
public static Connection open() {
	try {
		Class.forName(driver);	
		return (Connection) DriverManager.getConnection(url,username,password);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}
public static void close(Connection conn) {
	if(conn!=null){
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
}
