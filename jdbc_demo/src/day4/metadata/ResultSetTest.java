package day4.metadata;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.junit.Test;

import day4.c3p0.C3p0Utils;

public class ResultSetTest {
	@Test
	public void testInfo() throws SQLException{
		Connection con = C3p0Utils.getConnection();
		Statement st = con.createStatement();
		// 声明一个Sql语句
		
//		System.err.println("请您 输入要查询的表:");
//		Scanner sc = new Scanner(System.in);
//		String name = sc.nextLine();
		
//		String sql = "select * from "+name;
		String sql = "select * from stud";
		ResultSet rs = st.executeQuery(sql);
		// 获取表的源数据
		ResultSetMetaData rsmd = rs.getMetaData();
		// 分析此表有几列,从1开始。
		int cols = rsmd.getColumnCount();
		for(int i=1;i<=cols;i++){
			System.err.print(rsmd.getColumnName(i)+"\t");
		}
		System.err.println("\n**********************");
		while(rs.next()){
			for(int i=1;i<=cols;i++){
				System.err.print(rs.getString(i)+"\t");
			}
			System.err.println();
		}
		
	}
}
