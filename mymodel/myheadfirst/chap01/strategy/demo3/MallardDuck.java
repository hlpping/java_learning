package chap01.strategy.demo3;

public class MallardDuck extends Duck{
	
	public MallardDuck(){
		quackBehavior =new Quack();
		flyBehavior =new FlyWithWing();
	}

	@Override
	public void display() {
		System.out.println("MallardDuck is me!");
		
	}

}
