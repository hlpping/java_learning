package basestrong2.generic.base1;

public class Test3<T> {

	// 方法级别的泛型
	// public <T> void method (T arr[]){}
	// public <T> void method2 (T arr[]){}

	public void method(T a) {

	}

	public <T> void method2(T a) {

	}

	public static <T> void method3(T a) {

	}

//	public static void method4(T a) {		//不可以
//
//	}

	/**
	 * 类级别定义的泛型只对类中非静态成员起作用 
	 * 类级别定义的泛型对类中静态成员不起作用,需要在方法级别定义泛型
	 * 
	 */
}
