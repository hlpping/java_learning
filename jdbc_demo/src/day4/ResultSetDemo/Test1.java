package day4.ResultSetDemo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;
import com.mchange.v2.c3p0.DataSources;
import day4.c3p0.C3p0Utils;

public class Test1 {
	@Test
	public void test() throws SQLException{
		Connection con =C3p0Utils.getConnection();
		Statement st=con.createStatement();
		String sql ="select * from stud";
		ResultSet rs=st.executeQuery(sql);
		rs.afterLast();
		while(rs.previous())
			System.out.println(rs.getString(2));
		con.close();
		DataSources.destroy(C3p0Utils.getDataSource());
	}
	@Test
	public void test2() throws SQLException{
		Connection con =C3p0Utils.getConnection();
		Statement st=con.createStatement();
		String sql ="select * from stud";
		ResultSet rs=st.executeQuery(sql);
		rs.absolute(3);
		while(rs.next())
			System.out.println(rs.getString(2));
		con.close();
		DataSources.destroy(C3p0Utils.getDataSource());
	}
	@Test
	public void test3() throws SQLException{
		Connection con =C3p0Utils.getConnection();
		Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
				  ResultSet.CONCUR_UPDATABLE);
		String sql ="select * from stud";
		ResultSet rs=st.executeQuery(sql);		
		while(rs.next()){//需要加主键
			rs.updateString(2,rs.getString(2)+"ABC");
			rs.updateRow();  //必须执行此名才可保存结果
		}			
		con.close();
		DataSources.destroy(C3p0Utils.getDataSource());
	}
}
