package base.day06_oop_inner;

import org.junit.Test;

/**
 * 继承与类型转换
 */
public class Inherit02 {
	@Test
	public void test1(){
		Typist t = new Typist();
		t.type();
		
		Coder c = new Coder();
		c.type();
		c.code();
	}
	@Test
	public void test2(){
		Typist t = new Coder();		//子类当做父类来用
		t.type();
		work(t);
	}
	@Test
	public void test3(){
//		Coder c = new Typist();	// 父类不能当子类用, 因为子类有的方法, 父类不一定有
		Typist t = new Coder();	
		t.type();
//		t.code();
		
		Coder c =(Coder) t;		//强制类型转换
		c.code();
	}
	@Test
	public void test4(){
		Typist t1 = new Coder();
		Typist t2 = new Typist();
		System.out.println(t1 instanceof Coder);		// 判断 instanceof 运算符 左边的对象 是否是 右边类型
		System.out.println(t2 instanceof Coder);	//false
		
	}
	@Test
	public void test5(){
//		Typist t = new Coder();
		Coder t = new Coder();
		System.out.println(t instanceof Coder);
		System.out.println(t instanceof Typist);		
	}
	@Test
	public void test6(){
		Typist t = new Coder();
		t.type();
		// t.code();
		
		if(t instanceof Coder){
			Coder c = (Coder)t;	
			c.code();
		}else{
			System.out.println("这不是一个程序员, 不能编程");
		}
		
	}	
	
	public static void work(Typist t){	// 形参类型指定为Typist, 那么实参可以传入Typist或者其子类, 甚至子类的子类.
		t.type();
		t.type();
		t.type();
		System.out.println(t.getName());
		// t.code();	// 编译器进行语法检查的时候, 看到变量是什么类型, 就取那个类中找方法.
	}
}
class Typist {	// 打字员
	private String name = "打字员";	
	public String getName(){
		return name;	
	}
	
	public void type(){
		System.out.println("打字员打字");	
	}	
}

class Coder extends Typist {	// 程序员
	private String name = "程序员";	
	public String getName(){
		return name;	
	}
	
	public void type(){					//重写父类方法
		System.out.println("程序员打字");	
	}
	
	public void code(){					//子类特有方法
		System.out.println("编码");	
	}
}