package chap01.strategy.demo2;

public class FlyNoWay implements FlyBehavior{

	public void fly() {
		System.out.println(" I can't fly !");
	}

}
