package chap01.strategy.demo3;

import org.junit.Test;

public class TestDuck {
	@Test
	public void test1(){
		
		Duck duck1 = new MallardDuck();
		duck1.performFly();
		duck1.performQuack();
		System.out.println("***************");
	}
	@Test
	public void test2(){
		
		Duck duck1 = new ModelDuck();
		duck1.performFly();
		duck1.performQuack();
		
		duck1.setFlyBehavior(new FlyRocket());
		duck1.performFly();
	}
}
