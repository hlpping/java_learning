package day3.dbcp;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

public class DBCPTest {
	@Test
	public void jdbc1() throws Exception{
		String url = "jdbc:mysql://127.0.0.1:3306/jdbc1?useUnicode=true&characterEncoding=UTF-8";
		String driver = "com.mysql.jdbc.Driver";
		
		//1:使用一个类：
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl(url);
		dataSource.setDriverClassName(driver);
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		//2:测试是否连接成功。
		Connection con =dataSource.getConnection();
		System.out.println(con);
	    //3:获取st对像
		Statement st = con.createStatement();		
		ResultSet rs = st.executeQuery("select * from stud");
		while(rs.next()){
			System.err.println(rs.getString("name"));
		}		
		dataSource.close();
	}
	
	@Test
	public void jdbc2() throws Exception{
		///加载资源文件
		Properties p = new Properties();
		InputStream in = DBCPTest.class.getClassLoader().getResourceAsStream("dbcp.properties");
		p.load(in);
		
		//获取连接的ds对像
		DataSource ds =BasicDataSourceFactory.createDataSource(p);		
		Connection con =ds.getConnection();
		System.out.println(con);
		
		Statement st =con.createStatement();
		ResultSet rs=st.executeQuery("select * from stud");
		while(rs.next()){
			System.out.println(rs.getString("name"));
		}		
	}
	
	@Test
	public void jdbc3() throws Exception{
		//使用Spring进行查询
		JdbcTemplate jdbc = new JdbcTemplate(DBCPUtils.getDS());
		String sql = "select * from stud";
		List<Map<String,Object>> list = jdbc.queryForList(sql);
		System.err.println(list);
		
	}
}
