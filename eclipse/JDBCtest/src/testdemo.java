//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.Driver;
//import com.mysql.jdbc.Statement;

//public class testdemo {
//public static void main(String[] args) {
//	Connection conn=DBUtil.open();
//	
//	String string ="select p_Id,p_Name from persons";
//	try {
//		Statement stmt = (Statement) conn.createStatement();
//		ResultSet  rs = stmt.executeQuery(string);
//		while(rs.next()){
//			int id = rs.getInt(1);//从一开始
//			String name = rs.getString(2);
//			System.out.println(id+" "+name);
//		}
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	DBUtil.close(conn);
//	
//}
//}
