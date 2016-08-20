package cn.test.reflect.demo01;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;

@SuppressWarnings("unchecked")
public class ReflectTest {
	@Test
	public void testGetClass() throws Exception{
		 // 1.根据类名获取class对象
		Class clazz =Class.forName("cn.test.reflect.demo01.Person");
		// Class clazz = Person.class;	// 2.直接获取class对象
		// Person zs = new Person();
		// Class clazz = zs.getClass();	// 3.获取指定对象的class对象
		Person p =(Person) clazz.newInstance();
		p.setName("Maria");
		System.out.println(p);		
	}
	@Test
	public void testMethod() throws Exception{
		Class clazz =Class.forName("cn.test.reflect.demo01.Person");
		Person p1=new Person("Maria",20);
		Person p2=new Person("Maria Lee",20);
		Method m =clazz.getMethod("fun", int.class);
		m.invoke(p1, 10);
		m.invoke(p2, 10);
		
	}
	@Test
	public void testConstructor() throws Exception{
		Class clazz =Class.forName("cn.test.reflect.demo01.Person");
		Constructor c =clazz.getConstructor(String.class,int.class);
		Person p =(Person) c.newInstance("Maria",20);
		System.out.println(p);
	}
	@Test
	public void testField() throws Exception{
		Class clazz =Class.forName("cn.test.reflect.demo01.Person");
		Person p1 = new Person("张三");
		Person p2 = new Person("李四");

		Field f = clazz.getDeclaredField("age"); // 获取age属性
		// 私有的属性不能直接访问, 如果一定要访问, 那么需要强行改变访问权限
		f.setAccessible(true); 
		f.set(p1, 25); // 设置age属性
		f.set(p2, 22);
		System.out.println(p1);
		System.out.println(p2);
		System.out.println("p1的age: " + f.get(p1));
		System.out.println("p2的age: " + f.get(p2));
		
		
	}
	@Test
	public void testOther() throws Exception{
		Class clazz =Class.forName("cn.test.reflect.demo01.Person");
		// 获取所有构造函数
		 System.out.println(clazz.getConstructors().length);	
		
		// 获取clazz中所有公有方法(包括继承的, 不包括私有的), 打印个数
//		System.out.println(clazz.getMethods().length);

		// 获取所有在clazz类中声明的方法(包括私有的, 不包括继承的), 打印个数
//		System.out.println(clazz.getDeclaredMethods().length);	

		/*
		Method m = clazz.getMethod("fun"); // 根据函数名获取指定的Method
		m.invoke(p1); // 调用指定的方法, 返回指定方法的返回值
		m.invoke(p2); // 调用指定的方法, 返回指定方法的返回值
		*/
		
		// 公有的, 包括继承的
//		System.out.println(clazz.getFields().length);	
		// 自己声明的, 包括私有的
//		System.out.println(clazz.getDeclaredFields().length);	
	}
}
