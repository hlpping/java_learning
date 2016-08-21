package day2.connect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

public class Test1 {
	public static void main(String[] args) throws Exception {
		readUsers();
		readStud();
	}	
	public static void readUsers() throws Exception{	
		Connection con = DbUtils.getConn();
		System.out.println(con);
		try {
			String sql = "select * from users";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				System.err.println(">>:" + rs.getString("name"));
			}
		}catch (Exception e) {
			e.printStackTrace();
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
		con.close();
	}
}
