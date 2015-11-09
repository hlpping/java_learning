package base.day07_oop;

public class InheritTest02 {
	public static void main(String[] args) {
		new C();
	}
}
class A {
	static {
		System.out.print("7");	
	}
	A(){
		this(1);
		System.out.print("1");	
	}	
	A(int i){
		this("");
		System.out.print("2");
	}
	A(String s){
		super();
		System.out.print("3");
	}
}

class B extends A {
	static {
		System.out.print("8");	
	}
	B(){
		this("");
		System.out.print("4");	
	}	
	B(int i){
		System.out.print("5");
	}
	B(String s){
		// this(1);
		super(1);
		System.out.print("6");
	}
}

class C extends B {
	static {
		System.out.print("9");	
	}
}