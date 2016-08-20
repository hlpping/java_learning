package chap01.strategy.demo2;

import org.junit.Test;

public class TestDuck {
	@Test
	public void test1(){
		
		Duck duck1 = new MallardDuck();
		duck1.performFly();
		duck1.performQuack();
	}
}
