package basestrong.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class PersonTest {
	public static void main(String[] args) throws Exception {
		
		// 1, 初始化无参构造方法
//		Person p = (Person) Class.forName("reflect.Person").newInstance();
		
		// 2, 初始化无参构造方法
//		Class cls=Class.forName("reflect.Person");
//		Object o =cls.newInstance();
//		Person p =(Person)o;
		
		// 3, getConstructor 反映此 Class 对象所表示的类的指定公共构造方法
//		Class cls=Class.forName("reflect.Person");
//		Constructor c =cls.getConstructor(String.class);//一般用来调用有参数的构造方法
//		c .setAccessible(true);
//		Object o =c .newInstance("ss");			
//		System.err.println(">>>:"+o);
		
		//4 getConstructors 反映此 Class 对象所表示的类的所有公共构造方法。
//		Class cls=Class.forName("reflect.Person");
//		Constructor[] cons =cls.getConstructors();
//		for(Constructor s: cons)
//			System.out.println(s.getName());
		
		//5 getDeclaredConstructor 类或接口的指定构造方法
//		Class cls=Class.forName("reflect.Person");
//		Constructor cons =cls.getDeclaredConstructor(String.class);
//		cons.setAccessible(true);
//		Object o =cons .newInstance("ss");	
//		System.out.println(o);
		
		//6 getDeclaredConstructors  所有构造方法
//		Class cls=Class.forName("reflect.Person");
//		Constructor[] cons =cls.getDeclaredConstructors();
//		for(Constructor s: cons)
//			System.out.println(s.getName());
		
		// 7 Method Methods
//		Class cls=Class.forName("reflect.Person");
//		Method m=cls.getMethod("abc", null);
//		m.invoke(cls);	
		
//		Method[] m =cls.getMethods(); 
//		for(Method o: m	)
//			System.out.println(o.getName());			//只有Declared才有调用私有的方法
//		System.out.println(m.length);		
		
//		Method[] m =cls.getDeclaredMethods();
//		for(Method o: m	)
//			System.out.println(o.getName());
//		System.out.println(m.length);
		
		// 8 Field
//		Class cls=Class.forName("reflect.Person");
//		Field f = cls.getDeclaredField("name");
//		f.setAccessible(true);
//		Object o =cls.newInstance();
//		f.set(o,"Rose");
//		System.err.println("<<<:"+o);
		
	}
}
