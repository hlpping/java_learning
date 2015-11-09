package base.day07_oop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *	toString
 *	equals
 */
public class ObjectMethod {
	public static void main(String[] args) throws IOException {
//		testToString();
		testToString2();
//		testEquals();
		
	}
	static void testToString() throws IOException{
		String s= "abc";
		BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
		String line =reader.readLine();
		
		System.out.println("s= "+s);
		System.out.println("line+ "+line);
		
		System.out.println("==的结果: " + (s == line));
		System.out.println("equals的结果: " + s.equals(line));
	}
	static void testEquals(){
		Person1 p1 = new Person1();
		p1.name = "张三";
		p1.age = 22;
		
		Person1 p2 = new Person1();
		p2.name = "张三";
		p2.age = 22;
		
		Car c = new Car();		
		c = null;
		
		p2 = p1;		
		System.out.println(p1 == p2);	// 运算符==如果用来比较两个对象, 是比较的两个对象地址是否相同.
		
		System.out.println(p1.equals(p2));
	}
	
	static void testToString2(){
		Person1 p = new Person1();
		p.name = "张三";
		p.age = 22;
		
		// String s = p.toString();	// 将当前对象转为字符串表示形式
		System.out.println(p);		// 在使用println()方法打印一个对象的时候, 其实是调用了实参的toString();
		
		StringBuffer sb = new StringBuffer();
		sb.append("a");
		sb.append("bc");
		System.out.println(sb);
	}
}
class Person1{
	String name;
	int age;
	
	public String toString(){
		return name+" : "+age;
	}
	public boolean equals(Object obj){
		if(this==obj){
			return true;
		}
		if(obj==null){
			return false;
		}
		if(!(obj instanceof Person1) ){
			return false;
		}		
		Person1 p=(Person1) obj;
		if(!this.name.equals(p.name))		
			return false;
		if(this.age != p.age)		
			return false;
		return true;		
	}
	// 判断如果地址相同, 直接返回true, 地址相同属性肯定相同
	// 判断如果传入对象为null, 直接返回false, 因为可以执行这个方法, 那么调用equals的对象肯定不是null
	// 判断obj如果不是Person类型, 直接返回false
	// 由于形参定义时Object类型, 不能直接访问Person类的属性, 所以强转
	// 判断名字是否不同, 如果不同, 返回false
	// 判断年龄是否不同, 如果不同, 返回false
	// 如果名字和年龄都一样, 那么我们就认为这两个对象相同, 返回true
}
class Car { }
