package day2.pool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test1 {
	public static void main(String[] args) throws Exception {
		readUsers();
		readStud();
		readUsers();
		readStud();
		readUsers();
		readStud();
	}	
	public static void readUsers() throws Exception{	
		Connection con = DbUtils.getConn();
//		System.out.println(con);
		try {
			String sql = "select * from users";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				System.err.println(">>:" + rs.getString("name"));
			}		
		}finally {
			System.err.println("开始关闭");
			System.err.println("我是:"+con);
			con.close();
		}
	}
	public static void readStud() throws Exception {
		Connection con = DbUtils.getConn();
		String sql = "select * from stud";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			System.err.println("<<:" + rs.getString("NAME"));
		}
		System.err.println("我是:"+con);
		con.close();
	}
}
