package cn.test.io.demo02;

import org.junit.After;
import org.junit.Before;

public class SuperTest {
	long time = 0;
	String input = "input\\src.txt";
	String output = "output\\src.txt";

	@Before
	public void setUp() {
		time = System.currentTimeMillis();
	}

	@After
	public void tearDown() {
		time = System.currentTimeMillis() - time;
		System.out.println("程序运行时间: "+time+" 毫秒");
	}
}
