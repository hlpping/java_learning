package day1.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import org.junit.Test;

public class TestFunction {
	@Test
	public void jdbcTest3() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://127.0.0.1:3306/jdbc1?useUnicode=true&characterEncoding=UTF-8"; 
		Connection con = DriverManager.getConnection(url, "root", "root");
		// 获取Statement语句执行对像
		Statement st = con.createStatement();	
		// String sql = "insert into stud values(5,'RRR','JavaScript',10)";
		// String sql = "update stud set name='JackJack' where id=5";
		// String sql = "delete from stud where id=5";
		String sql = "select * from stud";		

		// 执行已经声明的语句
		// 返回的boolean是指，是否包含结果集。
		// 所以，只有当执行select时，才会返回真，其他全部是false
		boolean boo = st.execute(sql);
		System.err.println("boo is :" + boo);
		if (boo == true) {
			// 只有当boo为真时，才可以通过getResultSet的方式获取结果集
			ResultSet rs = st.getResultSet();
			while (rs.next()) {				// Object o = rs.getObject(2);
				System.err.println(rs.getObject("id") + ","
						+ rs.getObject("name") + "," + rs.getObject("les"));
			}
		}
		// st.close();
		con.close();		
	}
	
	@Test
	public void jdbcTest4() throws Exception{
		
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://127.0.0.1:3306/jdbc1?useUnicode=true&characterEncoding=UTF-8"; 
		Connection con = DriverManager.getConnection(url, "root", "root");
		
		Statement st = con.createStatement();
		String sql2 = "insert into stud values(8,'中国A','编程A',90)";
		st.execute(sql2);

		String sql = "select * from stud";
		// 对于查询，请必须使用excuteQuery方法。
		//此文件只可以执行select语句,并直接返回ResultSet结果集
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			System.err.println(">>>>" + rs.getString("id") + ","+ rs.getString("name"));
		}
		rs.close();
		st.close();
		con.close();
	}
	
	@Test
	public void jdbcTest5() throws Exception{
		
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://127.0.0.1:3306/jdbc1?useUnicode=true&characterEncoding=UTF-8"; 
		Connection con = DriverManager.getConnection(url, "root", "root");		
		Statement st = con.createStatement();
		
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.err.println("plz enter name:");
			String name = sc.next();
			if(name.equals("0")){
				break;
			}
			System.err.println("plz enter lessions:");
			String les = sc.next();
			System.err.println("plz eneter id:");
			String id = sc.next();
			System.err.println("Score:");
			String score = sc.next();
			//注意sql语句的格式
			String sql = "insert into stud values(" + id + ",'" + name + "','"
					+ les + "'," + score + ")";
			System.err.println("你要执行的SQL>>>:" + sql);
			st.execute(sql);
		}
		con.close();	
	}
}
