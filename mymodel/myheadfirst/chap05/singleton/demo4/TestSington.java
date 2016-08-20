package chap05.singleton.demo4;

import org.junit.Test;

public class TestSington {
	@Test
	public void test1(){
		
		System.out.println(Singleton.getInstance());
		System.out.println(Singleton.getInstance());
		
		System.out.println();
		
		System.out.println(Singleton2.getInstance());
		System.out.println(Singleton2.getInstance());
	}
}
