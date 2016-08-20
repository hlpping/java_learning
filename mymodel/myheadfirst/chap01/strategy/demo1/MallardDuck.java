package chap01.strategy.demo1;

public class MallardDuck extends Duck implements QuackBehavior , FlyBehavior{

	@Override
	public void display() {
		System.out.println("MallardDuck is me!");
		
	}

	public void quack() {
		System.out.println("quack ....");
	}

	public void fly() {
		System.out.println("fly ....");
		
	}

}
