package base.day07_oop;
/**
 * 多态 抽象类
 */
public class Polymorphism {
	public static void main(String[] args) {
		Juicer juicer=new Juicer();
		Apple apple =new Apple();
		juicer.run(apple);
		juicer.run(new Mango());
		
		juicer.run(new Fruit(){
			public void squeeze() {
				System.out.println("榨出了一杯梨汁");
			}			
		});
	}
}
class Juicer{
	public void run(Fruit fruit){
		fruit.squeeze();
	}
}
abstract class Fruit{
	abstract public void squeeze();	
}

class Apple extends Fruit{
	
	public void squeeze() {
		System.out.println("榨出了一杯苹果汁");	
	}	
}
class Watermelon extends Fruit {
	
	public void squeeze(){
		System.out.println("削皮");	
		System.out.println("榨出了一杯西瓜汁");
	}	
}

class Mango extends Fruit {
	
	public void squeeze(){
		System.out.println("去核");	
		System.out.println("榨出了一杯芒果汁");
	}	
}

class Orange extends Fruit {
	
	public void squeeze(){
		System.out.println("剥皮");	
		System.out.println("榨出了一杯橘子汁");
	}		
}