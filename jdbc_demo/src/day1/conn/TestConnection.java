package day1.conn;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import com.mysql.jdbc.Driver;

/**
 * 	连接数据库
 *  1:加载驱动类
 *  2:使用DriverManager的getConnection方法建立数据连接
 *  	String url = "jdbc:mysql://127.0.0.1:3306/jdbc1"; 
 *  	java.sql.Connection
 * 		 一定要记得关闭连接
 *  3:开始操作数据库
 *   
 *   1:通过加载驱动类,连接数据库
		依赖的是字符串,可以通过properties文件设置
	 2:通过注册的方式加载一个驱动类,连接数据库
		此方法依赖第三方jar即com.mysql.jdbc.Driver
     3.简单的数据连接 JDBC规范 
 		MySqlDriver implements java.sql.Driver{ 
 			static{
 				DriverManager.registerDriver(new Driver()); 
 			}
 		}
 * @author shuang
 * @version 1.0 Oct 28, 2011
 */
public class TestConnection {
	@Test
	public void jdbcTest1() throws Exception{
		//1:通过加载驱动类,连接数据库
		//依赖的是字符串,可以通过properties文件设置
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://127.0.0.1:3306/jdbc1"; 
		Connection con = DriverManager.getConnection(url, "root", "root");
		System.err.println("getConnection: "+con);
		con.close();
	}
	@Test
	public void jdbcTest2() throws Exception{
		// 2:通过注册的方式加载一个驱动类,连接数据库
		//此方法依赖第三方jar即com.mysql.jdbc.Driver
		DriverManager.registerDriver(new Driver());
		String url = "jdbc:mysql://127.0.0.1:3306/jdbc1";
		Connection con = DriverManager.getConnection(url, "root", "root");
		System.err.println("registerDriver: " + con);
		con.close();
	}
	
	
	
	
}
