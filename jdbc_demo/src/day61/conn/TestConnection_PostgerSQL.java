package day61.conn;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.junit.Test;

public class TestConnection_PostgerSQL {
	/**
	 * 此方法用来测试mysql中获得数据库,表的方法.
	 * @throws Exception
	 */
	@Test
	public void testDatabasesAndTables1() throws Exception{
		Class.forName("org.postgresql.Driver");
		String url = "jdbc:postgresql://10.6.156.192/crsmonitor"; 
		Connection con = DriverManager.getConnection(url, "hotel", "hotel");
		System.err.println("getConnection: "+con);
		
		/** 获得数据库的集合*/
		DatabaseMetaData databaseMetaData= con.getMetaData();
		ResultSet catalogsResultSet =databaseMetaData.getCatalogs();
		while(catalogsResultSet.next()){
			// 数据库名称
			String catalog = catalogsResultSet.getString("TABLE_CAT"); 
			System.out.println(catalog);
		}
		System.out.println("-------------------------------");
		
		/** 获得jdbc1数据库中表的集合*/
		String[] types = { "TABLE" };
		ResultSet tablesResultSet =databaseMetaData.getTables("jdbc1", null, null, types);
		while(tablesResultSet.next()){
			// 数据库表名称
			String tables = tablesResultSet.getString("TABLE_NAME"); 
			System.out.println(tables);
		}
		con.close();
		
	}
	
	@Test
	public void testDatabasesAndTables2() throws Exception{
		Class.forName("org.postgresql.Driver");
		String url = "jdbc:postgresql://10.6.156.192/crsmonitor"; 
		Connection con = DriverManager.getConnection(url, "hotel", "hotel");
		System.err.println("getConnection: "+con);
		
		/** 获得数据库的集合*/
		DatabaseMetaData databaseMetaData= con.getMetaData();
		ResultSet catalogsResultSet =databaseMetaData.getCatalogs();
		while(catalogsResultSet.next()){
			// 数据库名称
			String catalog = catalogsResultSet.getString("TABLE_CAT"); 
			System.out.println(catalog);
			String[] types = { "TABLE" };
			ResultSet tablesResultSet =databaseMetaData.getTables(catalog, null, null, types);
			while(tablesResultSet.next()){
				// 数据库表名称
				String tables = tablesResultSet.getString("TABLE_NAME"); 
				System.out.println(catalog+"\t : \t"+tables);
			}
			System.out.println("-------------------------------");
		}
		con.close();
		
	}
	@Test
	public void typeOfConlumn() throws Exception{
		Class.forName("org.postgresql.Driver");
		String url = "jdbc:postgresql://10.6.156.192/crsmonitor"; 
		Connection con = DriverManager.getConnection(url, "hotel", "hotel");
		System.err.println("getConnection: "+con);
		
		
		String sql ="select * from crsmonitor.action ";
		
		PreparedStatement  statment=con.prepareStatement(sql);
		ResultSet resultSet =statment.executeQuery();
//		ResultSetMetaData resultSetMetaData=statment.getResultSet().getMetaData();
		ResultSetMetaData resultSetMetaData=statment.getMetaData();
//		ResultSetMetaData resultSetMetaData=resultSet.getMetaData();
		
		int num =resultSetMetaData.getColumnCount();
		for(int i =1 ;i<=num;i++){
			String name=resultSetMetaData.getColumnName(i);
			String type=resultSetMetaData.getColumnTypeName(i);
			System.out.println(name+":"+type);
		}
		
		con.close();
	}
	
	@Test
	public void dataOfConlomn() throws Exception{
		Class.forName("org.postgresql.Driver");
		String url = "jdbc:postgresql://10.6.156.192/crsmonitor"; 
		Connection con = DriverManager.getConnection(url, "hotel", "hotel");
		System.err.println("getConnection: "+con);
		
		
		String sql ="select * from crsmonitor.action ";
		
		PreparedStatement  statment=con.prepareStatement(sql);
		ResultSet resultSet =statment.executeQuery();
		ResultSetMetaData resultSetMetaData=statment.getResultSet().getMetaData();
		
		int num =resultSetMetaData.getColumnCount();
		for(int i =1 ;i<=num;i++){
			String name=resultSetMetaData.getColumnName(i);
			String type=resultSetMetaData.getColumnTypeName(i);
			System.out.println(name+":"+type);
		}
		System.out.println("-----------------");
		
		while(resultSet.next()){
			for(int i=1;i<=num;i++){
				System.out.print(resultSet.getString(i)+"\t");
			}
			System.out.println();
		}
		
		con.close();
	}
}
