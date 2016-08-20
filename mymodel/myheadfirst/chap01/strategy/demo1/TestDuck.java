package chap01.strategy.demo1;

import org.junit.Test;

public class TestDuck {
	@Test
	public void test1(){
		
		MallardDuck duck1 = new MallardDuck();
		duck1.swim();
		duck1.display();
		duck1.quack();
		duck1.fly();
	}
}
