package day62.conn;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TestSchema {
	public static void main(String[] args) throws Exception {
		Class.forName("org.apache.derby.jdbc.ClientDriver");
		String url = "jdbc:derby://172.22.15.228:1531/sys_config"; 
		Connection con = DriverManager.getConnection(url, "derby", "test.db");
		System.err.println("getConnection: "+con);
		
		/** 获得数据库的集合*/
		DatabaseMetaData databaseMetaData= con.getMetaData();
		ResultSet catalogsResultSet =databaseMetaData.getSchemas();	//获得模式
		
		List<String> catalogsList = new ArrayList<String>();
		while(catalogsResultSet.next()){
			List<String> tableList = new ArrayList<String>();
			// 数据库名称
			String catalog = catalogsResultSet.getString("TABLE_SCHEM"); 
			catalogsList.add(catalog);
			
//			System.out.println(catalog);
			String[] types = { "TABLE" };
			ResultSet tablesResultSet =databaseMetaData.getTables(catalog, null, null, types);
			while(tablesResultSet.next()){
				// 数据库表名称
				String tables = tablesResultSet.getString("TABLE_NAME"); 
//				System.out.println(catalog+"\t : \t"+tables);
				tableList.add(catalog+"."+tables);
			}
			System.out.println("-------------------------------");
			if(tableList.size()>0){
				System.out.println(catalog);
				for(int i=0;i<tableList.size();i++){
					System.out.println(tableList.get(i));
				}
			}
			System.out.println(catalogsList.size());
		}
		
		con.close();

	}

}
