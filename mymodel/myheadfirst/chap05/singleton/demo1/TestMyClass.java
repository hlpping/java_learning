package chap05.singleton.demo1;

import org.junit.Test;

import chap05.singleton.demo4.Singleton;


public class TestMyClass {
	@Test
	public void test1() {

		System.out.println(MyClass.getInstance());
		System.out.println(MyClass.getInstance());

		System.out.println();

		System.out.println(MyClass2.getInstance());
		System.out.println(MyClass2.getInstance());

		System.out.println();

		System.out.println(MyClass3.getInstance());
		System.out.println(MyClass3.getInstance());

	}
	@Test
	public void test2() {
		System.out.println(Singleton.getInstance());
		System.out.println(Singleton.getInstance());
		System.out.println(Singleton.getInstance());
		
	}
}
