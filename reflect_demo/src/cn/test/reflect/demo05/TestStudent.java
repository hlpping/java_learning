package cn.test.reflect.demo05;


import java.lang.reflect.Method;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestStudent {
	
	Class clazz = null;
	@Before
	public void setUp() throws Exception {
		 clazz =Class.forName("cn.test.reflect.demo05.Student");
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void test01() throws Exception {
		Student s = (Student) clazz.newInstance();
		s.setId(1);
		System.out.println(s);
		System.out.println(s.getMessage());
	}
	@Test
	public void test02(){
		Method[]  methods =clazz.getMethods();
		
		for(Method m : methods){
			System.out.println(m.getModifiers()+"\t"+m.getName());
			//+"\t"+m.getAnnotations()[0]
		}
	}
	
	@Test
	public void test03() throws Exception, NoSuchMethodException{
		Student p1=new Student(2,"Maria");
		Student p2=new Student(3,"Maria Lee");
		Method m =clazz.getMethod("getMessage", null);
		m.invoke(p1, null);
		m.invoke(p2, null);
	}
	
	@Test
	public void test04(){
		
	}
	
	@Test
	public void test05(){
		
	}
	
	@Test
	public void test06(){
		
	}
	
	@Test
	public void test07(){
		
	}
	
	@Test
	public void test08(){
		
	}
	
	@Test
	public void test09(){
		
	}
	
	@Test
	public void test10(){
		
	}
	
	@Test
	public void test11(){
		
	}
	
	@Test
	public void test12(){
		
	}

}
