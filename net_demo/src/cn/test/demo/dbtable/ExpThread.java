package cn.test.demo.dbtable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.DatabaseMetaData;
import com.mysql.jdbc.Driver;

public class ExpThread extends Thread {
	public ExpThread() {

	}
	@Override
	public void run() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/myoa?useUnicode=true&characterEncoding=UTF-8";
			Connection con = DriverManager.getConnection(url, "root", "root");
			Statement st = con.createStatement();
			
			DatabaseMetaData dmd = (DatabaseMetaData) con.getMetaData();
			ResultSet rs = dmd.getTables(null, null, null,
					new String[] { "TABLE" });
			List<String> list = new ArrayList<String>();

			while (rs.next()) {
				String tableName = rs.getString("TABLE_NAME");
				System.out.println(">>>"+tableName);
				list.add(tableName);
			}
			
			
			
			
			
			
			
			
				con.close();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	public static void main(String[] args) {
		new ExpThread().start();
	}
}
