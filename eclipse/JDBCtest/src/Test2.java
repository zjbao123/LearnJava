//import com.mysql.jdbc.Connection;
//
//import java.util.List;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//
//public class Test2 {
//	public static void main(String[] args) {
//		// createTable();
//		// insert();
//		// update();
//		// delete();
//		System.out.println(query2());
//	}
//
//	static void createTable() {
//		Connection conn = DBUtil.open();
//		String sql = "create table UserTbl(id int primary key auto_increment,name varchar(20))";
//		try {
//			Statement stmt = conn.createStatement();
//			stmt.execute(sql);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			DBUtil.close(conn);
//
//		}
//
//	}
//
//	static void insert() {
//		Connection conn = DBUtil.open();
//		String sql = "insert into UserTbl(name)values('tom')";
//		try {
//			Statement stmt = conn.createStatement();
//			stmt.executeUpdate(sql);// 增删修改都用这个
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			DBUtil.close(conn);
//
//		}
//	}
//
//	static void update() {
//		Connection conn = DBUtil.open();
//		String sql = "update UserTbl set name ='lili' where id >1";
//		try {
//			Statement stmt = conn.createStatement();
//			stmt.executeUpdate(sql);// 增删修改都用这个
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			DBUtil.close(conn);
//
//		}
//	}
//
//	static void delete() {
//		Connection conn = DBUtil.open();
//		String sql = "delete from UserTbl  where id =1";
//		try {
//			Statement stmt = conn.createStatement();
//			stmt.executeUpdate(sql);// 增删修改都用这个
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			DBUtil.close(conn);
//
//		}
//	}
//
//	static void query() {
//		Connection conn = DBUtil.open();
//		String sql = "select * from UserTbl";
//		try {
//			Statement stmt = conn.createStatement();
//			ResultSet rs = stmt.executeQuery(sql);
//			while (rs.next()) {
//				int id = rs.getInt(1);
//				String name = rs.getString(2);
//				System.out.println("id:" + id + " name:" + name);
//			}
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			DBUtil.close(conn);
//
//		}
//	}
//
//	static List<User> query2() {
//		Connection conn = DBUtil.open();
//		String sql = "select * from UserTbl";
//		try {
//			Statement stmt = conn.createStatement();
//			ResultSet rs = stmt.executeQuery(sql);
//			List<User> list = new ArrayList<User>();
//
//			while (rs.next()) {
//				int id = rs.getInt(1);
//				String name = rs.getString(2);
//				User u = new User();
//				u.setId(id);
//				u.setName(name);
//				list.add(u);
//				// System.out.println("id:"+id+ " name:"+name);
//			}
//			return list;
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			DBUtil.close(conn);
//			
//
//		}return null;
//	}
//}
