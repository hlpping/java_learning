package base.day07_oop;

public class OverrideDemo {
	/*
重写(Override)和重载(Overload)的区别:
	他们的共同点是方法名相同.
	重载是方法名相同, 参数列表不同, 和返回值类型无关.
	重写是方法名相同, 参数列表相同, 返回值类型也相同
	(子类返回值类型是父类返回值类型的子类也可以).
	 */	
	public static void main(String[] args) {
//		fun((byte)1);
		
		Student s =new Student();
		s.run();
		
//		fun(new Student);
		
		Student stud =new Student();
		stud.test();
	}
	static void fun(Person p){
		int i =p.run();
		Person p1=p.getInstance();
	}
	static void fun(){
		System.out.println("A");
	}
	
	static int fun(int i){
		System.out.println("B");
		return i;
	}
	
	static void fun(double d){
		System.out.println("C");	
	}
	
	static void fun(byte b){
		System.out.println("D");	
	}
}
class Person {	
	public int run(){
		System.out.println("Person run..");	
		return 1;
	}		
	Person getInstance(){
		return new Person();	
	}
}
class Student extends Person {
	
	Student getInstance(){	//
		return new Student();	
	}	
	public int run(){
		System.out.println("Student run..");	
		return 1;
	}	
	void run(int i){
		System.out.println("Student run..");	
	}	
	void test(){
		run();
		super.run();
	}
}