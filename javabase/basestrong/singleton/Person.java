package basestrong.singleton;

public class Person {
	/**
	 * 单例模式 是只有一个实例,所以p1=p2
	 */
/*
	//饿汉模式 
	private Person(){} 
	public static Person p=new Person();
*/
	// 懒汉模式
	private Person() {
	}

	private static Person p;

	public static Person instance() {
		if (p == null)
			p = new Person();
		return p;
	}
}
