package base.day06_oop_inner;


public class InnerClassDemo {
	public static void main(String[] args) {
		/*
		Outer outer=new Outer();
		Outer.Inner inner =outer.new Inner();	//第一种调用方式
		Outer.Inner inner2 =outer.new Inner();
		outer.name="out";
		inner.name="in";
		
//		outer.run();
//		System.out.println();
//		inner.run();
		
//		outer.run();
//		outer.eat();
		*/
		Outer.Inner in =new Outer().new Inner();	//第二种调用方式
		in.eat();
	}
}
class Outer{
	String name;
	void run(){
		String name="outer_run";
		System.out.println("Outer Class "+this.name +" is running");
	}
	void eat(){
		System.out.println("Outer Class " + name + " eat");	
		Inner inner = new Inner();	
		inner.eat();
	}	
	class Inner{		//内部类
		String name;
		void run(){
			String name = "inner_run";
			System.out.println("Inner Class " + this.name + " is running.");	
			System.out.println(this.name + ": Outer Class name is " + Outer.this.name);		// 访问外部类的成员变量
			Outer.this.run();		// 访问外部类的方法
		}
		
		void eat(){
			System.out.println("Inner Class " + name + " eat");	
		}	
	}
}