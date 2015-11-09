package basestrong2.generic.base8;

import java.lang.reflect.Method;

public class TestReflect {
	public static void main(String[] args) throws Exception {
		Person person=new Person();
		Class[] parameterTypes ={String[].class};
		
		Method method=person.getClass().getMethod("main", parameterTypes);
	
		String[] para={"a","b","c"};
		method .invoke(person, new Object[]{para});
//		method .invoke(person, para);		//wrong number of arguments
	}
}
