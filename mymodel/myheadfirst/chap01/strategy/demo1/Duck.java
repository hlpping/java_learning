package chap01.strategy.demo1;

public abstract class Duck {
	Duck(){}
	
	public abstract void display() ;
	
	public void swim(){
		System.out.println(" All Duck can swiming !");
	}
}
