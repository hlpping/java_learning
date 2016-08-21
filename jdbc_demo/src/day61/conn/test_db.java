package day61.conn;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class test_db {
	public static void main(String[] args) throws Exception {
		Class.forName("org.postgresql.Driver");
		String url = "jdbc:postgresql://10.6.155.93:5432/hotelpg", user = "crsmonitor", pass = "crsmonitor";
		
		Connection conn = DriverManager.getConnection(url, user, pass);		
		DatabaseMetaData dmd = conn.getMetaData();
		ResultSet rs = dmd.getColumns(null, "crsmonitor", "action", null);
		ResultSetMetaData rsmd = rs.getMetaData();
		
		
		int cols = rsmd.getColumnCount();
		for (int i = 0; i < cols; i++)
			System.out.format("%4d. %s%n", (i + 1), rsmd.getColumnName(i + 1));
		int cnt = 0;
		while (rs.next()) {
			String name = rs.getString("COLUMN_NAME"), type = rs
					.getString("TYPE_NAME");
			System.out.format("%4d. %20s - %20s%n", ++cnt, name, type);
		}
	}
}