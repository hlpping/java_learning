package base.day06_oop_inner;

public class InheritTest {
	public static void main(String[] args) {
		A a;
		B b =new B();
		b.fun1();
		
		System.out.println("---------");
		a=b;
		a.fun1();
		//在子类当做父类来用的时候, 用父类变量记住一个子类对象.
	}
}
class A{
	void fun1(){
		System.out.println(fun2());
	}
	int fun2(){
		return 123;
	}
}
class B extends A{
	int fun2(){
		return 456;
	}	
}