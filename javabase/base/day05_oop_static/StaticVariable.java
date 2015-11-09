package base.day05_oop_static;

import org.junit.Test;

public class StaticVariable {
	@Test
	public void test1(){
		Person2 p1 = new Person2();
		Person2 p2 = new Person2();
		
		p1.name = "张三";
		p2.name = "李四";		
		p1.age = 20;
		p2.age = 22;		
		p1.show();
		p2.show();		
		System.out.println();
		
		p1.country = "中国";
		p1.show();		
		p2.country = "美国";
		p2.show();		
		p1.show();		
		System.out.println();
		
		p1.country = "中国";
		p1.show();
		p2.show();		
		System.out.println();
		
		Person2.country = "China"; 	// 静态变量可以直接使用类名.变量名形式访问
		p1.show();
		p2.show();
	}
	@Test
	public void test2(){
		
	}
}
class Person2{
	String name;
	int age;
	static String country="china";
	
	Person2(){}
	Person2(String name,int age,String country){
		this.name = name;
		this.age = age;
		this.country = country;
	}
	public void show(){
		System.out.println(name + " : " + age + " : " + country);	
	}
}
