package base.day05_oop_static;

import org.junit.Test;

/**
 * 参数类型的转换
 */
public class ArgTransferDemo {
	static int run(int x){
		return ++x;
	}
	static String run(String x){
		return "you are bad";
	}
	static void run2(String x){
		x= "you are bad";
	}
	static void run(Person1 x){
		x.name= "you";
	}
	@Test
	public void test1(){
		int x=98;
		x=run(x);
		System.out.println(x);
	}
	@Test
	public void test2(){
		String s="you are very good";
		run2(s);
		System.out.println(s);
	}
	@Test
	public void test3(){
		Person1 p =new Person1();
		p.name="me";
		run(p);
		System.out.println(p.name);
	}
}
class Person1{
	String name;
}