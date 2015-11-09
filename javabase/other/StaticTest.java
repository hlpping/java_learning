package other;

class StaticTest {
	
	public static void main(String[] args){
		new A();
	}	
}
/*
// DF A CB F ACB E ACB

new A(); 会先加载A类

加载A类之后 会调用静态代码块
	在静态代码块中new B(1); 会先加载B类
		运行B类静态代码块
			D
		创建B类对象
		
		调用B类构造函数(有参的)
			F
			new A();
				创建A类对象
					A
				调用构造函数无参的
					CB
初始化静态变量
	new B();
		调用无参构造函数
			调用有参构造函数
				F
				new A();
					ACB
			E
创建对象
	A
	
运行构造函数
	CB
					
*/
class A {
	{	// 创建对象后运行
		System.out.print("A");
	}
	static {	// 类加载后运行
		new B(1);	
	}
	static B b = new B();	// 类加载后运行
	A() {	// 构造函数是最后运行的
		this(1);
		System.out.print("B");
	}	
	A(int i) {
		System.out.print("C");
	}
}

class B {
	static {
		System.out.print("D");
	}
	B() {
		this(1);
		System.out.print("E"); 
	}
	B(int i) {
		System.out.print("F");
		new A();
	}
}

// 李毅 DF ACB F ACB E ACB

