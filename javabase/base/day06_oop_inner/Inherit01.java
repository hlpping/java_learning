package base.day06_oop_inner;

import org.junit.Test;

/**
 * 缁ф壙
 */
public class Inherit01 {
	@Test
	public void test1(){
		Person p =new Person();
		p.setName("aaaa");
		p.run();
		
		System.out.println("-----------");
		Teacher t = new Teacher();
		t.setName("Don");
		t.run();			//璋冪敤鐖剁被鐨勬柟娉�
		t.code();		
	}
	@Test
	public void test2(){
		System.out.println("-----------");
		Student s = new Student();
		s.setName("鏉庢瘏");
		s.run();
		s.code();		//璋冪敤鐖剁被鐨勬柟娉�
		s.study();		
	}
	@Test
	public void test3(){
		System.out.println("-----------");
		Student s1 = new Student();
		s1.setName("鏉庢瘏");					//璋冪敤鐖剁被鐨勭埗绫荤殑鏂规硶
		System.out.println(s1.getName());		
	}
	@Test
	public void test4(){
		System.out.println("-----------");
		Teacher t2 = new Teacher();
		t2.setName("Don");
		System.out.println(t2.getName());			
		t2.run();		
	}	
}

class Person extends Object {
	private String name;

	public String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	public void run() {
		System.out.println("Person " + name + " 璺戞");
	}
}

class Teacher extends Person {
	void code() {
		System.out.println(getName() + " 缂栫▼");
	}
	private void teach() {
		System.out.println("鏁欒");
	}
}
class Student extends Teacher{
	public void run(){	// 璋冪敤缁ф壙杩囨潵鐨勮窇姝�, 璺�3娆�
		super.run();
		super.run();
		super.run();
	}
	
	void study(){
		System.out.println(getName() + " 瀛︿範");
	}
}

