package day4.metadata;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import day4.c3p0.C3p0Utils;

public class DataBaseTest {
	@Test
	public void testInfo() throws SQLException{
		Connection con =C3p0Utils.getConnection();
		DatabaseMetaData md=con.getMetaData();
		System.err.println("major version of database："+md.getDatabaseMajorVersion());
		System.err.println("minor version of database : "+md.getDatabaseMinorVersion());
		System.err.println("JDBC driver's major version: "+md.getDriverMajorVersion());

		System.err.println("major JDBC version :"+md.getJDBCMajorVersion()); //3
		
		System.err.println("************************");
		//分析有多少数据库
		ResultSet rs = md.getCatalogs();
		while(rs.next()){
			System.err.println(">>"+rs.getString("TABLE_CAT"));
		}
		System.err.println("**********Table**************");
		//获取所有表
		ResultSet rs1 = md.getTables("jdbc1","jdbc1","",new String[]{"TABLE","VIEW"});
		while(rs1.next()){
			System.err.println(">>"+rs1.getString("TABLE_NAME"));
		}
		
		System.err.println("**************在此访问其他数据库**************");
		String sql2 = "select * from mydb.car";
		Statement st = con.createStatement();
		ResultSet rs3 = st.executeQuery(sql2);
		while(rs3.next()){
			System.err.println(">>>>>:"+rs3.getString("name"));
		}
		
	}
	
	
}
