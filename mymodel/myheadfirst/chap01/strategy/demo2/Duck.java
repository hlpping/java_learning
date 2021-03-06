package chap01.strategy.demo2;

public abstract class Duck {
	FlyBehavior flyBehavior ;
	QuackBehavior quackBehavior;
	
	Duck(){}
	
	public abstract void display() ;
	
	public void performFly(){
		flyBehavior.fly();
	}
	
	public void performQuack(){
		quackBehavior.quack();
	}
	
	public void swim(){
		System.out.println(" All Duck can swiming !");
	}
}
