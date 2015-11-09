package basestrong2.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestMain {

	public static void main(String[] args) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
     //在该类中调用Person类的main方法
	 
	 //创建类的对象
	 Person person=new Person();
	
	 /*
	  * public static void main(String[] args) {
		   System.out.println("已经调用了main方法");
	    }
	  */
	 //获取类中的main方法
	 Class[] parameterTypes={String[].class};	 
     Method method=person.getClass().getMethod("main", parameterTypes);
	 //System.out.println(method.getName());

     String[] argsp={"a","b","c"};
     
     //使用invoke调用main方法时,参数必须用new Object[]{实参1,实参2...}
     method.invoke(person,new Object[]{argsp});
		
	}

}
