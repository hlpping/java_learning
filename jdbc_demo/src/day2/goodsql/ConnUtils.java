package day2.goodsql;

import java.sql.Connection;
import java.sql.DriverManager;
import org.junit.Test;

public class ConnUtils {
	
	public static Connection getConn(){		
		Connection con =null;		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/jdbc1?useUnicode=true&characterEncoding=UTF-8"; 
			con = DriverManager.getConnection(url, "root", "root");		
		} catch (Exception e) {
			e.printStackTrace();
		}				
		return con;
	}
	
	@Test
	//测试连接
	public void test(){
		Connection con = ConnUtils.getConn();
		System.out.println(con);
	}
}
