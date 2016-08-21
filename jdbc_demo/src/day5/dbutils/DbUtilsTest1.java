package day5.dbutils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.KeyedHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import day4.c3p0.C3p0Utils;
/**
 * DbUtils的方法,如增删改,和各种方式的查询
 * @author shuang
 * @version 1.0 Oct 30, 2011
 */
public class DbUtilsTest1 {
	@Test
	public void mapListTest() throws SQLException{
		// 简单查询
		// 1:声明Sql
		// 2:初始化一个QueryRunner,不要忘记传参数
		// 调用它的query方法进行查询
		// 第二个参数：是指返回什么类型。
		String sql ="select * from stud";
		QueryRunner run =new QueryRunner(C3p0Utils.getDataSource());
		List<Map<String, Object>> list=run.query(sql, new MapListHandler());
		System.out.println(list);
	}
	@Test
	public void paramBeanTest2() throws SQLException{
		String sql = "select * from student where id=?";
		QueryRunner run = new QueryRunner(C3p0Utils.getDataSource());
		Student stud = (Student) run.query(sql, new BeanHandler(Student.class), 3);
		System.err.println("<<<<:" + stud);		
	}
	@Test
	public void insertTest3() throws SQLException{
		QueryRunner run = new QueryRunner(C3p0Utils.getDataSource());
//		String sql = "insert into student values (?,?,?,?)";
//		run.update(sql,5,"marry","sql",34);
		
//		String sql = "delete from student where id= ? ";
//		run.update(sql,5);
		
		String sql = "update student set sname=? where id= ? ";
		run.update(sql,"xxx",4);
		
		System.out.println("OK");
	}
	@Test
	public void queryCountTest4() throws SQLException{
		QueryRunner run = new QueryRunner(C3p0Utils.getDataSource());
	/*	
		String sql = "select count(*) from student";
		Object o=run.query(sql,new ScalarHandler());
		int count =Integer.valueOf(o.toString());
//		int count =Integer.valueOf(""+o);
//		Integer.parseInt(""+o);
		System.out.println(count);
		*/
		
		//一般查询时加上where语句 加快效率,而且一般使用主键
		String sql = "select id,sname from student where id=?";
		Object o=run.query(sql,new ScalarHandler("sname"),3);		
		System.out.println(o);
	}
	@Test
	public void mapTest5() throws SQLException{
		QueryRunner run = new QueryRunner(C3p0Utils.getDataSource());
//		String sql ="select * from student";
//		Map<String, Object> map=run.query(sql, new MapHandler());
		String sql ="select * from student where id =?";
		Map<String, Object> map=run.query(sql, new MapHandler(),2);
		System.out.println(map);
	}
	@Test
	public void mapMapTest6() throws SQLException{
		QueryRunner run = new QueryRunner(C3p0Utils.getDataSource());
		
		String sql ="select * from student ";
		Map<Object, Map<String, Object>> map =run.query(sql, new KeyedHandler("sname"));
		Iterator<Object> iter  =map.keySet().iterator();
		while (iter.hasNext()) {
			String key = (String) iter.next();
			System.err.println(key + "===" + map.get(key));
		}
//		ClassCastException
	}
	@Test
	public void colomnTest7() throws SQLException{
		QueryRunner run = new QueryRunner(C3p0Utils.getDataSource());
		
		List<Object> list = run.query("select sname,id from student",
				new ColumnListHandler(1)); 	// 1，指的是查询当中的排序
		for (Object o : list) 
			System.err.println("sname:" + o);		
	}
	@Test
	public void listArrayTest8() throws SQLException{
		QueryRunner run = new QueryRunner(C3p0Utils.getDataSource());
		
		List<Object[]> list = run.query("select sname,id from student",
				new ArrayListHandler()); 	
		for (Object[] o : list) {
//			System.err.println("sname:" + o);
			for (Object oo : o) {
				System.out.print(oo + "\t");
			}
			System.out.println();
		}
	}
	@Test
	public void arrayHandlerTest9() throws SQLException{
		QueryRunner run = new QueryRunner(C3p0Utils.getDataSource());
		
		Object[] o = run.query("select * from stud where id=?", new ArrayHandler(), 4);
		for (Object oo : o) {
			System.err.print(oo+"\t");
		}
		
	}
	@Test
	public void resultSetTest10() throws SQLException{
		QueryRunner run = new QueryRunner(C3p0Utils.getDataSource());
		
		/**
		 * 通过实现内部类的方式加以实现自己的封装
		 */
		String sql = "select id,sname,les,score from student";
		List<Student> list = run.query(sql, new ResultSetHandler<List<Student>>() {
			
			public List<Student> handle(ResultSet rs) throws SQLException {
				List<Student> list = new ArrayList<Student>();
				while (rs.next()) {
					Student s = new Student();
					s.setId(rs.getInt("id"));
					s.setSname(rs.getString("sname"));
					s.setLes(rs.getString("les").equals("SQL") ? "数据库" : "编程语言");
					s.setScore(rs.getInt("score"));
					list.add(s);
				}
				return list;
			}
		});
		System.err.println(">>>>L:" + list);
	}
	@Test
	public void test11() throws SQLException{
		//测试事务的方法,但没有数据表的支持,没有修改
		QueryRunner run = new QueryRunner(C3p0Utils.getDataSource());
		
		//获取Connection对像
		Connection con = null;
		try{
			con = C3p0Utils.getConnection();
			con.setAutoCommit(false);
			//以下同时写入两行记录－－>事务
			String sql = "insert into stud values('333','33','0','4334')";
			run.update(con,sql);
			
			String sql2 = "insert into stud values('133,'33','0','33')";
			run.update(con,sql2);
			
			con.commit();
		}catch(SQLException e){
			System.err.println("Back....");
			con.rollback();
		}finally{
			con.setAutoCommit(true);
			con.close();
		}
		
	}
}
