package basestrong.reflect;

public class Person {
	
	private static  String name="JJJJJack";		//Field
	public Person(){							//私有构造方法
		System.out.println("init....>>:无参");
	}
	private Person(String s){							//私有构造方法
		System.out.println("init....>>:有参数构造方法"+s);
	}
	private Person(int i){							//私有构造方法
		System.out.println("init....>>:无参");
	}
	@Override
	public String toString(){							//重写父类方法
		return "我是人...."+name;
	}
	
	/*
	 * 
	 * Method...
	 */
	public static  void aa(){							//静态方法
		System.out.println("OKOKOK");
	}
	private static  void abc(){							//静态方法
		System.out.println("abc");
	}
}
