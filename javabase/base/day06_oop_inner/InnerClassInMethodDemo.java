package base.day06_oop_inner;

public class InnerClassInMethodDemo {
	public static void main(String[] args) {
		Outer2 outer2=new Outer2();
//		outer2.run();
		
		// 方法中的内部类, 只能在方法中使用,这里调用的是普通的内部类
		 Outer2.Inner inner = outer2.new Inner();		
		 inner.run();
//		outer2.eat();	//调用普通的内部类方法
	}
}
class Outer2{
	String name;
	void run(){
		final int x=98;
		System.out.println("Outer class "+name+" is running ");
	
		class Inner{	//方法的内部类
			String name;
			void run(){
				System.out.println("Inner class "+name+" is running ");
				System.out.println(x);
			}
		}
		Inner inner =new Inner();
		inner.name="in";
		inner.run();
	}
	void eat(){
		Inner inner = new Inner();
		inner.name = "in";
		inner.run();
	}
	class Inner{		//普通的内部类
		String name;
		void run(){
			System.out.println("普通内部类Inner的run()");
		}
	}
}
class Inner {
	String name;
	
	void run(){
		System.out.println("外部类Inner的run()");	
	}
}