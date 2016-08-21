package day3.dbcp;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class DBCPUtils {
	private static DataSource ds;
	static {
		try {
			Properties p = new Properties();
			InputStream in = DBCPTest.class.getClassLoader().getResourceAsStream(
					"dbcp.properties");
			p.load(in);
			// 获取连接的ds对像
			ds = BasicDataSourceFactory.createDataSource(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static DataSource getDS() {
		return ds;
	}
	public static Connection getConn() {
		Connection con = null;
		try {
			con = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
