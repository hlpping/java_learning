package base.day05_oop_static;

import org.junit.Test;

public class ThisDemo {
	@Test
	public void test1(){
		A a =new A();
	}
}
class A{
	A(){
//		this(1,"");
		System.out.println("A");
	}
	A(int i){
		System.out.println("B");
	}
	A(int i,String s){
		this();
		System.out.println("C");
	}
	A(String s,int i){
		this(1);
		System.out.println("D");
	}
}