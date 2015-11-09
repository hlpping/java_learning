package base.day04_oop;

import org.junit.Test;

public class PersonDemo {
	@Test
	public void test1(){
		Person p = new Person();	// 使用Person类创建一个对象.		
		p.name = "张三";	// 给对象的属性赋值
		p.age = 20;
		
		Person p1 = new Person();	// 使用Person类, 再次创建对象.
		p1.name = "李四";
		p1.age = 22;
		
		System.out.println(p.name);	// 访问对象的属性
		System.out.println(p.age);
		
		System.out.println(p1.name);
		System.out.println(p1.age);
		
		p.eat();	// 调用对象的方法. 方法中使用了this.name, 由于是p对象调用, 所以打印出的是p.name
		p.run();
		
		p1.eat();	// p1调用eat, 所以this就相当于p1
		p1.run();
	}
}

class Person{
	String name;	// 给类定义一个属性(成员变量). 描述该类对象的特征. 程序中的Person都有名字
	int age;
	
	void eat(){
		String name ="marry";
//		System.out.println(this.name+" eat ");
		System.out.println(name+" eat ");
	}
	void run(){
		System.out.println(name+" run !");
	}
	void work(){
		System.out.println("work");
	}
}