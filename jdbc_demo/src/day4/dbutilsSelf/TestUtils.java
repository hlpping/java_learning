package day4.dbutilsSelf;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import day4.dbutilsSelf.bean.Student;

public class TestUtils {
	@Test
	public void testMap(){
		DbUtils db = new DbUtils();
		List<Map<String,Object>> list = db.query("select * from stud");
		System.err.println(list);		
	}
	
	@Test
	public void testBean(){
		DbUtils db = new DbUtils();
		List<Student> list=db.query("select * from student", Student.class);
		for(Student s: list){
			System.out.println(s);
		}
		
	}
}
