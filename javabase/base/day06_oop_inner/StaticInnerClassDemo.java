package base.day06_oop_inner;

public class StaticInnerClassDemo {
	public static void main(String[] args) {
//		 Outer3.Inner inner = new Outer3().new Inner();	// 普通内部类对象创建
//		 Outer3.Inner inner = new Outer3.Inner();		// 静态内部类对象创建
		
//		System.out.println( Outer3.Inner.name);
//		System.out.println(Outer3.name);
		
//		Outer3.run();
//		Outer3.Inner.run();
		
		Outer3.Inner inner = new Outer3.Inner();		// 创建了内部类对象, 没有创建外部类对象.
		inner.eat();	// 这个方法可以用了, 但由于没有外部类对象, 所以不能调用外部类的方法.
//		inner.run();
	}
}
class Outer3 {
	static String name = "out";
	int age;
	
	static void run(){
		System.out.println("外部类 " + name + " run()");	
	}	
	
	void eat(){
		System.out.println("外部类的eat()");	
	}
	
	static class Inner {
		static String name = "in";
		int age;
	
		static void run(){
			System.out.println("内部类 " + name + " run()");	
			Outer3.run();
		}	
		
		void eat(){
			System.out.println("内部类的eat()");	
			// Outer.this.eat();	// 静态内部类中不能使用外部非静态的成员
			
			Outer3 outer = new Outer3();
			outer.eat();
		}
	}
}