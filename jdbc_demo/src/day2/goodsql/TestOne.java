package day2.goodsql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import org.junit.Test;

public class TestOne {	
	@Test
	public void jdbc1() throws Exception{
		Connection con = ConnUtils.getConn();
		Statement st = con.createStatement();
		String sql = "insert into users values(1,'Marry1')";
		st.executeUpdate(sql);
		con.close();
	}	
	@Test
	public void jdbc2() throws Exception{		
		// 用户登录的示例,但是没有防止SQL注入

		Scanner sc = new Scanner(System.in);
		System.err.println("Name:");
		String name = sc.nextLine();
		System.err.println("pwd:");
		String pwd = sc.nextLine();
		// 组成有效的sql语句
		String sql = "select * from users where id=" + pwd + " and name='"+ name + "'";
		System.err.println(">>>:" + sql);
		
		// 获取连接并登录测试
		Connection con = ConnUtils.getConn();		
		Statement st = con.createStatement();
		// 只有两种可能的结果
		// 1：没有记录，2：有一行记录
		ResultSet rs = st.executeQuery(sql);
		if (rs.next()) { //
			System.err.println("你登录成功...");
		} else {
			System.err.println("你登录不成功。。。。。");
		}
		con.close();
	}	
	@Test
	public void jdbc3() throws Exception{	
		// 通过Connection的preparedStatement方法获取一个予编码的statement对像
		Connection con = ConnUtils.getConn();
		String sql = "insert into users values(?,?)";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, 5);
		pst.setString(2,"Jhon'Home");
		pst.executeUpdate();
		con.close();
		System.err.println("Ok");
	}	
	@Test
	public void jdbc4() throws Exception{	
		// 用户登录的示例--改造
		Scanner sc = new Scanner(System.in);
		System.err.println("Name:");
		String name = sc.nextLine();
		System.err.println("pwd:");
		String pwd = sc.nextLine();		
		String sql = "select * from users where id=? and name=?";
		
		Connection con = ConnUtils.getConn();		
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1,Integer.parseInt(pwd));
		pst.setString(2,name);		
		
		ResultSet rs = pst.executeQuery();
		if (rs.next()) { //
			System.err.println("你登录成功...");
		} else {
			System.err.println("你登录不成功。。。。。");
		}
		con.close();
	}	
	@Test
	public void jdbc5() throws Exception{	
		Connection con = ConnUtils.getConn();		
		Statement st = con.createStatement();
		String sql = "select * from users2";
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()){
			System.err.println(rs.getTimestamp("birth1"));
		}
		con.close();
	}
}
