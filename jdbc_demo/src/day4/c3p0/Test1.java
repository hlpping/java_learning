package day4.c3p0;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;

public class Test1 {

	@Test
	public void jdbc1() throws Exception {
		ComboPooledDataSource ds = new ComboPooledDataSource();
		// 设置参数
		ds.setDriverClass("com.mysql.jdbc.Driver");
		ds.setUser("root");
		ds.setPassword("root");
		ds.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/jdbc1?useUnicode=true&characterEncoding=UTF-8");

		// 测试是否连接上了
		Connection con = ds.getConnection();
		System.out.println("con: " + con);
		DataSources.destroy(ds); // 关闭所有数据连接
	}

	@Test
	public void jdbc2() throws Exception {
		//加载配置文件,添加参数为参数的,否则为默认
//		ComboPooledDataSource ds = new ComboPooledDataSource();
		ComboPooledDataSource ds = new ComboPooledDataSource("sss");
		Connection con = ds.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from users");
		while (rs.next()) {
			System.err.println(rs.getString("name"));
		}
		DataSources.destroy(ds);
	}
	
	@Test
	public void jdbc3() throws Exception {
		//利用静态工厂方法 测试
		Connection con = null;
		long s = System.currentTimeMillis();
		for(int i=1;i<=1000;i++){
			con = C3p0Utils.getConnection();
			System.err.println(i+">"+con);
			con.close();
		}
		long e = System.currentTimeMillis();
		System.err.println(e-s);
		DataSources.destroy(C3p0Utils.getDataSource());
	}
}
