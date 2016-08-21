package day4.spring;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import day4.c3p0.C3p0Utils;

public class QueryTest {
	//注入Ds,在这个类中声明一个成员变量。
	private DataSource dataSource = C3p0Utils.getDataSource();
	
	
	/**
	 * Spring查询 
	 */
	@Test
	public void test1(){
		System.err.println("这是使用的Spring.....");
		//查询数据表
		String sql = "select * from stud";
		//2:实例化JDBCTemplate核心SPring对像
		JdbcTemplate jt=new JdbcTemplate(dataSource);
		//3:进行查询
		List<Map<String,Object>> list=jt.queryForList(sql);
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).get("NAME"));
		}		
	}
	@Test
	public void test2(){
		List<Map<String,Object>> list=getStudents();
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).get("score"));
		}
	}
	/*
	 * 使用自己的封闭的查询
	 */
//	public List<Map<String,Object>> getStudents2(){
//		DbUtils db = new DbUtils();
//		List<Map<String,Object>> list = db.query("select * from stud");
//		return list;
//	}
	
	
	/*
	 * 原始查询
	 */
	public List<Map<String,Object>> getStudents(){
		System.err.println("这是原始查询......");
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		String sql = "select * from stud";
		Connection con = null;
		Statement st = null;
		try{
			con = dataSource.getConnection();
			st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				Map<String,Object> m = new HashMap<String, Object>();
				m.put("id", rs.getString("id"));
				m.put("name", rs.getString("NAME"));
				m.put("les", rs.getString("les"));
				m.put("score", rs.getString("score"));
				list.add(m);
			}
		}catch(SQLException e){
			throw new RuntimeException(e.getMessage(),e);
		}finally{
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
