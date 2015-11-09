package base.day05_oop_static;
class StaticMethod {
	
	public static void main(String[] args){
		/*
		Person3 p = new Person3();
		p.run();
		*/		
		// Person3.fun();		// 静态方法在类加载之后就可以使用, 可以使用 类名.方法名 形式访问
	
		// Person3 p1 = new Person3();
		// Person3 p2 = new Person3();
		
		Person3 p = new Person3();
		System.out.println(p.country);
		System.out.println(p.name);
	}		
}

class Person3 {	
	String name = "张三";	
	static String country = "中国";
	
	static {	// 类加载之后运行
		country = "美国";
		System.out.println("A");
	}	
	{		// 创建对象之后运行
		country = "中国";
		System.out.println("B");
	}	
	
	public Person3(){		
		System.out.println("C");	
	}	
	public void run(){
		String name = "王五";
		System.out.println(this.name + " is running.");
	}		
	static public void fun(){
		System.out.println(" 这是一个静态方法");
	 	Person3 p = new Person3();
	 	p.name = "张三";
	 	p.run();
	}
}  