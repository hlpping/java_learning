package day4.spring;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import day4.c3p0.C3p0Utils;

public class CRUDTest {
	@Test
	public void test1(){
		//查询数据表
		String sql = "select * from stud";
		//2:实例化JDBCTemplate核心SPring对像
		JdbcTemplate jt = new JdbcTemplate(C3p0Utils.getDataSource());
		//3:进行查询
		List<Map<String,Object>> list = jt.queryForList(sql);
		System.err.println("显示数据：");
		//map.put(id),map.put(name)
		for(Map<String,Object> mm:list){
			System.err.println(mm);
		}
	}
	@Test
	public void test2(){
		//查询数据表
		String sql = "select * from stud where les=? and NAME like ?";
		//2:实例化JDBCTemplate核心SPring对像
		JdbcTemplate jt = new JdbcTemplate(C3p0Utils.getDataSource());
		//3:进行查询
		String les = "Java";
		String name = "J";
		name = "%"+name+"%";
		List<Map<String,Object>> list = jt.queryForList(sql,new Object[]{les,name});
		System.out.println(list);		
	}
	@Test
	public void test3(){
		//写入新内容
		String sql = "insert into stud values(?,?,?,?)";
		
		Object[] o = new Object[]{9,"王健","Java",44};		//准备参数
		//先声明JT对像
		JdbcTemplate jt = new JdbcTemplate(C3p0Utils.getDataSource());
		jt.update(sql,o);		
	}
	@Test
	public void test4(){
		String sql = "delete from stud where id='3'";
		JdbcTemplate jt = new JdbcTemplate(C3p0Utils.getDataSource());
		jt.update(sql);
	}
	@Test
	public void test5(){
		String sql = "select count(*) from stud";
		JdbcTemplate jt = new JdbcTemplate(C3p0Utils.getDataSource());
		int a = jt.queryForInt(sql);
		System.err.println(a);
	}
}
