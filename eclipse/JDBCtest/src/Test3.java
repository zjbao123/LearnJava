import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.management.Query;

import com.mysql.jdbc.Connection;

public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(query());

	}

	static List<User> query() {
		Connection conn = DBUtil.open();
		String sql = "select id ,name from usertbl";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			List<User> users = new ArrayList<User>();
			while (rs.next()) {
					int id = rs.getInt(1);
					String name  = rs.getString(2);
					User a = new User();
					a.setId(id);
					a.setName(name);
					users.add(a);
			}
			return users;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		return null ;
	}

}
	